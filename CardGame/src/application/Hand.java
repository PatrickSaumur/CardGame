package application;

import java.util.ArrayList;

public class Hand extends CardSet {

	Hand(){
		cards = new ArrayList<Card>();
	}
	public void draw(Card newCard){
		cards.add(newCard);
	}

	public Card discard(){
		Card tempCard= cards.get(0);
		cards.remove(0);
		return tempCard;
	}
}
