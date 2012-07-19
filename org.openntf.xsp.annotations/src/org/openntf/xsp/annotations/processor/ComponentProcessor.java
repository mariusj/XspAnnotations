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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic.Kind;

import org.openntf.xsp.annotations.XspGenComplexType;
import org.openntf.xsp.annotations.XspGenComponent;
import org.openntf.xsp.annotations.XspGenProperty;


/**
 * Processor for XPages annotations.
 * @author Mariusz Jakubowski
 *
 */
@SupportedAnnotationTypes(value = { 
		"org.openntf.xsp.annotations.XspGenComponent", 
		"org.openntf.xsp.annotations.XspGenProperty",
		"org.openntf.xsp.annotations.XspGenDojoRenderer",
		"org.openntf.xsp.annotations.XspGenComplexType",
})
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class ComponentProcessor extends AbstractProcessor {

	private Filer filer;
	private Messager messager;

	@Override
	public synchronized void init(ProcessingEnvironment env) {
		filer = env.getFiler();
		messager = env.getMessager();
	}

	/**
	 * Holds information about component.
	 * @author Mariusz Jakubowski
	 */
	private static final class ComponentInfo {
		final TypeElement element;
		final XspGenComponent annotation;
		final String baseComponentType;
		final String componentType;
		
		ComponentInfo(TypeElement element) {
			this.element = element;
			this.annotation = element.getAnnotation(XspGenComponent.class);
			this.baseComponentType = annotation.baseComponentType();
			this.componentType = element.getQualifiedName().toString();
		}		
	};
	
	/**
	 * Returns a list of generators.
	 * @return
	 */
	private List<AbstractGenerator> getGenerators() {
		List<AbstractGenerator> generatros = new ArrayList<AbstractGenerator>();
		generatros.add(new FacesConfigGenerator(filer, messager));
		generatros.add(new XspConfigGenerator(filer, messager));
		//generatros.add(new CodeGenerator(filer, messager));
		generatros.add(new ComponentSourceGenerator(filer, messager));
		generatros.add(new DojoRendererSourceGenerator(filer, messager));
		return generatros;
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment env) {
		messager.printMessage(Kind.NOTE, "process " + annotations);
		if (annotations.size() == 0)
			return true;
		
		List<AbstractGenerator> generatros = getGenerators();
		for (AbstractGenerator gen : generatros) {
			gen.start();
		}
		
		Set<? extends Element> types = env.getElementsAnnotatedWith(XspGenComplexType.class);
		for (Element e : types) {
			for (AbstractGenerator gen : generatros) {
				gen.newComplexType((TypeElement) e, e.getAnnotation(XspGenComplexType.class));
			}

			List<? extends Element> fields = e.getEnclosedElements();
			for (Element field : fields) {
				if (field.getKind() == ElementKind.FIELD) {
					XspGenProperty annProp = field.getAnnotation(XspGenProperty.class);
					if (annProp != null) {
						for (AbstractGenerator gen : generatros) {
							//gen.newProperty((VariableElement) field, annProp);
						}
					}
				}
			}
		}
		
		
		
		Set<? extends Element> components = env.getElementsAnnotatedWith(XspGenComponent.class);
		List<ComponentInfo> componentsSorted = sortComponents(components);
		
		for (ComponentInfo component : componentsSorted) {
			for (AbstractGenerator gen : generatros) {
				gen.newComponent(component.element, component.annotation);
			}
			
			List<? extends Element> fields = component.element.getEnclosedElements();
			for (Element field : fields) {
				if (field.getKind() == ElementKind.FIELD) {
					XspGenProperty annProp = field.getAnnotation(XspGenProperty.class);
					if (annProp != null) {
						for (AbstractGenerator gen : generatros) {
							gen.newProperty((VariableElement) field, annProp);
						}
					}
				}
			}
			
			for (AbstractGenerator gen : generatros) {
				try {
					gen.endComponent(component.element);
				} catch (Exception e) {
					e.printStackTrace();
					messager.printMessage(Kind.ERROR, e.toString());
				}
			}
		}

		for (AbstractGenerator gen : generatros) {
			try {
				gen.end();
			} catch (Exception e) {
				e.printStackTrace();
				messager.printMessage(Kind.ERROR, e.toString());
			}
		}
		
		
		messager.printMessage(Kind.NOTE, "process end");
		return true;
	}

	/**
	 * Sorts components by dependency.
	 * @param components a set of components
	 * @return a list of sorted components
	 */
	private List<ComponentInfo> sortComponents(Set<? extends Element> components) {
		List<ComponentInfo> componentsSorted = new ArrayList<ComponentInfo>();
		for (Element element : components) {
			ComponentInfo component = new ComponentInfo((TypeElement) element);
			messager.printMessage(Kind.NOTE, "    type:" + component.componentType);
			messager.printMessage(Kind.NOTE, "    base:" + component.baseComponentType);
			int idx = 0;
			for (; idx<componentsSorted.size(); idx++) {
				if (component.componentType.equals(componentsSorted.get(idx).baseComponentType)) {
					messager.printMessage(Kind.NOTE, "    ++parent");
					break;
				}
			}
			messager.printMessage(Kind.NOTE, "    adding " + component.element.getSimpleName() + " @ " + idx);
			componentsSorted.add(idx, component);			
		}
		return componentsSorted;
	}

	/**
	 * Information about xsp property.
	 * @author Mariusz Jakubowski
	 */
	static final class PropertyInfo {
		public final VariableElement field;
		public final String fieldName;
		public final String fieldUName;
		public final String fieldType;
		public final String xspType;
		public final String xspItemType;
		public final XspGenProperty annotation;

		public PropertyInfo(VariableElement field, String fieldType, String type, String itemType) {
			this.field = field;
			this.fieldName = field.getSimpleName().toString();
			this.fieldUName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
			this.fieldType = fieldType;
			this.xspType = type;
			this.xspItemType = itemType;
			this.annotation = field.getAnnotation(XspGenProperty.class);
		}
	}
	
	/**
	 * Fills information about field & property from field definition & XspProperty annotation.
	 * @param field field to analyze
	 * @return info about property
	 */
	public static PropertyInfo javaTypeToXspType(VariableElement field) {
		TypeMirror asType = field.asType();
		switch (asType.getKind()) {
		case BOOLEAN: 
			return new PropertyInfo(field, "boolean", "boolean", null);
		case INT:
			return new PropertyInfo(field, "int", "int", null);
		case LONG:
			return new PropertyInfo(field, "long", "long", null);
		case FLOAT:
			return new PropertyInfo(field, "float", "float", null);
		case DOUBLE:
			return new PropertyInfo(field, "double", "double", null);
		case DECLARED:
			DeclaredType decType = (DeclaredType) asType;
			Element elemType = decType.asElement();
			if (elemType instanceof TypeElement) {
				TypeElement elemType2 = (TypeElement) elemType;
				String typeStr = elemType2.getQualifiedName().toString();
				if (Boolean.class.getCanonicalName().equals(typeStr)) {
					return new PropertyInfo(field, "java.lang.Boolean", "boolean", null);
				} else if (Integer.class.getCanonicalName().equals(typeStr)) {
					return new PropertyInfo(field, "java.lang.Integer", "int", null);
				} else if (Long.class.getCanonicalName().equals(typeStr)) {
					return new PropertyInfo(field, "java.lang.Long", "long", null);
				} else if (Float.class.getCanonicalName().equals(typeStr)) {
					return new PropertyInfo(field, "java.lang.Float", "float", null);
				} else if (Double.class.getCanonicalName().equals(typeStr)) {
					return new PropertyInfo(field, "java.lang.Double", "double", null);
				} else if (String.class.getCanonicalName().equals(typeStr)) {
					return new PropertyInfo(field, "java.lang.String", "java.lang.String", null);
				} else if (List.class.getCanonicalName().equals(typeStr)) {
					List<? extends TypeMirror> typeArguments = decType.getTypeArguments();
					String typeArg = null;
					if (typeArguments.size() > 0) {
						typeArg = typeArguments.get(0).toString();
					}
					return new PropertyInfo(field, decType.toString(), typeStr, typeArg);
				}
			}
			return new PropertyInfo(field, decType.toString(), decType.toString(), null);
		}
		return new PropertyInfo(field, "java.lang.String", "java.lang.String", null);		
	}
	
	/**
	 * Wraps a string into com.sun.java.xml.ns.javaee.String type. 
	 * @param value 
	 * @return
	 */
	static com.sun.java.xml.ns.javaee.String wrapString(String value) {
		com.sun.java.xml.ns.javaee.String ret = new com.sun.java.xml.ns.javaee.String();
		ret.setValue(value);
		return ret;
	}

}
