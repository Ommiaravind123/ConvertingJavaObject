package com.ibm;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.ibm.Student;

import java.io.File;
	import java.io.StringWriter;
	 
	import javax.xml.bind.JAXBContext;
	import javax.xml.bind.JAXBException;
	import javax.xml.bind.Marshaller;
	 
	public class ConvertToxml {
	
	  public static void main(String[] args) 
	  {
	    //Java object. We will convert it to XML.
	    Student s = new Student();
	    s.setSid(101);
	    s.setSname("Aravind");
	    s.setSalary(45000.00);
	     
	    //Method which uses JAXB to convert object to XML
	    jaxbObjectToXML(s);
	  }

	private static void jaxbObjectToXML(Student s) {
		  try
	      {
	        //Create JAXB Context
	          JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
	           
	          //Create Marshaller
	           Marshaller marshaller = jaxbContext.createMarshaller();
	 
	          //Required formatting??
	           marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 
	         //Store XML to File
	          File file = new File("src\\main\\resources\\Student.xml");
	           
	          //Writes XML file to file-system
	          marshaller.marshal(s, file); 
	      } 
	      catch (JAXBException e) 
	      {
	          e.printStackTrace();
	      }
	}
}
