package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.Player;

//import Proyecto1.DatosParty.Minigames.Minigame;
//import Proyecto1.DatosParty.Minigames.RockPaperScissors;

//import Proyecto1.DatosParty.GUI.Windows.Minigames.RockPaperScissors;

public class Duel extends Event {

    public Duel(){
        this.tag = "PvP";
    }
    @Override
    public String toString() {
        return "Duel{" +
                "tag='" + tag + '\'' +
                '}';
    }

    @Override
    public void interact(Player player) {
        System.out.println("PvP activado para: " + player.nickname );
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}

