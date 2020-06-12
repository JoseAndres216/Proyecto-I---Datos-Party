package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public class StealStar extends Event{

    public StealStar() {
        this.tag = "Steal star";
    }

    /**
     * Method to start the event
     *
     * @param starWinner list of players
     * @throws IOException list must have 2 players
     */
    @Override
    public void interact(Player starWinner) {


        Player losesCoins = Game.getRandomPlayer(starWinner); //obtener jugador random de la clase Game

        starWinner.modifyStars(true, 1);
        losesCoins.modifyStars(false, 1);
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
