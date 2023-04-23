package PilaEstatica;
    
public interface PilaTDA <T> {
    public boolean isemptyPila();//registra true si la pila esta vacia.
    public void pushPila(T dato);// inserta el dato en el tope de la pila.
    public T popPILA();//elimina el elemento que esta en el tope de la pila. 
    public T peekpila ();//regresa el elemento que esta en el tope, sin quitarlo.
    
    
    
}
