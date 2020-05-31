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
    private Phase phaseA = new Phase(new SimpleLinkedList<Box>());
    private Phase phaseB = new Phase(new SimpleLinkedList<Box>());
    private Phase phaseC = new Phase(new DoubleLinkedList<Box>());
    private Phase phaseD = new Phase(new CircularDoubleList<Box>());
    //Creating the main table
    private SimpleCircularList<Box> tableList = new SimpleCircularList<>();

    /**
     * Method for generating a random box, for creating the main table.
     *
     * @return
     */
    public Box getRandomBox() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        Box randomBox;
        switch (randomNum) {
            case 0:
                randomBox = new GreenBox();
                break;
            case 1:
                randomBox = new YellowBox();
                break;
            case 2:
                randomBox = new RedBox();
                break;
            case 3:
                randomBox = new WhiteBox();
                break;
            default:
                System.out.println("Algo paso al generar la casilla, el random era: " + randomNum);
                randomBox = new WhiteBox();
        }
        return randomBox;
    }

    //Method for puttin together the phases and the main table.
    public void generateTable() {
        //Setting the phases with the lists
        this.phaseA.config(3,3,1,  3,  7);//exit point esta basado en el modelo del excel
        this.phaseB.config(0,0,10, 0,  16);//exit point esta basado en el modelo del excel
        this.phaseC.config(3,3,3,  1,  25);//exit point esta basado en el modelo del excel
        this.phaseD.config(0,0,12, 0, -1);//exit point es -1 porque la fase D no esta conectada de ninguna forma
        /*
        Flag prints, for control
         */
        System.out.println("Fase A largo: " + phaseA.phaseList.len());
        System.out.println("Fase B largo: " + phaseB.phaseList.len());
        System.out.println("Fase C largo: " + phaseC.phaseList.len());
        System.out.println("Fase D largo: " + phaseD.phaseList.len());
        //Generate the main table, made of 36 boxes with intersections that connect phases
        //and random generated boxes on the other parts of the table.
        for (int i = 0; i < 36; i++) {
            switch (i) {
                case 2:
                    this.tableList.insertLast(new IntersectionBox(phaseA));
                    break;

                case 11:
                    this.tableList.insertLast(new IntersectionBox(phaseB));
                    break;

                case 20:
                    this.tableList.insertLast(new IntersectionBox(phaseC));
                    break;


                default:
                    this.tableList.insertLast(this.getRandomBox());
                    break;
            }
        }
    }

    /**
     * @param canvas canvas for drawing the boxes
     */
    public void drawPhase(Canvas canvas, MotherList list) {

    }
}


