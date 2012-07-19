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
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.openntf.xsp.annotations.XspGenComplexType;
import org.openntf.xsp.annotations.XspGenComponent;
import org.openntf.xsp.annotations.XspGenProperty;
import org.openntf.xsp.annotations.processor.ComponentProcessor.PropertyInfo;

import com.sun.java.xml.ns.javaee.DescriptionType;
import com.sun.java.xml.ns.javaee.DesignerExtension;
import com.sun.java.xml.ns.javaee.DisplayNameType;
import com.sun.java.xml.ns.javaee.FacesConfigComplexExtensionType;
import com.sun.java.xml.ns.javaee.FacesConfigComplexType;
import com.sun.java.xml.ns.javaee.FacesConfigComponentExtensionType;
import com.sun.java.xml.ns.javaee.FacesConfigComponentType;
import com.sun.java.xml.ns.javaee.FacesConfigConverterType;
import com.sun.java.xml.ns.javaee.FacesConfigExtensionType;
import com.sun.java.xml.ns.javaee.FacesConfigPropertyExtensionType;
import com.sun.java.xml.ns.javaee.FacesConfigPropertyType;
import com.sun.java.xml.ns.javaee.FacesConfigType;
import com.sun.java.xml.ns.javaee.FullyQualifiedClassType;
import com.sun.java.xml.ns.javaee.IconType;
import com.sun.java.xml.ns.javaee.JavaTypeType;
import com.sun.java.xml.ns.javaee.ObjectFactory;
import com.sun.java.xml.ns.javaee.PathType;
import com.sun.java.xml.ns.javaee.PropertyDesignerExtensionType;


/**
 * Generates .xsp-config file
 * @author Mariusz Jakubowski
 *
 */
public class XspConfigGenerator extends AbstractGenerator {
	private FacesConfigType xspConfig;
	private FacesConfigComponentType component;

	public XspConfigGenerator(Filer filer, Messager messager) {
		super(filer, messager);
	}

	@Override
	public void start() {
		xspConfig = new FacesConfigType();
		
		FacesConfigExtensionType ext = new FacesConfigExtensionType();
		xspConfig.getApplicationOrFactoryOrComponent().add(ext);

		ext.setDefaultPrefix("xe");
		ext.setNamespaceUri("http://www.ibm.com/xsp/coreex");
	}
	
	@Override
	public void newComponent(TypeElement element, XspGenComponent annotation) {
		Name name = element.getSimpleName();
		messager.printMessage(Kind.NOTE, "adding component " + name);

		component = new FacesConfigComponentType();
		xspConfig.getApplicationOrFactoryOrComponent().add(component);
		
		DescriptionType desc = new DescriptionType();
		component.getDescription().add(desc);
		desc.setValue(annotation.description());
		
		DisplayNameType dname = new DisplayNameType();
		component.getDisplayName().add(dname);
		dname.setValue(annotation.displayName());
		
		IconType icon = new IconType();
		boolean addIcon = false;
		if (!"".equals(annotation.smallIcon())) {
			PathType small = new PathType();
			small.setValue(annotation.smallIcon());
			icon.setSmallIcon(small);
			addIcon = true;
		}
		if (!"".equals(annotation.largeIcon())) {
			PathType large = new PathType();
			large.setValue(annotation.largeIcon());
			icon.setLargeIcon(large);
			addIcon = true;
		}
		if (addIcon) {
			component.getIcon().add(icon);
		}
		
		if (!"".equals(annotation.componentType()))
			component.setComponentType(ComponentProcessor.wrapString(annotation.componentType()));
		else
			component.setComponentType(ComponentProcessor.wrapString(element.getQualifiedName().toString()));
		
		FullyQualifiedClassType fqcn = new FullyQualifiedClassType();
		fqcn.setValue(element.getQualifiedName().toString() + "Impl");
		component.setComponentClass(fqcn);
		
		FacesConfigComponentExtensionType ext = new FacesConfigComponentExtensionType();
		component.getComponentExtension().add(ext);
		
		ext.setBaseComponentType(annotation.baseComponentType());
		if (!"".equals(annotation.componentFamily())) {
			ext.setComponentFamily(annotation.componentFamily());
		}
		ext.setTagName(annotation.tagName());
		
		DesignerExtension desext = new DesignerExtension();
		ext.setDesignerExtension(desext);
		
		desext.setCategory(annotation.paletteCategory());
		desext.setInPalette(annotation.inPalette());
		
		if (!"".equals(annotation.markup()))
			desext.setRenderMarkup(annotation.markup());
	}
	
