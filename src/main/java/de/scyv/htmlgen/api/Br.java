package de.scyv.htmlgen.api;
import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;
/**
 * This class is generated. Do not change manually!
 */
public class Br extends AbstractElement {
    public Br() { super("br"); }
    public Br text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
