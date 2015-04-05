package model;

import data.BehaviorType;
import data.TrainItemData;
import data.UserBehavior;
import evaluation.Result;

public class RuleBased extends Model{

	public RuleBased() throws Exception {
		super();
	}

	@Override
	public Result getResult() {
		Result result = new Result();
		for(UserBehavior bhv:trainData){
			if ((bhv.behaviorType == BehaviorType.BUY || bhv.behaviorType == BehaviorType.CART) 
					&& bhv.time.beforeTrain()<1*24*3600*1000 && TrainItemData.checkItem(bhv.itemId))
				result.addResultItem(bhv.userId, bhv.itemId);
		}
		return result;
	}
	
	
}
