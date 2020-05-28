package Proyecto1.DatosParty.GUI.Help;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Class for drawing the help window, it has its own main method
 */
public class HelpWindowStart extends Application {
    /**
     * method for drawing help window, a normal window with always on top feature
     * @param stage
     * @throws Exception IO exception from the FXML loader
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HelpWindow.fxml"));
        stage.setAlwaysOnTop(true);
        root.getStylesheets().add("file:stylesheet.css");
        stage.setTitle("Help!");
        stage.setScene(new Scene(root, 800, 600));
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
