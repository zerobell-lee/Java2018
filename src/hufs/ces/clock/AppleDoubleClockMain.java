
package hufs.ces.clock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AppleDoubleClockMain extends Application {

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		AppleDoubleClockPane clockboard = new AppleDoubleClockPane("America/Phoenix"); // Create a clock

		// Create a handler for animation
		EventHandler<ActionEvent> eventHandler = e -> {
			clockboard.refresh(); // Set a new clock time
		};

		// Create an animation for a running clock
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); // Start animation

		// Create a scene and place it in the stage
		Scene scene = new Scene(clockboard, 800, 400);
		primaryStage.setTitle("Apple Double Clock"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		//BorderPane으로 만들어라
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
