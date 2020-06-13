package Proyecto1.DatosParty.DataStructures.Nodes;

import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;

/**
 * Node for the simple circular list.
 *
 * @param <T> data type for the nodes content.
 */
public class SimpleNode<T> implements FatherNode<T> {

    private SimpleNode<T> next = null;
    private T data = null;

    public SimpleNode(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void setNext(FatherNode next) {

    }

    public void setNext(SimpleNode next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public SimpleNode getNext() {
        return this.next;
    }

}
