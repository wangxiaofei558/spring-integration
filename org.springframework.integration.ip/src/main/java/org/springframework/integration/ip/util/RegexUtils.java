/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.ip.util;

/**
 * Regular Expression Utilities.
 * 
 * @author Gary Russell
 *
 */
public abstract class RegexUtils {

	/**
	 * Escapes (precedes with \) any characters in the parameter in the set<br/><br/>
	 * <code>.$[]^*+{}()\?|</code><br/><br/>
	 * Used to escape a string that is used as a regular expression pattern, to remove
	 * the special meaning of these characters.
	 * @param stringToEscape The string to escape.
	 * @return The escaped string.
	 */
	public static String escapeRegExSpecials(String stringToEscape) {
		// In the following, we look for all the specials and any we find 
		// are escaped in the output string, allowing that string to 
		// be used as a pattern containing the literal specials.
		String out = stringToEscape.replaceAll(
				"(\\.|\\$|\\[|\\]|\\^|\\*|\\+|\\{|\\}|\\(|\\)|\\\\|\\?|\\|)", 
				"\\\\$1");
		return out;
	}

}
