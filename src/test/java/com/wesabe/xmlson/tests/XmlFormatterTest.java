package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlFormatter;
import com.wesabe.xmlson.XmlsonArray;
import com.wesabe.xmlson.XmlsonFormatter;
import com.wesabe.xmlson.XmlsonMember;
import com.wesabe.xmlson.XmlsonObject;

@RunWith(Enclosed.class)
public class XmlFormatterTest {
	private static String format(XmlsonMember member) {
		final XmlsonFormatter formatter = new XmlFormatter();
		return formatter.format(member);
	}
	
	public static class An_Empty_Object {
		@Test
		public void itIsFormattedAsAnEmptyRootElement() throws Exception {
			final XmlsonObject object = new XmlsonObject("object");
			
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<object />" +
				"\n",
				format(object)
			);
		}
	}
	
	public static class An_Object_With_A_Null_Property {
		@Test
		public void itIsFormattedAsARootElementWithAnEmptyNullElement() throws Exception {
			final XmlsonObject object = new XmlsonObject("object");
			object.addNullProperty("test");
			
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<object>" +
					"<test null=\"true\" />" +
				"</object>" +
				"\n",
				format(object)
			);
		}
	}
	
	public static class An_Object_With_A_String_Property {
		@Test
		public void itIsFormattedAsARootElementWithATextElement() throws Exception {
			final XmlsonObject object = new XmlsonObject("object").addProperty("key", "value");
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<object>" +
					"<key>value</key>" +
				"</object>" +
				"\n",
				format(object)
			);
		}
	}
	
	public static class An_Object_With_A_Multiline_String_Property {
		@Test
		public void itIsFormattedAsARootElementWithATextElement() throws Exception {
			final XmlsonObject object = new XmlsonObject("object").addProperty("key", "value\nvalue");
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<object>" +
					"<key>value\nvalue</key>" +
				"</object>" +
				"\n",
				format(object)
			);
		}
	}
	
	public static class An_Object_With_A_Boolean_Property {
		@Test
		public void itIsFormattedAsARootElementWithATextElement() throws Exception {
			final XmlsonObject object = new XmlsonObject("object").addProperty("key", false);
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<object>" +
					"<key>false</key>" +
				"</object>" +
				"\n",
				format(object)
			);
		}
	}
	
	public static class An_Object_With_A_Numeric_Property {
		@Test
		public void itIsFormattedAsARootElementWithATextElement() throws Exception {
			final XmlsonObject object = new XmlsonObject("object").addProperty("key", 100);
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<object>" +
					"<key>100</key>" +
				"</object>" +
				"\n",
				format(object)
			);
		}
	}
	
	public static class An_Object_With_A_Member_Property {
		@Test
		public void itIsFormattedAsARootElementWithAnEmptyElement() throws Exception {
			final XmlsonObject object = new XmlsonObject("object").add(new XmlsonObject("property"));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<object>" +
					"<property />" +
				"</object>" +
				"\n",
				format(object)
			);
		}
	}
	
	public static class An_Empty_Array {
		@Test
		public void itIsFormattedAsAnEmptyRootElement() throws Exception {
			final XmlsonArray array = new XmlsonArray("array");
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<array />" +
				"\n",
				format(array)
			);
		}
	}
	
	public static class An_Array_With_Members {
		@Test
		public void itIsFormattedAsARootElementWithASubTextElement() throws Exception {
			final XmlsonArray array = new XmlsonArray("array");
			array.add(new XmlsonObject("item").addProperty("name", "Mr. Peez"));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<array>" +
					"<item>" +
						"<name>Mr. Peez</name>" +
					"</item>" +
				"</array>" +
				"\n",
				format(array)
			);
		}
	}
	
	public static class An_Empty_Object_And_An_Empty_Hash {
		@Test
		public void itIsFormattedAsARootElementWithTwoEmptyElements() throws Exception {
			final XmlsonObject object = new XmlsonObject("root");
			object.add(new XmlsonObject("object"));
			object.add(new XmlsonArray("array"));
			assertEquals(
				"<?xml version=\"1.0\"?>\n" +
				"<root>" +
					"<object />" +
					"<array />" +
				"</root>" +
				"\n",
				format(object)
			);
		}
	}
}
