package de.scyv.htmlgen;

/**
 * Element that can have a text child element.
 */
public class TextContentElement extends AbstractElement {

    private String textContent;

    /**
     * Create the text content element.
     * @param textContent The text content
     */
    public TextContentElement(String textContent) {
        super("");
        this.textContent = textContent;
    }

    @Override
    public String toHTML() {
        return textContent;
    }

}
