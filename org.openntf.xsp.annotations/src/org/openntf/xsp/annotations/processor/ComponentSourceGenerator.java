/*
 * � Copyright Mariusz Jakubowski 2012
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
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.FileObject;

import org.openntf.xsp.annotations.XspGenComplexType;
import org.openntf.xsp.annotations.XspGenComponent;
import org.openntf.xsp.annotations.XspGenConfig;
import org.openntf.xsp.annotations.XspGenProperty;
import org.openntf.xsp.annotations.processor.XspProcessor.PropertyInfo;


/**
 * Generates implementation files of components.
 * @author Mariusz Jakubowski
 *
 */
public class ComponentSourceGenerator extends AbstractGenerator {
	private String baseFullName;
	private String baseSimpleName;
	private String newFullName;
	private String newSimpleName;

	private XspGenProperty annProp;
	private List<PropertyInfo> fields;
	
	private StringBuilder source;
	private String pkg;
	

	public ComponentSourceGenerator(Filer filer, Messager messager) {
		super(filer, messager);
	}

	@Override
	public void start(XspGenConfig config) {
		// nothing to do		
	}

	@Override
	public void newComponent(TypeElement element, XspGenComponent annotation) {
		if (!annotation.generateComponentCode())
			return;
		
		baseSimpleName = element.getSimpleName().toString();
		baseFullName = element.getQualifiedName().toString();
		
		newFullName = baseFullName + "Impl";
		newSimpleName = baseSimpleName + "Impl";
		
		messager.printMessage(Kind.NOTE, "  generating code for component " + newSimpleName);

		pkg = newFullName.substring(0, newFullName.indexOf(newSimpleName) - 1);
		
		source = new StringBuilder();
		header();
        componentConstructor(annotation);
        if (!"".equals(annotation.componentFamily()))
    		getFamily(annotation.componentFamily());
        fields = new ArrayList<PropertyInfo>();
	}
	
	/**
	 * Generates header.
	 */
	private void header() {
		source.append("package " + pkg + ";\n\n");
		source.append("import javax.faces.context.FacesContext;\n")
			.append("import javax.faces.el.ValueBinding;\n\n");
		source.append("public class " + newSimpleName + " extends " + baseSimpleName + " {\n\n");
	}
	
	/**
	 * Generates constructor for a component.
	 * @param annotation
	 */
	private void componentConstructor(XspGenComponent annotation) {
		source.append("public " + newSimpleName + "() {\n");
		if (!"".equals(annotation.renderer()))
			source.append("setRendererType(\"" + annotation.renderer() + "\");\n");
		else
			source.append("setRendererType(\"" + baseFullName + "\");\n");
		source.append("}\n\n");
	}
	
	/**
	 * Generates constructor for a component.
	 * @param annotation
	 */
	private void complexConstructor(XspGenComplexType annotation) {
		source.append("public " + newSimpleName + "() {\n");
		source.append("}\n\n");
	}

	/**
	 * Generates getFamily metod.
	 */
	private void getFamily(String family) {
		source.append("@Override public String getFamily() {\n")
			.append("return \"" + family + "\";\n")
			.append("}\n\n");
	}
	
	/**
	 * {@inheritDoc}
	 * Generates getter and setter.
	 */
	@Override
	public void newProperty(VariableElement field, XspGenProperty annProp) {
		if (annProp.dontGenerateCode())
			return;
		
		// check if property is defined inside component
		Object parentAnnotation = field.getEnclosingElement().getAnnotation(XspGenComponent.class);
		if (parentAnnotation == null) {
			parentAnnotation = field.getEnclosingElement().getAnnotation(XspGenComplexType.class);
		}

		if (parentAnnotation == null)
			return;
					
		messager.printMessage(Kind.NOTE, "    generating code for property " + annProp.displayName());

		this.annProp = annProp;
		PropertyInfo propInfo = XspProcessor.javaTypeToXspType(field);
		fields.add(propInfo);
		
		createSetter(propInfo);
		createGetter(propInfo);
	}

	/**
	 * Generates setter for a property
	 * @param propInfo info about property
	 */
	private void createSetter(PropertyInfo propInfo) {
		if (!annProp.allowRunTimeBinding() || propInfo.xspItemType != null)
			return;
		source.append("public void set" + propInfo.fieldUName + " (" + propInfo.xspType + " arg) {\n")
			.append("this." + propInfo.fieldName + " = arg;\n")
			.append("}\n\n");
	}
	
