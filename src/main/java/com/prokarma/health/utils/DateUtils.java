package com.prokarma.health.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.util.StringUtils;

public class DateUtils {

	public static String getDateInValidicFormat(Date date) 
	{
		try
		{
			
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ");        
	        GregorianCalendar gc = new GregorianCalendar();
	        gc.setTime(date);
	        String dateString = sdf.format(gc.getTime());       
	        gc.setTime(sdf.parse(dateString));      
	        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	        System.out.println();
	        return date2.toString();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		 return null;
	}
}
