package DAlem_Lab2;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {

    /**
     * The main method for the GUI example program JavaFX version
     * @param args not used
     * @throws IOException
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMainPane root = new FXMainPane(); // Instantiate FXMainPane
        stage.setScene(new Scene(root, 400, 300)); // Set scene dimensions
        stage.setTitle("Hello World GUI"); // Set stage title
        stage.show(); // Display the stage
    }

}