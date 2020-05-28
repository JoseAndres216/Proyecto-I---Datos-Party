package Proyecto1.DatosParty.GUI.Help;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.IOException;


public class HelpWindowController {
    Image help = new Image("file: src/Proyecto1/DatosParty/GUI/Resources/images/helpLogo.jpeg");
    @FXML
    private Button exitButton;

    @FXML
    private ImageView helpLogo;

    @FXML
    private ImageView daRulesLogo;

    @FXML
    private ImageView keyboardLogo;

    public HelpWindowController() throws IOException {
    }


    public void pressedExitButton(Event event) {
        System.out.println("Pressed exit button" + exitButton.getId());
        helpLogo.setImage(help);
        //Codigo para cerrar la ventana
    }
}
