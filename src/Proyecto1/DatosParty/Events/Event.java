package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.DataStructures.Stack.Stack;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public abstract class Event implements Comparable<Event> {

    public abstract void interact(SimpleLinkedList<Player> players) throws IOException;

    private final Event instance = null;
    private final Stack<Event> events = new Stack<>();
    //Configuration of events
    private final int duelEvent = 10;
    private final int stealCoins = 10;
    private final int giftCoins = 5;
    private final int lose1star = 4;
    private final int earnTwoStars = 3;
    private final int earnFiveStars = 1;
    private final int teleportEvent = 10;
    private final int swapPlaces = 5;

    public Event() {
        this.generateEventStack();
    }

    private void generateEventStack() {

    }
}
