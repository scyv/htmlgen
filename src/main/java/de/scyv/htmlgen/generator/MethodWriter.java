package de.scyv.htmlgen.generator;

/**
 * Generates code for a method of a HTMLElement.
 */
public class MethodWriter {

    /**
     * Writes the method to set the value of an attribute.
     *
     * @param attrName the attribute name
     * @param clazzName the class name
     * @return A StringBuilder that represent the method
     */
    public StringBuilder writeAttributeSetter(String attrName, String clazzName) {
        String tab = ElementUtil.tab();
        StringBuilder method = new StringBuilder();
        method.append(tab + "/**\n");
        method.append(tab + " * Set the value for attribute " + attrName + ".\n\n");
        method.append(tab + " * @param value the value for the attribute.\n");
        method.append(tab + " * @return The current element.\n");
        method.append(tab + " */\n");
        method.append(tab + "public " + clazzName + " set" + ElementUtil.upperFirst(attrName) + "(String value) {\n");
        method.append(tab + tab + "setAttribute(\"" + attrName + "\", value);\n");
        method.append(tab + tab + "return this;\n");
        method.append(tab + "}\n\n");
        return method;
    }

    /**
     * Writes the method to add a child to the current element.
     *
     * @param childElementName name of the child element
     * @return A StringBuilder that represent the method
     */
    public StringBuilder writeChildElementAppender(String childElementName) {
        StringBuilder method = new StringBuilder();
        String tab = ElementUtil.tab();
        String clazzName = ElementUtil.upperFirst(childElementName);
        method.append(tab + "/**\n");
        method.append(tab + " * Append a " + childElementName + " to the current element.\n\n");
        method.append(tab + " * @return An instance of the created child.\n");
        method.append(tab + " */\n");
        method.append(tab + "public " + clazzName + " " + childElementName + "() {\n");
        method.append(tab + tab + "return appendChild(new " + clazzName + "());\n");
        method.append(tab + "}\n\n");
        return method;
    }

    /**
     * Writes the method to add a text node to the current element.
     *
     * @param clazzName name of the class name of the html element
     * @return A StringBuilder that represent the method
     */
    public StringBuilder writeAddTextMethod(String clazzName) {
        StringBuilder method = new StringBuilder();
        String tab = ElementUtil.tab();
        method.append(tab + "/**\n");
        method.append(tab + " * Append a text to the current element.\n\n");
        method.append(tab + " * @param text The text value to add.\n");
        method.append(tab + " * @return The current element.\n");
        method.append(tab + " */\n");
        method.append(tab + "public " + clazzName + " text(String text) {\n");
        method.append(tab + tab + "appendChild(new TextContentElement(text));\n");
        method.append(tab + tab + "return this;\n");
        method.append(tab + "}\n\n");
        return method;
    }

}
