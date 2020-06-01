package Proyecto1.DatosParty.DataStructures.BaseModels;

/**
 * Base model for the implementation of the lists
 *
 * @param <T>
 */
public interface MotherList<T> {
    boolean isEmpty();
    FatherNode<T> getTail();
    void insertLast(T data);

    T accessNode(int i) throws Exception;

    int len();


}


