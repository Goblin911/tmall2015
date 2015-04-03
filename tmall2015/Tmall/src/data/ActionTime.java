package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionTime {
	Date date;
	private static String defaultDatePattern = "yyyy-MM-dd HH";
	public ActionTime(String str) throws ParseException{
		date =  new SimpleDateFormat(defaultDatePattern).parse(str);
	}
	
	public String toString() {
		return new SimpleDateFormat(defaultDatePattern).format(date);
	}
}
