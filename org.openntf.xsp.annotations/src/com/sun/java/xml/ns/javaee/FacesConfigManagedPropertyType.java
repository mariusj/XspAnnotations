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
 *                 The "managed-property" element represents an individual 
 *                 property of a managed bean that will be configured to the 
 *                 specified value (or value set) if the corresponding 
 *                 managed bean is automatically created.
 *                 
 *             
 * 
 * <p>Java class for faces-config-managed-propertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="faces-config-managed-propertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://java.sun.com/xml/ns/javaee}descriptionGroup"/>
 *         &lt;element name="property-name" type="{http://java.sun.com/xml/ns/javaee}string"/>
 *         &lt;element name="property-class" type="{http://java.sun.com/xml/ns/javaee}java-typeType" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="map-entries" type="{http://java.sun.com/xml/ns/javaee}faces-config-map-entriesType"/>
 *           &lt;element name="null-value" type="{http://java.sun.com/xml/ns/javaee}faces-config-null-valueType"/>
 *           &lt;element name="value" type="{http://java.sun.com/xml/ns/javaee}faces-config-valueType"/>
 *           &lt;element name="list-entries" type="{http://java.sun.com/xml/ns/javaee}faces-config-list-entriesType"/>
 *         &lt;/choice>
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
@XmlType(name = "faces-config-managed-propertyType", namespace = "http://java.sun.com/xml/ns/javaee", propOrder = {
    "description",
    "displayName",
    "icon",
    "propertyName",
    "propertyClass",
    "mapEntries",
    "nullValue",
    "value",
    "listEntries"
})
public class FacesConfigManagedPropertyType {

    protected List<DescriptionType> description;
    @XmlElement(name = "display-name")
    protected List<DisplayNameType> displayName;
    protected List<IconType> icon;
    @XmlElement(name = "property-name", required = true)
    protected com.sun.java.xml.ns.javaee.String propertyName;
    @XmlElement(name = "property-class")
    protected JavaTypeType propertyClass;
    @XmlElement(name = "map-entries")
    protected FacesConfigMapEntriesType mapEntries;
    @XmlElement(name = "null-value")
    protected FacesConfigNullValueType nullValue;
    protected java.lang.String value;
    @XmlElement(name = "list-entries")
    protected FacesConfigListEntriesType listEntries;
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
     * Gets the value of the propertyName property.
     * 
     * @return
     *     possible object is
     *     {@link com.sun.java.xml.ns.javaee.String }
     *     
     */
    public com.sun.java.xml.ns.javaee.String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the value of the propertyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.sun.java.xml.ns.javaee.String }
     *     
     */
    public void setPropertyName(com.sun.java.xml.ns.javaee.String value) {
        this.propertyName = value;
    }

    /**
     * Gets the value of the propertyClass property.
     * 
     * @return
     *     possible object is
     *     {@link JavaTypeType }
     *     
     */
    public JavaTypeType getPropertyClass() {
        return propertyClass;
    }

    /**
     * Sets the value of the propertyClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JavaTypeType }
     *     
     */
    public void setPropertyClass(JavaTypeType value) {
        this.propertyClass = value;
    }

    /**
     * Gets the value of the mapEntries property.
     * 
     * @return
     *     possible object is
     *     {@link FacesConfigMapEntriesType }
     *     
     */
    public FacesConfigMapEntriesType getMapEntries() {
        return mapEntries;
    }

    /**
     * Sets the value of the mapEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacesConfigMapEntriesType }
     *     
     */
    public void setMapEntries(FacesConfigMapEntriesType value) {
        this.mapEntries = value;
    }

    /**
     * Gets the value of the nullValue property.
     * 
     * @return
     *     possible object is
     *     {@link FacesConfigNullValueType }
     *     
     */
    public FacesConfigNullValueType getNullValue() {
        return nullValue;
    }

    /**
     * Sets the value of the nullValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacesConfigNullValueType }
     *     
     */
    public void setNullValue(FacesConfigNullValueType value) {
        this.nullValue = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    /**
     * Gets the value of the listEntries property.
     * 
     * @return
     *     possible object is
     *     {@link FacesConfigListEntriesType }
     *     
     */
    public FacesConfigListEntriesType getListEntries() {
        return listEntries;
    }

    /**
     * Sets the value of the listEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacesConfigListEntriesType }
     *     
     */
    public void setListEntries(FacesConfigListEntriesType value) {
        this.listEntries = value;
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
