package com.wesabe.xmlson;

import java.util.Map.Entry;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Text;

/**
 * A class which formats {@link XmlsonDocument}s as XML.
 * 
 * @author coda
 * @see <a href="http://xml.org">XML Documentation</a>
 */
public class XmlDocumentFormatter implements XmlsonDocumentFormatter {
	
	/* (non-Javadoc)
	 * @see com.wesabe.xmlson.XmlsonDocumentFormatter#format(com.wesabe.xmlson.XmlsonDocument)
	 */
	@Override
	public String format(XmlsonDocument document) {
		Document xmlDocument = serialize(document);
		return xmlDocument.toXML();
	}

	private Document serialize(XmlsonDocument document) {
		Element root = new Element(document.getName());
		
		for (XmlsonMember member : document.getMembers()) {
			root.appendChild(serialize(member));
		}
		
		return new Document(root);
	}

	private Element serialize(XmlsonMember member) {
		if (member instanceof XmlsonArray) {
			return serialize((XmlsonArray) member);
		}
		
		return serialize((XmlsonObject) member);
	}
	
	private Element serialize(XmlsonArray array) {
		Element element = new Element(array.getName());
		
		for (XmlsonMember member : array.getMembers()) {
			element.appendChild(serialize(member));
		}
		
		return element;
	}
	
	private Element serialize(XmlsonObject object) {
		Element element = new Element(object.getName());
		
		for (Entry<XmlsonString, XmlsonElement> property : object.getProperties().entrySet()) {
			XmlsonElement value = property.getValue();
			if (value instanceof XmlsonPrimitive<?>) {
				Element propertyElement = new Element(serialize(property.getKey()));
				Node node = serialize(property.getValue());
				if (node == null) {
					propertyElement.addAttribute(new Attribute("null", "true"));
				} else {
					propertyElement.appendChild(node);
				}

				element.appendChild(propertyElement);
			} else {
				element.appendChild(serialize((XmlsonMember) value));
			}

		}
		
		return element;
	}

	private Node serialize(XmlsonElement element) {
		if (element instanceof XmlsonNull) {
			return null;
		}
		
		return new Text(serialize((XmlsonPrimitive<?>) element));
	}

	private String serialize(XmlsonPrimitive<?> primitive) {
		return primitive.getValue().toString();
	}
}
