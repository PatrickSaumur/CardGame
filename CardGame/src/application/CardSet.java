package application;

import java.util.ArrayList;

public abstract class CardSet {
	protected ArrayList<Card> cards = new ArrayList<Card>();

	public void printFirstCard(){
		try{
			System.out.print(cards.get(0).getName());
		}catch(Exception e){
			System.out.print("card set empty");
		}
	}
}
