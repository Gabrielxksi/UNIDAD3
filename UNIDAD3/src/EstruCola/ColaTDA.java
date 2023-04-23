package EstruCola;

public interface ColaTDA <T> {
    
    public boolean isEmptyCola();//registra true si la pila esta vacia.
    public void pushCola(T dato);// inserta el dato en el tope de la pila.
    public T popCola();//elimina el elemento que esta en el tope de la pila. 
    public T peekCola ();//regresa el elemento que esta en el tope, sin quitarlo.
    
}
