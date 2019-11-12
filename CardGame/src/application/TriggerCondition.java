package application;

import java.util.ArrayList;

public class TriggerCondition {



	public ArrayList<Card> checkTargets(Card actor){
		//TODO check viable targets
		Card tree = null;//the're potential targets
		ArrayList<Card> targets = new ArrayList<Card>();
		for (Card currentTarget:targets){
			if (tree.CanITargetYou(actor)){
				targets.add(tree);
			}
		}
		return targets;

	}
}
