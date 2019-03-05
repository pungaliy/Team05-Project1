package edu.usc.cs310.proj1.objects;

import java.util.ArrayList;

public class Recipe extends Item {
	public String recipeName;
	public String imageLink;
	public String prepTime;
	public String cookTime;
	public String ingredients[];
	public String instructions[];
	
	Recipe(String recipename, String imagelink, String preptime, String cooktime,ArrayList<String> ingredient,ArrayList<String> instruction) {
		recipeName = recipename;
		imageLink = imagelink;
		prepTime = preptime;
		cookTime = cooktime;
		ingredients = new String[ingredient.size()];
		instructions = new String[instruction.size()];
		for(int i = 0; i < ingredient.size(); i++) {
			ingredients[i] = ingredient.get(i);
		}
		for(int i = 0; i < instruction.size(); i++) {
			instructions[i] = instruction.get(i);
		}
	}
	
}