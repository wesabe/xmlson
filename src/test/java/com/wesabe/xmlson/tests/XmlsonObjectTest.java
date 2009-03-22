package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlsonBoolean;
import com.wesabe.xmlson.XmlsonDocument;
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
	}
	
	public static class Adding_A_Null_String_Property {
		@Test
		public void itAddsThePropertyToThePropertiesMap() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			String blee = null;
			object.addProperty("blah", blee);
			
			XmlsonNull property = (XmlsonNull) object.getProperties().get(new XmlsonString("blah"));
			assertNull(property.getValue());
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
		@Test(expected = IllegalArgumentException.class)
		public void itThrowsAnException() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			object.add(object);
		}
	}
	
	public static class Adding_A_Document_As_A_Member {
		@Test(expected = IllegalArgumentException.class)
		public void itThrowsAnException() throws Exception {
			XmlsonObject object = new XmlsonObject("blah");
			object.add(new XmlsonDocument("root"));
		}
	}
}
