package Proyecto1.DatosParty.DataStructures.Nodes;

import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;

public class JointNode<T> implements FatherNode<T> {
    private FatherNode nextTable;
    private T data;

    public JointNode(T data) {
        this.data = data;
    }

    public FatherNode getNextTable() {
        return nextTable;
    }

    public void setNextTable(FatherNode nextTable) {
        this.nextTable = nextTable;
    }

    @Override
    public void setData(T newData) {

    }

    @Override
    public void setNext(FatherNode next) {

    }

    @Override
    public T getData() {
        return null;
    }

    @Override
    public FatherNode<T> getNext() {
        return this.nextTable;
    }
}
