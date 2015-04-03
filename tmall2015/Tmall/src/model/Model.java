package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import data.TrainUserData;
import data.UserBehavior;
import evaluation.Result;

public class Model {
	LinkedList<UserBehavior> trainData;
	HashMap<Integer,LinkedList<UserBehavior>> map = new HashMap<Integer, LinkedList<UserBehavior>>();
	public Model() throws Exception{
		trainData = TrainUserData.getTrainData();
		for(UserBehavior bhv: trainData){
			if (!map.containsKey(bhv.userId))
				map.put(bhv.userId, new LinkedList<UserBehavior>());
			map.get(bhv.userId).add(bhv);
		}
	}
	
	public Result getResult(){
		return null;
	}
	
	Set<Integer> getUserSet(){
		return map.keySet();
	}
	
}
