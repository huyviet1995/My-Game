package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Person {
	
	private String name;
	private Place place;
	private List<Thing> possessions;
	public boolean beChallenged;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name;}
	public Place getPlace() { return place; }
	public List<Thing> getPossessions() { return possessions; }

	public Person(String name, Place place) {
		super();
		this.name = name;
		this.place = place;
		this.possessions = new ArrayList<Thing>();
		place.gain(this);
	}
	
	public void say(String text) {
		Utility.displayMessage("At " + place + ": " + this + " says -- " + text);
	}
	
	public List<Thing> otherThingsAtSamePlace() {
		List<Thing> otherThingsAtSamePlace = new ArrayList<Thing>();
		for (Thing thing : place.getContents()) {
			if (!possessions.contains(thing)) {
				otherThingsAtSamePlace.add(thing);
			}
		}
		return otherThingsAtSamePlace;
	}
	
	public List<Person> otherPeopleAtSamePlace() {
		List<Person> otherPeopleAtSamePlace = new ArrayList<Person>();
		for (Person occupant : place.getOccupants()) {
			if (!occupant.equals(this)) {
				otherPeopleAtSamePlace.add(occupant);
			}
			
		}
		return otherPeopleAtSamePlace;
	}
	
	public void lookAround() {
		say("I see " + Utility.verbalizeList(otherPeopleAtSamePlace(), "no people") +
				" and " + Utility.verbalizeList(otherThingsAtSamePlace(), "no objects") +
				" and can go " + Utility.verbalizeList(place.exits(), "nowhere"));
	}
	
	public void listPossessions() {
		say("I have " + Utility.verbalizeList(possessions, "nothing"));
	}
	
	public void read(Scroll scroll) {
		if ((scroll.isOwned()) && (scroll.getOwner().equals(this))) {
			scroll.beRead();
			
		
		} else {
			Utility.displayMessage(this + " does not have " + scroll);
		}
	}
	public void moveTo(Place newPlace) {
		Utility.displayMessage(this + " moves from " + place + " to " + newPlace);
		place.lose(this);
		newPlace.gain(this);
		for(Thing possession : possessions) {
			place.lose(possession);
			newPlace.gain(possession);
		}
		place = newPlace;
		
		
		greet(otherPeopleAtSamePlace());
		
	}
	
	public void go(String direction) {
		Place newPlace = place.neighborTowards(direction);
		if (newPlace==null) {
			Utility.displayMessage("You cannot go " + direction + " from " + place);
		} else {
			moveTo(newPlace);
		}
	}
	
	public void take(Thing thing) {
		//if (equals(thing.getOwner())) {
			//Utility.displayMessage(this + " already has " + thing);
		//} else {
			if (!thing.isOwned()) {
			
			if (thing instanceof Pokemon ) {
				this.say(thing.getName()+ ", I catch you");
				this.getPlace().lose(thing);
				thing.setOwner(this);
				possessions.add(thing);
				
			}
			else
			{
				say("I take " + thing);
				thing.setOwner(this);
				possessions.add(thing);
				this.getPlace().lose(thing);
			}
			
		}
	}
	
	
	public void give(Person taker, Thing thing) {
			thing.setOwner(taker);
			
			taker.possessions.add(thing);
			this.lose(thing);
		}
		
	
	public void lose(Thing thing) {
			thing.becomeUnowned();
			this.possessions.remove(thing);
		}
	public void eat (Thing thing) {
		if (equals(thing.getOwner())) {
			Utility.displayMessage(this + "has already eaten " + thing);
			
		}
		else if (!(thing instanceof Pokemon)){
			this.lose(thing);
			thing.becomeUnowned();
			Utility.displayMessage(this.getName() + " already gains some weight and get diabete!");
		}
	}
	
	public void greet(List<Person> people) {
		if (!people.isEmpty()) {
			say("Hi " + Utility.verbalizeList(people, "no one")); // "no one" can't happen
		}
	}
	
	public boolean challengeAccept () {
		double drawNumber = Math.random();
		return (drawNumber < 0.5);
	}

	
	/*public Person possibleEnemy() {
		List<Person> others =this.otherPeopleAtSamePlace();
		Person possibleEnemy = null;
		if (!others.isEmpty() && (doChallenge()) && (!this.pokemons().isEmpty())) {
			possibleEnemy = others.get(Utility.randInt(others.size()));
			//this.say("Hey " + possibleEnemy.getName() + ". I challenge you to a Pokemon match!");
		}
		return possibleEnemy;
	}*/
	public Pokemon chosenPokemon() {
		Pokemon pokemon = null;
		if (!this.pokemons().isEmpty())
			pokemon = this.pokemons().get(Utility.randInt(pokemons().size()));
		return pokemon;
	}
	

			
				/*this.say("I chose you " + this.chosenPokemon().getName());
				this.possibleEnemy().say("I chose you " + this.possibleEnemy().chosenPokemon().getName());
				this.chosenPokemon().attack(possibleEnemy(), possibleEnemy().chosenPokemon());*/
				
	
	public List<Pokemon> pokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon> () ;
		for (Thing thing: possessions){
			if (thing instanceof Pokemon) {
				pokemons.add((Pokemon)thing);
				
			}
		}
		return pokemons;
	}
	public boolean havePokemon() {
		return (!pokemons().isEmpty() );
	}

	
	
	
	@Override
	public String toString() {
		return name;
	}
}

