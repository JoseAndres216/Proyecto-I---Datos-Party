package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;

public class Phase {

    public MotherList<Box> phaseList;
    public int exitPoint;

    public MotherList<Box> getPhaseList() {
        return phaseList;
    }

    public int getExitPoint() {
        return exitPoint;
    }
    public void config(MotherList<Box> list, int exitPoint){
        this.phaseList = list;
        this.exitPoint = exitPoint;
    }

}

