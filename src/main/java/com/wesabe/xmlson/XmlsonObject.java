package com.wesabe.xmlson;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An XMLSON object, which consists of primitive/element pairs and members.
 * 
 * @author coda
 * 
 */
public class XmlsonObject extends XmlsonMember {
	private final Map<XmlsonString, XmlsonElement> properties = new LinkedHashMap<XmlsonString, XmlsonElement>();

	/**
	 * Creates a named XMLSON object.
	 * 
	 * @param name
	 *            the object's name
	 */
	public XmlsonObject(String name) {
		super(name);
	}

	/**
	 * Returns an unmodifiable view of this object's properties.
	 * 
	 * @return this object's properties
	 */
	public Map<XmlsonString, XmlsonElement> getProperties() {
		return Collections.unmodifiableMap(properties);
	}

	/**
	 * Adds a string property.
	 * 
	 * @param key
	 *            the property's name
	 * @param value
	 *            the property's value
	 * @return {@code this}, for chaining purposes
	 */
	public XmlsonObject addProperty(String key, String value) {
		if (value == null) {
			return addNullProperty(key);
		}

		properties.put(new XmlsonString(key), new XmlsonString(value));

		return this;
	}

	/**
	 * Adds a numeric property.
	 * 
	 * @param key
	 *            the property's name
	 * @param value
	 *            the property's value
	 * @return {@code this}, for chaining purposes
	 */
	public XmlsonObject addProperty(String key, Number value) {
		if (value == null) {
			return addNullProperty(key);
		}

		properties.put(new XmlsonString(key), new XmlsonNumber(value));

		return this;
	}

	/**
	 * Adds a boolean property.
	 * 
	 * @param key
	 *            the property's name
	 * @param value
	 *            the property's value
	 * @return {@code this}, for chaining purposes
	 */
	public XmlsonObject addProperty(String key, Boolean value) {
		if (value == null) {
			return addNullProperty(key);
		}

		properties.put(new XmlsonString(key), new XmlsonBoolean(value));

		return this;
	}

	/**
	 * Adds a null property.
	 * 
	 * @param key
	 *            the property's name
	 * @return {@code this}, for chaining purposes
	 */
	public XmlsonObject addNullProperty(String key) {
		properties.put(new XmlsonString(key), new XmlsonNull());
		return this;
	}

	/**
	 * Adds a member.
	 * 
	 * @param member
	 *            the member to add
	 * @return {@code this}, for chaining purposes
	 */
	public XmlsonObject add(XmlsonMember member) {
		if (member == this) {
			throw new IllegalArgumentException("can't add member to itself");
		}
		
		properties.put(new XmlsonString(member.getName()), member);
		
		return this;
	}

	@Override
	public String toString() {
		return "{" + getName() + ":" + properties + "}";
	}

	/**
	 * Returns the property or member with the given key.
	 * 
	 * @param key the property's key or member's name
	 * @return the property or member
	 */
	public XmlsonElement get(String key) {
		return properties.get(new XmlsonString(key));
	}
	
	/**
	 * Returns the property with the given key as a {@link String}.
	 * 
	 * @param key the property's key
	 * @return the property as a string
	 * @throws ClassCastException if the property is not a string
	 */
	public String getString(String key) {
		final XmlsonElement element = get(key);
		if (element instanceof XmlsonNull) {
			return null;
		}
		return ((XmlsonString) element).getValue();
	}
	
	/**
	 * Returns the property with the given key as an {@link Integer}.
	 * 
	 * @param key the property's key
	 * @return the property as an integer
	 * @throws ClassCastException if the property is not an integer
	 */
	public Integer getInteger(String key) {
		final XmlsonElement element = get(key);
		if (element instanceof XmlsonNull) {
			return null;
		}
		return (Integer) ((XmlsonNumber) element).getValue();
	}
	
	/**
	 * Returns the property with the given key as a {@link Double}.
	 * 
	 * @param key the property's key
	 * @return the property as a double
	 * @throws ClassCastException if the property is not a double
	 */
	public Double getDouble(String key) {
		final XmlsonElement element = get(key);
		if (element instanceof XmlsonNull) {
			return null;
		}
		return (Double) ((XmlsonNumber) element).getValue();
	}
	
	/**
	 * Returns the property with the given key as a {@link Boolean}.
	 * 
	 * @param key the property's key
	 * @return the property as a boolean
	 * @throws ClassCastException if the property is not a boolean
	 */
	public Boolean getBoolean(String key) {
		final XmlsonElement element = get(key);
		if (element instanceof XmlsonNull) {
			return null;
		}
		return ((XmlsonBoolean) element).getValue();
	}
}
