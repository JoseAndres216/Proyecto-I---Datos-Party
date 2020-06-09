package Proyecto1.DatosParty.Minigames;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Events.Event;
import Proyecto1.DatosParty.Player;

public  abstract class Minigame extends Event {
    @Override
    public void interact(SimpleLinkedList<Player> players) {

    }

    public abstract void play(SimpleLinkedList<Player> players);

}
