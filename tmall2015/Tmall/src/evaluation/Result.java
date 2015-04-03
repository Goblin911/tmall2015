package evaluation;

import java.util.LinkedList;

public class Result {
	LinkedList<ResultItem> result = new LinkedList<ResultItem>();
	public ResultItem addResultItem(int userId, int itemId){
		ResultItem ri = new ResultItem(userId, itemId);
		result.add(ri);
		return ri;
	}
}
