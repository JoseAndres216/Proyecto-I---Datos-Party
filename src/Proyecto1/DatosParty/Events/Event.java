package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.Stack.Stack;
import Proyecto1.DatosParty.Player;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Event implements Comparable<Event> {

    private static Stack<Event> events = new Stack<>();
    public String tag;

    /**
     * Event stack generator, the configuration, for how many events are added, its inside.
     *
     * @return stack with random placed events.
     */
    public static Stack<Event> getEventStack() {


        int duelEvent = 10;
        int stealCoins = 10;
        int giftCoins = 5;
        int lose1star = 4;
        int earnTwoStars = 3;
        int earnFiveStars = 1;
        int teleportEvent = 0;
        int swapPlaces = 5;
        if (events.isEmpty()) {
            while (duelEvent != 0 || stealCoins != 0 || giftCoins != 0 || lose1star != 0 || earnTwoStars != 0 || earnFiveStars != 0 || teleportEvent != 0 || swapPlaces != 0) {
                int randomInt = ThreadLocalRandom.current().nextInt(0, 8);
                switch (randomInt) {
                    case 0:
                        if (duelEvent != 0) {

                            events.push(new Duel());
                            duelEvent--;
                        }
                        break;
                    case 1:
                        if (stealCoins != 0) {

                            events.push(new StealCoins());
                            stealCoins--;
                        }
                        break;
                    case 2:
                        if (giftCoins != 0) {
                            events.push(new GiftCoins());
                            giftCoins--;
                        }
                        break;
                    case 3:
                        if (lose1star != 0) {

                            events.push(new EarnStars(1));
                            lose1star--;
                        }

                        break;
                    case 4:
                        if (earnTwoStars != 0) {


                            events.push(new EarnStars(2));
                            earnTwoStars--;
                            break;
                        }
                    case 5:
                        if (earnFiveStars != 0) {

                            events.push(new EarnStars(5));
                            earnFiveStars--;
                        }

                        break;
                    case 6:
                        if (teleportEvent != 0) {

                            events.push(new Teleport());
                            teleportEvent--;
                        }

                        break;
                    case 7:
                        if (swapPlaces != 0) {

                            events.push(new SwapPlayers());
                            swapPlaces--;
                        }

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + randomInt);
                }
            }

        }
        return events;
    }

    //Configuration of events

    public abstract void interact(Player player);

    @Override
    public String toString() {
        return "Event{" +
                "tag='" + tag + '\'' +
                '}';
    }

}

