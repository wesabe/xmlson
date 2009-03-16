package com.wesabe.xmlson;

/**
 * An interface for classes which format {@link XmlsonDocument}s.
 * 
 * @author coda
 */
public interface XmlsonDocumentFormatter {
	/**
	 * Given an {@link XmlsonDocument}, format it as a string.
	 * 
	 * @param document
	 *            the document to be formatted
	 * @return the formatted document
	 */
	public abstract String format(XmlsonDocument document);
}
