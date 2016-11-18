package de.scyv.htmlgen;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 */
public class Generator {

    public static void main(String[] args) throws Exception {
        new Generator().generate();

    }

    private void generate() throws Exception {
        String apiSpecRaw = new String(
                Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("api-spec.json").toURI())));

        String targetPath = "src/main/java/de/scyv/htmlgen/api/";

        JSONObject apiSpec = new JSONObject(apiSpecRaw);

        JSONObject attributes = apiSpec.getJSONObject("attributes");
        JSONObject elements = apiSpec.getJSONObject("elements");
        JSONArray flowElements = elements.getJSONArray("flowElements");
        JSONArray phrasingElements = elements.getJSONArray("phrasingElements");
        JSONArray metadataElements = elements.getJSONArray("metadataElements");

        Set<String> flowElementNames = getAllElementNames(flowElements);
        Set<String> phrasingElementNames = getAllElementNames(phrasingElements);

        Map<String, JSONObject> elementsMap = new HashMap<>();
        Consumer<? super Object> action = obj -> {
            JSONObject element = (JSONObject) obj;
            String elementName = String.valueOf(element.get("name"));
            elementsMap.put(elementName, element);
        };
        flowElements.forEach(action);
        phrasingElements.forEach(action);
        phrasingElements.forEach(action);

        new File(targetPath).mkdirs();

        Consumer<? super Object> writeClassFile = obj -> {
            JSONObject element = (JSONObject) obj;
            String elementName = String.valueOf(element.get("name"));
            String fileName = upperFirst(elementName);
            StringBuilder fileContent = new StringBuilder("");
            fileContent.append("package de.scyv.htmlgen.api;\n");
            fileContent.append("import de.scyv.htmlgen.AbstractElement;\n");
            fileContent.append("import de.scyv.htmlgen.TextContentElement;\n");
            fileContent.append("/**\n");
            fileContent.append(" * This class is generated. Do not change manually!\n");
            fileContent.append(" */\n");
            fileContent.append("public class " + fileName + " extends AbstractElement {\n");
            fileContent.append(tab() + "public " + fileName + "() { super(\"" + elementName + "\"); }\n");

            if (element.has("childIncludes")) {
                fileContent.append(getAddElementMethods(getAllElementNames(element, "childIncludes").stream()));
            } else {
                Set<String> childExcludes = getAllElementNames(element, "childExcludes");
                Predicate<? super String> predicate = name -> {
                    boolean filter = true;
                    filter &= !childExcludes.contains(name);
                    if (filter) {
                        JSONObject child = elementsMap.get(name);
                        if (child.has("parentIncludes")) {
                            filter &= getAllElementNames(child, "parentIncludes").contains(elementName);
                        }
                    }
                    return filter;
                };
                fileContent.append(getAddElementMethods(flowElementNames.stream().filter(predicate)));
                fileContent.append(getAddElementMethods(phrasingElementNames.stream().filter(predicate)));
            }
            
            if(!element.has("notext")) {
                fileContent.append(tab() + "public "+fileName+" text(String text) {\n");
                fileContent.append(tab() + tab() + "appendChild(new TextContentElement(text));\n");
                fileContent.append(tab() + tab() + "return this;\n");
                fileContent.append(tab() + "}\n\n");
            }

            fileContent.append("}\n");
            try {
                String targetFile = targetPath + fileName + ".java";
                System.out.println("Creating class file: " + targetFile);
                Files.write(Paths.get(targetFile), fileContent.toString().getBytes(Charset.forName("UTF-8")));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        };
        flowElements.forEach(writeClassFile);
        phrasingElements.forEach(writeClassFile);

        metadataElements.forEach(obj -> {
            JSONObject element = (JSONObject) obj;
            String elementName = String.valueOf(element.get("name"));
            String fileName = upperFirst(elementName);
            StringBuilder fileContent = new StringBuilder("");
            fileContent.append("package de.scyv.htmlgen.api;\n");
            fileContent.append("import de.scyv.htmlgen.AbstractElement;\n");
            fileContent.append("/**\n");
            fileContent.append(" * This class is generated. Do not change manually!\n");
            fileContent.append(" */\n");
            fileContent.append("public class " + fileName + " extends AbstractElement {\n");
            fileContent.append(tab() + "public " + fileName + "() { super(\"" + elementName + "\"); }\n");
            fileContent.append("}\n");
            try {
                String targetFile = targetPath + fileName + ".java";
                System.out.println("Creating class file: " + targetFile);
                Files.write(Paths.get(targetFile), fileContent.toString().getBytes(Charset.forName("UTF-8")));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        });
    }

    private Set<String> getAllElementNames(JSONObject element, String arrayName) {
        Set<String> result = new HashSet<>();
        if (element.has(arrayName)) {
            element.getJSONArray(arrayName).forEach(obj -> {
                if (obj instanceof String) {
                    result.add(String.valueOf(obj));
                } else {
                    JSONObject jsonElement = (JSONObject) obj;
                    result.add(String.valueOf(jsonElement.get("name")));
                }
            });
        }
        return result;
    }

    private Set<String> getAllElementNames(JSONArray elements) {
        Set<String> result = new HashSet<>();
        elements.forEach(obj -> {
            JSONObject jsonElement = (JSONObject) obj;
            result.add(String.valueOf(jsonElement.get("name")));
        });
        return result;
    }

    private StringBuilder getAddElementMethods(Stream<String> elements) {
        StringBuilder methodBody = new StringBuilder();
        elements.forEach(elementName -> {
            String clazzName = upperFirst(elementName);
            methodBody.append(tab() + "public " + clazzName + " " + elementName + "() {\n");
            methodBody.append(tab() + tab() + "return appendChild(new " + clazzName + "());\n");
            methodBody.append(tab() + "}\n\n");
        });
        return methodBody;
    }

    private String tab() {
        return "    ";
    }

    private String upperFirst(String input) {
        return input.substring(0, 1).toUpperCase() + (input.length() > 1 ? input.substring(1) : "");
    }

}
