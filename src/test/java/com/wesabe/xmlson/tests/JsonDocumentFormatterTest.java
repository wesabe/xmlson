package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.JsonDocumentFormatter;
import com.wesabe.xmlson.XmlsonArray;
import com.wesabe.xmlson.XmlsonDocument;
import com.wesabe.xmlson.XmlsonDocumentFormatter;
import com.wesabe.xmlson.XmlsonObject;

@RunWith(Enclosed.class)
public class JsonDocumentFormatterTest {
	private static String format(XmlsonDocument document) {
		XmlsonDocumentFormatter formatter = new JsonDocumentFormatter();
		return formatter.format(document);
	}
	
	public static class An_Empty_Document {
		@Test
		public void itIsFormattedAsAnEmptyHash() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			assertEquals(
				"{}",
				format(document)
			);
		}
	}
	
	public static class An_Empty_Object {
		@Test
		public void itIsFormattedAsAHashWithAnObjectProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object"));
			assertEquals(
				"{" +
					"\"object\":{}" +
				"}",
				format(document)
			);
		}
	}
	
	public static class A_Document_With_Shallow_Properties {
		@Test
		public void itIsFormattedAsAHash() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.addProperty("key", "value");
			assertEquals("{\"key\":\"value\"}", format(document));
		}
	}
	
	public static class An_Object_With_A_String_Property {
		@Test
		public void itIsFormattedAsAHashWithAnObjectPropertyWithAStringProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").addProperty("key", "value"));
			assertEquals(
				"{" +
					"\"object\":{" +
						"\"key\":\"value\"" +
					"}" +
				"}",
				format(document)
			);
		}
	}
	
	public static class An_Object_With_A_Boolean_Property {
		@Test
		public void itIsFormattedAsAHashWithAnObjectPropertyWithABooleanProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").addProperty("key", false));
			assertEquals(
				"{" +
					"\"object\":{" +
						"\"key\":false" +
					"}" +
				"}",
				format(document)
			);
		}
	}
	
	public static class An_Object_With_A_Null_Property {
		@Test
		public void itIsFormattedAsAHashWithAnObjectPropertyWithANullProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").addNullProperty("key"));
			assertEquals(
				"{" +
					"\"object\":{" +
						"\"key\":null" +
					"}" +
				"}",
				format(document)
			);
		}
	}
	
	public static class An_Object_With_A_Numeric_Property {
		@Test
		public void itIsFormattedAsAHashWithAnObjectPropertyWithANumericProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").addProperty("key", 100));
			assertEquals(
				"{" +
					"\"object\":{" +
						"\"key\":100" +
					"}" +
				"}",
				format(document)
			);
		}
	}
	
	public static class An_Object_With_A_Member_Property {
		@Test
		public void itIsFormattedAsAHashWithAnObjectPropertyWithAObjectProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").add(new XmlsonObject("property")));
			assertEquals(
				"{" +
					"\"object\":{" +
						"\"property\":{}" +
					"}" +
				"}",
				format(document)
			);
		}
	}
	
	public static class An_Empty_Array {
		@Test
		public void itIsFormattedAsAHashWithAnArrayProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonArray("array"));
			assertEquals(
				"{" +
					"\"array\":[]" +
				"}",
				format(document)
			);
		}
	}
	
	public static class An_Array_With_Members {
		@Test
		public void itIsFormattedAsAHashWithAnArrayPropertyOfObjects() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			XmlsonArray array = new XmlsonArray("array");
			array.add(new XmlsonObject("item").addProperty("name", "Mr. Peez"));
			document.add(array);
			assertEquals(
				"{" +
					"\"array\":[" +
						"{" +
							"\"name\":\"Mr. Peez\"" +
						"}" +
					"]" +
				"}",
				format(document)
			);
		}
	}
	
	public static class An_Empty_Object_And_An_Empty_Hash {
		@Test
		public void itIsFormattedAsAHashWithAnArrayPropertyAndAnObjectProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object"));
			document.add(new XmlsonArray("array"));
			assertEquals(
				"{" +
					"\"object\":{}," +
					"\"array\":[]" +
				"}",
				format(document)
			);
		}
	}
}
