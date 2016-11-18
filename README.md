# HTML Generator

This is a simple library for generating HTML Code.

## Generate the API

* `src/main/resources/api-spec.json` defines, how each element is defined and categorized
* The API itself is generated with the class `de.scyv.htmlgen.generator.Generator`
   * Run Generator.main() to start generation of the API
   
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
                                // allowed to be child of this element.
                                // If defined, has precedence before "childExcludes".
            ...                 // If defined and empty, NO child is allowed for this element.
        ],
        "childExcludes": [      // (optional)
            "notAllowedChild",  // Array of element names of elements that are
            ...                 // not allowed to be child of this element.
        ],
        "parentIncludes": [     // (optional)
            "parentElementName",// Array of element names of elements that are 
            ...                 // allowed to be a parent of this element.
        ]
    }  


