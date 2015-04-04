package evaluation;

public class ResultItem {
	int userId;
	int itemId;
	public ResultItem(int userId, int itemId){
		this.userId = userId;
		this.itemId = itemId;
	}
	public String toString(){
		return userId+","+itemId;
	}
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof ResultItem)) return false;
		ResultItem other = (ResultItem)o;
		return (userId == other.userId && itemId == other.itemId);
	}
}