	/**
	 * Generates getter for a property.
	 * @param propInfo info about property
	 */
	private void createGetter(PropertyInfo propInfo) {
		if (!annProp.allowRunTimeBinding() || propInfo.xspItemType != null)
			return;
		String prefix = "boolean".equals(propInfo.xspType) ? "is" : "get";
		source.append("public " + propInfo.xspType + " " + prefix + propInfo.fieldUName + "() {\n")
			.append("if (" + propInfo.fieldName + "!= null)\n")
			.append("return " + propInfo.fieldName + ";\n")
			.append("ValueBinding _vb = getValueBinding(\"" + propInfo.fieldName + "\");\n")
			.append("if (_vb != null) {\n")
			.append(propInfo.fieldType + " val = (" + propInfo.fieldType + ") _vb.getValue(FacesContext.getCurrentInstance());\n")
			.append("if (val != null)\n")
			.append("return val;\n")
			.append("}\n");
		String defaultValue = annProp.defaultValue();
		if ("".equals(defaultValue)) {
			if ("boolean".equals(propInfo.xspType)) {
				defaultValue = "false";
			} else if ("int".equals(propInfo.xspType)) {
				defaultValue = "0";
			} else if ("long".equals(propInfo.xspType)) {
				defaultValue = "0";
			} else if ("float".equals(propInfo.xspType)) {
				defaultValue = "0.0f";
			} else if ("double".equals(propInfo.xspType)) {
				defaultValue = "0.0";
			} else {
				defaultValue = "null";
			}
		} else {
			if ("float".equals(propInfo.xspType)) {
				defaultValue += "f";
			} else if ("java.lang.String".equals(propInfo.xspType)) {
				defaultValue = "\"" + defaultValue + "\"";
			}
		}
		source.append("return " + defaultValue + ";\n");
		source.append("}\n\n");
	}
	
	/**
	 * Generates saveState method.
	 */
	private void saveState() {
		source.append("@Override public Object saveState(FacesContext facesContext) {\n")
				.append("Object[] values = new Object[" + (fields.size()+1) + "];\n")
				.append("values[0] = super.saveState(facesContext);\n");
		for (int i = 0; i < fields.size(); i++) {
			PropertyInfo propInfo = fields.get(i);
			source.append("values[" + (i+1) + "] = " + propInfo.fieldName + ";\n");
		}
		source.append("return values;\n")
			.append("}\n\n");
	}

	/**
	 * Generates restoreState method.
	 */
	private void restoreState() {
		source.append("@Override public void restoreState(FacesContext facesContext, Object state) {\n")
			.append("Object[] values = (Object[])state;\n")
			.append("super.restoreState(facesContext, values[0]);\n");
	    for (int i=0; i<fields.size(); i++) {
	    	PropertyInfo propInfo = fields.get(i);
	    	source.append(propInfo.fieldName + "=(" + propInfo.fieldType + ") values[" + (i+1) + "];\n");
	    }		
		source.append("}\n\n");
	}

	/**
	 * {@inheritDoc}
	 * Saves the source file.
	 */
	@Override
	public void endComponent(TypeElement element) throws Exception {
        restoreState();
        saveState();
        source.append("}\n");
        String fname = pkg + '.' + newSimpleName;
		messager.printMessage(Kind.NOTE, fname);
		FileObject srcFile = filer.createSourceFile(fname, element);
		messager.printMessage(Kind.NOTE, "creating " + srcFile.toUri());
		Writer writer = srcFile.openWriter();
		writer.write(source.toString());
		writer.close();
	}

	@Override
	public void end() throws Exception {
		// nothing to do		
	}

	@Override
	public void newComplexType(TypeElement element, XspGenComplexType annotation) {
		if (!annotation.generateCode())
			return;
		
		baseSimpleName = element.getSimpleName().toString();
		baseFullName = element.getQualifiedName().toString();
		
		newFullName = baseFullName + "Impl";
		newSimpleName = baseSimpleName + "Impl";

		messager.printMessage(Kind.NOTE, "  generating code for complex type " + newSimpleName);

		pkg = newFullName.substring(0, newFullName.indexOf(newSimpleName) - 1);
		
		source = new StringBuilder();
		header();
        complexConstructor(annotation);
        fields = new ArrayList<PropertyInfo>();
	}
	
}
