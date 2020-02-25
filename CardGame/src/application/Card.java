package application;

import java.util.ArrayList;

import effects.TargetCondition;

public abstract class Card {
	protected String name;
	protected String cardSet;
	protected ArrayList<TargetCondition> targetingConditions;
	Card(String cardName){
		name=cardName;
	}
	public String getName(){
		return(name);
	}
	Card(){

	}

	public abstract void addDeck(ArrayList<Card> deck);
	public boolean CanITargetYou(Card actor) {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<TargetCondition> getTargetingConditions() {
		return targetingConditions;
	}
	public ArrayList<String> getConditionOrder() {
		// TODO Auto-generated method stub
		return null;
	}
}
