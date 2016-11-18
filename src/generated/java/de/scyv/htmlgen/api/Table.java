package de.scyv.htmlgen.api;
import de.scyv.htmlgen.AbstractElement;
import de.scyv.htmlgen.TextContentElement;
/**
 * This class is generated. Do not change manually!
 */
public class Table extends AbstractElement {
    public Table() { super("table"); }
    public Tbody tbody() {
        return appendChild(new Tbody());
    }

    public Thead thead() {
        return appendChild(new Thead());
    }

    public Tr tr() {
        return appendChild(new Tr());
    }

    public Table text(String text) {
        appendChild(new TextContentElement(text));
        return this;
    }

}
