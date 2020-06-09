package Proyecto1.DatosParty.DataStructures.BaseModels;

public interface FatherNode<T> {

    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //

    /**
     * Setters and getters of the class
     */
    void setData(T newData);

    void setNext(FatherNode next);

    T getData();

    FatherNode<T> getNext();

}
