package application;

public class Player {
	private Deck deck;
	private Hand hand;
	private Discard discard;
	private int life;
	private int mana;
	private int exhaustion;

	Player(){
		deck= new Deck(1);
		hand= new Hand();
		discard = new Discard();
		exhaustion = 0;
	}

	public void printTopDeck(){
		deck.printFirstCard();
	}

	public void printTopHand(){
		hand.printFirstCard();
	}

	public void draw() throws DeckEmptyException{
		try{
			hand.draw(deck.removeCard());
		}catch(DeckEmptyException dee){
			try{
				shuffleInDiscard();
				hand.draw(deck.removeCard());
			}catch(DeckEmptyException dee2){System.out.print("Deck empty");}
		}
	}

	private void shuffleInDiscard() {
		exhaustionIncreases();
		deck.cards.addAll(discard.cards);
		discard.cards.clear();
		deck.shuffle();
	}

	private void exhaustionIncreases() {
		++exhaustion;
	}

	public void discardFromHand(){
		discard.discard(hand.discard());
	}

	public void discardFromDeck(){
		try{
			discard.discard(deck.removeCard());
		}catch(DeckEmptyException dee){
			try{
				shuffleInDiscard();
				discard.discard(deck.removeCard());
			}catch(DeckEmptyException dee2){System.out.println("Deck empty");}
		}
	}

}
