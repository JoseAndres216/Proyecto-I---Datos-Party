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
    //Initialization of the lists thas will be part of phases for generation.
    private SimpleLinkedList<Box> phaseAList = new SimpleLinkedList<>(), phaseBList = new SimpleLinkedList<>();
    private DoubleLinkedList<Box> phaseCList = new DoubleLinkedList<>();
    private CircularDoubleList<Box> phaseDList = new CircularDoubleList<>();

    //Intialization of the Phases, (the main table will not be a phase)
    private Phase phaseA = new Phase();
    private Phase phaseB = new Phase();
    private Phase phaseC = new Phase();
    private Phase phaseD = new Phase();
    //Creating the main table
    private SimpleCircularList<Box> tableList = new SimpleCircularList<>();
    /**
     * @param list   a list for adding the boxes
     * @param green  amount of green boxes
     * @param red    amount of red boxes
     * @param yellow amount of yellow boxes
     * @return a list with all the boxes inside, in a random order.
     */
    public void generatePhases(MotherList list, int green, int red, int yellow, int white) {
        while (green != 0 || red != 0 || yellow != 0 || white != 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 4);

            switch (randomNum) {
                case 0:
                    if (green != 0) {
                        list.insertLast(new GreenBox());
                        green--;

                    }
                    break;
                case 1:
                    if (yellow != 0) {
                        list.insertLast(new YellowBox());
                        yellow--;
                    }
                    break;
                case 2:
                    if (red != 0) {
                        list.insertLast(new RedBox());
                        red--;
                    }
                    break;
                case 3:
                    if (white != 0) {
                        list.insertLast(new WhiteBox());
                        white--;
                    }

            }

        }


    }

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
        //Fill the phases of the board with random order of boxes
        this.generatePhases(phaseAList, 3, 3, 1, 3);
        this.generatePhases(phaseBList, 0, 0, 10, 0);
        this.generatePhases(phaseCList, 3, 3, 3, 1);
        this.generatePhases(phaseDList, 0, 0, 12, 0);

        //Setting the phases with the lists
        this.phaseA.config(this.phaseAList, 7);//exit point esta basado en el modelo del excel
        this.phaseA.config(this.phaseBList, 7);//exit point esta basado en el modelo del excel
        this.phaseA.config(this.phaseCList, 7);//exit point esta basado en el modelo del excel
        this.phaseA.config(this.phaseDList, -1);//exit point es -1 porque la fase D no esta conectada de ninguna forma

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


        System.out.println(this.tableList);
    }

    /**
     * @param canvas canvas for drawing the boxes
     */
    public void drawPhase(Canvas canvas, MotherList list) {

    }
}


