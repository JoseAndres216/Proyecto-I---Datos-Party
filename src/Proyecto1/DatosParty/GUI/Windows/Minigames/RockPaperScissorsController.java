package Proyecto1.DatosParty.GUI.Windows.Minigames;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Events.Event;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public class RockPaperScissorsController extends Minigame {
    @Override
    public void play(SimpleLinkedList<Player> players) throws IOException {
        System.out.println(players.accessNode(0) + " and " + players.accessNode(1) + "\n" +
                "are playing Rock Paper Scissors");
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }

    @Override
    public void interact(Player player) {

    }
}
