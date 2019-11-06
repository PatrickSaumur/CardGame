package application;

import java.util.ArrayList;

public class Discard extends CardSet {

	Discard(){
		cards = new ArrayList<Card>();
	}

	public void discard(Card newCard){
		cards.add(newCard);
	}
}
