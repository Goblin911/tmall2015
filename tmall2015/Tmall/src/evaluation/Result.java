package evaluation;

import java.io.PrintStream;
import java.util.LinkedList;

public class Result {
	LinkedList<ResultItem> result = new LinkedList<ResultItem>();
	public ResultItem addResultItem(int userId, int itemId){
		ResultItem ri = new ResultItem(userId, itemId);
		if (result.contains(ri)) return null;
		result.add(ri);
		return ri;
	}
	public void dump(PrintStream printer) {
		printer.println("user_id, item_id");
		for(ResultItem ri:result){
			printer.println(ri);
		}
		
	}
}
