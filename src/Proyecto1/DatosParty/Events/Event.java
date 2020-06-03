package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.DataStructures.Stack.Stack;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public abstract class Event implements Comparable<Event> {

    public abstract void interact(SimpleLinkedList<Player> players) throws IOException;

    private Event instance = null;
    private Stack<Event> events = new Stack<>();
    //Configuration of events
    private int duelEvent = 10;
    private int stealCoins = 10;
    private int giftCoins = 5;
    private int loseAstar = 4;
    private int earnTwoStars = 3;
    private int earnFiveStars = 1;
    private int teleportEvent = 10;
    private int swapPlaces = 5;

    public Event() {
        this.generateEventStack();
    }

    private void generateEventStack() {

    }
}
