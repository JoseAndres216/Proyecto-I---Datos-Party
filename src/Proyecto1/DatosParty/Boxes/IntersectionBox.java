package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.Phase;

public class IntersectionBox extends Box{

    public Phase phase;


    public IntersectionBox(Phase phase){
        this.phase = phase;
        this.isIntersection = true;

    }

    public MotherList<Box> getList(){
        return this.phase.phaseList;
    }

    public Phase getPhase(){
        return this.phase;
    }
}
