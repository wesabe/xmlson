package com.wesabe.xmlson;

import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonEscaper;
import com.google.gson.JsonObject;

/**
 * A class which formats {@link XmlsonDocument}s as JSON.
 * 
 * @author coda
 * @see <a href="http://json.org">JSON Documentation</a>
 */
@SuppressWarnings("deprecation")
public class JsonDocumentFormatter implements XmlsonDocumentFormatter {
	private static final JsonEscaper ESCAPER = new JsonEscaper(false);
	
	/* (non-Javadoc)
	 * @see com.wesabe.xmlson.XmlsonDocumentFormatter#format(com.wesabe.xmlson.XmlsonDocument)
	 */
	@Override
	public String format(XmlsonDocument document) {
		JsonObject jsonDocument = serialize(document);
		return jsonDocument.toString();
	}

	private JsonElement serialize(XmlsonMember member) {
		if (member instanceof XmlsonArray) {
			return serialize((XmlsonArray) member);
		}
		
		return serialize((XmlsonObject) member);
	}
	
	private JsonArray serialize(XmlsonArray array) {
		JsonArray json = new JsonArray();
		
		for (XmlsonMember member : array.getMembers()) {
			json.add(serialize(member));
		}
		
		return json;
	}
	
	private JsonObject serialize(XmlsonObject object) {
		JsonObject json = new JsonObject();
		
		// TODO coda@wesabe.com -- Mar 14, 2009: reduce the number of branches in JsonDocumentFormatter
		
		for (Entry<XmlsonString, XmlsonElement> property : object.getProperties().entrySet()) {
			final String key = property.getKey().getValue();
			final XmlsonElement value = property.getValue();
			
			if (value instanceof XmlsonMember) {
				json.add(key, serialize((XmlsonMember) value));
			} else if (value instanceof XmlsonNumber) {
				json.addProperty(key, ((XmlsonNumber) value).getValue());
			} else if (value instanceof XmlsonBoolean) {
				json.addProperty(key, ((XmlsonBoolean) value).getValue());
			} else if (value instanceof XmlsonNull) {
				json.addProperty(key, (String) null);
			} else {
				json.addProperty(key, ESCAPER.escapeJsonString(((XmlsonPrimitive<?>) value).getValue().toString()));
			}
		}
		
		return json;
	}
}
