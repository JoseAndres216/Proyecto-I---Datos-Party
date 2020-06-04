package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

/**
 * Class that implements the Earn 2 - 5 stars, and the Lose 1 stars
 * events.
 */
public class EarnStars extends Event {
    private final int amount;
    private final boolean gain;
    public EarnStars(int amount, boolean gain) {
        this.amount = amount; //can be 2 or 5 or 1 if its lose 1 star.
        this.gain = gain;
    }


    @Override
    public void interact(SimpleLinkedList<Player> players) throws IOException {
        int i = players.len();
        int counter = 0;

        while (counter < (i)){
            players.accessNode(counter).modifyStars(this.gain, this.amount);
             counter++;
        }
    }
    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
