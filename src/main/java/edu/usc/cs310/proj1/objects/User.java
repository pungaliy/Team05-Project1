package edu.usc.cs310.proj1.objects;
/**
 * @author karti
 *
 */
public class User {
	public ItemList favoriteList;
	public ItemList toExploreList;
	public ItemList doNotShowList;
	public SearchResult searchResult;
	
	public boolean moveTo(Item i, String list1, String list2) {
		return true; //only if successfully transferred
	}
	
	public boolean createSearchResult(String search) {
		return true;
	}
}
