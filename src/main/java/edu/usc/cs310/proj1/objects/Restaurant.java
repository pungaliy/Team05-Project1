package edu.usc.cs310.proj1.objects;
public class Restaurant extends Item{
	public String address;
	public String phoneNumber;
	public String googleMapsLink;
	public double distance;
<<<<<<< Updated upstream
	
=======
	public String thisName;
>>>>>>> Stashed changes
	public String prettyPrint() {
		String s = "name: " + name;
		s+="\n";
		s += "ID: " + this.uniqueID;
		s+="\n";
		s += "price: " + this.price;
		s+="\n";
		s += "website: " + websiteLink;
		s+="\n";
		s+="phoneNumber: " + phoneNumber;
		s+="\n";
		s += "address: " + address;
		s+="\n";
		s += "distance: " + distance + "\n";
		return s;
	}
	@Override
	public String toString() {
		return name;
		
	}
}

