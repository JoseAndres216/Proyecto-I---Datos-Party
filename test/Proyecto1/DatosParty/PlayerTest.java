package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void OnlyOnePossible() throws Exception {

        Player StuntMan = new Player(1, "StuntMan");
        Game.getInstance().addPlayer(StuntMan);
        StuntMan.MoveTo(Table.getInstance().phaseC, 5);
        SimpleLinkedList<Box> got = StuntMan.calcPossibleMoves(1);
        System.out.println(got);


    }

}