	@Override
	public void newComplexType(TypeElement element, XspGenComplexType annotation) {
		Name name = element.getSimpleName();
		messager.printMessage(Kind.NOTE, "adding complex type " + name);
		
		FacesConfigComplexType complex = new FacesConfigComplexType();
		xspConfig.getApplicationOrFactoryOrComponent().add(complex);
		
		DescriptionType desc = new DescriptionType();
		complex.getDescription().add(desc);
		desc.setValue(annotation.description());
		
		DisplayNameType dname = new DisplayNameType();
		complex.getDisplayName().add(dname);
		dname.setValue(annotation.displayName());

		complex.setComplexId(ComponentProcessor.wrapString(element.getQualifiedName().toString()));

		FullyQualifiedClassType fqcn = new FullyQualifiedClassType();
		fqcn.setValue(element.getQualifiedName().toString() + "Impl");
		complex.setComplexClass(fqcn);
		
		FacesConfigComplexExtensionType ext = new FacesConfigComplexExtensionType();
		complex.getComplexExtension().add(ext);
		
		ext.setTagName(annotation.tagName());
	}
	
	
	
	@Override
	public void newProperty(VariableElement field, XspGenProperty annProp) {
		messager.printMessage(Kind.NOTE, "  adding property " + annProp.displayName());
		FacesConfigPropertyType prop = new FacesConfigPropertyType();
		component.getProperty().add(prop);

		DescriptionType pdesc = new DescriptionType();						
		prop.getDescription().add(pdesc);
		pdesc.setValue(annProp.description());
		
		DisplayNameType pname = new DisplayNameType();
		prop.getDisplayName().add(pname);
		pname.setValue(annProp.displayName());
		
		com.sun.java.xml.ns.javaee.String strName = new com.sun.java.xml.ns.javaee.String();
		strName.setValue(field.getSimpleName().toString());
		prop.setPropertyName(strName);
		
		FacesConfigPropertyExtensionType ext = new FacesConfigPropertyExtensionType();
		prop.getPropertyExtension().add(ext);
		
		JavaTypeType type = new JavaTypeType();
		if ("".equals(annProp.propertyClass())) {
			PropertyInfo xspType = ComponentProcessor.javaTypeToXspType(field);
			type.setValue(xspType.xspType);
			if (xspType.xspItemType != null) {
				ext.setAllowRunTimeBinding(false);
				ext.setCollectionProperty(true);
				ext.setPropertyItemClass(xspType.xspItemType);
			}
		} else {
			type.setValue(annProp.propertyClass());
		}
		prop.setPropertyClass(type);
		
		if (!"".equals(annProp.defaultValue())) { 
			ext.setDefaultValue(annProp.defaultValue());
		}

		if (!annProp.allowRunTimeBinding()) {
			ext.setAllowRunTimeBinding(false);
		}

		if (annProp.collectionProperty()) {
			ext.setCollectionProperty(true);
		}
		
		if (!"".equals(annProp.propertyItemClass())) {
			ext.setPropertyItemClass(annProp.propertyItemClass());
		}
		
		if (!"".equals(annProp.propertyAddMethod())) {
			ext.setPropertyAddMethod(annProp.propertyAddMethod());
		}
		
		if (annProp.localizable()) {
			ext.setLocalizable(true);
		}
		
		PropertyDesignerExtensionType desExt = new PropertyDesignerExtensionType();
		ext.setDesignerExtension(desExt);
		
		desExt.setCategory(annProp.category());
		
		if (!"".equals(annProp.editor())) {
			desExt.setEditor(annProp.editor());
		}

		if (!"".equals(annProp.editorParameter())) {
			desExt.setEditorParameter(annProp.editorParameter());
		}
		
	}
	
	@Override
	public void endComponent(TypeElement element) throws Exception {
	}

	/**
	 * {@inheritDoc}
	 * Writes library.xsp-config file.
	 */
	@Override
	public void end() throws Exception {
		JAXBContext context = JAXBContext
				.newInstance("com.sun.java.xml.ns.javaee");
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		FileObject file = filer.createResource(StandardLocation.SOURCE_OUTPUT,
				"", "../META-INF/library.xsp-config", (Element[]) null);
		messager.printMessage(Kind.NOTE, "creating " + file.toUri());
		Writer facesWriter = file.openWriter();
		ObjectFactory f = new ObjectFactory();
		JAXBElement<FacesConfigType> facesConfig2 = f.createFacesConfig(xspConfig);
		m.marshal(facesConfig2, facesWriter);
		facesWriter.close();
	}

	

}
