package Proyecto1.DatosParty.DataStructures.SimpleCircularList;

import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.Nodes.SimpleNode;

/**
 * Simply linked list
 *
 * @param <T> data type for the content of the node
 */
public class SimpleCircularList<T> implements MotherList<T> {

    private SimpleNode<T> head = null;
    private int extension;

    private int getExtension() {
        return this.extension;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public FatherNode<T> getTail() {

        return null;
    }

    public void insertLast(T data) {
        SimpleNode<T> simpleNode = new SimpleNode(data);
        if (isEmpty()) {
            this.head = simpleNode;
            simpleNode.setNext(this.head);
            this.extension++;
        } else {
            SimpleNode<T> temp = this.head;
            while (temp.getNext() != this.head) {
                temp = temp.getNext();
            }
            temp.setNext(simpleNode);
            simpleNode.setNext(this.head);
            this.extension++;
        }
    }

    public void insertSpecialNode(FatherNode newNode) {

    }

    @Override
    public T accessNode(int i) {
        if (i < 0 || i > this.extension) {
            throw new IllegalArgumentException("Index out of range, index given: " + i + "elements: " + this.extension);
        }


            SimpleNode<T> temp = this.head;
            int counter = 0;
            while (counter != i) {
                temp = temp.getNext();
                counter++;
            }
            return temp.getData();
        }

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
        SimpleNode<T> temp = this.head.getNext();
        while (temp != this.head) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public FatherNode<T> getHead() {
        return this.head;
    }

}

