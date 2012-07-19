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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *                 
 *                 The "list-entries" element represents a set of initialization
 *                 elements for a managed property that is a java.util.List or an
 *                 array.  In the former case, the "value-class" element can 
 *                 optionally be used to declare the Java type to which each 
 *                 value should be converted before adding it to the Collection.
 *                 
 *             
 * 
 * <p>Java class for faces-config-list-entriesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="faces-config-list-entriesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value-class" type="{http://java.sun.com/xml/ns/javaee}faces-config-value-classType" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="null-value" type="{http://java.sun.com/xml/ns/javaee}faces-config-null-valueType"/>
 *           &lt;element name="value" type="{http://java.sun.com/xml/ns/javaee}faces-config-valueType"/>
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
@XmlType(name = "faces-config-list-entriesType", namespace = "http://java.sun.com/xml/ns/javaee", propOrder = {
    "valueClass",
    "nullValueOrValue"
})
public class FacesConfigListEntriesType {

    @XmlElement(name = "value-class")
    protected FacesConfigValueClassType valueClass;
    @XmlElements({
        @XmlElement(name = "value", type = java.lang.String.class),
        @XmlElement(name = "null-value", type = FacesConfigNullValueType.class)
    })
    protected List<Object> nullValueOrValue;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

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
     * Gets the value of the nullValueOrValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nullValueOrValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNullValueOrValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String }
     * {@link FacesConfigNullValueType }
     * 
     * 
     */
    public List<Object> getNullValueOrValue() {
        if (nullValueOrValue == null) {
            nullValueOrValue = new ArrayList<Object>();
        }
        return this.nullValueOrValue;
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
