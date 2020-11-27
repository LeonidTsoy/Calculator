package Calculator;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Calculator {
    JButton button [] = new JButton[17];

    public void buttons(){
        JPanel windowContent = new JPanel();
        JTextField displayField = new JTextField(30);
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);
        windowContent.add("North",displayField);
        JPanel p1 = new JPanel();
        GridLayout gl =new GridLayout(4,3);
        p1.setLayout(gl);
        windowContent.add("Center",p1);
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 260);
        CalculatorEngine calcEngine = new CalculatorEngine(this);
        String but [] = {"0","1","2","3","4","5","6","7","8","9","C",".","=","+","-","/","*"};
        for(int i = 0; i<18; i++){
            button [i] = new JButton(but[i]);
            p1.add(button[i]);
            button[i].addActionListener(calcEngine);
        }
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
}

