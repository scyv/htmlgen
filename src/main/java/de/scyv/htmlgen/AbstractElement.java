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
    
    protected AbstractElement(String name) {
        this.name = name;
    }
    
    protected <T extends AbstractElement> T appendChild(T child) {
        if (children == null) {
            children = new LinkedHashSet<>();
        }
        children.add(child);
        return child;
    }
    
    protected void appendAttribute(String key, String value) {
        if (attributes == null) {
            attributes = new LinkedHashMap<>();
        }
        attributes.put(key, value);
    }
    
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
