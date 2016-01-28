package edu.gac.mcs178.gack.domain;

import java.util.List;

import edu.gac.mcs178.gack.Registry;
import edu.gac.mcs178.gack.Utility;

public class AutoPerson extends Person {
	
	private static Registry registry;
	
	public static Registry getRegistry() {
		if(registry == null){
			registry = new Registry();
		}
		return registry;
	}

	private int threshold;
	private int restlessness;
	
	public AutoPerson(String name, Place place, int threshold) {
		super(name, place);
		this.threshold = threshold;
		this.restlessness = 0;
		getRegistry().add(this);
	}
	
	public void maybeAct() {
		if (restlessness < threshold) {
			restlessness++;
		} else {
			restlessness = 0;
			catchPokemon();
			act();
			challengeOthers();
		}
	}
	
	public void act() {
		List<Place> neighbors = getPlace().neighbors();
		if (!neighbors.isEmpty()) {
			Place newPlace = neighbors.get(Utility.randInt(neighbors.size()));
			moveTo(newPlace);
		}
	}
	public void challengeOthers() {
		List<Person> enemies = this.otherPeopleAtSamePlace();
		Person enemy=null;
		if (!enemies.isEmpty())
			enemy = enemies.get(Utility.randInt(enemies.size()));
		if (enemy!=null && enemy.havePokemon()) {
			this.say("Hey " + enemy.getName() + ". I challenge you to a pokemon match");
			if (enemy.challengeAccept()) {
				
				Pokemon recipientPokemon=enemy.chosenPokemon();
				Pokemon myPokemon=this.chosenPokemon();
				enemy.say("I accept your challenge " + this.getName());
				this.say(myPokemon.getName()+ ", I choose you");
				enemy.say(recipientPokemon.getName()+ ", I choose you");
				while (!recipientPokemon.die() || !myPokemon.die()) {
					myPokemon.attack(enemy, recipientPokemon);
					recipientPokemon.attack(this,myPokemon);
				}
					if (recipientPokemon.die()) {
						this.say("Your pokemon's heath is + " +recipientPokemon.getHealth());
						this.say("Haha, I win");
						recipientPokemon.giveUpPokemon(this);
					}
					else if (myPokemon.die()) {
						enemy.say("Your pokemon's health is " + myPokemon.getHealth());
						enemy.say("Haha I win");
						myPokemon.giveUpPokemon(enemy);
						
					}
				
					myPokemon.revive();
					recipientPokemon.revive();
					
				} else if (!enemy.havePokemon()) 
					enemy.say("Dude, I don't have any pokemon now, next time, okay ?");
				else 
					enemy.say("Sorry, I am not in the mood today!");
					
				}
			}
		
	
	public void catchPokemon() {
		List<Pokemon> pokemons = this.getPlace().getPokemon();
		
		//for (Pokemon pokemon:pokemons) {
			//this.say(pokemon.getName());
		if (!pokemons.isEmpty()) {
			Pokemon caughtPokemon = pokemons.get(Utility.randInt(pokemons.size()));
			this.take(caughtPokemon);
			
		}
		
	}
	
}
