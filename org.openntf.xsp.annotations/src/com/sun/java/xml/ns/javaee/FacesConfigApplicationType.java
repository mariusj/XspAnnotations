//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.05 at 04:57:18 PM CEST 
//


package com.sun.java.xml.ns.javaee;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 
 *                 The "application" element provides a mechanism to define the
 *                 various per-application-singleton implementation artifacts for
 *                 a particular web application that is utilizing 
 *                 JavaServer Faces.  For nested elements that are not specified, 
 *                 the JSF implementation must provide a suitable default.
 * 
 *             
 * 
 * <p>Java class for faces-config-applicationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="faces-config-applicationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="action-listener" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType"/>
 *         &lt;element name="default-render-kit-id" type="{http://java.sun.com/xml/ns/javaee}string"/>
 *         &lt;element name="message-bundle" type="{http://java.sun.com/xml/ns/javaee}string"/>
 *         &lt;element name="navigation-handler" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType"/>
 *         &lt;element name="view-handler" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType"/>
 *         &lt;element name="state-manager" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType"/>
 *         &lt;element name="el-resolver" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType"/>
 *         &lt;element name="property-resolver" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType"/>
 *         &lt;element name="variable-resolver" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType"/>
 *         &lt;element name="locale-config" type="{http://java.sun.com/xml/ns/javaee}faces-config-locale-configType"/>
 *         &lt;element name="resource-bundle" type="{http://java.sun.com/xml/ns/javaee}faces-config-application-resource-bundleType"/>
 *         &lt;element name="application-extension" type="{http://java.sun.com/xml/ns/javaee}faces-config-application-extensionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faces-config-applicationType", namespace = "http://java.sun.com/xml/ns/javaee", propOrder = {
    "actionListenerOrDefaultRenderKitIdOrMessageBundle"
})
public class FacesConfigApplicationType {

    @XmlElementRefs({
        @XmlElementRef(name = "variable-resolver", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "locale-config", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "default-render-kit-id", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "property-resolver", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "action-listener", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "resource-bundle", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "navigation-handler", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "message-bundle", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "view-handler", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "el-resolver", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "application-extension", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class),
        @XmlElementRef(name = "state-manager", namespace = "http://java.sun.com/xml/ns/javaee", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> actionListenerOrDefaultRenderKitIdOrMessageBundle;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the actionListenerOrDefaultRenderKitIdOrMessageBundle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actionListenerOrDefaultRenderKitIdOrMessageBundle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActionListenerOrDefaultRenderKitIdOrMessageBundle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link FacesConfigLocaleConfigType }{@code >}
     * {@link JAXBElement }{@code <}{@link FullyQualifiedClassType }{@code >}
     * {@link JAXBElement }{@code <}{@link FullyQualifiedClassType }{@code >}
     * {@link JAXBElement }{@code <}{@link FullyQualifiedClassType }{@code >}
     * {@link JAXBElement }{@code <}{@link com.sun.java.xml.ns.javaee.String }{@code >}
     * {@link JAXBElement }{@code <}{@link FullyQualifiedClassType }{@code >}
     * {@link JAXBElement }{@code <}{@link FacesConfigApplicationResourceBundleType }{@code >}
     * {@link JAXBElement }{@code <}{@link FullyQualifiedClassType }{@code >}
     * {@link JAXBElement }{@code <}{@link FullyQualifiedClassType }{@code >}
     * {@link JAXBElement }{@code <}{@link com.sun.java.xml.ns.javaee.String }{@code >}
     * {@link JAXBElement }{@code <}{@link FullyQualifiedClassType }{@code >}
     * {@link JAXBElement }{@code <}{@link FacesConfigApplicationExtensionType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getActionListenerOrDefaultRenderKitIdOrMessageBundle() {
        if (actionListenerOrDefaultRenderKitIdOrMessageBundle == null) {
            actionListenerOrDefaultRenderKitIdOrMessageBundle = new ArrayList<JAXBElement<?>>();
        }
        return this.actionListenerOrDefaultRenderKitIdOrMessageBundle;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

}
