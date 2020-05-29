package Proyecto1.DatosParty.DataStructures.Nodes;

import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;

/**
 * Double node, for doubly linked and doubly linked circular list
 *
 * @param <T> generic data type for the content of node.
 */
public class DoubleNode<T> implements FatherNode<T> {

    private DoubleNode next;
    private DoubleNode prev;
    private T data;

    public DoubleNode(T data) {
        this.data = data;
    }


    public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;

    }

    @Override
    public void setData(T newData) {

    }

    @Override
    public void setNext(FatherNode next) {

    }

    public T getData() {

        return data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {

        this.next = next;
    }

    public DoubleNode getPrev() {

        return prev;
    }

    public void setPrev(DoubleNode prev) {

        this.prev = prev;

    }


}
