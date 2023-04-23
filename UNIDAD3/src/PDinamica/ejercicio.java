package PDinamica;

import EntradaYSalida.tools;
public class ejercicio  {
    
    public static void cadenaPosfija(String cad){
        
        PilaC pila = new PilaC();
        String posfija = "";
        
        for(char i: cad.toCharArray()){
            
            if(i == '('){
                pila.pushPila(i);
            }
            
            if(Character.isLetter(i)){
                posfija += i;
            }
            
            if(operador(i)){
                while(!pila.isemptyPila()&& jerarquia((char)pila.peekpila()) >= jerarquia(i)){
                    posfija += pila.peekpila();
                    pila.popPILA();
                }
                pila.pushPila(i);
            }
            
            if(i == ')'){
                while(!pila.isemptyPila()&& (char)pila.peekpila() != '('){
                posfija += pila.popPILA();        
                }
            }
     
        }
        while(!pila.isemptyPila()){
            pila.popPILA();   
        }
        
        
        System.out.println(pila.toString());
        System.out.println(posfija + "\n");    

    }
    
    private static boolean operador(char cad){ 
        return cad == '^' || cad == '*' || cad == '/' || cad == '+' || cad == '-';        
    }
    
    public static byte jerarquia(char cad){
        byte orden = 0;
        switch(cad){
            case '^' : orden = 3; break;  
            case '/' :
            case '%' :
            case '*' : orden = 2; break; 
            case '+' :
            case '-' : orden = 1; break;
        }
        return orden;    
    }
    
    public static void main(String[] args) {
    String expresion= tools.leeString("INGRESA LA EXPRESION");
        cadenaPosfija(expresion);
    }
    /*
    public static byte jerarquias (char car){
        byte orden = 0;
        switch(car){
            case '^':orden =3;break;
            case'/':orden =3;break;
            case '%':orden =3;break;
            case '*':orden = 2;break;
            case'+':orden = 2;break;
            case'-':orden=1; break;
        }
        return orden;
    }
    public static boolean validaOperador(char operador){   
            switch(operador){
            case '^':
            case'/':
            case '%':
            case '*':
            case'+':
            case'-':
                return true;
            default:
                return false;
    }
}
  
    public static void main(String[] args) {
        String expresion = tools.leeString("INGRESA LA EXPRESION");
        String codPos= "";
        
       
       /* for (char i: expresion.toCharArray()){
            char car = i;
        }
        
        
        if (validaOperador(car)){
        while */
    }
          
   /* public static void main(String [] args){
        PilaC pila=  new PilaC  ();
        String cadena= tools.leeString("INGRESA LA EXPRESION ARITMETICA");
        for (int i=0; i <= cadena.length() ;i++){
            if (cadena.equals("(")){
                pila.pushPila(cadena);
                
            }
            if (cadena.equals(")")){
                pila.popPILA();
            }
        }
        if(pila.isemptyPila()){
            tools.imprime("TIENE PARENTESIS BALANCEADOS");
        }
        else{
            
            tools.imprime("NO TIENE PARENTESIS BALANCEADOS");
        }
*/
       /* public static void main(String[] args ){
            PilaC pila=  new PilaC  ();
            String expresion= tools.leeString("INGRESA LA EXPRESION");
            String cadPos= "";
            
            for(char i : expresion.toCharArray()){
                if (i== '(')pila.pushPila(i);
                if (Character.isLetter(i)) cadPos+=i;
            }
            System.out.println("cadena:  "+ cadPos);
            System.out.println(pila);
        }*/
    /*
    if (validaOperador(car)){
    while (!pila.
    ejercicio obj = new ejercicio();
        obj.cadenaPosfija("(a+b)/(c-e)");
         String cadena= tools.leeString("INGRESA LA EXPRESION ARITMETICA");
    */

