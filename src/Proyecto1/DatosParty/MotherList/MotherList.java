package Proyecto1.DatosParty.MotherList;

public interface MotherList<T>{
    public boolean isEmpty();
    public void insertFirst(T data);
    public void insertLast(T data);
    public T index(int i);
}
