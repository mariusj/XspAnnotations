package org.openntf.xsp.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Configures the xsp-config file.
 * @author Mariusz Jakubowski
 *
 */
@Target(ElementType.TYPE)
public @interface XspGenConfig {
	String defaultPrefix();
	
	String namespaceUri();
}
