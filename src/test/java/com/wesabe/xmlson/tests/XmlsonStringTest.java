package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlsonString;

@RunWith(Enclosed.class)
public class XmlsonStringTest {
	public static class An_Xmlson_String {
		@Test
		public void itHasAStringValue() throws Exception {
			XmlsonString string = new XmlsonString("blah");
			assertEquals("blah", string.getValue());
		}
		
		@Test
		public void itEqualsOtherXmlsonStrings() throws Exception {
			XmlsonString a = new XmlsonString("woo");
			XmlsonString b = new XmlsonString("woo");
			assertTrue(a.equals(b));
			assertTrue(a.hashCode() == b.hashCode());
		}
		
		@Test
		public void itDoesNotEqualNull() throws Exception {
			XmlsonString a = new XmlsonString("woo");
			assertFalse(a.equals(null));
		}
		
		@Test
		public void itDoesNotEqualANonString() throws Exception {
			XmlsonString a = new XmlsonString("woo");
			assertFalse(a.equals("woo"));
		}
		
		@Test
		public void itEscapesWhitespaceCharacters() throws Exception {
			XmlsonString string = new XmlsonString("bl\nah");
			assertEquals("bl\\nah", string.getValue());
		}
	}
}
