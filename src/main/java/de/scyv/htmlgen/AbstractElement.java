package de.scyv.htmlgen;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * An abstract element 
 */
public abstract class AbstractElement {

    private String name;
    private Set<AbstractElement> children;
    
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
    
    public String toHTML() {
        StringBuilder sb = new StringBuilder();
        if (children == null || children.isEmpty()) {
            sb.append("<" + this.name + "/>");            
        } else {
            sb.append("<" + this.name + ">");
            for(AbstractElement child : children) {
                sb.append(child.toHTML());
            }
            sb.append("</" + this.name + ">");            
        }
        return sb.toString();
    }
    
}
