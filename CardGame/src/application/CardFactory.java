package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CardFactory {
	DBController cardDB = DBController.getInstance();

	public Card getCard (String cardID){

		CardBuilder cardToBuild = new CardBuilder();
		switch(cardDB.getCardTypeByCardName(cardID)){// get the card type so we can get the right info
		case("Action"):{
			return (cardToBuild.buildActionCardFromCardSet(cardDB.getActionCardInfoByCardName(cardID)));

		}
		case("Creature"):{
			return (cardToBuild.buildCreatureCardFromCardSet(cardDB.getCreatureCardInfoByCardName(cardID)));
		}
		}
		System.out.print("You should not be here");// test line, execution should never reach this point

		return null;
	}
	public ArrayList<Card> populatePlayerDeck (String fileName){
		ArrayList<Card> deck = new ArrayList<Card>();
		String fileOut;
		try{
			File file = new File(getClass().getResource(fileName).getFile());
			Scanner fileScanner = new Scanner(file);
			do{
				fileOut=fileScanner.nextLine();
				if (fileOut.equals("Start")){ //indecates the start of a creature deck
					deck.get(deck.size()-1).addDeck(populateCreatureDeck(fileScanner)); // only called on creature cards
				}
				else{
					deck.add(getCard(fileOut));
				}
			}while(fileScanner.hasNext());
			fileScanner.close();
			return deck;
		}catch(Exception e){e.printStackTrace();System.out.print( "Error in populate player deck");}

		return null;

	}
	private ArrayList<Card> populateCreatureDeck(Scanner fileScanner) {
		String fileOut;
		ArrayList<Card> creatureDeck = new ArrayList<Card>();
		try{
			do{
				fileOut = fileScanner.nextLine();
				if (!fileOut.equals("End")){ // Indicates the end of a creature deck
					creatureDeck.add(getCard(fileOut));
				}
				else break;
			}while (true);
		}catch(Exception e){System.out.print(e);}
		return creatureDeck;
	}

}
