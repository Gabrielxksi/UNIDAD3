package EstruCola;

import EntradaYSalida.tools;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ColaB <T> implements ColaTDA<T> {
    private Queue cola;
    public ColaB(){
        cola=new LinkedList();
    }
    public int Size(){
        return cola.size();
    }
    
    @Override
    public boolean isEmptyCola(){
        return (cola.isEmpty());
    }
    
    @Override
    public T peekCola(){
        return (T)(cola.element());
    }
    public void vaciar(){
        cola.clear();
    }
    
    @Override
    public void pushCola(T dato){
        cola.add(dato);
    }
    
    @Override
    public T popCola(){
        T dato;
        dato=(T)cola.element();
        cola.remove();
        return dato;
    }
    
    @Override
    public String toString(){
        String cad="";
        byte j=0;
        for (Iterator i = cola.iterator(); i.hasNext();) {
            cad+="["+  j+ "] =====>  ["+ i.next()+ "]"+ "\n";
            j++;
        }
        return cad;
    }
    
     public static void Menu(){
        ColaB cola= new ColaB();
        String dato,op;
        do{
            op=tools.boton("PUSH,POP,PEEK,FREE,SALIR");
            switch(op){
                case "PUSH": 
                    cola.pushCola(tools.leeString("escribe el dato que deseas agregar: "));
                    tools.imprime("datos de la pila: \n" + cola.toString());
                        break;
                case "POP":
                    if (cola.isEmptyCola())tools.errorMsj("pila Vacia");
                    else 
                        tools.imprime("dato eliminado de la sima de la pila: " + cola.popCola()+ "\n"+ cola.toString());
                        break; 
                case "PEEK":
                    if (cola.isEmptyCola())tools.errorMsj("pila vacia");
                    else 
                        tools.imprime("dato de la cima de la pila: ==>" + cola.peekCola()+ "\n"+ cola.toString());
                        break;
                case  "FREE":
                    if (cola.isEmptyCola())tools.errorMsj("pila vacia");
                    else
                    {
                        cola=null;
                        cola = new ColaB();
                    }
                    break;
            }
            
        }
        while(!op.equals("SALIR"));
    }
       public static void main(String[] args) {
        Menu();
    }
}
