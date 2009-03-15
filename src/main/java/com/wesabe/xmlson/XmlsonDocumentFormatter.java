package com.wesabe.xmlson;

import java.io.IOException;

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
	 * @throws IOException
	 *             if something goes wrong
	 */
	public abstract String format(XmlsonDocument document) throws IOException;
}
