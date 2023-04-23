package PDinamica;
import EntradaYSalida.tools;
import javax.swing.*;
import java.util.Stack;
import java.util.EmptyStackException;
public class PilaD {
    
        public static void Menu(){
        Stack pila= new Stack();
        String dato,op;
        do{
            op=tools.boton("PUSH,POP,PEEK,FREE,SALIR");
            switch(op){
                case "PUSH": 
                    pila.push(tools.leeInt("escribe un daro entero: "));
                    tools.imprime("datos de la pila: \n" + pila.toString());
                        break;
                case "POP":
                    if (pila.empty())tools.errorMsj("pila Vacia");
                    else 
                        tools.imprime("dato eliminado de la sima de la pila: " + pila.pop()+ "\n"+ pila.toString());
                        break; 
                case "PEEK":
                    if (pila.empty())tools.errorMsj("pila vacia");
                    else 
                        tools.imprime("dato de la cima de la pila: ==>" + pila.peek()+ "\n"+ pila.toString());
                        break;
                case  "FREE":
                    if (pila.empty())tools.errorMsj("pila vacia");
                    else
                    {
                        pila=null;
                        pila = new Stack();
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

