package application;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GameController {

	Player humanPlayer = new Player();
	Player opponent = new Player();
	GameController(Stage primaryStage){

		BorderPane gameRoot =new BorderPane();
		Scene gameScene = new Scene(gameRoot);
		Button deckButton = new Button("Deck");
		Button quitButton = new Button("Quit");
		Button handButton = new Button("Hand");
		Button drawButton = new Button("Draw");
		Button endTurnButton = new Button("End Turn");
		Button discardButton = new Button("Discard");
		VBox buttons = new VBox(10, deckButton, handButton, drawButton, discardButton, endTurnButton, quitButton);
		gameRoot.setRight(buttons);
		EventHandler<ActionEvent> closeEvent  = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.close();}
		};
		quitButton.setOnAction(closeEvent);
		EventHandler<ActionEvent> deckEvent  = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				humanPlayer.printTopDeck();}
		};
		EventHandler<ActionEvent> handEvent  = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				humanPlayer.printTopHand();}
		};
		EventHandler<ActionEvent> endTurnEvent  = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			}
		};
		EventHandler<ActionEvent> drawEvent  = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					humanPlayer.draw();
				} catch (DeckEmptyException e1) {
					System.out.println("No cards in deck or discard");
				}
			}
		};
		EventHandler<ActionEvent> discardEvent  = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				humanPlayer.discardFromDeck();}
		};
		handButton.setOnAction(handEvent);
		drawButton.setOnAction(drawEvent);
		discardButton.setOnAction(discardEvent);
		deckButton.setOnAction(deckEvent);
		endTurnButton.setOnAction(endTurnEvent);
		primaryStage.setScene(gameScene);

		boardSetUp();



	}


	private void boardSetUp() {

		for (int i=0;i<5;i++){
			try {
				humanPlayer.draw();
			} catch (DeckEmptyException e) {
				e.printStackTrace();
			}
		}
		for (int i=0;i<5;i++){
			try {
				opponent.draw();
			} catch (DeckEmptyException e) {
				e.printStackTrace();
			}
		}
	}
	private void endTurn(){

	}



}
