package de.scyv.htmlgen.generator;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Utilities for getting data from an JSONObject
 */
public final class ElementUtil {

    private ElementUtil() {
        // util class
    }

    /**
     * Get the name of an element.
     * 
     * @param obj if obj is instance of JSONObject we use the "name" property of the json object.
     * @return the name.
     */
    public static final String getElementName(Object obj) {
        final String name;
        if (obj instanceof JSONObject) {
            name = String.valueOf(((JSONObject) obj).get("name"));
        } else {
            name = String.valueOf(obj);
        }
        return name;
    }
    
    /** 
     * @return Return a tab representation.
     */
    public static final String tab() {
        return "    ";
    }

    /**
     * Makes the first character of a string an upper case letter.
     * 
     * @param input the input string
     * @return a new string with the first letter capitalized.
     */
    public static final String upperFirst(String input) {        
        return input.substring(0, 1).toUpperCase() + (input.length() > 1 ? input.substring(1) : "");
    }
    
    /**
     * Get the element names from an array of json objects.
     * 
     * @param element the element where the array is.
     * @param arrayName the name of the array to look for
     * @return a set of the element names.
     */
    public static final Set<String> getAllElementNames(JSONObject element, String arrayName) {
        Set<String> result = new HashSet<>();
        if (element.has(arrayName)) {
            return getAllElementNames(element.getJSONArray(arrayName));
        }
        return result;
    }

    /**
     * Get the element names from an array of json objects.
     * 
     * @param elements the array to search in.
     * @return a set of the element names.
     */
    public static final Set<String> getAllElementNames(JSONArray elements) {
        Set<String> result = new HashSet<>();
        elements.forEach(obj -> {
            result.add(getElementName(obj));
        });
        return result;
    }
   
}
