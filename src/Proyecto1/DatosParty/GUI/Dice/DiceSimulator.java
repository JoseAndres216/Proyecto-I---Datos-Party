package Proyecto1.DatosParty.GUI.Dice;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class DiceSimulator extends Application {
    private ImageView viewDie1 = new ImageView();
    private ImageView viewDie2 = new ImageView();
    private Label resultDie;
    private Label message1;
    private Label message2;

    public static void main(String[] args){
        launch (args);
    }
    public void start (Stage secondaryStage){
        secondaryStage.setTitle("Let it Roll!");
        Label message1 = new Label ("Please hit start to roll the dice!");
        secondaryStage.show();

    }
}
