package data;

public class UserBehavior implements Comparable<UserBehavior>{
	public int userId;
	public int itemId;
	public int behaviorType;
	public GeoHash userGeohash;
	public int itemCategory;
	public ActionTime time;
	public boolean targetItem;
	
	public UserBehavior(String line) throws Exception{
		String[] arr = line.split(",");
		if (arr.length!=6) throw new Exception("The train user line field num not right!");
		userId = Integer.parseInt(arr[0]);
		itemId = Integer.parseInt(arr[1]);
		behaviorType = Integer.parseInt(arr[2]);
		userGeohash = new GeoHash(arr[3]);
		itemCategory = Integer.parseInt(arr[4]);
		time = new ActionTime(arr[5]);
	}

	@Override
	public int compareTo(UserBehavior o) {
		if (userId < o.userId) return -1;
		if (userId > o.userId) return 1;
		return (time.date.getTime()-o.time.date.getTime()>0)?1:-1;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(userId+"\t");
		if (targetItem) sb.append("*");
		sb.append(itemId+"\t");
		sb.append(behaviorType+"\t");
		sb.append(itemCategory+"\t");
		sb.append(time+"\n");
		return sb.toString();
	}
	
}
