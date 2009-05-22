package com.wesabe.xmlson.tests;

import static org.hamcrest.CoreMatchers.*;
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
			final XmlsonNumber number = new XmlsonNumber(300);
			assertThat(number.getValue(), is((Number) 300));
		}
		
		@Test
		public void itEqualsOtherXmlsonIntegers() throws Exception {
			final XmlsonNumber a = new XmlsonNumber(300);
			final XmlsonNumber b = new XmlsonNumber(300);
			assertThat(a.equals(b), is(true));
			assertThat(b.hashCode(), is(a.hashCode()));
		}
		
		@Test
		public void itDoesNotEqualNull() throws Exception {
			final XmlsonNumber a = new XmlsonNumber(300);
			assertThat(a.equals(null), is(false));
		}
		
		@Test
		public void itDoesNotEqualANonInteger() throws Exception {
			final XmlsonNumber a = new XmlsonNumber(300);
			assertThat(a.equals("woo"), is(false));
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			final XmlsonNumber a = new XmlsonNumber(300);
			assertThat(a.toString(), is("300"));
		}
	}
	
	public static class An_Xmlson_Float {
		@Test
		public void itHasAnFloatValue() throws Exception {
			final XmlsonNumber number = new XmlsonNumber(30.2);
			assertThat(number.getValue(), is((Number) 30.2));
		}
	}
}
