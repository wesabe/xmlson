package com.wesabe.xmlson;

/**
 * An XMLSON document containing a list of {@link XmlsonMember}s.
 * 
 * @author coda
 */
public class XmlsonDocument extends XmlsonObject {
	/**
	 * Creates a named XMLSON document.
	 * 
	 * @param name
	 *            the document's name
	 */
	public XmlsonDocument(String name) {
		super(name);
	}
}
