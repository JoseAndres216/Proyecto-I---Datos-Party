package Proyecto1.DatosParty.GUI.Inputs;


import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InputManager extends Application {
    private VBox root = new VBox();
    private Scene scene = new Scene(root);

    private static InputManager instance = null;

    private InputManager(){

    }
    public static synchronized InputManager getInstance(){
        if(instance == null){
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
        System.out.println(players);
        this.rollDicesView(Game.getInstance().getPlayers().accessNode(0));
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("SOS quiero mimir");
        // Display the Stage
        stage.show();


    }

    public void rollDicesView(Player player ){

      //Create the Text and the players name.
        Text text = new Text("Hello "+player.nickname+", press the button to roll the dices...:)");
        Button rollDicesButton = new Button("Let it roll.");
        rollDicesButton.setOnAction((event) -> {    // lambda expression
            this.root.getChildren().remove(rollDicesButton);
            try {
                this.selectRoadPathView(player);
            } catch (Exception e) {
                System.out.println(e);
            }

        });
        // Add the Text and the button to the VBox
        root.getChildren().addAll(text, rollDicesButton);
    }
    public void selectRoadPathView(Player player) throws Exception {
        SimpleLinkedList<Box> list = player.RollDices();
        System.out.println(list);
        switch (list.len()){
            case 1:
                Button move = new Button(list.accessNode(0).toString());
                root.getChildren().add(move);
                break;
            case 2:
                Button move1 = new Button(list.accessNode(0).toString());
                Button move2 = new Button(list.accessNode(1).toString());

                move1.setOnAction((event) -> {    // lambda expression
                    try {
                        player.MoveTo(list.accessNode(0).getExcelId());
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                });
                move2.setOnAction((event) -> {    // lambda expression
                    try {
                        player.MoveTo(list.accessNode(1).getExcelId());
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                });
                root.getChildren().add(move1);
                root.getChildren().add(move2);
                break;
            case 3:
                Button move3 = new Button(list.accessNode(2).toString());
                root.getChildren().add(move3);
                break;
            case 0 :
                System.out.println("The list is 0 len");
                break;
            default:
                throw new IllegalArgumentException("The possibles are more than 3.");
        }
    }
}


