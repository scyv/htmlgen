package de.scyv.htmlgen.generator;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Main entry point of this project for generating the HTML-API.
 *
 * Use this class to generate the API.
 */
public class Generator {

    private static final String TARGET_PATH = "src/generated/java/de/scyv/htmlgen/api/";
    private static final String SPEC_FILE = "api-spec.json";

    private JSONObject attributes;
    private JSONObject elements;
    private JSONArray flowElements;
    private JSONArray phrasingElements;
    private JSONArray metadataElements;
    private Map<String, JSONObject> elementsMap;

    public static void main(String[] args) throws Exception {
        new Generator().generate();
    }

    /**
     * Main entry point of this project for generating the HTML-API.
     *
     * Use this to generate the API.
     *
     * @throws IOException when there is a problem reading the specification
     * file.
     * @throws URISyntaxException when the uri to the specification file is
     * errornous.
     */
    public Generator() throws IOException, URISyntaxException {

        // Read specification json file
        String apiSpecRaw = new String(
                Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(SPEC_FILE).toURI())));

        // collect specific sections from the json
        JSONObject apiSpec = new JSONObject(apiSpecRaw);
        attributes = apiSpec.getJSONObject("attributes");
        elements = apiSpec.getJSONObject("elements");
        flowElements = elements.getJSONArray("flowElements");
        phrasingElements = elements.getJSONArray("phrasingElements");
        metadataElements = elements.getJSONArray("metadataElements");

        // create a map of all elements
        elementsMap = new HashMap<>();
        Consumer<? super Object> addToElementsMap = obj -> {
            JSONObject element = (JSONObject) obj;
            String elementName = String.valueOf(element.get("name"));
            elementsMap.put(elementName, element);
        };
        flowElements.forEach(addToElementsMap);
        phrasingElements.forEach(addToElementsMap);
        phrasingElements.forEach(addToElementsMap);

        // make sure, that the target path exists
        new File(TARGET_PATH).mkdirs();

    }

    private void generate() {
        final Consumer<? super Object> generateFileContent = getGenerateFileContentConsumer();
        final Consumer<? super Object> generateMetadataElementsFileContent = getGenerateMetadataElementsFileContentConsumer();
        flowElements.forEach(generateFileContent);
        phrasingElements.forEach(generateFileContent);
        metadataElements.forEach(generateMetadataElementsFileContent);
    }

    private Consumer<? super Object> getGenerateFileContentConsumer() {
        final Set<String> flowElementNames = ElementUtil.getAllElementNames(flowElements);
        final Set<String> phrasingElementNames = ElementUtil.getAllElementNames(phrasingElements);
        ClassWriter writer = new ClassWriter();
        return obj -> {
            JSONObject element = (JSONObject) obj;
            String elementName = String.valueOf(element.get("name"));
            String fileName = ElementUtil.upperFirst(elementName);
            StringBuilder fileContent = new StringBuilder();
            fileContent.append(writer.createClassHead(elementName, fileName));

            if (element.has("childIncludes")) {
                fileContent.append(writeChildElementAppender(ElementUtil.getAllElementNames(element, "childIncludes").stream()));
            } else {
                Set<String> childExcludes = ElementUtil.getAllElementNames(element, "childExcludes");
                Predicate<? super String> predicate = name -> {
                    boolean filter = true;
                    filter &= !childExcludes.contains(name);
                    if (filter) {
                        JSONObject child = elementsMap.get(name);
                        if (child.has("parentIncludes")) {
                            filter &= ElementUtil.getAllElementNames(child, "parentIncludes").contains(elementName);
                        }
                    }
                    return filter;
                };
                fileContent.append(writeChildElementAppender(flowElementNames.stream().filter(predicate)));
                fileContent.append(writeChildElementAppender(phrasingElementNames.stream().filter(predicate)));
            }
            writeAttributeSetter(element, fileContent);

            if (!element.has("notext")) {
                fileContent.append(new MethodWriter().writeAddTextMethod(fileName));
            }

            writeClassFile(fileName, fileContent);

        };
    }

    private Consumer<? super Object> getGenerateMetadataElementsFileContentConsumer() {
        final ClassWriter writer = new ClassWriter();
        return obj -> {
            JSONObject element = (JSONObject) obj;
            String elementName = String.valueOf(element.get("name"));
            String fileName = ElementUtil.upperFirst(elementName);
            StringBuilder fileContent = new StringBuilder();
            fileContent.append(writer.createClassHead(elementName, fileName));
            writeClassFile(fileName, fileContent);
        };
    }

    private StringBuilder writeChildElementAppender(final Stream<String> stream) {
        final MethodWriter writer = new MethodWriter();
        final StringBuilder methods = new StringBuilder();
        stream.forEach(elementName -> {
            methods.append(writer.writeChildElementAppender(elementName));
        });
        return methods;
    }

    private void writeAttributeSetter(final JSONObject element, final StringBuilder fileContent) {
        MethodWriter writer = new MethodWriter();
        String clazzName = ElementUtil.upperFirst(ElementUtil.getElementName(element));
        final Consumer<Object> writeAttributeSetter = obj -> {
            String attrName = ElementUtil.getElementName(obj);
            fileContent.append(writer.writeAttributeSetter(attrName, clazzName));
        };
        attributes.getJSONArray("coreAttributes").forEach(writeAttributeSetter);
        attributes.getJSONArray("eventHandlerAttributes").forEach(writeAttributeSetter);
        attributes.getJSONArray("xmlAttributes").forEach(writeAttributeSetter);
        if (element.has("attributes")) {
            element.getJSONArray("attributes").forEach(writeAttributeSetter);
        }

    }

    private void writeClassFile(final String fileName, final StringBuilder fileContent) {
        fileContent.append("}\n");
        try {
            String targetFile = TARGET_PATH + fileName + ".java";
            System.out.println("Creating class file: " + targetFile);
            Files.write(Paths.get(targetFile), fileContent.toString().getBytes(Charset.forName("UTF-8")));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
