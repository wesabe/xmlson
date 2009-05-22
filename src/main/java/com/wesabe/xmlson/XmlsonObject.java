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
}
