package effects;

import java.util.ArrayList;

import application.Card;

public class TargetCascader {

	public ArrayList<Card> findTargets (Card targeter){

		ArrayList<TargetCondition> targetingConditions = targeter.getTargetingConditions();
		ArrayList<String> conditionOperator = targeter.getConditionOrder();
		ArrayList<Card> tempTargets = targetingConditions.get(0).getTargets(targeter);
		ArrayList<Card> targets = new ArrayList<Card>();
		targets.addAll(tempTargets);
		ArrayList<Card> recivedTargets = new ArrayList<Card>();

		if (conditionOperator.size()>0){


			for(int i=1;i<conditionOperator.size();i++){
				recivedTargets= targetingConditions.get(1).getTargets(targeter);
				switch(conditionOperator.get(i)){
				case "AND":
					tempTargets.clear();
					for (int j=0; j<recivedTargets.size(); j++){
						if(targets.contains(recivedTargets.get(j))){
							tempTargets.add(recivedTargets.get(j));
						}
					}
					break;

				case "OR":
					for (int j=0; j<recivedTargets.size(); j++){
						if(targets.contains(recivedTargets.get(j))){
						}else tempTargets.add(recivedTargets.get(j));
					}
					break;
				}
				recivedTargets.clear();
				targets.clear();
				targets.addAll(tempTargets);
			}
		}

		return targets;

	}
}

