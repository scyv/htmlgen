package de.scyv.htmlgen.api;
import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;
/**
 * This class is generated. Do not change manually!
 */
public class Base extends AbstractElement {
    public Base() { super("base"); }
    public Base text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
