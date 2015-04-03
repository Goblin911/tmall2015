package data;

import java.util.HashMap;

public class TrainItemData {
	static HashMap<Integer,ItemInfo> map = new HashMap<Integer, ItemInfo>();
	public static void addItemInfo(String line) throws Exception {
		String[] arr = line.split(",");
		if (arr.length!=3) throw new Exception("The train item line field num not right!");
		int item = Integer.parseInt(arr[0]);
		int cat = Integer.parseInt(arr[2]);
		if (map.keySet().contains(item)){
			
		}else{
			ItemInfo info = new ItemInfo(item, cat);
			map.put(item, info);
		}
		if (arr[1].length()>0) map.get(item).addGeoHash(arr[1]);
	}
	public static boolean checkItem(int itemId){
		return map.containsKey(itemId);
	}

}
