package data;

import java.util.LinkedList;

public class ItemInfo {
	int itemId;
	LinkedList<GeoHash> geos = new LinkedList<GeoHash>();
	int itemCategory;
	public ItemInfo(int itemId, int itemCategory){
		this.itemId = itemId;
		this.itemCategory = itemCategory;
	}
	public void addGeoHash(String geo){
		geos.add(new GeoHash(geo));
	}
}
