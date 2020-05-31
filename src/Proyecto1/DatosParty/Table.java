package Proyecto1.DatosParty;


import Proyecto1.DatosParty.Boxes.*;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.CircularDoubleList.CircularDoubleList;
import Proyecto1.DatosParty.DataStructures.DoubleLinkedList.DoubleLinkedList;
import Proyecto1.DatosParty.DataStructures.SimpleCircularList.SimpleCircularList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import javafx.scene.canvas.Canvas;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class Table
 */
public class Table {
    //Intialization of the Phases, (the main table will not be a phase)
    public Phase phaseA = new Phase(new SimpleLinkedList<Box>(),false);
    public Phase phaseB = new Phase(new SimpleLinkedList<Box>(),false);
    public Phase phaseC = new Phase(new DoubleLinkedList<Box>(),false);
    private Phase phaseD = new Phase(new CircularDoubleList<Box>(),false);

    public Phase mainPhase = new Phase(new SimpleCircularList(),true);
    //Creating the main table


    /**
     * Method for generating a random box, for creating the main table.
     *
     * @return
     */
    public Box getRandomBox(int counterCasillasPrincipal) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        Box randomBox;
        switch (randomNum) {
            case 0:
                randomBox = new GreenBox(counterCasillasPrincipal);
                break;
            case 1:
                randomBox = new YellowBox(counterCasillasPrincipal);
                break;
            case 2:
                randomBox = new RedBox(counterCasillasPrincipal);
                break;
            case 3:
                randomBox = new WhiteBox(counterCasillasPrincipal);
                break;
            default:
                System.out.println("Algo paso al generar la casilla, el random era: " + randomNum);
                randomBox = new WhiteBox(counterCasillasPrincipal);
        }
        return randomBox;
    }

    //Method for puttin together the phases and the main table.
    public void generateTable() {
        //Setting the phases with the lists
        this.phaseA.config(3,3,1,  3,  7);//exit point esta basado en el modelo del excel
        this.phaseB.config(0,0,10, 0,  16);//exit point esta basado en el modelo del excel
        this.phaseC.config(3,3,3,  1,  25);//exit point esta basado en el modelo del excel
        this.phaseD.config(0,0,12, 0,  -1);//exit point es -1 porque la fase D no esta conectada de ninguna forma

        //Generate the main table, made of 36 boxes with intersections that connect phases
        //and random generated boxes on the other parts of the table.
        for (int i = 0; i < 36; i++) {
            int counterCasillasPrincipal = 0;
            switch (i) {
                case 2:
                    this.mainPhase.phaseList.insertLast(new IntersectionBox(phaseA,counterCasillasPrincipal));
                     break;

                case 11:
                    this.mainPhase.phaseList.insertLast(new IntersectionBox(phaseB,counterCasillasPrincipal));
                      break;

                case 20:
                    this.mainPhase.phaseList.insertLast(new IntersectionBox(phaseC,counterCasillasPrincipal));
                      break;


                default:
                    this.mainPhase.phaseList.insertLast(this.getRandomBox(counterCasillasPrincipal));
                     break;
            }
            counterCasillasPrincipal++;
        }
    }

    /**
     * @param canvas canvas for drawing the boxes
     */
    public void drawPhase(Canvas canvas, MotherList list) {

    }
}


