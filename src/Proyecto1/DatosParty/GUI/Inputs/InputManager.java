package Proyecto1.DatosParty.GUI.Inputs;


import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import Proyecto1.DatosParty.Table;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InputManager extends Application {
    private static InputManager instance = null;
    private int playerIndex = 0;
    private VBox root = new VBox();
    private Scene scene = new Scene(root);

    private InputManager() {

    }

    public static synchronized InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
        }
        return instance;
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Set the Size of the VBox
        root.setMinSize(350, 250);
        // Set the Properties of the Stage
        stage.setX(100);
        stage.setY(200);
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        SimpleLinkedList<Player> players = Game.getInstance().getPlayers();

        this.rollDicesView();
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("SOS quiero mimir");
        // Display the Stage
        stage.show();


    }

    public void rollDicesView() throws Exception {
        Table.getInstance().drawTable();
        Table.getInstance().drawTable();
        Table.getInstance().drawPlayers();
        this.getNextIndex();
        Player player = Game.getInstance().getPlayers().accessNode(playerIndex);
        //Create the Text and the players name.

        Text text = new Text("Hello " + player.nickname + ", press the button to roll the dices...:)");

        Button rollDicesButton = new Button("Let it roll.");

        this.root.getChildren().addAll(text, rollDicesButton);

        rollDicesButton.setOnAction((event) -> {    // lambda expression

            try {
                this.root.getChildren().clear();
                this.selectRoadPathView(player);
            } catch (Exception e) {
                System.out.println(e);
            }

        });
        // Add the Text and the button to the VBox


    }

    public void selectRoadPathView(Player player) throws Exception {
        SimpleLinkedList<Box> list = player.RollDices();
        switch (list.len()) {
            case 1:
                Button move = new Button(list.accessNode(0).toString());
                move.setOnAction((event) -> {    // lambda expression
                    try {
                        root.getChildren().removeAll(move);
                        this.rollDicesView();

                        player.MoveTo(list.accessNode(0).getExcelId());
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                });
                root.getChildren().add(move);
                break;
            case 2:
                Button m1 = new Button(list.accessNode(0).toString());
                Button m2 = new Button(list.accessNode(1).toString());

                m1.setOnAction((event) -> {    // lambda expression
                    try {
                        player.MoveTo(list.accessNode(0).getExcelId());
                        root.getChildren().removeAll(m1, m2);
                        this.rollDicesView();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                });
                m2.setOnAction((event) -> {    // lambda expression
                    try {
                        player.MoveTo(list.accessNode(1).getExcelId());
                        root.getChildren().removeAll(m1, m2);
                        this.rollDicesView();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                });
                root.getChildren().add(m1);
                root.getChildren().add(m2);
                break;
            case 3:
                Button m21 = new Button(list.accessNode(0).toString());
                Button m22 = new Button(list.accessNode(1).toString());
                Button m23 = new Button(list.accessNode(2).toString());

                m21.setOnAction((event) -> {    // lambda expression
                    try {
                        player.MoveTo(list.accessNode(0).getExcelId());
                        root.getChildren().removeAll(m21, m22, m23);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                });
                m22.setOnAction((event) -> {    // lambda expression
                    try {
                        player.MoveTo(list.accessNode(1).getExcelId());
                        root.getChildren().removeAll(m21, m22, m23);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                });
                m23.setOnAction((event) -> {    // lambda expression
                    try {
                        player.MoveTo(list.accessNode(2).getExcelId());
                        root.getChildren().removeAll(m21, m22, m23);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                });

                root.getChildren().add(m21);
                root.getChildren().add(m22);
                break;
            case 0:
                System.out.println("The list is 0 len");
                break;
            default:
                throw new IllegalArgumentException("The possibles are more than 3.");
        }
    }

    public void getNextIndex() {
        if ((this.playerIndex + 1) < Game.getInstance().getPlayers().len()) {
            playerIndex++;
        } else {
            playerIndex = 0;
        }

    }

}


