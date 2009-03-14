package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlsonNumber;

@RunWith(Enclosed.class)
public class XmlsonNumberTest {
	public static class An_Xmlson_Integer {
		@Test
		public void itHasAnIntegerValue() throws Exception {
			XmlsonNumber number = new XmlsonNumber(300);
			assertEquals(Integer.valueOf(300), number.getValue());
		}
	}
	
	public static class An_Xmlson_Float {
		@Test
		public void itHasAnFloatValue() throws Exception {
			XmlsonNumber number = new XmlsonNumber(30.2);
			assertEquals(Double.valueOf(30.2), number.getValue());
		}
	}
}
