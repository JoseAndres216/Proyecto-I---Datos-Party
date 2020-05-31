package Proyecto1.DatosParty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) {
        launch(args);
        Table tableroPrueba = new Table();
        tableroPrueba.generateTable();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("\\GUI\\MainMenu\\MainMenu.fxml"));
        stage.setAlwaysOnTop(false);
        stage.setTitle("Datos Party!");
        stage.setScene(new Scene(root));
        stage.resizableProperty().setValue(false);
        stage.setFullScreen(false);
        stage.show();

    }
}


