package Proyecto1.DatosParty.GUI.Inputs;


import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import Proyecto1.DatosParty.Table;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class IOManager extends Application {
    private static IOManager instance = null;
    private int playerIndex = 0;
    private VBox root = new VBox();
    private Scene scene = new Scene(root);
    private boolean started = false;

    private int size = 20;
    private String family = "Tw Cen MT Condensed Extra Bold";
    private Font font = Font.font(family, size);

    private Label eventDisplay;

    private IOManager() {

    }

    public static synchronized IOManager getInstance() {
        if (instance == null) {
            instance = new IOManager();
        }
        return instance;
    }

    public void close() {
        Stage stage = (Stage) (this.root.getScene().getWindow());
        stage.close();
    }

    public boolean isStarted() {
        return this.started;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.started = true;

        // Set the Size of the VBox
        root.setMinSize(150, 200);
        root.setMaxSize(150, 200);
        root.setBackground(new Background(new BackgroundFill(Color.valueOf("#3aa5ab"), CornerRadii.EMPTY, Insets.EMPTY)));
        // Set the Properties of the Stage
        stage.setX(370);
        stage.setY(200 + 20);
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        root.setSpacing(10);
        root.setAlignment(Pos.BASELINE_CENTER);
        eventDisplay = Game.getInstance().getEventDisplay();
        this.rollDicesView();
        // Add the scene to the Stage
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        // Display the Stage
        stage.show();


    }

    public void rollDicesView() throws Exception {
        Table.getInstance().drawTable();
        Table.getInstance().drawPlayers();

        Player player = Game.getInstance().getPlayers().accessNode(playerIndex);
        //Create the Text and the players name.

        Text text = new Text("PLAYING: " + player.nickname.toUpperCase());
        text.setFill(Color.WHITE);

        text.setFont(font);
        text.setTextAlignment(TextAlignment.CENTER);
        Button rollDicesButton = new Button("ROLL DICES");

        rollDicesButton.setFont(font);
        ImageView image = new ImageView(player.getAvatar());
        this.root.getChildren().addAll(text, image, rollDicesButton);

        rollDicesButton.setOnAction((event) -> {    // lambda expression

            try {
                this.root.getChildren().remove(rollDicesButton);
                this.selectBoxView(player);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        // Add the Text and the button to the VBox


    }

    public void selectBoxView(Player player) throws Exception {
        SimpleLinkedList<Box> list = player.RollDices();
        Table.getInstance().drawTable();
        Table.getInstance().drawPlayers();
        System.out.println(list);
        switch (list.len()) {

            case 1:

                Button move = new Button(new StringBuilder().append(list.accessNode(0).getExcelId()).toString());
                move.setFont(font);
                move.setOnAction((event) -> {    // lambda expression
                    try {
                        root.getChildren().clear();
                        this.eventDisplay.setText(String.format("%s moves %dspaces and%s", player.nickname, list.len(), list.accessNode(0).getMessage(player)));

                        player.MoveTo(list.accessNode(0).getExcelId());
                        this.getNextIndex();
                        this.rollDicesView();

                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }

                });
                root.getChildren().add(move);
                break;
            case 2:
                Button m1 = new Button(new StringBuilder().append(list.accessNode(0).getExcelId()).toString());
                Button m2 = new Button(new StringBuilder().append(list.accessNode(1).getExcelId()).toString());
                m1.setFont(font);
                m2.setFont(font);
                m1.setOnAction((event) -> {    // lambda expression
                    try {
                        this.eventDisplay.setText(player.nickname + list.accessNode(0).getMessage(player));
                        player.MoveTo(list.accessNode(0).getExcelId());
                        root.getChildren().clear();
                        this.getNextIndex();
                        this.rollDicesView();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }

                });
                m2.setOnAction((event) -> {    // lambda expression
                    try {
                        this.eventDisplay.setText(player.nickname + list.accessNode(1).getMessage(player));
                        player.MoveTo(list.accessNode(1).getExcelId());
                        root.getChildren().removeAll(m1, m2);
                        root.getChildren().clear();
                        this.getNextIndex();
                        this.rollDicesView();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }

                });
                root.getChildren().add(m1);
                root.getChildren().add(m2);
                break;
            case 0:
                throw new IllegalArgumentException("Empty possible moves");
            default:
                throw new IllegalArgumentException("The possibles are more than 2.");
        }
    }

    public void getNextIndex() throws Throwable {
        if ((this.playerIndex + 1) < Game.getInstance().getPlayers().len()) {
            playerIndex++;
        } else {
            playerIndex = 0;
            Game.getInstance().nextRound();
        }

    }

}


