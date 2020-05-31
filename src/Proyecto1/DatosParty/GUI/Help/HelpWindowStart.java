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
     *
     * @param stage
     * @throws Exception IO exception from the FXML loader
     */
    private static HelpWindowStart instance = null;

    private HelpWindowStart() {

    }

    public void setOpen(boolean open) {

        this.open = open;
    }

    private boolean open;

    public static synchronized HelpWindowStart getInstance() {
        if (instance == null) {
            instance = new HelpWindowStart();

        }
        return instance;
    }

    public void start(Stage stage) throws Exception {
        if (this.open) {
            return;
        }
        this.open = true;
        Parent root = FXMLLoader.load(getClass().getResource("HelpWindow.fxml"));
        stage.setAlwaysOnTop(true);
        stage.setTitle("Help!");
        stage.setScene(new Scene(root, 800, 600));
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        stage.show();

    }

}
