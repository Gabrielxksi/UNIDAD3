package PDinamica;

import EntradaYSalida.tools;
import PilaEstatica.PilaTDA;
import java.util.ArrayList;


public class PilaC<T> implements PilaTDA<T> {
private ArrayList pila;
int tope;

    public PilaC(){
        pila= new ArrayList();
        tope=-1;
    }
    
    public int Size(){
        return pila.size();
    }
    
    @Override
    public boolean isemptyPila(){
        return pila.isEmpty();
    }
    
    public void vaciar (){
        pila.clear();
    }
    
    @Override
    public void pushPila (Object dato){
        pila.add(dato);
        tope++;
    }
    
    @Override
    public T popPILA(){
        T dato= (T) pila.get(tope);
        pila.remove(tope);
        tope--;
        return dato;
    }
    
    @Override
    public T peekpila(){
        return (T)pila.get(tope);
    }
    
    @Override
    public String toString(){
        return toString(tope);
    }
    private String toString(int i){
        return (i>=0)?"tope===>"+ i + "[" + pila.get(i)+"]\n" + toString(i-1):"";
        
    }
    
    //MENU
    
    public static void Menu(){
        
        PilaC pila=  new PilaC  ();
        String dato,op;
        do{
            op=tools.boton("PUSH,POP,PEEK,FREE,SALIR");
            switch(op){
                case "PUSH": 
                    pila.pushPila(tools.leeInt("escribe un daro entero: "));
                    tools.imprime("datos de la pila: \n" + pila.toString());
                        break;
                case "POP":
                    if (pila.isemptyPila())tools.errorMsj("pila Vacia");
                    else 
                        tools.imprime("dato eliminado de la sima de la pila: " + pila.popPILA()+ "\n"+ pila.toString());
                        break; 
                case "PEEK":
                    if (pila.isemptyPila())tools.errorMsj("pila vacia");
                    else 
                        tools.imprime("dato de la cima de la pila: ==>" + pila.peekpila()+ "\n"+ pila.toString());
                        break;
                case  "FREE":
                    if (pila.isemptyPila())tools.errorMsj("pila vacia");
                    else
                    {
                        pila.vaciar();
                        pila = new PilaC();
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
