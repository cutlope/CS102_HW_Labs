/**
 * PotLuck Game
 * @author Abdullah Riaz
 * @version 31.03.2021
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PotLuck extends JFrame implements ActionListener {
    //Constants
    private final int FRAME_WIDTH = 300;
    private final int FRAME_HEIGHT = 400;
    private final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13", "14","15", "16","17", "18","19", "20", "21", "22", "23", "24", "25"};
    

    
    //Variables
    private GridLayout numpad;
    private JButton[] buttons = new JButton[numbers.length];
    private BombButton bombButton;
    private BombButton bombButton2;
    private PrizeButton starButton;
    private JPanel buttonPanel;
    private int prize ;
    private int bomb ;
    private int bomb2 ;
    private int counter ;
    private JLabel label;
    private boolean gameOver = false;

    public PotLuck() {

        while ( prize == bomb  || prize == bomb2 || bomb == bomb2){
        prize = (int) (Math.random() * 25);
        bomb = (int) (Math.random() * 25);
        bomb2 = (int) (Math.random() * 25);
        }
        counter = 0;

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("PotLuck");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();
        numpad = new GridLayout(5, 5);
        numpad.setHgap(5); 
        numpad.setVgap(5);

        buttonPanel.setLayout(numpad);


        for (int i = 0; i < buttons.length; i++) {

            if (i == bomb ) {
                bombButton = new BombButton(numbers[i]);
                bombButton.setBackground(Color.WHITE);
                bombButton.addActionListener(this);
                buttonPanel.add(bombButton);
            }
            else if (i == bomb2) {
                bombButton2 = new BombButton(numbers[i]);
                bombButton2.setBackground(Color.WHITE);
                bombButton2.addActionListener(this);
                buttonPanel.add(bombButton2);
            }


            else if (i == prize ) {
                starButton = new PrizeButton(numbers[i]);
                starButton.setBackground(Color.WHITE);
                starButton.addActionListener(this);
                buttonPanel.add(starButton);
            }
            else{
                buttons[i] = new JButton(numbers[i]);
                buttons[i].setBackground(Color.WHITE);
                buttons[i].addActionListener(this);
                buttonPanel.add(buttons[i]);
            }

        }

        add(buttonPanel);
        add(label = new JLabel("You have clicked " + counter +  " times"), BorderLayout.SOUTH);
        


    }

    
    /** 
     * Performs Action on event
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bombButton || e.getSource() == bombButton2) {
            gameOver = true;
            repaint();
            label.setText("Sorry! You are blown up at attempt " + (counter + 1) + "!");
            ((JButton) buttonPanel.getComponent(prize)).setText("★") ;
            for(int i = 0; i < 25 ; i++){
                if(buttonPanel.getComponent(i) != bombButton && buttonPanel.getComponent(i) != bombButton2 && buttonPanel.getComponent(i) != starButton ){
                  ((JButton) buttonPanel.getComponent(i)).setEnabled(false);   
                }}
        }

        else if (e.getSource() == starButton ) {
            gameOver = true;
            ( (JButton) e.getSource()).setFont(new Font(getFont().getFontName(), Font.PLAIN , 20));;
            ( (JButton) e.getSource()).setText("★") ;
            ( (JButton) e.getSource()).setForeground(Color.ORANGE);
            for(int i = 0; i < 25 ; i++){
                if(buttonPanel.getComponent(i) != starButton){
                  ((JButton) buttonPanel.getComponent(i)).setEnabled(false);   
                }}
            
            label.setText("You got it in " + (counter + 1) +  " attempts!");

        }
        else {
        counter++;
        ( (JButton) e.getSource()).setEnabled(false); 
        label.setText("You have clicked " + counter +  " times");
        }
    }
    

    class BombButton extends JButton  {
        public BombButton(String text) {
            super(text);
            
        }

        @Override
        public void paintComponent(Graphics g) {
           super.paintComponent(g);
           if (gameOver) {
               int height = getHeight() - 20;
               int width = getWidth() - 20;

               Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(3));
                g2d.setColor(Color.RED);
                g2d.drawArc(20,2,width,height,-270,50);
                g2d.setColor(Color.GRAY);
                g2d.fillRect(20, 8, getWidth()- 40 , height/4 );
                g2d.setColor(Color.BLACK);
                g2d.fillOval(8,10, width, height);
 
    

           }
        }       
    }

    class PrizeButton extends JButton  {
        public PrizeButton(String text) {
            super(text);
            
        }
    }


    
    
    /** 
     * Main Method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        PotLuck game = new PotLuck();
        game.setVisible(true);

    }
}
