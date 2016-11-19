package de.scyv.htmlgen;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * An abstract element 
 */
public abstract class AbstractElement {

    private String name;
    private Set<AbstractElement> children;
    private Map<String, String> attributes;

    /**
     * Create the element with the given name.
     *
     * @param name the name of the attribute
     */
    protected AbstractElement(String name) {
        this.name = name;
    }

    /**
     * Append a child to the element.
     *
     * @param <T> the type of the child element
     * @param child the child element
     * @return  the child element
     */
    protected <T extends AbstractElement> T appendChild(T child) {
        if (children == null) {
            children = new LinkedHashSet<>();
        }
        children.add(child);
        return child;
    }

    /**
     * Sets the attribute value.
     * @param key the name of the attribute to set
     * @param value the value of the attribute
     */
    protected void setAttribute(String key, String value) {
        if (attributes == null) {
            attributes = new LinkedHashMap<>();
        }
        attributes.put(key, value);
    }

    /**
     * Output a string representation of the HTML.
     * @return String
     */
    public String toHTML() {
        StringBuilder sb = new StringBuilder();
        StringBuilder attributesSb = new StringBuilder();
        
        if (attributes != null && !attributes.isEmpty()) {
            for (Entry<String, String> entry: attributes.entrySet()) {
                String value = entry.getValue();
                attributesSb.append(" ");
                if (value== null || value.isEmpty() ) {
                    attributesSb.append(entry.getKey());
                } else {
                    attributesSb.append(entry.getKey() + "=\"" + value + "\"");
                }
            }
        }
        
        if (children == null || children.isEmpty()) {
            sb.append("<" + this.name + attributesSb + "/>");            
        } else {
            sb.append("<" + this.name + attributesSb+ ">");
            for(AbstractElement child : children) {
                sb.append(child.toHTML());
            }
            sb.append("</" + this.name + ">");            
        }
        return sb.toString();
    }
    
}
