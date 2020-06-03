package Proyecto1.DatosParty;


import Proyecto1.DatosParty.Boxes.*;
import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;
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
    private static Table instance = null;
    //Intialization of the Phases, (the main table will not be a phase)
    public Phase phaseA = new Phase(new SimpleLinkedList<Box>(),false);
    public Phase phaseB = new Phase(new SimpleLinkedList<Box>(),false);
    public Phase phaseC = new Phase(new DoubleLinkedList<Box>(),false);
    public Phase phaseD = new Phase(new CircularDoubleList<Box>(),true);
    //Intialization of the main table.
    public Phase mainPhase = new Phase(new SimpleCircularList(),true);
    private Table(){
        this.generateTable();
    }

    public static synchronized Table getInstance(){

        if(instance == null){
            instance = new Table();
        }
        return instance;
    }

    public Phase getPhaseA() {
        return phaseA;
    }

    public Phase getPhaseB() {
        return phaseB;
    }

    public Phase getPhaseC() {
        return phaseC;
    }

    public Phase getPhaseD() {
        return phaseD;
    }

    public Phase getMainPhase() {
        return mainPhase;
    }

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
        //Setting the phases with the lists
        this.phaseA.config(3,3,1,  3,  7);//exit point esta basado en el modelo del excel
        this.phaseB.config(0,0,10, 0,  16);//exit point esta basado en el modelo del excel
        this.phaseC.config(3,3,3,  1,  25);//exit point esta basado en el modelo del excel
        this.phaseD.config(0,0,12, 0,  -1);//exit point es -1 porque la fase D no esta conectada de ninguna forma

    }

    /**
     * @param canvas canvas for drawing the boxes
     */
    public void drawPhase(Canvas canvas) {
        int x = 420, y = 180;
        this.mainPhase.getPhaselist().getHead().getData().draw(x, y, canvas);
        FatherNode<Box> node = this.mainPhase.getPhaselist().getHead().getNext();
        for (int i = 1; i <= 35; i++) {
            if (i <= 9) {
                x += 36;
                node.getData().draw(x, y, canvas);
            } else if (i > 9 && i <= 18) {
                y += 36;
                node.getData().draw(x, y, canvas);
            } else if (i > 18 && i <= 27) {
                x -= 36;
                node.getData().draw(x, y, canvas);
            } else if (i > 27 && i <= 36) {
                y -= 36;
                node.getData().draw(x, y, canvas);
            }
        }
    }
}


