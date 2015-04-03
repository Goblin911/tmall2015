package evaluation;

public class ResultItem {
	int userId;
	int itemId;
	public ResultItem(int userId, int itemId){
		this.userId = userId;
		this.itemId = itemId;
	}
	public String toString(){
		return userId+", "+itemId;
	}
}
