package PDinamica;

import EntradaYSalida.tools;
import static PDinamica.PilaD.Menu;
import PilaEstatica.PilaTDA;
import java.util.Stack;

public class PilaNodo <T> implements PilaTDA<T>{
   private Nodo pila;
   public PilaNodo(){
       pila=null;
   }
    
   @Override
   public void pushPila(T dato){
       Nodo tope = new Nodo(dato);
       if (isemptyPila())pila=tope;
       else{
           tope.sig=pila;
           pila=tope;
       }
   }
   @Override
   public boolean isemptyPila(){
       return (pila== null);
   }
   public void vaciar (){
        pila = null;
    }
   @Override
   public T peekpila(){
       return (T) (pila.getInfo());
   }
   @Override
   public T popPILA(){
       Nodo tope= pila;
       T dato= (T) pila.getInfo();
       pila=pila.getSig();
       tope=null;
       return dato;
   }
   @Override
   public String toString(){
       Nodo tope=pila;
       return toString(tope);   
   }
   private String toString(Nodo i){
       return(i!=null)?"TOPE ===>" + "["+ i.getInfo()+"] \n"+ toString(i.getSig()):"";
   }
   
   
   
    public static void Menu(){
        PilaNodo pila= new PilaNodo();
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
                        pila = new PilaNodo();
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
