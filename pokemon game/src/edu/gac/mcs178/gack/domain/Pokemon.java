package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Pokemon extends Thing {
	private int damage;
	private int health;
	private Person owner;
	private int originalHealth;
	private String skill;
	
	public Pokemon(String name, int attack, int health, String skill) {
		super(name);
		this.damage= attack;
		this.health = health;
		this.originalHealth=health;
		this.skill= skill;
	}
	
	
	public void setAttack (int damage) {
		this.damage = damage;
	}
	
	public void setHealth (int newHealth) {
		this.health = newHealth;
	}
	
	public int getAttack () {
		return this.damage;
	}
	
	public int getHealth () {
		return this.health;
	}
	public String getSkill() {
		return this.skill;
	}
	
	public void attack(Person enemy, Pokemon enemyPokemon) {
		enemyPokemon.setHealth(enemyPokemon.getHealth() - this.getAttack());
		Utility.displayMessage(this.getName() + " uses " + this.skill + " and  deals a damage of " + this.getAttack() + " to " + enemyPokemon.getName());
	}
	
	public static List<Pokemon> pokemonIn (Place place) {
		ArrayList<Pokemon> pokemonIn = new ArrayList<Pokemon>();
		for (Thing thing:place.getContents()) 
			if (thing instanceof Pokemon) 
				pokemonIn.add((Pokemon)thing);
			
		return pokemonIn;
		
	}
	public boolean die() {
		return this.getHealth()<=0;
		
	}
	public void giveUpPokemon(Person recipient) {
		Person owner=this.getOwner();
		if (this.die()) {
			owner.say("I adore you power, I will give my beloved "+ this.getName()+" to you!");
			owner.give(recipient, this);
			
		}
		
	}
	
	public void revive() {
		this.setHealth(originalHealth);
	}
	
	/*public void beRead() {
		Person owner = getOwner();
		if (owner == null) {
			Utility.displayMessage("No one has " + getName());
		} else {
			owner.say("I have read " + getName());
		}
	}
	
	public static List<Scroll> scrollsIn(Place place) {
		ArrayList<Scroll> scrollsIn = new ArrayList<Scroll>();
		for (Thing thing : place.getContents()) {
			if (thing instanceof Scroll) {
				scrollsIn.add((Scroll) thing);
			}
		}
		return scrollsIn;
	}*/
	

}