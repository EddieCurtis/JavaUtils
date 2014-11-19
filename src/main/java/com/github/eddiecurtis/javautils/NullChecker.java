package com.github.eddiecurtis.javautils;

/**
 * A class used to process objects and check for null values
 * @author Eddie Curtis
 * @date 19 Nov 2014
 */
public class NullChecker {

	public static int numberOfNullObjects(Object... args) {
		int nullCount = 0;
		if (args != null) {
			for (Object o : args) {
				if (o == null) {
					nullCount++;
				}
			}
		}
		return nullCount;
	}
}
