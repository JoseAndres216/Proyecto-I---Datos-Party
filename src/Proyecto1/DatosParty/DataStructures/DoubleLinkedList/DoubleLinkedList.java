package Proyecto1.DatosParty.DataStructures.DoubleLinkedList;

import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.Nodes.DoubleNode;

/**
 * Doubly linked list
 *
 * @param <T> data type for the content of the node
 */
public class DoubleLinkedList<T> implements MotherList<T> {

    private DoubleNode<T> head, tail;
    private int len;

    public int getExtension() {
        return this.len;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public FatherNode<T> getTail() {
        return this.tail ;
    }

    public void insertFirst(T data) {
        DoubleNode newElement = new DoubleNode<T>(data);
        if (this.head == null) {
            this.head = this.tail = newElement;
            this.len++;
        } else {
            newElement.setNext(this.head);
            this.head.setPrev(newElement);
            this.head = newElement;
            this.len++;
        }
    }

    public void insertLast(T data) {
        DoubleNode newElement = new DoubleNode<T>(data);
        if (this.head == null) {
            this.head = this.tail = newElement;
            this.len++;
        } else {
            this.tail.setNext(newElement);
            newElement.setPrev(this.tail);
            this.tail = tail;
            this.len++;
        }
    }

    public T accessNode(int i) {
        if (((i) > (this.len - 1)) || i < 0) {
            return null;
        } else {
            if (i == 0) {
                return this.head.getData();
            } else if (i == (this.len - 1)) {
                return this.tail.getData();
            }
            DoubleNode<T> temp = this.head;
            int var = 0;
            while (var != i) {
                var++;
                temp = temp.getNext();
            }
            return temp.getData();
        }
    }

    @Override
    public int len() {
        return this.len;
    }

    public String print() {
        if (this.head == null) {
            return "Double list of: ";
        }
        StringBuilder stringBuilder = new StringBuilder("Double list of: ");
        DoubleNode<T> temp = this.head;
        while (temp != null) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getNext();
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    public String printReverse() {
        if (this.head == null) {
            return "Double list (reversed) of:  ";
        }
        StringBuilder stringBuilder = new StringBuilder("Double list:  ");
        DoubleNode<T> temp = this.tail;


        while (temp != null) {
            stringBuilder.append(temp.getData().toString());
            stringBuilder.append(", ");
            temp = temp.getPrev();
        }

        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

}
