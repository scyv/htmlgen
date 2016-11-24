package de.scyv.htmlgen.api;

import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;

import javax.annotation.Generated;

/**
 * This class represents a &lt;table&gt; html element.
 * This class is generated. Do not change manually!
 */
@Generated(value="HTMLGEN", date="2016-11-24T10:34Z")
/**
 * Represents a &lt;table&gt; html element.
 */
public class Table extends AbstractElement {

    public Table() { super("table"); }
    /**
     * Append a tbody to the current element.

     * @return An instance of the created child.
     */
    public Tbody tbody() {
        return appendChild(new Tbody());
    }

    /**
     * Append a thead to the current element.

     * @return An instance of the created child.
     */
    public Thead thead() {
        return appendChild(new Thead());
    }

    /**
     * Append a tr to the current element.

     * @return An instance of the created child.
     */
    public Tr tr() {
        return appendChild(new Tr());
    }

    /**
     * Set the value for attribute class.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Table setClass(String value) {
        setAttribute("class", value);
        return this;
    }

    /**
     * Set the value for attribute id.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Table setId(String value) {
        setAttribute("id", value);
        return this;
    }

    /**
     * Set the value for attribute title.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Table setTitle(String value) {
        setAttribute("title", value);
        return this;
    }

    /**
     * Set the value for attribute style.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Table setStyle(String value) {
        setAttribute("style", value);
        return this;
    }

    /**
     * Set the value for attribute onblur.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Table setOnblur(String value) {
        setAttribute("onblur", value);
        return this;
    }

    /**
     * Set the value for attribute onclick.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Table setOnclick(String value) {
        setAttribute("onclick", value);
        return this;
    }

    /**
     * Set the value for attribute cellpadding.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Table setCellpadding(String value) {
        setAttribute("cellpadding", value);
        return this;
    }

    /**
     * Set the value for attribute cellspacing.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Table setCellspacing(String value) {
        setAttribute("cellspacing", value);
        return this;
    }

    /**
     * Set the value for attribute border.

     * @param value the value for the attribute.
     * @return The current element.
     */
    public Table setBorder(String value) {
        setAttribute("border", value);
        return this;
    }

    /**
     * Append a text to the current element.

     * @param text The text value to add.
     * @return The current element.
     */
    public Table text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
