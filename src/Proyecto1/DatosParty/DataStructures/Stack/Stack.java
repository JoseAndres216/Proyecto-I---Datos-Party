package Proyecto1.DatosParty.DataStructures.Stack;

import Proyecto1.DatosParty.DataStructures.Nodes.SimpleNode;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;

public class Stack<T extends Comparable<T>>{
    private SimpleLinkedList<T> List = new SimpleLinkedList<>();

    public void push(T data){
            List.insertLast(data);
            }

    public void pop(){
            List.deleteLastnode();
            }

    public T peek(){
            SimpleNode temp = List.getHead();
            while(temp.getNext()!=null){
            temp=temp.getNext();
            }
            pop();
            return (T) temp.getData();
            }

    public void printStack(){
            List.toString();
    }
}
