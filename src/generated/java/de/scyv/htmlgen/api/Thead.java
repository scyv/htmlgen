package de.scyv.htmlgen.api;

import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;

import javax.annotation.Generated;

/**
 * This class represents a &lt;thead&gt; html element.
 * This class is generated. Do not change manually!
 */
@Generated("2016-11-19T22:06Z")
/**
 * Represents a &lt;thead&gt; html element.
 */
public class Thead extends AbstractElement {

    public Thead() { super("thead"); }
    /**
     * Append a div to the current element.

     * @return An instance of the created child.
     */
    public Div div() {
        return appendChild(new Div());
    }

    /**
     * Append a h1 to the current element.

     * @return An instance of the created child.
     */
    public H1 h1() {
        return appendChild(new H1());
    }

    /**
     * Append a table to the current element.

     * @return An instance of the created child.
     */
    public Table table() {
        return appendChild(new Table());
    }

    /**
     * Append a tr to the current element.

     * @return An instance of the created child.
     */
    public Tr tr() {
        return appendChild(new Tr());
    }

    /**
     * Append a p to the current element.

     * @return An instance of the created child.
     */
    public P p() {
        return appendChild(new P());
    }

    /**
     * Append a br to the current element.

     * @return An instance of the created child.
     */
    public Br br() {
        return appendChild(new Br());
    }

    /**
     * Append a a to the current element.

     * @return An instance of the created child.
     */
    public A a() {
        return appendChild(new A());
    }

    /**
     * Append a base to the current element.

     * @return An instance of the created child.
     */
    public Base base() {
        return appendChild(new Base());
    }

    /**
     * Set the value for attribute class.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Thead setClass(String value) {
        setAttribute("class", value);
        return this;
    }

    /**
     * Set the value for attribute id.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Thead setId(String value) {
        setAttribute("id", value);
        return this;
    }

    /**
     * Set the value for attribute title.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Thead setTitle(String value) {
        setAttribute("title", value);
        return this;
    }

    /**
     * Set the value for attribute style.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Thead setStyle(String value) {
        setAttribute("style", value);
        return this;
    }

    /**
     * Set the value for attribute onblur.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Thead setOnblur(String value) {
        setAttribute("onblur", value);
        return this;
    }

    /**
     * Set the value for attribute onclick.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Thead setOnclick(String value) {
        setAttribute("onclick", value);
        return this;
    }

    /**
     * Append a text to the current element.

     * @param text The text value to add.
     * @return The current element.
     */
    public Thead text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
