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

package org.openntf.xsp.annotations.processor;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

import org.openntf.xsp.annotations.XspGenComplexType;
import org.openntf.xsp.annotations.XspGenComponent;
import org.openntf.xsp.annotations.XspGenProperty;

/**
 * Base class for code & resource generators processing annotation {@link XspGenComponent}.  
 * @author Mariusz Jakubowski
 *
 */
public abstract class AbstractGenerator {
	
	protected Filer filer;
	protected Messager messager;
	
	/**
	 * Creates new generator.
	 * @param filer a Filer
	 * @param messager a Messager
	 */
	public AbstractGenerator(Filer filer, Messager messager) {
		super();
		this.filer = filer;
		this.messager = messager;
	}
	
	/**
	 * Called when processing of annotations starts.
	 */
	public abstract void start();
	
	/**
	 * Called on new component (new class with {@link XspGenComponent} annotation).
	 * @param element processed class
	 * @param annotation class annotation
	 */
	public abstract void newComponent(TypeElement element, XspGenComponent annotation);

	/**
	 * Called on new complexType (new class with {@link XspGenComplexType} annotation).
	 * @param element processed class
	 */
	public abstract void newComplexType(TypeElement element, XspGenComplexType annotation);
	
	
	/**
	 * Called on new property (field with {@link XspGenProperty} annotation).
	 * @param field processed field
	 * @param annProp field annotation
	 */
	public abstract void newProperty(VariableElement field, XspGenProperty annProp);
	
	/**
	 * Called after all properties of component.
	 * @param element processed class
	 * @throws Exception
	 */
	public abstract void endComponent(TypeElement element) throws Exception;
	

	/**
	 * Called when processing of annotations ends. 
	 * @throws Exception
	 */
	public abstract void end() throws Exception;
	
	
}
