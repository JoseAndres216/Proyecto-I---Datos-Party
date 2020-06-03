package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

/**
 * Class that implements the Earn 2 - 5 stars, and the Lose 1 stars
 * events.
 */
public class EarnStars extends Event {
    private int amount;

    public EarnStars(int amount) {
        this.amount = amount; //can be 2 or 5 or 1 if its lose 1 star.
    }


    @Override
    public void interact(SimpleLinkedList<Player> players) throws IOException {
        int i = players.len();
        int counter = 0;

        while (counter != (i-1)){
            players.accessNode(counter).modifyStars(true, this.amount);
            System.out.println("Player "+ players.accessNode(counter).toString() +" earned: "+ this.amount + " stars.");
            counter++;

        }
    }
}
