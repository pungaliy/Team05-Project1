package cs310team5project.cs310;

import java.util.ArrayList;

public class Recipe extends Item {
	
	Recipe(String recipename, String imagelink, String preptime, String cooktime,ArrayList<String> ingredient,ArrayList<String> instruction) {
		recipeName = recipename;
		imageLink = imagelink;
		prepTime = preptime;
		cookTime = cooktime;
		ingredients = ingredient;
		instructions = instruction;
	}

	public String recipeName;
	public String imageLink;
	public String prepTime;
	public String cookTime;
	public ArrayList<String> ingredients;
	public ArrayList<String> instructions;
	
}