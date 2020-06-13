package Proyecto1.DatosParty;

import Proyecto1.DatosParty.DataStructures.Nodes.SimpleNode;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void nextRoundSorter() {
        Player test1 = new Player(1,"test1");
        Player test2 = new Player(2,"test2");
        Player test3 = new Player(3,"test3");
        Player test4 = new Player(4,"test4");
        Game.getInstance().addPlayer(test1);
        Game.getInstance().addPlayer(test2);
        Game.getInstance().addPlayer(test3);
        Game.getInstance().addPlayer(test4);

        test4.modifyCoins(true, 40);
        test1.modifyCoins(true, 15);
        test3.modifyCoins(true, 3);
        test2.modifyCoins(true, 2);

        System.out.println(Game.getInstance().getPlayers());
        //sort the list
        SimpleLinkedList<Player> list = Game.getInstance().getPlayers();
        for (SimpleNode<Player> first = list.getHead(); first.getNext() != null; first = first.getNext()) {
            SimpleNode<Player> smaller = first;
            SimpleNode<Player> temp = smaller.getNext();
            while (temp != null) {
                //if(temp.getData().compareTo(smaller.getData())<0){
                if (temp.getData().getStars() > smaller.getData().getStars()) {
                    smaller = temp;
                } else if (temp.getData().getStars() == smaller.getData().getStars()) {
                    if (temp.getData().getCoins() > smaller.getData().getCoins()) {
                        smaller = temp;
                    }
                    else if (temp.getData().getCoins() == smaller.getData().getCoins()) {

                    }


                }
                temp = temp.getNext();
                list.swap(first, smaller);
            }
        }
        System.out.println(Game.getInstance().getPlayers());
    }
}