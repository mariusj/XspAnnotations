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

import java.io.Writer;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.openntf.xsp.annotations.XspGenComponent;
import org.openntf.xsp.annotations.XspGenProperty;

import com.sun.java.xml.ns.javaee.FacesConfigRenderKitType;
import com.sun.java.xml.ns.javaee.FacesConfigRendererType;
import com.sun.java.xml.ns.javaee.FacesConfigType;
import com.sun.java.xml.ns.javaee.FullyQualifiedClassType;
import com.sun.java.xml.ns.javaee.ObjectFactory;

/**
 * Generates faces-config.xml file.
 * @author Mariusz Jakubowski
 *
 */
public class FacesConfigGenerator extends AbstractGenerator {
	private FacesConfigType facesConfig;
	private FacesConfigRenderKitType renderKit;
	
	public FacesConfigGenerator(Filer filer, Messager messager) {
		super(filer, messager);
	}
	
	@Override
	public void start() {
		facesConfig = new FacesConfigType();
		renderKit = new FacesConfigRenderKitType();
		facesConfig.getApplicationOrFactoryOrComponent().add(renderKit);
	}
	
	@Override
	public void newComponent(TypeElement element, XspGenComponent annotation) {
		String fqn = element.getQualifiedName().toString();
		FacesConfigRendererType renderer = new FacesConfigRendererType();
		renderKit.getRenderer().add(renderer);
		if (!"".equals(annotation.componentFamily()))
			renderer.setComponentFamily(ComponentProcessor.wrapString(annotation.componentFamily()));
		if (!"".equals(annotation.renderer()))
			renderer.setRendererType(ComponentProcessor.wrapString(annotation.renderer()));
		else
			renderer.setRendererType(ComponentProcessor.wrapString(fqn));
		FullyQualifiedClassType fqcn = new FullyQualifiedClassType();
		fqcn.setValue(fqn + "Renderer");
		renderer.setRendererClass(fqcn);
	}
	
	@Override
	public void newProperty(VariableElement field, XspGenProperty annProp) {
	}

	@Override
	public void endComponent(TypeElement element) throws Exception {
	}

	/**
	 * {@inheritDoc}
	 * Writes library.faces-config.xml file.
	 */
	@Override
	public void end() throws Exception {
		JAXBContext context = JAXBContext
				.newInstance("com.sun.java.xml.ns.javaee");
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		FileObject file = filer.createResource(StandardLocation.SOURCE_OUTPUT,
				"", "../META-INF/library.faces-config.xml", (Element[]) null);
		messager.printMessage(Kind.NOTE, "creating " + file.toUri());
		Writer facesWriter = file.openWriter();
		ObjectFactory f = new ObjectFactory();
		JAXBElement<FacesConfigType> facesConfig2 = f.createFacesConfig(facesConfig);
		m.marshal(facesConfig2, facesWriter);
		facesWriter.close();
	}

	
}
