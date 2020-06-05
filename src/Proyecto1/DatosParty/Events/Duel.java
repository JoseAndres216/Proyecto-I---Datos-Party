package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Minigames.Minigame;
import Proyecto1.DatosParty.Minigames.RockPaperScissors;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

/**
 Class duel, triggers a minigame for two players.
 */
public class Duel extends Event {
    public Duel() {
        this.tag = "Pvp";
    }

    /**
     * Method for starting the event
     * @param players list of two players
     * @throws IOException list must have exactly two players.
     */
    @Override
    public void interact(SimpleLinkedList<Player> players) throws IOException {
        if (players.len() != 2) {
            throw new IOException("There must be only two players for a PvP");
        }
        System.out.println("Duel started");
        Minigame duel = new RockPaperScissors();
        duel.play(players);
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
