package Proyecto1.DatosParty.MotherList;

public interface MotherList<T> {
    boolean isEmpty();

    void insertLast(T data);

    T accessNode(int i);

    int len();

}


