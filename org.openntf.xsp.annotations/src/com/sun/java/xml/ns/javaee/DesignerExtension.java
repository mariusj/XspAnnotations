//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.09 at 03:11:17 PM CEST 
//


package com.sun.java.xml.ns.javaee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for designer-extension complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="designer-extension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="in-palette" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="render-markup" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "designer-extension", propOrder = {
    "inPalette",
    "category",
    "renderMarkup"
})
public class DesignerExtension {

    @XmlElement(name = "in-palette")
    protected boolean inPalette;
    @XmlElement(required = true)
    protected java.lang.String category;
    @XmlElement(name = "render-markup", required = true)
    protected java.lang.String renderMarkup;

    /**
     * Gets the value of the inPalette property.
     * 
     */
    public boolean isInPalette() {
        return inPalette;
    }

    /**
     * Sets the value of the inPalette property.
     * 
     */
    public void setInPalette(boolean value) {
        this.inPalette = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setCategory(java.lang.String value) {
        this.category = value;
    }

    /**
     * Gets the value of the renderMarkup property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRenderMarkup() {
        return renderMarkup;
    }

    /**
     * Sets the value of the renderMarkup property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRenderMarkup(java.lang.String value) {
        this.renderMarkup = value;
    }

}
