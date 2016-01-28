package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Food extends Thing {
	
	public Food(String name) {
		super(name);
	}

	public void beEaten() {
		Person owner = getOwner();
		if (owner == null) {
			Utility.displayMessage("No one has eaten " + this.getName());
		} else {
			owner.say("I have eaten " + this.getName());
		}
	}
	
	public static List<Food> FoodIn(Place place) {
		ArrayList<Food> FoodIn = new ArrayList<Food>();
		for (Thing thing : place.getContents()) {
			if (thing instanceof Food) {
				FoodIn.add((Food) thing);
			}
		}
		return FoodIn;
	}
}
