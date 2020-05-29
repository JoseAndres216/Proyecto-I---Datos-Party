package Proyecto1.DatosParty.DataStructures.BaseModels;

public abstract interface FatherNode<T> {

    public void setData(T newData);

    public void setNext(FatherNode next);

    public T getData();

    public FatherNode<T> getNext();

}
