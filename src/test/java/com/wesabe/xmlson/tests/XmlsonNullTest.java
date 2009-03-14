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
	}
}
