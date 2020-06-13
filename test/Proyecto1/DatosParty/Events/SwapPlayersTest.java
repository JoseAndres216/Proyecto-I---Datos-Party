package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import org.junit.Test;

public class SwapPlayersTest {

    @Test
    public void interact() throws Exception {
        Player stuntMan1 = new Player(1, "stunt man 1");
        Player stuntMan2 = new Player(2, "stunt man 2");

        Game.getInstance().addPlayer(stuntMan1);
        Game.getInstance().addPlayer(stuntMan2);
        System.out.println(Game.getInstance().getPlayers());
        SwapPlayers testSwap = new SwapPlayers();

        testSwap.interact(stuntMan1);

    }
}