package Proyecto1.DatosParty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class Main extends Application {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(screenWidth + "x" + screenHeight);
        Parent root = FXMLLoader.load(getClass().getResource("\\GUI\\MainMenu\\MainMenu.fxml"));
        stage.setAlwaysOnTop(false);
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(root, screenWidth, screenHeight));
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setFullScreen(false);


        stage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}


