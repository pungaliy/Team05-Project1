package edu.usc.cs310.proj1.objects;
public class Item {
	public boolean isFavorite = false;
	public boolean isDoNotExplore = false;
	public boolean isToExplore = false;
	public String uniqueID;
	public String price;
	public double rating;
	public String websiteLink;
	public String name;
	public String getUniqueId() {
		return uniqueID;
	}
	public String getPrice () {
		return price;
	}
	public String getLink() {
		return websiteLink;
	}
	
}
