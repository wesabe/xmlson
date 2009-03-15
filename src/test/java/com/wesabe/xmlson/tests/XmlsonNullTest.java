package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlsonNull;

@RunWith(Enclosed.class)
public class XmlsonNullTest {
	public static class An_Xmlson_Null {
		@Test
		public void itHasANullValue() throws Exception {
			XmlsonNull nullValue = new XmlsonNull();
			assertNull(nullValue.getValue());
		}
		
		@Test
		public void itEqualsOtherXmlsonNulls() throws Exception {
			XmlsonNull a = new XmlsonNull();
			XmlsonNull b = new XmlsonNull();
			assertTrue(a.equals(b));
			assertTrue(a.hashCode() == b.hashCode());
		}
		
		@Test
		public void itDoesNotEqualNull() throws Exception {
			XmlsonNull a = new XmlsonNull();
			assertFalse(a.equals(null));
		}
		
		@Test
		public void itDoesNotEqualANonNull() throws Exception {
			XmlsonNull a = new XmlsonNull();
			assertFalse(a.equals("woo"));
		}
	}
}
