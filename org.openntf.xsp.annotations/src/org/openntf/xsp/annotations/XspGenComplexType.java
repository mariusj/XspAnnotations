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
 * Defines a complex type
 * @author Mariusz Jakubowski
 *
 */
@Target(ElementType.TYPE)
public @interface XspGenComplexType {
	/**
	 * Description of a complex type.
	 */
	String description();
	
	/**
	 * Name of a complex type.
	 */
	String displayName();
	
	/**
	 * Tag used in xpage.
	 */
	String tagName();
	
}
