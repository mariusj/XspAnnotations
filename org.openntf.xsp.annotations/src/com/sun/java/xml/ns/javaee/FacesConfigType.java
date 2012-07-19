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
 *                 The "faces-config" element is the root of the configuration
 *                 information hierarchy, and contains nested elements for all
 *                 of the other configuration settings.
 * 
 *             
 * 
 * <p>Java class for faces-configType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="faces-configType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="application" type="{http://java.sun.com/xml/ns/javaee}faces-config-applicationType"/>
 *         &lt;element name="factory" type="{http://java.sun.com/xml/ns/javaee}faces-config-factoryType"/>
 *         &lt;element name="component" type="{http://java.sun.com/xml/ns/javaee}faces-config-componentType"/>
 *         &lt;element name="converter" type="{http://java.sun.com/xml/ns/javaee}faces-config-converterType"/>
 *         &lt;element name="managed-bean" type="{http://java.sun.com/xml/ns/javaee}faces-config-managed-beanType"/>
 *         &lt;element name="navigation-rule" type="{http://java.sun.com/xml/ns/javaee}faces-config-navigation-ruleType"/>
 *         &lt;element name="referenced-bean" type="{http://java.sun.com/xml/ns/javaee}faces-config-referenced-beanType"/>
 *         &lt;element name="render-kit" type="{http://java.sun.com/xml/ns/javaee}faces-config-render-kitType"/>
 *         &lt;element name="lifecycle" type="{http://java.sun.com/xml/ns/javaee}faces-config-lifecycleType"/>
 *         &lt;element name="validator" type="{http://java.sun.com/xml/ns/javaee}faces-config-validatorType"/>
 *         &lt;element name="faces-config-extension" type="{http://java.sun.com/xml/ns/javaee}faces-config-extensionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="version" use="required" type="{http://java.sun.com/xml/ns/javaee}faces-config-versionType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faces-configType", namespace = "http://java.sun.com/xml/ns/javaee", propOrder = {
    "applicationOrFactoryOrComponent"
})
public class FacesConfigType {

    @XmlElements({
        @XmlElement(name = "navigation-rule", type = FacesConfigNavigationRuleType.class),
        @XmlElement(name = "managed-bean", type = FacesConfigManagedBeanType.class),
        @XmlElement(name = "converter", type = FacesConfigConverterType.class),
        @XmlElement(name = "component", type = FacesConfigComponentType.class),
        @XmlElement(name = "faces-config-extension", type = FacesConfigExtensionType.class),
        @XmlElement(name = "validator", type = FacesConfigValidatorType.class),
        @XmlElement(name = "lifecycle", type = FacesConfigLifecycleType.class),
        @XmlElement(name = "render-kit", type = FacesConfigRenderKitType.class),
        @XmlElement(name = "application", type = FacesConfigApplicationType.class),
        @XmlElement(name = "referenced-bean", type = FacesConfigReferencedBeanType.class),
        @XmlElement(name = "factory", type = FacesConfigFactoryType.class)
    })
    protected List<Object> applicationOrFactoryOrComponent;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String version;

    /**
     * Gets the value of the applicationOrFactoryOrComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicationOrFactoryOrComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicationOrFactoryOrComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacesConfigNavigationRuleType }
     * {@link FacesConfigManagedBeanType }
     * {@link FacesConfigConverterType }
     * {@link FacesConfigComponentType }
     * {@link FacesConfigExtensionType }
     * {@link FacesConfigValidatorType }
     * {@link FacesConfigLifecycleType }
     * {@link FacesConfigRenderKitType }
     * {@link FacesConfigApplicationType }
     * {@link FacesConfigReferencedBeanType }
     * {@link FacesConfigFactoryType }
     * 
     * 
     */
    public List<Object> getApplicationOrFactoryOrComponent() {
        if (applicationOrFactoryOrComponent == null) {
            applicationOrFactoryOrComponent = new ArrayList<Object>();
        }
        return this.applicationOrFactoryOrComponent;
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

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setVersion(java.lang.String value) {
        this.version = value;
    }

}
