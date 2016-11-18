package de.scyv.htmlgen.api;
import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;
/**
 * This class is generated. Do not change manually!
 */
public class Title extends AbstractElement {
    public Title() { super("title"); }
    public Title text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
