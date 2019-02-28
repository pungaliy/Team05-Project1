package edu.usc.cs310.proj1.objects;
public class Item {
	public boolean isFavorite = false;
	public boolean isDoNotExplore = false;
	public boolean isToExplore = false;
	private int uniqueID;
	private double price;
	private String websiteLink;
	
	public int getUniqueId() {
		return uniqueID;
	}
	public double getPrice () {
		return price;
	}
	public String getLink() {
		return websiteLink;
	}
	
}