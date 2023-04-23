package EstruCola;

import EntradaYSalida.tools;
import java.util.ArrayList;

public class ColaC<T> implements ColaTDA<T> {
    private ArrayList cola;
    byte u;
    
    public ColaC(){
        cola= new ArrayList();
        u=0;
    }
    
    public int Size(){
        return cola.size();
    }
    
    @Override
    public boolean isEmptyCola(){
        return cola.isEmpty();
    }
    
    public void vaciar (){
        cola.clear();
    }
    
    @Override
    public void pushCola(Object dato){
        cola.add(dato);
        u++;
    }
    
    @Override
    public T popCola(){
        T dato =(T)cola.get(0);
        cola.remove(0);
        u--;
        return dato;
    }
    
    @Override
    public T peekCola(){
        return (T) cola.get(0);
    }
    
    @Override
    public String toString(){
        return toString(0);
    }
    
    private String toString(int i){
        return(i<u)?"["+ i + "] ====> ["+ cola.get(i) + "]\n" + toString (i+1):"";
    }
    
         public static void Menu(){
        ColaC cola= new ColaC();
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
                        cola = new ColaC();
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
