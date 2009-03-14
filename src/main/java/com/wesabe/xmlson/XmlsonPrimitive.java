package com.wesabe.xmlson;

/**
 * An XMLSON primitive.
 * 
 * @author coda
 *
 * @param <E> The type of primitive.
 */
public abstract class XmlsonPrimitive<E> extends XmlsonElement {
	
	/**
	 * Returns the primitive value.
	 * 
	 * @return the primitive value
	 */
	public abstract E getValue();
}
