package com.wesabe.xmlson.tests;

import static org.hamcrest.CoreMatchers.*;
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
			final XmlsonBoolean bool = new XmlsonBoolean(false);
			assertThat(bool.getValue(), is(false));
		}
		
		@Test
		public void itEqualsOtherXmlsonBooleans() throws Exception {
			final XmlsonBoolean a = new XmlsonBoolean(false);
			final XmlsonBoolean b = new XmlsonBoolean(false);
			assertThat(a.equals(b), is(true));
			assertThat(b.hashCode(), is(a.hashCode()));
		}
		
		@Test
		public void itDoesNotEqualNull() throws Exception {
			final XmlsonBoolean a = new XmlsonBoolean(false);
			assertThat(a.equals(null), is(false));
		}
		
		@Test
		public void itDoesNotEqualANonBoolean() throws Exception {
			final XmlsonBoolean a = new XmlsonBoolean(false);
			assertThat(a.equals(200), is(false));
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			final XmlsonBoolean a = new XmlsonBoolean(false);
			assertThat(a.toString(), is("false"));
		}
	}
}

