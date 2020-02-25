package application;

import java.sql.ResultSet;

import effects.AttackEffect;
import effects.Effect;
import effects.EffectParser;
import effects.HealEffect;

public class CardBuilder {

	public Card buildCreatureCardFromCardSet(ResultSet cardInfoByCardName) {
		try{
			cardInfoByCardName.first();
			return new CreatureCard(cardInfoByCardName.getString("CardT.CardName"), cardInfoByCardName.getString("cardset"), cardInfoByCardName.getString("CreatureType"), cardInfoByCardName.getInt("Life"));
		}catch(Exception e){System.out.print(e);}
		return null;
	}

	public Card buildActionCardFromCardSet(ResultSet cardInfoByCardName) {
		try{
			EffectParser effectParser = new EffectParser();
			cardInfoByCardName.first();
			ActionCard tempCard=new ActionCard(cardInfoByCardName.getString("CardT.CardName"), cardInfoByCardName.getString("cardset"));
			do{
				tempCard.addEffect(makeEffect(effectParser.getEffectType(), effectParser.getMagnatude()));
			}while(cardInfoByCardName.next());
			return tempCard;
		}catch(Exception e){System.out.println(e+" BuildActionCard");}
		return null;
	}

	private Effect makeEffect(String effectType, int magnatude){
		effectType.toLowerCase();
		switch(effectType){
		case "attack": return (new AttackEffect(magnatude));
		case "heal": return (new HealEffect(magnatude));
		default: return null;
		}
	}
}
