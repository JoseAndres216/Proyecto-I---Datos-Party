package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;

/**
 * Class that implements the Earn 2 - 5 stars, and the Lose 1 stars
 * events.
 */
public class EarnStars extends Event {
    private final int amount;


    /**
     * Constructor of class
     *
     * @param amount amount of stars to win
     */
    public EarnStars(int amount) {
        this.amount = amount; //can be 2 or 5 or 1 if its lose 1 star.
        this.tag = "Earn " + amount + " stars.";
    }


    @Override
    public void interact(Player player) {
        player.modifyStars(true, this.amount);
        String message = player.nickname + " earned " + amount + " stars.";
        Game.getInstance().getEventDisplay().setText(message);


    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
