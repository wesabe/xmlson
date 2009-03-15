package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlsonBoolean;

@RunWith(Enclosed.class)
public class XmlsonBooleanTest {
	public static class An_Xmlson_Boolean {
		@Test
		public void itHasABooleanValue() throws Exception {
			XmlsonBoolean bool = new XmlsonBoolean(false);
			assertFalse(bool.getValue());
		}
		
		@Test
		public void itEqualsOtherXmlsonBooleans() throws Exception {
			XmlsonBoolean a = new XmlsonBoolean(false);
			XmlsonBoolean b = new XmlsonBoolean(false);
			assertTrue(a.equals(b));
			assertTrue(a.hashCode() == b.hashCode());
		}
		
		@Test
		public void itDoesNotEqualNull() throws Exception {
			XmlsonBoolean a = new XmlsonBoolean(false);
			assertFalse(a.equals(null));
		}
		
		@Test
		public void itDoesNotEqualANonBoolean() throws Exception {
			XmlsonBoolean a = new XmlsonBoolean(false);
			assertFalse(a.equals(200));
		}
	}
}
