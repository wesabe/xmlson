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
	}
}
