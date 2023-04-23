package EstruCola;

import EntradaYSalida.tools;

public class ColaA <T> implements ColaTDA <T> {
    private T Cola[];
    private byte U;
    
    public ColaA (int max){
        Cola =(T[])(new Object[max]);
        U=-1;
    }
    
    @Override
    public boolean isEmptyCola(){
        return (U==-1);
    }
    
        public boolean isSpace(){
        return (U<Cola.length-1);
    }
        @Override
        public void pushCola(T dato){
        if (isSpace()){
            U++;
            Cola[U]=dato;
        }
        else
            tools.errorMsj("PILA LLENA!!!!!");
    }
          
    @Override
    public T popCola (){
        T dato = Cola [0];
        recorrePos();
        U--; return dato;
    }
    
    @Override
    public T peekCola(){
        return Cola [0];
    }
    
    public void VaciarCola(){
        Cola=null;
        U=-1;
}
    public void recorrePos() {

        for (int j = 0; j < U; j++) {
            Cola[j] = Cola[j + 1];

        }
        
    }
 
    @Override
    public String toString(){
        return toString(U);
    }
    private String toString(int i){
         return(i<=U)?"tope===>"+ i + "["+ Cola [i]+ "]\n" + toString (i+1):"";
         //return(i>=0)?"tope===>"+ i + "["+ Cola [i]+ "]\n" + toString (i-1):"";
    }
    
    public static void Menu(){
       ColaA <String> cola = new ColaA ((byte)10);
        String op="";
        do{
            op=tools.boton("PUSH,POP,PEEK,FREE,SALIR");
            switch(op){
                case "PUSH": 
                   cola.pushCola(tools.leeString("escribe un dato entero: "));
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
                        cola = new ColaA ((byte)10);
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


