package com.github.eddiecurtis.javautils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A class used to store a collection of objects, which overrides {@link Object#equals(Object)} and 
 * {@link Object#hashCode()}. This ensures that when comparing two {@link HashableKey} objects that
 * not only can we build a hash code for the parameters passed in, but also that the equals method
 * for this class will in turn call the equals method on every element passed in during construction.
 * @author Eddie Curtis
 * @date 19 Nov 2014
 */
public class HashableKey <T> {

	private List<T> arguments;
	
	public HashableKey(T... args) {
		arguments = Arrays.asList(args);
	}
	
	/**
	 * Implementation of the {@link Object#equals(Object)} method which will compare two {@link HashableKey}
	 * objects and each of their contents. This method will return true if the object being compared is also
	 * a {@link HashableKey}, and all of the parameters used to construct both objects return true when an
	 * equals() comparison is done on them.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
	    if (obj != null && obj instanceof HashableKey<?>) {
	    	equal = obj == this;
	    	if (!equal) {
                HashableKey<?> otherKey = (HashableKey<?>) obj;
	    		if (otherKey.arguments.size() == this.arguments.size()) {
	    			equal = true;
		    		for (int i = 0; i < this.arguments.size(); i++) {
		    			if (!otherKey.arguments.get(i).equals(this.arguments.get(i))) {
		    				equal = false;
		    				break;
		    			}
		    		}
	    		}
	    	}
	    }
	    return equal;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(13, 61);
		for (T arg : arguments) {
			hashCodeBuilder.append(arg);
		}
		return hashCodeBuilder.toHashCode();
	}
	
}
