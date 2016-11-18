package de.scyv.htmlgen.api;
import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;
/**
 * This class is generated. Do not change manually!
 */
public class Div extends AbstractElement {
    public Div() { super("div"); }
    public Div div() {
        return appendChild(new Div());
    }

    public H1 h1() {
        return appendChild(new H1());
    }

    public Table table() {
        return appendChild(new Table());
    }

    public P p() {
        return appendChild(new P());
    }

    public Br br() {
        return appendChild(new Br());
    }

    public A a() {
        return appendChild(new A());
    }

    public Base base() {
        return appendChild(new Base());
    }

    public Div attrClass(String value) {
        appendAttribute("class", value);
        return this;
    }

    public Div attrId(String value) {
        appendAttribute("id", value);
        return this;
    }

    public Div attrTitle(String value) {
        appendAttribute("title", value);
        return this;
    }

    public Div text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}