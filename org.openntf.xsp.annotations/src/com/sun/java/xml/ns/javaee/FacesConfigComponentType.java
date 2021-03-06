//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.05 at 04:57:18 PM CEST 
//


package com.sun.java.xml.ns.javaee;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 
 *                 The "component" element represents a concrete UIComponent
 *                 implementation class that should be registered under the
 *                 specified type identifier, along with its associated 
 *                 properties and attributes.  Component types must be unique 
 *                 within the entire web application.
 * 
 *                 Nested "attribute" elements identify generic attributes that 
 *                 are recognized by the implementation logic of this component.
 *                 Nested "property" elements identify JavaBeans properties of 
 *                 the component class that may be exposed for manipulation 
 *                 via tools.
 * 
 *             
 * 
 * <p>Java class for faces-config-componentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="faces-config-componentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://java.sun.com/xml/ns/javaee}descriptionGroup"/>
 *         &lt;element name="component-type" type="{http://java.sun.com/xml/ns/javaee}string"/>
 *         &lt;element name="component-class" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType"/>
 *         &lt;element name="facet" type="{http://java.sun.com/xml/ns/javaee}faces-config-facetType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attribute" type="{http://java.sun.com/xml/ns/javaee}faces-config-attributeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="property" type="{http://java.sun.com/xml/ns/javaee}faces-config-propertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="component-extension" type="{http://java.sun.com/xml/ns/javaee}faces-config-component-extensionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faces-config-componentType", namespace = "http://java.sun.com/xml/ns/javaee", propOrder = {
    "description",
    "displayName",
    "icon",
    "componentType",
    "componentClass",
    "facet",
    "attribute",
    "property",
    "componentExtension"
})
public class FacesConfigComponentType {

    protected List<DescriptionType> description;
    @XmlElement(name = "display-name")
    protected List<DisplayNameType> displayName;
    protected List<IconType> icon;
    @XmlElement(name = "component-type", required = true)
    protected com.sun.java.xml.ns.javaee.String componentType;
    @XmlElement(name = "component-class", required = true)
    protected FullyQualifiedClassType componentClass;
    protected List<FacesConfigFacetType> facet;
    protected List<FacesConfigAttributeType> attribute;
    protected List<FacesConfigPropertyType> property;
    @XmlElement(name = "component-extension")
    protected List<FacesConfigComponentExtensionType> componentExtension;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the displayName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisplayName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisplayNameType }
     * 
     * 
     */
    public List<DisplayNameType> getDisplayName() {
        if (displayName == null) {
            displayName = new ArrayList<DisplayNameType>();
        }
        return this.displayName;
    }

    /**
     * Gets the value of the icon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IconType }
     * 
     * 
     */
    public List<IconType> getIcon() {
        if (icon == null) {
            icon = new ArrayList<IconType>();
        }
        return this.icon;
    }

    /**
     * Gets the value of the componentType property.
     * 
     * @return
     *     possible object is
     *     {@link com.sun.java.xml.ns.javaee.String }
     *     
     */
    public com.sun.java.xml.ns.javaee.String getComponentType() {
        return componentType;
    }

    /**
     * Sets the value of the componentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.sun.java.xml.ns.javaee.String }
     *     
     */
    public void setComponentType(com.sun.java.xml.ns.javaee.String value) {
        this.componentType = value;
    }

    /**
     * Gets the value of the componentClass property.
     * 
     * @return
     *     possible object is
     *     {@link FullyQualifiedClassType }
     *     
     */
    public FullyQualifiedClassType getComponentClass() {
        return componentClass;
    }

    /**
     * Sets the value of the componentClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullyQualifiedClassType }
     *     
     */
    public void setComponentClass(FullyQualifiedClassType value) {
        this.componentClass = value;
    }

    /**
     * Gets the value of the facet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the facet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFacet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacesConfigFacetType }
     * 
     * 
     */
    public List<FacesConfigFacetType> getFacet() {
        if (facet == null) {
            facet = new ArrayList<FacesConfigFacetType>();
        }
        return this.facet;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacesConfigAttributeType }
     * 
     * 
     */
    public List<FacesConfigAttributeType> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<FacesConfigAttributeType>();
        }
        return this.attribute;
    }

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacesConfigPropertyType }
     * 
     * 
     */
    public List<FacesConfigPropertyType> getProperty() {
        if (property == null) {
            property = new ArrayList<FacesConfigPropertyType>();
        }
        return this.property;
    }

    /**
     * Gets the value of the componentExtension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componentExtension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponentExtension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacesConfigComponentExtensionType }
     * 
     * 
     */
    public List<FacesConfigComponentExtensionType> getComponentExtension() {
        if (componentExtension == null) {
            componentExtension = new ArrayList<FacesConfigComponentExtensionType>();
        }
        return this.componentExtension;
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
