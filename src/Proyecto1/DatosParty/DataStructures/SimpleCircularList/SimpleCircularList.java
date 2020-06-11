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

    public void insertFirst(T data) {
        SimpleNode<T> simpleNode = new SimpleNode(data);
        if (isEmpty()) {
            this.head = simpleNode;
            simpleNode.setNext(this.head);
            this.extension++;
        } else {
            SimpleNode<T> temp = this.head;
            this.head = simpleNode;
            simpleNode.setNext(temp);
            this.extension++;
        }
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

    public boolean isNode(T data) {
        SimpleNode<T> temp = this.head;
        int nodesLeft = this.extension;
        while (nodesLeft != 0) {
            if (temp.getData() == data) {
                return true;
            } else {
                temp = temp.getNext();
                nodesLeft--;
            }
        }
        System.out.println("Couldn't find the node");
        return false;
    }

    public int searchPosition(T data) {
        SimpleNode<T> temp = this.head;
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

    public void editNode(int position, T newData) {
        if (position <= 0 || position > this.extension) {
            System.out.println("The node doesn't exists");
        } else {
            SimpleNode<T> temp = this.head;
            int counter = 1;
            while (counter != position) {
                temp = temp.getNext();
                counter++;
            }
            temp.setData(newData);
        }
    }

    public void editNodebyData(T previousData, T newData) {
        editNode(searchPosition(previousData), newData);
    }

    public void deleteFirstnode() {
        SimpleNode<T> temp = this.head;
        while (temp.getNext() != this.head) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        this.head = temp.getNext();

    }

    public void deleteLastnode() {
        SimpleNode<T> temp = this.head;
        while (temp.getNext().getNext() != this.head) {
            temp = temp.getNext();
        }
        temp.setNext(this.head);
    }

    public void deleteNodebyData(T data) {
        int position = searchPosition(data);
        if (position == -1) {
            System.out.println("Couldn't find the node");
        } else if (position == 1) {
            deleteFirstnode();
        } else if (position == this.extension) {
            deleteLastnode();
        } else {
            SimpleNode<T> temp = this.head;
            int counter = 1;
            while ((counter + 1) != position) {
                temp = temp.getNext();
                counter++;
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public T retrnNodedata(int index) {
        if (index < 0 || index >= this.extension) {
            System.out.println("Node out of range.");
            return null;
        } else {
            SimpleNode<T> temp = this.head;
            while (index != 0) {
                temp = temp.getNext();
                index--;
            }
            return temp.getData();
        }
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

    public void emptyList() {
        this.head = null;
        this.extension = 0;
    }
}

