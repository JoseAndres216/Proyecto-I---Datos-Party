package Proyecto1.DatosParty.DataStructures.BaseModels;

/**
 * Base model for the node of the lists, allows to make polymorphism in the different lists and different methods.
 * @param <T> Generic data type for storing inside the node.
 */
public interface FatherNode<T> {

    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //

    /*
     * Setters and getters of the class
     */
    void setData(T newData);

    void setNext(FatherNode next);

    T getData();

    FatherNode<T> getNext();

}
