package EstructurasLineales;
import EntradaYSalida.tools;
import PilaEstatica.PilaA;
import PilaEstatica.PilaTDA;
import javax.swing.JOptionPane;
public class EstructurasLineales {
    
    public static void Menu(){
        
        PilaA <Integer> pila = new PilaA ((byte)10);
        String op="";
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
                        pila=null;
                        pila = new PilaA ((byte)10);
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
