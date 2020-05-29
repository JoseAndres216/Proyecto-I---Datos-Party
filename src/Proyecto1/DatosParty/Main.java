package Proyecto1.DatosParty;

import Proyecto1.DatosParty.DoubleLinkedList.DoubleLinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.IIOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("\\GUI\\MainMenu\\MainMenu.fxml"));
        stage.setAlwaysOnTop(true);
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(root));
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setFullScreen(true);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


