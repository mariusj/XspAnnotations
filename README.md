XspAnnotations
==============

A set of annotations and code generators for XPages components.


Creating a reusable component in XPages involves very extensive code duplication. One have to implement:

* a class that manages properties and a state of a component:
    * constructor
    * override getFamily method
    * for every property write a set method and a get method
    * a get method for property is not simply returning a value but involves checking the value binding. It is about 8 lines of code for every method. The code is almost identical for every get method.
    * override restoreState and saveState methods
 * a class for rendering component
 * a .xsp-config file with very descriptive \<component\> declaration
 * an entry in a faces-config.xml file


This project simplifies this task. Using a set of annotations a code and xml files can be generated automatically. 
It is infulenced by JSF 2.0 specification (XPages are based on JSF 1.2 and doesn't support annotations).


Annotatations defined in this project are as follows:

 * `XspGenComponent` - for marking a class as a component
 * `XspGenProperty` - for marking a field as property
 * `XspGenDojoRenderer` - for marking a class a renderer based on a Dojo
 * `XspGenComplexType` - for marking a class as a complex type


These annotations are used by following generators:

 * `ComponentSourceGenerator` - generates a code for a XPages component
 * `DojoRendererSourceGenerator` - generates a code for a Dojo renderer
 * `FacesConfigGenerator` - generates a *.faces-config.xml file with renderes definitions
 * `XspConfigGenerator` - generates a *.xsp-config file with component and property definitions


A sample component defined using this project contains only one short file:


        @XspGenComponent(
                description = "A Button with progress indicator built in, for indicating processing after you press the button", 
                displayName = "Dojo BusyButton", 
                tagName = "dxBusyButton",
                componentFamily = "javax.faces.Input",
                baseComponentType = "com.ibm.xsp.extlib.dojo.form.Button",
                paletteCategory = "Extlib DojoX"
        )
        @XspGenDojoRenderer(
                baseClass = "com.ibm.xsp.extlib.renderkit.dojo.form.DojoButtonRenderer",
                dojoModule = "dojox.form.BusyButton",
                defaultDojoType = "dojox.form.BusyButton",
                css = { "/.ibmxspres/dojoroot/dojox/form/resources/BusyButton.css" }
        )
        public abstract class BusyButton extends UIDojoButton {        
            @XspGenProperty(
                    description = "text while button is busy", 
                    displayName = "Busy Label",
                    category = "dojo-widget"
            )
            protected String busyLabel;
            
            @XspGenProperty(
                    description = "use a busy icon", 
                    displayName = "Use Busy Icon",
                    category = "dojo-widget"
            )
            protected Boolean useIcon;            
        }
