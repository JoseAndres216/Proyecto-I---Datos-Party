package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class Main extends Application {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) throws Exception {
        launch(args);
        Table tablero = Table.getInstance();
        MotherList<Box> listaP = tablero.mainPhase.phaseList;

    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("\\GUI\\MainMenu\\MainMenu.fxml"));
        stage.setAlwaysOnTop(false);
        stage.setTitle("Datos Party!");
        stage.setScene(new Scene(root));
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setFullScreen(false);
        stage.show();

    }
}


