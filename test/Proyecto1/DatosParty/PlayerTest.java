package Proyecto1.DatosParty;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void OnlyOnePossible() throws Exception {
        Player StuntMan = new Player(1,"StuntMan");
        SimpleLinkedList got = StuntMan.calcPossibleMoves(12);
        System.out.println(Table.getInstance().mainPhase.phaseList);
        System.out.println(got);


    }
}
