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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof XmlsonPrimitive<?>) {
			XmlsonPrimitive<?> that = (XmlsonPrimitive<?>) obj;
			
			return getValue().equals(that.getValue());
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
	@Override
	public String toString() {
		return getValue().toString();
	}
}
