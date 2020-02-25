package application;

import java.util.ArrayList;

import effects.Effect;

public class ActionCard extends Card {

	private ArrayList<Effect> effects= new ArrayList<Effect>();

	//Constructors
	public ActionCard(String cardNameIn, String cardSetIn) {
		super();
		name= cardNameIn;
		cardSet= cardSetIn;
	}

	@Override
	public void addDeck(ArrayList<Card> inDeck) { // Needs to exist in the interface so that it can be called on a generic card but will only be called by creature card

	}

	public void addEffect(Effect effect) { //adds an effect
		effects.add(effect);

	}


}
