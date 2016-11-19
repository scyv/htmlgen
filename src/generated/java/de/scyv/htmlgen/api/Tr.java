package de.scyv.htmlgen.api;

import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;

import javax.annotation.Generated;

/**
 * This class represents a &lt;tr&gt; html element.
 * This class is generated. Do not change manually!
 */
@Generated("2016-11-19T22:06Z")
/**
 * Represents a &lt;tr&gt; html element.
 */
public class Tr extends AbstractElement {

    public Tr() { super("tr"); }
    /**
     * Append a td to the current element.

     * @return An instance of the created child.
     */
    public Td td() {
        return appendChild(new Td());
    }

    /**
     * Append a th to the current element.

     * @return An instance of the created child.
     */
    public Th th() {
        return appendChild(new Th());
    }

    /**
     * Set the value for attribute class.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Tr setClass(String value) {
        setAttribute("class", value);
        return this;
    }

    /**
     * Set the value for attribute id.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Tr setId(String value) {
        setAttribute("id", value);
        return this;
    }

    /**
     * Set the value for attribute title.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Tr setTitle(String value) {
        setAttribute("title", value);
        return this;
    }

    /**
     * Set the value for attribute style.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Tr setStyle(String value) {
        setAttribute("style", value);
        return this;
    }

    /**
     * Set the value for attribute onblur.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Tr setOnblur(String value) {
        setAttribute("onblur", value);
        return this;
    }

    /**
     * Set the value for attribute onclick.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Tr setOnclick(String value) {
        setAttribute("onclick", value);
        return this;
    }

    /**
     * Append a text to the current element.

     * @param text The text value to add.
     * @return The current element.
     */
    public Tr text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
