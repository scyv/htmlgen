# HTML Generator

This is a simple library for generating HTML Code.

## Generate the API

* `src/main/resources/api-spec.json` defines, how each element is defined and categorized
* The API itself is generated with the class `de.scyv.htmlgen.generator.Generator`
   * Run Generator.main() to start generation of the API

## KNOWN ISSUES

* There are many elements and attributes still missing
* We are not able to enforce the order of elements (which is needed by some elements) yet
* We cannot restrict attribute category of an element (by now the global attributes are allowed for every element)
 
## The file api-spec.json

* The file api-spec.json represents the contents of https://www.w3.org/TR/html-markup/ in an easy parseable json format.
* The file contains the two sections "attributes" and "elements"
    * "attributes" defines possible attributes
    * "elements" defines the elements and their relationship with other elements

#### Element definition:


    {
        "name" : "MyElement",
        "childIncludes": [      // (optional)
            "childElementName", // Array of element names of elements that are
                                // the ONLY allowed childs of this element.
                                // If defined, has precedence before "childExcludes".
            ...                 // If defined and empty, NO child is allowed for this element.
        ],
        "childExcludes": [      // (optional)
            "notAllowedChild",  // Array of element names of elements that are
            ...                 // not allowed to be child of this element.
        ],
        "parentIncludes": [     // (optional)
            "parentElementName",// Array of element names of elements that are 
            ...                 // the ONLY allowed parents of this element.
        ],
        "attributes": [         // (optional)
            "someAttribute"     //
            ...
        ],
        "notext": true          // (optional) When set to true, no text content is allowed
                                // within the element. Defaults to false.
    }  


