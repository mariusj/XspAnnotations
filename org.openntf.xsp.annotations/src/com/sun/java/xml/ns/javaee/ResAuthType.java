//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.05 at 04:57:18 PM CEST 
//


package com.sun.java.xml.ns.javaee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * 	The res-authType specifies whether the Deployment Component
 * 	code signs on programmatically to the resource manager, or
 * 	whether the Container will sign on to the resource manager
 * 	on behalf of the Deployment Component. In the latter case,
 * 	the Container uses information that is supplied by the
 * 	Deployer.
 * 
 * 	The value must be one of the two following:
 * 
 * 	    Application
 * 	    Container
 * 
 *       
 * 
 * <p>Java class for res-authType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="res-authType">
 *   &lt;simpleContent>
 *     &lt;restriction base="&lt;http://java.sun.com/xml/ns/javaee>string">
 *     &lt;/restriction>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "res-authType", namespace = "http://java.sun.com/xml/ns/javaee")
public class ResAuthType
    extends String
{


}
