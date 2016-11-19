package de.scyv.htmlgen.api;

import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;

import javax.annotation.Generated;

/**
 * This class represents a &lt;head&gt; html element.
 * This class is generated. Do not change manually!
 */
@Generated("2016-11-19T22:06Z")
/**
 * Represents a &lt;head&gt; html element.
 */
public class Head extends AbstractElement {

    public Head() { super("head"); }
    /**
     * Append a meta to the current element.

     * @return An instance of the created child.
     */
    public Meta meta() {
        return appendChild(new Meta());
    }

    /**
     * Append a noscript to the current element.

     * @return An instance of the created child.
     */
    public Noscript noscript() {
        return appendChild(new Noscript());
    }

    /**
     * Append a link to the current element.

     * @return An instance of the created child.
     */
    public Link link() {
        return appendChild(new Link());
    }

    /**
     * Append a style to the current element.

     * @return An instance of the created child.
     */
    public Style style() {
        return appendChild(new Style());
    }

    /**
     * Append a title to the current element.

     * @return An instance of the created child.
     */
    public Title title() {
        return appendChild(new Title());
    }

    /**
     * Append a script to the current element.

     * @return An instance of the created child.
     */
    public Script script() {
        return appendChild(new Script());
    }

    /**
     * Append a command to the current element.

     * @return An instance of the created child.
     */
    public Command command() {
        return appendChild(new Command());
    }

    /**
     * Set the value for attribute class.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Head setClass(String value) {
        setAttribute("class", value);
        return this;
    }

    /**
     * Set the value for attribute id.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Head setId(String value) {
        setAttribute("id", value);
        return this;
    }

    /**
     * Set the value for attribute title.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Head setTitle(String value) {
        setAttribute("title", value);
        return this;
    }

    /**
     * Set the value for attribute style.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Head setStyle(String value) {
        setAttribute("style", value);
        return this;
    }

    /**
     * Set the value for attribute onblur.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Head setOnblur(String value) {
        setAttribute("onblur", value);
        return this;
    }

    /**
     * Set the value for attribute onclick.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Head setOnclick(String value) {
        setAttribute("onclick", value);
        return this;
    }

    /**
     * Append a text to the current element.

     * @param text The text value to add.
     * @return The current element.
     */
    public Head text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
