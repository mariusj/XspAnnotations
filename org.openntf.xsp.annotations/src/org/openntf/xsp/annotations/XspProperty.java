/*
 * © Copyright Mariusz Jakubowski 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */

package org.openntf.xsp.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Defines a XPages property
 * @author Mariusz Jakubowski
 *
 */
@Target(ElementType.FIELD)
public @interface XspProperty {
	/**
	 * Description of a property.
	 */
	String description();
	
	/**
	 * Name displayed in property editor.
	 */
	String displayName();
	
	/**
	 * Property class used in xsp-config.
	 */
	String propertyClass() default "";
	
	/**
	 * Default property value.
	 */
	String defaultValue() default "";
	
	/**
	 * Category of a property
	 */
	String category() default "";
	
	/**
	 * Editor used to edit property in properties editor.
	 */
	String editor() default "";
	
	/**
	 * Editor parameters.
	 */
	String editorParameter() default "";

	/**
	 * Flag allowRunTimeBinding in xsp-config
	 */
	boolean allowRunTimeBinding() default true;
	
	/**
	 * If true this property is a collection
	 */
	boolean collectionProperty() default false;
	
	/**
	 * For collection property - class for property item. 
	 */
	String propertyItemClass() default "";
	
	/**
	 * For collection property - name of a method to add a new item. 
	 */
	String propertyAddMethod() default "";
	
	/**
	 * If true code for this property will not be generated. 
	 */
	boolean dontGenerateCode() default false;
}
