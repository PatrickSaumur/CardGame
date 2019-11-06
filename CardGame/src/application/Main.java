package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene mainMenu = new Scene(root,400,400);
			mainMenu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(mainMenu);

			Button startButton = new Button("Start");
			Button quitButton = new Button("Quit");
			VBox buttons = new VBox(10, startButton, quitButton);
			root.setRight(buttons);
			EventHandler<ActionEvent> closeEvent  = new EventHandler<ActionEvent>() {
				@Override
		         public void handle(ActionEvent e) {
					primaryStage.close();}
				};
			quitButton.setOnAction(closeEvent);
			EventHandler<ActionEvent> startEvent  = new EventHandler<ActionEvent>() {
				@Override
		         public void handle(ActionEvent e) {
					@SuppressWarnings("unused")
					GameController game = new GameController(primaryStage);}
				};
			startButton.setOnAction(startEvent);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
