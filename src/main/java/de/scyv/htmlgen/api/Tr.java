package de.scyv.htmlgen.api;
import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;
/**
 * This class is generated. Do not change manually!
 */
public class Tr extends AbstractElement {
    public Tr() { super("tr"); }
    public Td td() {
        return appendChild(new Td());
    }

    public Th th() {
        return appendChild(new Th());
    }

    public Tr text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
