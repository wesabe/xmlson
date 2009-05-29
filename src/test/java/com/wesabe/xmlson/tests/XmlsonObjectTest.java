package com.wesabe.xmlson.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlsonBoolean;
import com.wesabe.xmlson.XmlsonNull;
import com.wesabe.xmlson.XmlsonNumber;
import com.wesabe.xmlson.XmlsonObject;
import com.wesabe.xmlson.XmlsonString;

@RunWith(Enclosed.class)
public class XmlsonObjectTest {
	public static class A_New_Xmlson_Object {
		@Test
		public void itHasAName() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			assertEquals("blah", object.getName());
		}
		
		@Test
		public void itHasNoProperties() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			assertTrue(object.getProperties().isEmpty());
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			assertThat(object.toString(), is("{blah:{}}"));
		}
	}
	
	public static class Adding_A_String_Property {
		@Test
		public void itReturnsTheObjectForChaining() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			assertSame(object, object.addProperty("blah", "blah"));
		}
		
		@Test
		public void itAddsThePropertyToThePropertiesMap() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", "blee");
			
			XmlsonString property = (XmlsonString) object.getProperties().get(new XmlsonString("blah"));
			assertEquals("blee", property.getValue());
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", "blee");
			
			assertThat(object.toString(), is("{blah:{blah=blee}}"));
		}
		
		@Test
		public void itIsRetrievableAsAString() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", "blee");
			
			assertThat(object.getString("blah"), is("blee"));
		}
	}
	
	public static class Adding_A_Null_String_Property {
		@Test
		public void itAddsThePropertyToThePropertiesMap() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", (String) null);
			
			XmlsonNull property = (XmlsonNull) object.getProperties().get(new XmlsonString("blah"));
			assertNull(property.getValue());
		}
		
		@Test
		public void itIsRetrievableAsANullString() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", (String) null);
			
			assertThat(object.getString("blah"), is(nullValue()));
		}
	}
	
	public static class Adding_A_Number_Property {
		@Test
		public void itReturnsTheObjectForChaining() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			assertSame(object, object.addProperty("blah", 100));
		}
		
		@Test
		public void itAddsThePropertyToThePropertiesMap() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", 100);
			
			XmlsonNumber property = (XmlsonNumber) object.getProperties().get(new XmlsonString("blah"));
			assertEquals(100, property.getValue());
		}
		
		@Test
		public void itIsRetrievableAsAnInteger() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", 200);
			
			assertThat(object.getInteger("blah"), is(200));
		}
		
		@Test
		public void itIsRetrievableAsADouble() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", 200.0);
			
			assertThat(object.getDouble("blah"), is(200.0));
		}
	}
	
	public static class Adding_A_Null_Number_Property {
		@Test
		public void itAddsThePropertyToThePropertiesMap() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			Number blee = null;
			object.addProperty("blah", blee);
			
			XmlsonNull property = (XmlsonNull) object.getProperties().get(new XmlsonString("blah"));
			assertNull(property.getValue());
		}
		
		@Test
		public void itIsRetrievableAsAnInteger() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", (Integer) null);
			
			assertThat(object.getInteger("blah"), is(nullValue()));
		}
		
		@Test
		public void itIsRetrievableAsADouble() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", (Double) null);
			
			assertThat(object.getDouble("blah"), is(nullValue()));
		}
	}
	
	public static class Adding_A_Boolean_Property {
		@Test
		public void itReturnsTheObjectForChaining() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			assertSame(object, object.addProperty("blah", false));
		}
		
		@Test
		public void itAddsThePropertyToThePropertiesMap() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", false);
			
			XmlsonBoolean property = (XmlsonBoolean) object.getProperties().get(new XmlsonString("blah"));
			assertEquals(false, property.getValue());
		}
		
		@Test
		public void itIsRetrievableAsABoolean() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", true);
			
			assertThat(object.getBoolean("blah"), is(true));
		}
	}
	
	public static class Adding_A_Null_Boolean_Property {
		@Test
		public void itAddsThePropertyToThePropertiesMap() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			Boolean blee = null;
			object.addProperty("blah", blee);
			
			XmlsonNull property = (XmlsonNull) object.getProperties().get(new XmlsonString("blah"));
			assertNull(property.getValue());
		}
		
		@Test
		public void itIsRetrievableAsABoolean() throws Exception {
			final XmlsonObject object = new XmlsonObject("blah");
			object.addProperty("blah", (Boolean) null);
			
			assertThat(object.getBoolean("blah"), is(nullValue()));
		}
	}
	
	public static class Adding_A_Null_Property {
		@Test
		public void itReturnsTheObjectForChaining() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			assertSame(object, object.addNullProperty("blah"));
		}
		
		@Test
		public void itAddsThePropertyToThePropertiesMap() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			object.addNullProperty("blah");
			
			XmlsonNull property = (XmlsonNull) object.getProperties().get(new XmlsonString("blah"));
			assertNull(property.getValue());
		}
	}
	
	public static class Adding_A_Member {
		@Test
		public void itReturnsTheObjectForChaining() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			assertSame(object, object.add(new XmlsonObject("blah")));
		}
		
		@Test
		public void itAddsTheMemberToThePropertyMap() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			XmlsonObject member = new XmlsonObject("blee");
			object.add(member);
			
			XmlsonObject otherMember = (XmlsonObject) object.getProperties().get(new XmlsonString("blee"));
			assertSame(member, otherMember);
		}
	}
	
	public static class Adding_Itself_As_A_Member {
		@Test
		public void itThrowsAnException() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			try {
				object.add(object);
				fail("should have thrown an IllegalArgumentException but didn't");
			} catch (IllegalArgumentException e) {
				assertEquals("can't add member to itself", e.getMessage());
			}
		}
	}
}
