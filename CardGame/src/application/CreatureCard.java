package application;

import java.util.ArrayList;

public class CreatureCard extends Card {
	private Deck deck;
	private int life;
	private String creatureType;

	public CreatureCard(String cardNameIn, String cardSetIn, String creatureTypeIn, int lifeIn) {
		super();
		name= cardNameIn;
		cardSet= cardSetIn;
		creatureType= creatureTypeIn;
		life = lifeIn;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addDeck(ArrayList<Card> inDeck) {
		deck = new Deck();
		deck.setDeck(inDeck);

	}

}
