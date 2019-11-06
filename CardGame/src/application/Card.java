package application;

import java.util.ArrayList;

public abstract class Card {
	protected String name;
	protected String cardSet;
	Card(String cardName){
		name=cardName;
	}
	public String getName(){
		return(name);
	}
	Card(){

	}

	public abstract void addDeck(ArrayList<Card> deck);
}
