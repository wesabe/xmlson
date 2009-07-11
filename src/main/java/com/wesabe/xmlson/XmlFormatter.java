package com.wesabe.xmlson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map.Entry;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ctc.wstx.api.WstxOutputProperties;

/**
 * A class which formats {@link XmlsonMember}s as XML.
 * 
 * @author coda
 * @see <a href="http://xml.org">XML Documentation</a>
 */
public class XmlFormatter implements XmlsonFormatter {
	private static final String NULL_PROPERTY_ATTRIBUTE = "null";

	@Override
	public void format(XmlsonMember member, OutputStream output) throws IOException {
		final XMLOutputFactory xof = XMLOutputFactory.newInstance();
		xof.setProperty(WstxOutputProperties.P_OUTPUT_VALIDATE_CONTENT, true);
		try {
			final XMLStreamWriter writer = xof.createXMLStreamWriter(output);
			writer.writeStartDocument();
			serializeMember(writer, member);
			writer.writeEndDocument();
		} catch (XMLStreamException e) {
			throw new IOException(e);
		}
	}

	@Override
	public String format(XmlsonMember member) {
		try {
			final ByteArrayOutputStream output = new ByteArrayOutputStream();
			format(member, output);
			output.close();
			return output.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void serializeMember(XMLStreamWriter writer, XmlsonMember member) throws XMLStreamException {
		if (member instanceof XmlsonArray) {
			serializeArray(writer, (XmlsonArray) member);
		} else {
			serializeObject(writer, (XmlsonObject) member);
		}
	}
	
	private void serializeArray(XMLStreamWriter writer, XmlsonArray array) throws XMLStreamException {
		writer.writeStartElement(array.getName());
		for (XmlsonMember member : array.getMembers()) {
			serializeMember(writer, member);
		}
		writer.writeEndElement();
	}
	
	private void serializeObject(XMLStreamWriter writer, XmlsonObject object) throws XMLStreamException {
		writer.writeStartElement(object.getName());
		for (Entry<XmlsonString, XmlsonElement> property : object.getProperties().entrySet()) {
			final XmlsonElement value = property.getValue();
			if (value instanceof XmlsonPrimitive<?>) {
				serializeProperty(writer, property.getKey(), (XmlsonPrimitive<?>) value);
			} else {
				serializeMember(writer, (XmlsonMember) value);
			}
		}
		writer.writeEndElement();
	}

	private void serializeProperty(XMLStreamWriter writer, XmlsonString key, XmlsonPrimitive<?> value) throws XMLStreamException {
		writer.writeStartElement(key.getValue());
		if (value instanceof XmlsonNull) {
			writer.writeAttribute(NULL_PROPERTY_ATTRIBUTE, Boolean.TRUE.toString());
		} else {
			writer.writeCharacters(value.getValue().toString());
		}
		writer.writeEndElement();
	}
}
