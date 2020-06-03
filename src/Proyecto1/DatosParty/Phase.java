package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.*;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;

import java.util.concurrent.ThreadLocalRandom;

public class Phase {

    public MotherList<Box> phaseList;
    public int exitPoint;
    public boolean isTable;
    public boolean isPhaseD = false;

    public Phase(MotherList list, boolean isTable) {
        this.phaseList = list;
        this.isTable = isTable;
    }

    public Box getPhaseListElement(int i) throws Exception {
        return phaseList.accessNode(i);
    }

    public MotherList<Box> getPhaselist() {
        return phaseList;
    }

    public int getExitPoint() {
        return exitPoint;
    }

    /**
     * @param greenBoxes  amount of green boxes
     * @param redBoxes    amount of red boxes
     * @param yellowBoxes amount of yellow boxes
     * @param whiteBoxes  amount of white boxes
     * @param exitPoint   zero-based index position of the mainTable list box that is the exit point fo the phase (-1) on the phase D
     */
    public void config(int greenBoxes, int redBoxes, int yellowBoxes, int whiteBoxes, int exitPoint ) {
        this.generatePhases(greenBoxes, redBoxes, yellowBoxes, whiteBoxes);
        this.exitPoint = exitPoint;

    }

    /**
     * Method for filling the phase with the amount of boxes in a random order
     *
     * @param greenBoxes  amount of green boxes
     * @param redBoxes    amount of red boxes
     * @param yellowBoxes amount of yellow boxes
     * @param whiteBoxes  amount of white boxes
     */
    public void generatePhases(int greenBoxes, int redBoxes, int yellowBoxes, int whiteBoxes) {
        while (greenBoxes != 0 || redBoxes != 0 || yellowBoxes != 0 || whiteBoxes != 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
            switch (randomNum) {
                case 0:
                    if (greenBoxes != 0) {
                        this.phaseList.insertLast(new GreenBox());
                        greenBoxes--;
                    }
                    break;
                case 1:
                    if (yellowBoxes != 0) {
                        this.phaseList.insertLast(new YellowBox());
                        yellowBoxes--;
                    }
                    break;
                case 2:
                    if (redBoxes != 0) {
                        this.phaseList.insertLast(new RedBox());
                        redBoxes--;
                    }
                    break;
                case 3:
                    if (whiteBoxes != 0) {
                        this.phaseList.insertLast(new WhiteBox());
                        whiteBoxes--;
                    }
                    break;
            }
        }
    }
}

