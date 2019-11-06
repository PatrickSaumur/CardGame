package application;

import java.sql.*;

public class DBController {

	private Connection con;
	private static DBController cardDB = new DBController();
	private PreparedStatement stmt;

	private DBController (){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CardDB?" + "user=root&password=8472erikSen117&serverTimezone=UTC");
			stmt=con.prepareStatement("SELECT CardType FROM CardT WHERE CardName=?");
		}catch(Exception e){System.out.println(e+"error in DBcontroller constructor");}
	}

	public static DBController getInstance(){
		return cardDB;
	}

	public String getCardTypeByCardName(String cardName) {
		ResultSet results;
		//cardName="Human Soldier";
		try{
			 stmt.setString(1,cardName);
			results = stmt.executeQuery();
			 results.first();
			 String tempString = results.getNString("CardType");
			 results.close();
			return tempString;
		}catch(Exception e){e.printStackTrace();System.out.println("error in getCardTypeByCardName");}
		return null;
	}

	public ResultSet getActionCardInfoByCardName (String cardName){
		try{
		PreparedStatement stmt = con.prepareStatement("select CardT.CardName, EffectType, EffectMagnatude, TriggerAction, Target, cardset from CardT left join ActionCardT on CardT.CardName=actioncardt.CardName left join EffectT on ActionCardT.CardName=EffectT.CardName where CardT.CardName=?");
		stmt.setString(1, cardName);
		return stmt.executeQuery();
		}catch(Exception e){System.out.println(e+"ga");}
		return null;

	}
	public ResultSet getCreatureCardInfoByCardName (String cardName){
		try{
		PreparedStatement stmt = con.prepareStatement("select CardT.CardName, cardset, CreatureType, Life from CardT left join CreatureCardT on CardT.CardName=Creaturecardt.CardName where CardT.CardName=?");
		stmt.setString(1, cardName);
		return stmt.executeQuery();
		}catch(Exception e){System.out.print(e+"error in getCreatureCardInfoByCardName");}
		return null;

	}

}
