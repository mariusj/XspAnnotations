package org.openntf.xsp.annotations;

/**
 * Flag on XPages component to generate code for a Dojo Renderer.
 * @author Mariusz Jakubowski
 */
public @interface XspGenDojoRenderer {
	/**
	 * Base class for this renderer (eg. com.ibm.xsp.extlib.renderkit.dojo.DojoWidgetRenderer.) 
	 */
	public String baseClass() default "";

	/**
	 * Included dojo module (used by DojoWidgetBaseRenderer).
	 */
	public String dojoModule() default "";
	
	/**
	 * Default dojo type for a component (used by DojoWidgetBaseRenderer).
	 */
	public String defaultDojoType() default "";
	
	/**
	 * Tag name (used by DojoWidgetBaseRenderer).
	 */
	public String tagName() default "";
	
	/**
	 * Included css files (used by DojoWidgetBaseRenderer).
	 */
	public String[] css() default {};
}
