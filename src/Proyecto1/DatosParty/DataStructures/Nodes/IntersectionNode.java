package Proyecto1.DatosParty.DataStructures.Nodes;

import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;

public class IntersectionNode<T> implements FatherNode<T> {
    private T data;
    private FatherNode nextPhase;
    private FatherNode nextTable;

    public IntersectionNode(T data) {
        this.data = data;
    }

    public FatherNode getNextTable() {
        return nextTable;
    }

    public void setNextTable(FatherNode nextTable) {
        this.nextTable = nextTable;
    }

    public FatherNode getNextPhase() {
        return nextPhase;
    }

    public void setNextPhase(FatherNode nextPhase) {
        this.nextPhase = nextPhase;
    }

    public FatherNode getNext() {
        return next;
    }

    public void setNext(FatherNode next) {
        this.next = next;
    }

    private FatherNode next;


    @Override
    public void setData(T newData) {
    }

    @Override
    public T getData() {
        return null;
    }


}
