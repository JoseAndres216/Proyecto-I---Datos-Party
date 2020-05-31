package Proyecto1.DatosParty.DataStructures.CircularDoubleList;

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


    public int searchPosition(T data) {
        DoubleNode<T> temp = this.head;
        int position = 1;
        if (temp.getData().equals(data)) {
            return position;
        } else {
            temp = temp.getNext();
            position++;
        }
        while (temp != this.head) {
            if (temp.getData().equals(data)) {
                return position;
            } else {
                temp = temp.getNext();
                position++;
            }
        }
        return -1;
    }

    public void deleteFirstnode() {
        DoubleNode<T> temp = this.head;
        while (temp.getNext() != this.head) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        this.head = temp.getNext();
        this.head.setPrev(temp);

    }

    public void deleteLastNode() {
        DoubleNode<T> temp = this.head;
        while (temp.getNext().getNext() != this.head) {
            temp = temp.getNext();
        }
        temp.setNext(this.head);
        this.head.setPrev(temp);
    }

    public T accessNode(int index) {
        if (index < 0 || index >= this.extension) {
            System.out.println("Node out of range.");
            return null;
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


    public String print() {
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
