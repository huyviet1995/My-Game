package edu.gac.mcs178.gack.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;
import edu.gac.mcs178.gack.domain.Person;
import edu.gac.mcs178.gack.domain.Pokemon;
import edu.gac.mcs178.gack.domain.Thing;
import edu.gac.mcs178.gack.domain.Place;

import edu.gac.mcs178.gack.domain.Person;

public class StatusButtonListener implements ActionListener {
	
	private GraphicalUserInterface gui;
	private Person player;
	private List<Person> people;
	
	
	public StatusButtonListener(GraphicalUserInterface gui, Person player) {
		super();
		this.gui = gui;
		this.player = player;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		gui.displayMessage("\n>>> Pokemon around you");
		people = player.otherPeopleAtSamePlace();
		gui.displayMessage("List of owned pokemon around you:");
		for (Person person: people) {
			if (person.havePokemon())
				
			for (Pokemon pokemon: person.pokemons())
			{
				gui.displayMessage(pokemon.getName() + "(Owner: "+pokemon.getOwner()+ ". Health: "+ pokemon.getHealth() +". Attack: " + pokemon.getAttack()+ ". Skill:" +pokemon.getSkill() + ")");
			}
		}
		gui.displayMessage("List of wild pokemon:");
		for (Pokemon pokemon: player.getPlace().getPokemon()) {
			if (!pokemon.isOwned()) {
				
				gui.displayMessage(pokemon.getName()+". Attack: "+pokemon.getAttack()+". Health: "+pokemon.getHealth() + ". Skill: "+ pokemon.getSkill());
			}
		}
	}
}
