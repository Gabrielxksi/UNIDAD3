package PDinamica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Posfija<T> extends JFrame {

    private JTextField txtEntrefija;
    private JTable tblDatos;
    private DefaultTableModel model;
    private PilaNodo<Character> pila = new PilaNodo<Character>();

    public Posfija() {
        setTitle("Convertidor de entrefija a posfija");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblEntrefija = new JLabel("Expresión entrefija:");
        lblEntrefija.setBounds(20, 20, 120, 20);
        getContentPane().add(lblEntrefija);

        txtEntrefija = new JTextField();
        txtEntrefija.setBounds(150, 20, 200, 20);
        getContentPane().add(txtEntrefija);

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(370, 20, 100, 20);
        getContentPane().add(btnConvertir);

        tblDatos = new JTable();
        model = new DefaultTableModel();
        model.addColumn("Entrefija");
        model.addColumn("Pila");
        model.addColumn("Posfija");
        tblDatos.setModel(model);
        JScrollPane scrollPane = new JScrollPane(tblDatos);
        scrollPane.setBounds(20, 60, 450, 180);
        getContentPane().add(scrollPane);

        btnConvertir.addActionListener(event -> convertir());

        setVisible(true);
    }

    private void convertir() {
        String entrefija = txtEntrefija.getText();
        String posfija = "";

        model.setRowCount(0);
        for (int i = 0; i < entrefija.length(); i++) {
            char c = entrefija.charAt(i);

            if (c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                pila.pushPila(c);
            } else if (Character.isLetter(c)) {
                posfija += c;
            } else if (c == ')') {
                while (!pila.isemptyPila() && pila.peekpila() != '(') {
                    posfija += pila.popPILA();
                }
                if (!pila.isemptyPila() && pila.peekpila() == '(') {
                    pila.popPILA();
                }
            }

            model.addRow(new Object[]{entrefija.substring(0, i + 1), pila.toString(), posfija});
        }

        while (!pila.isemptyPila()) {
            posfija += pila.popPILA();
            model.addRow(new Object[]{entrefija, pila.toString(), posfija});
        }

        model.addRow(new Object[]{entrefija, "", posfija});
    }

    public static void main(String[] args) {
        new Posfija();
    }
}



/*s

    public static void Posfija(String expresion){
        
        PilaNodo pila = new PilaNodo();
        String cadPos = "";
        for ( char i : expresion.toCharArray() ){
                if ( i == '(' ) pila.pushPila(i);
                if (Character.isLetter(i)) cadPos+= i ;
                if ( validaOperador(i)){
                    while (!pila.isEmptyPila() && jerarquia((char) pila.peekPila()) >= jerarquia(i)  ){
                        cadPos += pila.peekPila();
                        pila.popPila();
                        }
                    pila.pushPila(i);
                    }
                
                if ( i == ')'){
                    while (!pila.isEmptyPila() && (char) pila.peekPila() != '(' ){
                        cadPos += pila.popPila();
                    }
                }
        }
        while(!pila.isEmptyPila()){
            pila.popPila(); 
    }
        System.out.println(pila.toString());
        System.out.println(cadPos + "\n");  
    }
        
    public static byte jerarquia (char car){
        byte orden = 0;
        
        switch (car){
            case '^': orden= 3; break;
            case '/': orden = 3; break;
            case '%': orden = 3; break;
            case '*': orden =2; break;
            case '+': orden=2; break;
            case '-': orden =1; break;
        }
        return orden;
    }
    
    public static boolean validaOperador(char car){
        return car == '^' || car == '*' || car == '/' || car == '+' || car == '-';     
    }
    
    
    public static void main(String[] args) {
        String expresion = Tools.leeString("Ingrese la expresión:");

        Posfija(expresion);
        
        //if (isPotencia(expresion))Tools.imprime();
    }

*******************************
public static void ConverNodoPosfija(String expresion){
    //PilaNodo pila = new PilaNodo();
    String cadPos = "";
    
        for (char i : expresion.toCharArray()) {
                if ( i == '(' ) pila.pushPila(i);
                if (Character.isLetter(i)) cadPos+= i ; 
            }
        System.out.println("Cadena letras:" + cadPos);
        System.out.println(pila);
    }







mientras lo qe se encuentre en el tope de la pila sea diferente del "(
se elimina del tope de la pila y se concatena en posfija
quedando pila vacía 

mientras lo q se tenga en el tope de la pila tenga mayor o igual predencia 
sale la mayor potencia para entrar el de menor 


 */
    

