package de.scyv.htmlgen.api;
import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;
/**
 * This class is generated. Do not change manually!
 */
public class Tbody extends AbstractElement {
    public Tbody() { super("tbody"); }
    public Tr tr() {
        return appendChild(new Tr());
    }

    public Tbody text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
