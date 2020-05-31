package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;

public class IntersectionBox extends Box{

    public MotherList<Box> phase;

    public IntersectionBox(MotherList<Box> phase){
        this.phase = phase;
        this.isIntersection = true;
    }

    public MotherList getPhase(){
        return phase;
    }
}
