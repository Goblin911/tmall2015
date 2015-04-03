package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionTime implements Comparable<Date>{
	Date date;
	private static String defaultDatePattern = "yyyy-MM-dd HH";
	public ActionTime(String str) throws ParseException{
		date =  new SimpleDateFormat(defaultDatePattern).parse(str);
	}
	
	public String toString() {
		return new SimpleDateFormat(defaultDatePattern).format(date);
	}

	@Override
	public int compareTo(Date o) {
		long sub = date.getTime()-o.getTime();
		if (sub == 0) return 0;
		return (sub>0)?1:-1;
	}
	
	public long beforeTrain(){
		return TrainUserData.trainEndTime.getTime() - date.getTime();
	}
	
}
