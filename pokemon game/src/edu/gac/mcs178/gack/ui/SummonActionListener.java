package edu.gac.mcs178.gack.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JPopupMenu;

import edu.gac.mcs178.gack.Utility;
import edu.gac.mcs178.gack.domain.Person;
import edu.gac.mcs178.gack.domain.Pokemon;

import edu.gac.mcs178.gack.domain.Thing;

public class SummonActionListener implements ActionListener {
	
	private static final Thing INSTRUCTION = new Thing("Summon...");
	
	
	private GraphicalUserInterface gui;
	private Person player;
	private JComboBox summonJComboBox;
	private boolean enabled;
	private List<Pokemon> pokemons;
	private List<Person> people;
	private List<Thing> things;

	public SummonActionListener(GraphicalUserInterface gui, Person player, JComboBox summonJCombox) {
		super();
		this.gui = gui;
		this.player = player;
		this.summonJComboBox = summonJCombox;
		this.enabled = true;
		pokemons=player.pokemons();
		summonJComboBox.addItem(INSTRUCTION);
		//if the player is not challenged, then show nothing
		for (Pokemon pokemon:pokemons) {
			summonJComboBox.addItem(pokemon);
		}
	}
	public void setEnabled(boolean b) {
		enabled = b;
	}
	
	public void updateJComboBox() {
		summonJComboBox.removeAllItems();
		pokemons=player.pokemons();
		people = player.otherPeopleAtSamePlace();
		summonJComboBox.addItem(INSTRUCTION);
	//	if (!player.pokemons().isEmpty()){
		for (Pokemon pokemon:pokemons) {
			summonJComboBox.addItem(pokemon);
		}
		//}
		
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (enabled) {
			List<Person> playerHavePokemon = new ArrayList<Person>();
			people=player.otherPeopleAtSamePlace();
			Pokemon item = (Pokemon)summonJComboBox.getSelectedItem();
			if (!item.getName().equals(INSTRUCTION.getName())) {
				JPopupMenu popup = new JPopupMenu();
				if (people.isEmpty()) 
				{
					popup.add("There is no player to challenge");
					popup.show(summonJComboBox, 0, 0);
					updateJComboBox();
					//gui.playTurn();
				}
				else {
					
					for (Person person:people)
					{
						if (person.havePokemon())
							playerHavePokemon.add(person);
					}
					if (playerHavePokemon.isEmpty()) {
						popup.add("No player has any pokemon");
						popup.show(summonJComboBox, 0, 0);
						updateJComboBox();
					}
					else {
					for (Person person:playerHavePokemon)
					popup.add(new AttackAction("Summon "+ item+" to attack " + person,player,item, person, gui));
					popup.show(summonJComboBox,0,0);
					}
				}
	}
	}
}
}
@SuppressWarnings("serial")
class AttackAction extends AbstractAction  {
	
	private Person player;
	private Pokemon item;
	private Person recipient;
	private GraphicalUserInterface gui;
	private SummonActionListener summonJComboBox;
	
	public AttackAction(String name, Person player, Pokemon item, Person recipient, GraphicalUserInterface gui) {
		super(name);
		this.player = player;
		this.item = item;
		this.recipient = recipient;
		this.gui = gui;
	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		gui.displayMessage("\n>>>"+ player.getName() + " use" + this.item + " to challenge "+ this.recipient.getName() +"'s "+ recipient.chosenPokemon().getName());
		gui.displayMessage(String.valueOf(recipient.havePokemon()));
		Pokemon recipientPokemon=recipient.chosenPokemon();
		if (recipientPokemon==null ) {
				gui.displayMessage(player.getName() + " does not have any pokemon to play!");
		}
		else {
			player.say("Hey " + recipient.getName() + ". I challenge you to a pokemon match");
			if (recipient.challengeAccept()) {
				recipient.say("I accept your challenge, "+ player.getName());
				
				player.say(item +", I choose you");
				recipient.say(recipientPokemon +", I choose you");
				while (!recipientPokemon.die() || !this.item.die()) {
					this.item.attack(recipient, recipientPokemon);
					recipientPokemon.attack(player,this.item);	
					
				}
				
				if (recipientPokemon.die()) {
					player.say("Your pokemon's health is "+ recipientPokemon.getHealth());
					player.say("Haha, I win");
					recipientPokemon.giveUpPokemon(player);
				}
				else if (item.die()) {
					recipient.say("Your pokemon's health is "+ item.getHealth());
					recipient.say("Haha I win");
					item.giveUpPokemon(recipient);
					
				}
				item.revive();
				recipientPokemon.revive();
				
			}
			else  { 
				recipient.say("Sorry, I am not in the mood today!"); 
			}
		}
		gui.playTurn();
	}

}





