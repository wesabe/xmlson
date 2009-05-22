package com.wesabe.xmlson.tests;

import static org.hamcrest.CoreMatchers.*;
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
			final XmlsonNull nullValue = new XmlsonNull();
			assertThat(nullValue.getValue(), is(nullValue()));
		}
		
		@Test
		public void itEqualsOtherXmlsonNulls() throws Exception {
			final XmlsonNull a = new XmlsonNull();
			final XmlsonNull b = new XmlsonNull();
			assertThat(a.equals(b), is(true));
			assertThat(b.hashCode(), is(a.hashCode()));
		}
		
		@Test
		public void itDoesNotEqualNull() throws Exception {
			final XmlsonNull a = new XmlsonNull();
			assertThat(a.equals(null), is(false));
		}
		
		@Test
		public void itDoesNotEqualANonNull() throws Exception {
			final XmlsonNull a = new XmlsonNull();
			assertThat(a.equals("woo"), is(false));
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			final XmlsonNull a = new XmlsonNull();
			assertThat(a.toString(), is("null"));
		}
	}
}
