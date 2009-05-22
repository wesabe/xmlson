package com.wesabe.xmlson.tests;

import static org.hamcrest.CoreMatchers.*;
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
			final XmlsonString string = new XmlsonString("blah");
			assertThat(string.getValue(), is("blah"));
		}
		
		@Test
		public void itEqualsOtherXmlsonStrings() throws Exception {
			final XmlsonString a = new XmlsonString("woo");
			final XmlsonString b = new XmlsonString("woo");
			assertThat(a.equals(b), is(true));
			assertThat(b.hashCode(), is(a.hashCode()));
		}
		
		@Test
		public void itDoesNotEqualNull() throws Exception {
			final XmlsonString a = new XmlsonString("woo");
			assertThat(a.equals(null), is(false));
		}
		
		@Test
		public void itDoesNotEqualANonString() throws Exception {
			final XmlsonString a = new XmlsonString("woo");
			assertThat(a.equals(200), is(false));
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			final XmlsonString a = new XmlsonString("woo");
			assertThat(a.toString(), is("woo"));
		}
	}
}
