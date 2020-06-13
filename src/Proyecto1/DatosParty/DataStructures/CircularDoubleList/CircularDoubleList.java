package Proyecto1.DatosParty.DataStructures.CircularDoubleList;

import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.Nodes.DoubleNode;

/**
 * Circular doubly linked list
 *
 * @param <T> value type of the content of the nodes
 */
public class CircularDoubleList<T> implements MotherList<T> {
    private DoubleNode<T> head = null;
    private int extension;

    private int getExtension() {
        return this.extension;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public FatherNode<T> getHead() {
        return this.head;
    }

    @Override
    public FatherNode<T> getTail() {

        return null;
    }


    public void insertLast(T data) {
        DoubleNode<T> node = new DoubleNode(data);
        if (isEmpty()) {
            this.head = node;
            node.setNext(this.head);
            node.setPrev(this.head);
            this.extension++;
        } else {
            DoubleNode<T> temp = this.head;
            DoubleNode<T> tempnext = temp.getNext();
            while (tempnext != this.head) {
                temp = temp.getNext();
                tempnext = tempnext.getNext();
            }
            temp.setNext(node);
            node.setPrev(temp);
            node.setNext(this.head);
            this.head.setPrev(node);
            this.extension++;
        }
    }

    public T accessNode(int index) throws IllegalArgumentException {
        if (index < 0 || index >= this.extension) {
            throw new IllegalArgumentException("Index out of range, given: " + index + " max: " + (this.len() - 1));
        } else {
            DoubleNode<T> temp = this.head;
            while (index != 0) {
                temp = temp.getNext();
                index--;
            }
            return temp.getData();
        }
    }

    @Override
    public int len() {
        return this.extension;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[ ");
        stringBuilder.append(this.head.getData().toString());
        stringBuilder.append(", ");
        DoubleNode<T> temp = this.head.getPrev();
        while (temp != this.head) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getPrev();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
