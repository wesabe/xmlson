package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlDocumentFormatter;
import com.wesabe.xmlson.XmlsonArray;
import com.wesabe.xmlson.XmlsonDocument;
import com.wesabe.xmlson.XmlsonDocumentFormatter;
import com.wesabe.xmlson.XmlsonObject;

@RunWith(Enclosed.class)
public class XmlDocumentFormatterTest {
	private static String format(XmlsonDocument document) throws IOException {
		XmlsonDocumentFormatter formatter = new XmlDocumentFormatter();
		return formatter.format(document);
	}
	
	public static class An_Empty_Document {
		@Test
		public void itIsFormattedAsAnEmptyRootElement() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root />" +
				"\n",
				format(document)
			);
		}
	}
	
	public static class An_Empty_Object {
		@Test
		public void itIsFormattedAsAnEmptyElement() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object"));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<object />" +
				"</root>" +
				"\n",
				format(document)
			);
		}
	}
	
	public static class An_Object_With_A_String_Property {
		@Test
		public void itIsFormattedAsAnElementWithAStringProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").addProperty("key", "value"));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<object>" +
						"<key>value</key>" +
					"</object>" +
				"</root>" +
				"\n",
				format(document)
			);
		}
	}
	
	public static class An_Object_With_A_Boolean_Property {
		@Test
		public void itIsFormattedAsAnElementWithABooleanProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").addProperty("key", false));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<object>" +
						"<key>false</key>" +
					"</object>" +
				"</root>" +
				"\n",
				format(document)
			);
		}
	}
	
	public static class An_Object_With_A_Null_Property {
		@Test
		public void itIsFormattedAsAnElementWithANullProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").addNullProperty("key"));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<object>" +
						"<key null=\"true\" />" +
					"</object>" +
				"</root>" +
				"\n",
				format(document)
			);
		}
	}
	
	public static class An_Object_With_A_Numeric_Property {
		@Test
		public void itIsFormattedAsAnElementWithANumericProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").addProperty("key", 100));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<object>" +
						"<key>100</key>" +
					"</object>" +
				"</root>" +
				"\n",
				format(document)
			);
		}
	}
	
	public static class An_Object_With_A_Member_Property {
		@Test
		public void itIsFormattedAsAnElementWithAMemberProperty() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object").add(new XmlsonObject("property")));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<object>" +
						"<property />" +
					"</object>" +
				"</root>" +
				"\n",
				format(document)
			);
		}
	}
	
	public static class An_Empty_Array {
		@Test
		public void itIsFormattedAsAnEmptyElement() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonArray("array"));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<array />" +
				"</root>" +
				"\n",
				format(document)
			);
		}
	}
	
	public static class An_Array_With_Members {
		@Test
		public void itIsFormattedAsAnElementWithChildren() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			XmlsonArray array = new XmlsonArray("array");
			array.add(new XmlsonObject("item").addProperty("name", "Mr. Peez"));
			document.add(array);
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<array>" +
						"<item>" +
							"<name>Mr. Peez</name>" +
						"</item>" +
					"</array>" +
				"</root>" +
				"\n",
				format(document)
			);
		}
	}
	
	public static class An_Empty_Object_And_An_Empty_Hash {
		@Test
		public void itIsFormattedAsAnElementWithChildren() throws Exception {
			XmlsonDocument document = new XmlsonDocument("root");
			document.add(new XmlsonObject("object"));
			document.add(new XmlsonArray("array"));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<object />" +
					"<array />" +
				"</root>" +
				"\n",
				format(document)
			);
		}
	}
}
