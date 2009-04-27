package com.wesabe.xmlson;

import java.io.IOException;
import java.io.OutputStream;

/**
 * An interface for classes which format {@link XmlsonMember}s.
 * 
 * @author coda
 */
public interface XmlsonFormatter {
	/**
	 * Format an {@link XmlsonMember} and write it to an {@link OutputStream}.
	 * 
	 * @param member
	 *            the member to be formatted
	 * @param output
	 *            the output stream to which {@code member} will be written
	 * @throws IOException
	 *             if there is an error writing to {@code output}
	 */
	public abstract void format(XmlsonMember member, OutputStream output) throws IOException;

	/**
	 * Given an {@link XmlsonMember}, format it as a string.
	 * 
	 * @param member
	 *            the member to be formatted
	 * @return {@code member} as a formatted string
	 */
	public abstract String format(XmlsonMember member);
}
