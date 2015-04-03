package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class TrainUserData {
	static LinkedList<UserBehavior> userBehaviors = new LinkedList<UserBehavior>();
	static HashMap<Integer,LinkedList<UserBehavior>> map = new HashMap<Integer, LinkedList<UserBehavior>>();

	public static UserBehavior addBehavior(String line) throws Exception{
		UserBehavior bhv = new UserBehavior(line);
		userBehaviors.add(bhv);
		return bhv;
	}
	
	
	public static void arrange(){
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		Collections.sort(userBehaviors);
		for(UserBehavior bhv: userBehaviors){
			if (!map.containsKey(bhv.userId))
				map.put(bhv.userId, new LinkedList<UserBehavior>());
			map.get(bhv.userId).add(bhv);
		}
	}
	
	public static LinkedList<UserBehavior> queryUser(int userId) {
		return map.get(userId);
	}
	
	static Date trainEndTime;
	private static String defaultDatePattern = "yyyy-MM-dd HH";
	public static void setTrainEndTime(String time) throws ParseException {
		trainEndTime = new SimpleDateFormat(defaultDatePattern).parse(time);
	}
}