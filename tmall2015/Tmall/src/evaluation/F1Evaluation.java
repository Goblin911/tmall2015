package evaluation;

import java.util.LinkedList;

import data.BehaviorType;
import data.TrainItemData;
import data.TrainUserData;
import data.UserBehavior;

public class F1Evaluation {
	public static F1Evaluation instance;
	
	public static F1Evaluation getInstance() throws Exception{
		if (instance == null) instance = new F1Evaluation();
		return instance;
	}
	
	
	double precision;
	double recall;
	Result groundTruth;
	
	private F1Evaluation() throws Exception{
		LinkedList<UserBehavior> testData = TrainUserData.getTestData();
		groundTruth = new Result();
		for(UserBehavior bhv: testData){
			if (bhv.behaviorType == BehaviorType.BUY && TrainItemData.checkItem(bhv.itemId))
				groundTruth.addResultItem(bhv.userId, bhv.itemId);
		}
	}
	public double getF1Score(Result result){
		int tp = 0;
		for(ResultItem ri: result.result){
			if (groundTruth.result.contains(ri)) tp++;
		}
		precision = (double)tp/result.result.size();
		recall = (double)tp/groundTruth.result.size();
		
		System.out.println("result size: "+result.result.size());
		System.out.println("groundTruth size: "+groundTruth.result.size());
		System.out.println("tp size: "+tp);
		
		return 2*(precision*recall)/(precision+recall);
	}
	
	public double getPrecision(){
		return precision;
	}
	
	public double getRecall(){
		return recall;
	}
}
