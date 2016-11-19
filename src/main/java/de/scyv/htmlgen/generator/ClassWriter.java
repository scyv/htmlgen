package de.scyv.htmlgen.generator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * A writer for creating a class for a html element.
 */
public class ClassWriter {

    /**
     * Create the class head.
     * 
     * @param elementName the name of the html element
     * @param fileName the filename
     * @return a StringBuilder representing the head of the class
     */
    public StringBuilder createClassHead(String elementName, String fileName) {

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());

        StringBuilder classHead = new StringBuilder();
        classHead.append("package de.scyv.htmlgen.api;\n\n");
        classHead.append("import de.scyv.htmlgen.AbstractElement;\n");
        classHead.append("import de.scyv.htmlgen.TextContentElement;\n\n");
        classHead.append("import javax.annotation.Generated;\n\n");
        classHead.append("/**\n");
        classHead.append(" * This class represents a &lt;" + elementName + "&gt; html element.\n");
        classHead.append(" * This class is generated. Do not change manually!\n");
        classHead.append(" */\n");
        classHead.append("@Generated(\"" + nowAsISO + "\")\n");
        classHead.append("/**\n");
        classHead.append(" * Represents a &lt;" + elementName + "&gt; html element.\n");
        classHead.append(" */\n");
        classHead.append("public class " + fileName + " extends AbstractElement {\n\n");
        classHead.append(ElementUtil.tab() + "public " + fileName + "() { super(\"" + elementName + "\"); }\n");
        return classHead;
    }

}
