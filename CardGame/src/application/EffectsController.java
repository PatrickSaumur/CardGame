package application;

import java.util.ArrayList;

public class EffectsController {
	private static ArrayList<Effect> attackEffects = new ArrayList<Effect>();

	public static void addAttackEffect(Effect effect){
		attackEffects.add(effect);
	}

	public static void attackHappened(Card actor){
		ArrayList<Card> targets=new ArrayList<Card>();
		for (Effect currentEffect:attackEffects){
			for (TriggerCondition currentTrigger:currentEffect.getTriggerConditions()){
				targets.addAll(currentTrigger.checkTargets(actor));
			}
		}
	}
}
