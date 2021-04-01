/**
 * Bin/Hex/Dec Converter 
 * @author Abdullah Riaz
 * @version 31.03.2021
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Converter extends JFrame  {

    //Variables
    private JLabel hex;
    private JLabel dec;
    private JLabel bin;
    private JTextField hexTxt;
    private JTextField binTxt;
    private JTextField decTxt; 
    private JPanel conPan;
    private GridLayout conLay;


    
    public Converter() {
        setSize(300, 300);
        setTitle("Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        conLay = new GridLayout(3, 3);
        conLay.setHgap(5); 
        conLay.setVgap(10);
        conPan = new JPanel();
        conPan.setLayout(conLay);
        dec = new JLabel("Decimal");
        hex = new JLabel("Hexadecimal");
        bin = new JLabel("Binary");
        decTxt = new JTextField();
        decTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                decTxtAction(e);
        }});
        binTxt = new JTextField();
        binTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                binTxtAction(e);
        }});
        hexTxt = new JTextField();
        hexTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                hexTxtAction(e);
        }});

        conPan.add(dec);
        conPan.add(decTxt);
        conPan.add(hex);
        conPan.add(hexTxt);
        conPan.add(bin);
        conPan.add(binTxt);
        add(conPan);
        }

    
    /** 
     * Calls Converstion methods when text is added to decimal field 
     * @param e
     */
    private void decTxtAction(ActionEvent e) {
        int decimal = Integer.parseInt(decTxt.getText());
        hexTxt.setText(decToHex(decimal));
        binTxt.setText(decToBin(decimal));

    }

    
    /** 
     * Calls Converstion methods when text is added to Binary field
     * @param e
     */
    private void binTxtAction(ActionEvent e) {
        int decimal = Integer.parseInt(binTxt.getText());
        hexTxt.setText(decToHex(Integer.parseInt(binToDec(decimal))));
        decTxt.setText(binToDec(decimal));

    }

    
    /** 
     * Calls Converstion methods when text is added to hexadecimal field
     * @param e
     */
    private void hexTxtAction(ActionEvent e) {
        String hexString = hexTxt.getText();
        decTxt.setText(hexToDec(hexString));
        binTxt.setText(decToBin(Integer.parseInt(hexToDec(hexString))));

    }

    
    /** 
     * Calls Converstion methods when text is added to hexadecimal field
     * @param hex
     * @return String
     */
    private String hexToDec(String hex) {
        String hexstring = "0123456789ABCDEF";  
        hex = hex.toUpperCase();  
        int num = 0;  
        String convDec = "";
        for (int i = 0; i < hex.length(); i++)  
        {  
            char ch = hex.charAt(i);  
            int n = hexstring.indexOf(ch);  
            num = 16 * num + n;  
        }  

        return (convDec + num);
        

    }
    
    /** 
     * Converts Decimal to hex
     * @param num
     * @return String
     */
    private String decToHex(int num){
        
        int reminder;
        String convHex = "";
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while (num > 0) {
            reminder = num % 16;
            convHex = hex[reminder] + convHex;
            num = num / 16;
        }
        return convHex;
    }

    
    /** 
     * Converts binary to decimal
     * @param num
     * @return String
     */
    private String binToDec(int num){
        String convDecimal = "";
        int decimal = 0;
        int temp;
        int i = 0;
        while(true){
            if(num == 0){
                break;
        } 
            else {
                temp = num % 10;
                decimal = (int) (decimal + temp * Math.pow(2, i));
                num = num/10;
                i++;
            }
        }
        convDecimal = convDecimal + decimal;
        return convDecimal;
    }


    
    /** 
     * Converts Decimal to Binary
     * @param num
     * @return String
     */
    private String decToBin(int num){
        int binary[] = new int[50];
        int i = 0;
        String convDecimal = "";
        while(num > 0){
            binary[i++] = num % 2;
            num = num/2;
        }
        for(int j = i-1 ;j >= 0;j--){
            convDecimal = convDecimal + binary[j]  ;
        }
        return convDecimal;
    }

    
    
    /**  
     * Main  Method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Converter convert = new Converter();
        convert.setVisible(true);
    }
}
