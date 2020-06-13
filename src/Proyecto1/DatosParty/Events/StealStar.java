package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;

public class StealStar extends Event{
    /**
     * Method to start the event
     *
     * @param starWinner list of players
      */
    @Override
    public void interact(Player starWinner) {


        Player losesStar = Game.getRandomPlayer(starWinner); //obtener jugador random de la clase Game

        starWinner.modifyStars(true, 1);
        losesStar.modifyStars(false, 1);
        Game.getInstance().getEventDisplay().setText(starWinner.nickname + " stole " + losesStar + " coins from " + losesStar.nickname);

    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
