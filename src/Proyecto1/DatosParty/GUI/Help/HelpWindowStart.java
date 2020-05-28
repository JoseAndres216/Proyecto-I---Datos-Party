package Proyecto1.DatosParty.GUI.Help;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelpWindowStart extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HelpWindow.fxml"));
        stage.setAlwaysOnTop(true);
        root.getStylesheets().add("file:stylesheet.css");
        stage.setTitle("Help!");
        stage.setScene(new Scene(root, 800, 600));
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
