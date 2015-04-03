package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class TrainUserData {
	static LinkedList<UserBehavior> userBehaviors = new LinkedList<UserBehavior>();
	static HashMap<Integer,LinkedList<UserBehavior>> map = new HashMap<Integer, LinkedList<UserBehavior>>();

	public static UserBehavior addBehavior(String line) throws Exception{
		UserBehavior bhv = new UserBehavior(line);
		userBehaviors.add(bhv);
		return bhv;
	}
	
	
	public static void arrange(){
		//System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
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
	
	public static Date trainEndTime;
	private static String defaultDatePattern = "yyyy-MM-dd HH";
	public static void setTrainEndTime(String time) throws ParseException {
		trainEndTime = new SimpleDateFormat(defaultDatePattern).parse(time);
	}


	public static LinkedList<UserBehavior> getTestData() throws Exception {
		if (trainEndTime == null) throw new Exception("trainEndTime is not set");
		LinkedList<UserBehavior> test = new LinkedList<UserBehavior>();
		for(UserBehavior bhv: userBehaviors){
			if (bhv.time.compareTo(trainEndTime)>=0) 
				test.add(bhv);
		}
		return test;
	}


	public static LinkedList<UserBehavior> getTrainData() throws Exception {
		if (trainEndTime == null) throw new Exception("trainEndTime is not set");
		LinkedList<UserBehavior> train = new LinkedList<UserBehavior>();
		for(UserBehavior bhv: userBehaviors){
			if (bhv.time.compareTo(trainEndTime)<0) 
				train.add(bhv);
		}
		return train;
	}

}
