

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class SimpleDateFormatExample {
	public static void main(String[] args) throws ParseException, DatatypeConfigurationException {

		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ");        
	        GregorianCalendar gc = new GregorianCalendar();
	        String dateString = sdf.format(gc.getTime());       
	        gc.setTime(sdf.parse(dateString));      
	        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		System.out.println(date2.toString());
		Date curDate = new Date();

		SimpleDateFormat format = new SimpleDateFormat();
		String DateToStr = format.format(curDate);
		System.out.println("Default pattern: " + DateToStr);

		format = new SimpleDateFormat("YYYY-MM-DDhh:mm:ssZ");
		DateToStr = format.format(curDate);
		System.out.println(DateToStr);

		format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		DateToStr = format.format(curDate);
		System.out.println(DateToStr);

		format = new SimpleDateFormat("dd MMMM yyyy zzzz", Locale.ENGLISH);
		DateToStr = format.format(curDate);
		System.out.println(DateToStr);

		format = new SimpleDateFormat("MMMM dd HH:mm:ss zzzz yyyy",
				Locale.ITALIAN);
		DateToStr = format.format(curDate);
		System.out.println(DateToStr);

		format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		DateToStr = format.format(curDate);
		System.out.println(DateToStr);

		try {
			Date strToDate = format.parse(DateToStr);
			System.out.println(strToDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}