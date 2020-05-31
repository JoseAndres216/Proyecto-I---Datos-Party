package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;

public class Phase {

    public MotherList<Box> phaseList;
    public int exitPoint;

    public Phase(MotherList<Box> phaseList, int exitPoint) {
        this.phaseList = phaseList;
        this.exitPoint = exitPoint;
    }

    public MotherList<Box> getPhaseList() {
        return phaseList;
    }

    public void setPhaseList(MotherList<Box> phaseList) {
        this.phaseList = phaseList;
    }

    public int getExitPoint() {
        return exitPoint;
    }

    public void setExitPoint(int exitPoint) {
        this.exitPoint = exitPoint;
    }
}

