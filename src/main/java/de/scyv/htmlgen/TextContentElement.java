package de.scyv.htmlgen;

public class TextContentElement extends AbstractElement {

    private String textContent;

    public TextContentElement(String textContent) {
        super("");
        this.textContent = textContent;
    }

    @Override
    public String toHTML() {
        return textContent;
    }
    
}
