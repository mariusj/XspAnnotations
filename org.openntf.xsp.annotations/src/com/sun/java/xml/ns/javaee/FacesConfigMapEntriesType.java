//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.09 at 03:11:17 PM CEST 
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
 *                 The "map-entries' element represents a set of key-entry pairs 
 *                 that will be added to the computed value of a managed property 
 *                 of type java.util.Map.  In addition, the Java class types 
 *                 of the key and entry values may be optionally declared.
 *                 
 *             
 * 
 * <p>Java class for faces-config-map-entriesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="faces-config-map-entriesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="key-class" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType" minOccurs="0"/>
 *         &lt;element name="value-class" type="{http://java.sun.com/xml/ns/javaee}faces-config-value-classType" minOccurs="0"/>
 *         &lt;element name="map-entry" type="{http://java.sun.com/xml/ns/javaee}faces-config-map-entryType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "faces-config-map-entriesType", propOrder = {
    "keyClass",
    "valueClass",
    "mapEntry"
})
public class FacesConfigMapEntriesType {

    @XmlElement(name = "key-class")
    protected FullyQualifiedClassType keyClass;
    @XmlElement(name = "value-class")
    protected FacesConfigValueClassType valueClass;
    @XmlElement(name = "map-entry")
    protected List<FacesConfigMapEntryType> mapEntry;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the keyClass property.
     * 
     * @return
     *     possible object is
     *     {@link FullyQualifiedClassType }
     *     
     */
    public FullyQualifiedClassType getKeyClass() {
        return keyClass;
    }

    /**
     * Sets the value of the keyClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullyQualifiedClassType }
     *     
     */
    public void setKeyClass(FullyQualifiedClassType value) {
        this.keyClass = value;
    }

    /**
     * Gets the value of the valueClass property.
     * 
     * @return
     *     possible object is
     *     {@link FacesConfigValueClassType }
     *     
     */
    public FacesConfigValueClassType getValueClass() {
        return valueClass;
    }

    /**
     * Sets the value of the valueClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacesConfigValueClassType }
     *     
     */
    public void setValueClass(FacesConfigValueClassType value) {
        this.valueClass = value;
    }

    /**
     * Gets the value of the mapEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacesConfigMapEntryType }
     * 
     * 
     */
    public List<FacesConfigMapEntryType> getMapEntry() {
        if (mapEntry == null) {
            mapEntry = new ArrayList<FacesConfigMapEntryType>();
        }
        return this.mapEntry;
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
