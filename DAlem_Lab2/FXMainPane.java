package DAlem_Lab2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.
 * Before beginning to implement, design the structure of your GUI in order to
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.
 * @author Dawit Alem
 *
 */
public class FXMainPane extends VBox {

    // Declare five buttons, a label, and a textfield
    private Button buttonAmharic; // Amharic button
    private Button buttonHello;
    private Button buttonHowdy;
    private Button buttonChinese;
    private Button buttonClear;
    private Button buttonExit;
    private Label feedbackLabel;
    private TextField feedbackTextField;
    private HBox buttonHBox;
    private HBox inputHBox;

    // Declare an instance of DataManager
    private DataManager dataManager;

    /**
     * The MainPanel constructor sets up the entire GUI in this approach.
     */
    FXMainPane() {
        // Instantiate the DataManager instance
        dataManager = new DataManager();

        // Instantiate the buttons
        buttonHello = new Button("Hello");
        buttonHowdy = new Button("Howdy");
        buttonChinese = new Button("Chinese");
        buttonAmharic = new Button("ሰላም"); // Amharic for "Hello"
        buttonClear = new Button("Clear");
        buttonExit = new Button("Exit");

        // Instantiate the label and textfield
        feedbackLabel = new Label("Feedback:");
        feedbackTextField = new TextField();

        // Instantiate the HBoxes
        buttonHBox = new HBox();
        inputHBox = new HBox();

        // Set alignment and margins
        buttonHBox.setAlignment(Pos.CENTER);
        inputHBox.setAlignment(Pos.CENTER);
        HBox.setMargin(buttonHello, new Insets(5));
        HBox.setMargin(buttonHowdy, new Insets(5));
        HBox.setMargin(buttonChinese, new Insets(5));
        HBox.setMargin(buttonAmharic, new Insets(5)); // Margin for Amharic button
        HBox.setMargin(buttonClear, new Insets(5));
        HBox.setMargin(buttonExit, new Insets(5));

        // Add the label and textfield to one of the HBoxes
        inputHBox.getChildren().addAll(feedbackLabel, feedbackTextField);

        // Add the buttons to the other HBox
        buttonHBox.getChildren().addAll(buttonHello, buttonHowdy, buttonChinese, buttonAmharic, buttonClear, buttonExit);

        // Add the HBoxes to this FXMainPane (a VBox)
        getChildren().addAll(inputHBox, buttonHBox);

        // Set the button action handlers
        buttonHello.setOnAction(new ButtonHandler());
        buttonHowdy.setOnAction(new ButtonHandler());
        buttonChinese.setOnAction(new ButtonHandler());
        buttonAmharic.setOnAction(new ButtonHandler()); // Set action for Amharic button
        buttonClear.setOnAction(new ButtonHandler());
        buttonExit.setOnAction(new ButtonHandler());
    }

    // Create a private inner class to handle the button clicks
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getTarget() == buttonHello) {
                feedbackTextField.setText(dataManager.getHello());
            } else if (event.getTarget() == buttonHowdy) {
                feedbackTextField.setText(dataManager.getHowdy());
            } else if (event.getTarget() == buttonChinese) {
                feedbackTextField.setText(dataManager.getChinese());
            } else if (event.getTarget() == buttonAmharic) {
                feedbackTextField.setText("ሰላም ዓለም"); // Amharic for "Hello World"
            } else if (event.getTarget() == buttonClear) {
                feedbackTextField.setText("");
            } else if (event.getTarget() == buttonExit) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}
