package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;

//import Proyecto1.DatosParty.Minigames.Minigame;
//import Proyecto1.DatosParty.Minigames.RockPaperScissors;

//import Proyecto1.DatosParty.GUI.Windows.Minigames.RockPaperScissors;

public class Duel extends Event {

    public Duel(){
        this.tag = "PvP";
    }

    @Override
    public void interact(Player player) {
        Game.getInstance().getEventDisplay().setText(new StringBuilder().append(player.nickname).append(" and ").append(Game.getRandomPlayer(player).nickname).append(" are on a 1v1 match.").toString());

    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}

