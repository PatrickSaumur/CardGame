package application;

import java.util.ArrayList;

public class Deck extends CardSet {

	Deck(int temp){
		CardFactory cardIndustry=new CardFactory();
		cards.addAll(cardIndustry.populatePlayerDeck("/PlayerDeck.txt"));
		shuffle();
	}
	Deck(){
	}
	Deck(String fileName){
	}

	public void setDeck (ArrayList<Card> cardIn){
		cards.addAll(cardIn);
	}
	public Card removeCard() throws DeckEmptyException{
		try{
			Card tempCard= cards.get(0);
			cards.remove(0);
			return tempCard;
		}catch(IndexOutOfBoundsException e){
		}
		return null;
	}

	public void shuffle() {
		ArrayList <Card> tempDeck = new ArrayList <Card>();
		int randomNumber;
		while(cards.size()>0){
			randomNumber= (int) (Math.random()*cards.size());
			tempDeck.add(cards.get(randomNumber));
			cards.remove(randomNumber);
		}
		cards=tempDeck;
	}


}
