package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

//import Proyecto1.DatosParty.GUI.Windows.Minigames.RockPaperScissors;

public class Duel extends Event {
    @Override
    public void interact(SimpleLinkedList<Player> players) throws IOException {
        if (players.len() != 2) {
            throw new IOException("There must be only two players for a PvP");
        }
        //Minigame duel = new RockPaperScissors();
        //duel.interact(players);
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
