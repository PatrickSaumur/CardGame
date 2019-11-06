package application;

import java.util.ArrayList;

public class EffectsController {
	private static ArrayList<Effect> attackEffects = new ArrayList<Effect>();
	
	public static void addAttackEffect(Effect effect){
		attackEffects.add(effect);
	}
	
	public static void attackHappened(Card actor){
		Effect currentEffect;
		ArrayList<TriggerCondition> effectTriggers;
		for (int i=0;i<attackEffects.size();i++){
			currentEffect=attackEffects.get(i);
			effectTriggers=currentEffect.getTriggerConditions();
			for (int j=0;j<effectTriggers.size();j++){
				((Object) effectTriggers).checkTargets(actor);
			}
		}
	}
}
