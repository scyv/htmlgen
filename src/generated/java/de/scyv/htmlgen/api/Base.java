package de.scyv.htmlgen.api;

import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;

import javax.annotation.Generated;

/**
 * This class represents a &lt;base&gt; html element.
 * This class is generated. Do not change manually!
 */
@Generated(value="HTMLGEN", date="2016-11-24T10:34Z")
/**
 * Represents a &lt;base&gt; html element.
 */
public class Base extends AbstractElement {

    public Base() { super("base"); }
    /**
     * Set the value for attribute class.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Base setClass(String value) {
        setAttribute("class", value);
        return this;
    }

    /**
     * Set the value for attribute id.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Base setId(String value) {
        setAttribute("id", value);
        return this;
    }

    /**
     * Set the value for attribute title.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Base setTitle(String value) {
        setAttribute("title", value);
        return this;
    }

    /**
     * Set the value for attribute style.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Base setStyle(String value) {
        setAttribute("style", value);
        return this;
    }

    /**
     * Set the value for attribute onblur.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Base setOnblur(String value) {
        setAttribute("onblur", value);
        return this;
    }

    /**
     * Set the value for attribute onclick.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Base setOnclick(String value) {
        setAttribute("onclick", value);
        return this;
    }

    /**
     * Append a text to the current element.

     * @param text The text value to add.
     * @return The current element.
     */
    public Base text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
