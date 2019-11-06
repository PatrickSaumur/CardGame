package application;

import java.util.ArrayList;

public abstract class Effect {
	String effectType;
	int effectMagnatude;
	public Effect(int effectMagnatude) {
		this.effectMagnatude=effectMagnatude;
	}
	public ArrayList<TriggerCondition> getTriggerConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
