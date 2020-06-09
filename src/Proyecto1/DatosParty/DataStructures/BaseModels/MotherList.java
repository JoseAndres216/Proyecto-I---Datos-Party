package Proyecto1.DatosParty.DataStructures.BaseModels;

/**
 * Base model for the implementation of the lists
 *
 * @param <T>
 */
public interface MotherList<T> {

    int len();

    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //

    /**
     * Setters and getters of the class
     */
    FatherNode<T> getHead();
    FatherNode<T> getTail();


    boolean isEmpty();

    void insertLast(T data);

    T accessNode(int i) throws Exception;




}


