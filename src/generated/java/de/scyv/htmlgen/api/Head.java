package de.scyv.htmlgen.api;
import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;
/**
 * This class is generated. Do not change manually!
 */
public class Head extends AbstractElement {
    public Head() { super("head"); }
    public Meta meta() {
        return appendChild(new Meta());
    }

    public Noscript noscript() {
        return appendChild(new Noscript());
    }

    public Link link() {
        return appendChild(new Link());
    }

    public Style style() {
        return appendChild(new Style());
    }

    public Title title() {
        return appendChild(new Title());
    }

    public Script script() {
        return appendChild(new Script());
    }

    public Command command() {
        return appendChild(new Command());
    }

    public Head text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
