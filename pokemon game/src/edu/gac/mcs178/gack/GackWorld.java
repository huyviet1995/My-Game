package edu.gac.mcs178.gack;

import edu.gac.mcs178.gack.domain.AutoPerson;
import edu.gac.mcs178.gack.domain.Person;
import edu.gac.mcs178.gack.domain.Place;
import edu.gac.mcs178.gack.domain.Scroll;
import edu.gac.mcs178.gack.domain.Thing;
import edu.gac.mcs178.gack.domain.Witch;
import edu.gac.mcs178.gack.domain.Wizard;
import edu.gac.mcs178.gack.domain.Pokemon;

public class GackWorld extends World {
	
	public GackWorld() {
		super();
		Place foodService = new Place("Food Service");
		Place po = new Place("Post Office");
		Place alumniHall = new Place("Alumni Hall");
		Place chamberOfWizards = new Place("Chamber of Wizards");
		Place library = new Place("Library");
		Place goodShipOlin = new Place("Good Ship Olin");
		Place lounge = new Place("Lounge");
		Place computerLab = new Place("Computer Lab");
		Place offices = new Place("Offices");
		Place dormitory = new Place("Dormitory");
		Place pond = new Place("Pond");
		
		foodService.addNewNeighbor("down", po);
		po.addNewNeighbor("south", alumniHall);
		alumniHall.addNewNeighbor("north", foodService);
		alumniHall.addNewNeighbor("east", chamberOfWizards);
		alumniHall.addNewNeighbor("west", library);
		chamberOfWizards.addNewNeighbor("west", alumniHall);
		chamberOfWizards.addNewNeighbor("south", dormitory);
		dormitory.addNewNeighbor("north", chamberOfWizards);
		dormitory.addNewNeighbor("west", goodShipOlin);
		library.addNewNeighbor("east", library);
		library.addNewNeighbor("south", goodShipOlin);
		goodShipOlin.addNewNeighbor("north", library);
		goodShipOlin.addNewNeighbor("east", dormitory);
		goodShipOlin.addNewNeighbor("up", lounge);
		lounge.addNewNeighbor("west", computerLab);
		lounge.addNewNeighbor("south", offices);
		computerLab.addNewNeighbor("east", lounge);
		offices.addNewNeighbor("north", lounge);
		
		
		new AutoPerson("Louis Yu", dormitory,2);
		new AutoPerson("Jeff", dormitory, 5);
		new AutoPerson("Max", offices, 5);
		new AutoPerson("Karl", computerLab, 5);
		new Witch("Barbara", offices, 3, pond);
		new Wizard("Elvee", offices, 1, chamberOfWizards);
		
		lounge.gain(new Pokemon("MewTwo", 200, 1000,"telekinesis"));
		goodShipOlin.gain(new Pokemon("Legendary Birds",300,800,"raising fire"));
		lounge.gain(new Thing("Karl's glasses"));
		lounge.gain(new Pokemon("Pikachu", 300 ,1000, "destructive thunder"));
		offices.gain(new Pokemon("Charmander", 400,900, "hell fire"));
		offices.gain(new Pokemon("Squirtle", 500,800, "torrent"));
		offices.gain(new Pokemon("Bulbasaur", 400, 800,"photosynthesis"));
		offices.gain(new Pokemon("Eevee", 300,700,"thunderstone")); 
		
		library.gain(new Scroll("Scroll of Enlightenment"));
		String[] someTitles = {"War and Peace", "Iliad", "Collected Works of Rilke"};
		for (String title : someTitles) {
			library.gain(new Scroll(title));
		}
		computerLab.gain(new Scroll("Unix Programmers Manual"));
		computerLab.gain(new Scroll("NeXT User's Reference"));
		
		dormitory.gain(new Scroll("late lab report"));
		dormitory.gain(new Pokemon("Blastoise", 400,900,"water shooting"));
		dormitory.gain(new Pokemon("Butterfree", 500,900,"compoundeyes"));
		dormitory.gain(new Pokemon("Sandslash", 400, 1000,"sand carpeting"));
		dormitory.gain(new Pokemon("Golbat", 300,900, "ultra sound "));
		
		setPlayer(new Person("player", dormitory));
	}
}
