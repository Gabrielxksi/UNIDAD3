package PilaEstatica;

import EntradaYSalida.tools;

public class PilaA <T> implements PilaTDA <T> {
    private T pila [];
    private byte tope;
    
    public PilaA (int max){
        pila =(T[])(new Object[max]);
        tope=-1;
    }
    
    @Override
    public boolean isemptyPila(){
        return (tope==-1);
    }
    
    public boolean isSpace(){
        return (tope<pila.length-1);
    }
    
    @Override
    public void pushPila(T dato){
        if (isSpace()){
            tope++;
            pila[tope]=dato;
        }
        else
            tools.errorMsj("PILA LLENA!!!!!");
    }
    
    @Override
    public T popPILA (){
        T dato = pila [tope];
        tope--;
        return dato;
    }
    
    @Override
    public T peekpila(){
        return pila [tope];
    }
    
    @Override
    public String toString(){
        return toString(tope);
    }
    
    private String toString(int i){
        return(i>=0)?"tope===>"+ i + "["+ pila [i]+ "]\n" + toString (i-1):"";
    }
}
