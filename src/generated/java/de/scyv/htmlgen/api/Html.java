package de.scyv.htmlgen.api;
import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;
/**
 * This class is generated. Do not change manually!
 */
public class Html extends AbstractElement {
    public Html() { super("html"); }
    public Head head() {
        return appendChild(new Head());
    }

    public Body body() {
        return appendChild(new Body());
    }

    public Html text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
