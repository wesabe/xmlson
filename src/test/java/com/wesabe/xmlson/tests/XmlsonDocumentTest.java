package com.wesabe.xmlson.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.xmlson.XmlsonDocument;
import com.wesabe.xmlson.XmlsonObject;
import com.wesabe.xmlson.XmlsonString;

@RunWith(Enclosed.class)
public class XmlsonDocumentTest {
	public static class A_New_Document {
		@Test
		public void itHasAName() throws Exception {
			XmlsonDocument document = new XmlsonDocument("blah");
			assertEquals("blah", document.getName());
		}
		
		@Test
		public void itHasNoProperties() throws Exception {
			XmlsonDocument document = new XmlsonDocument("blah");
			assertTrue(document.getProperties().isEmpty());
		}
	}
	
	public static class Adding_A_Member {
		@Test
		public void itReturnsTheDocumentForChainingPurposes() throws Exception {
			XmlsonDocument document = new XmlsonDocument("blah");
			assertSame(document, document.add(new XmlsonObject("blee")));
		}
		
		@Test
		public void itAddsTheMemberToTheMap() throws Exception {
			XmlsonDocument document = new XmlsonDocument("blah");
			XmlsonObject object = new XmlsonObject("blee");
			
			document.add(object);
			
			assertSame(object, document.getProperties().get(new XmlsonString("blee")));
		}
	}
}
