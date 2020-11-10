package Calculator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
    Calculator parent;
    char lastCommand = ' ';
    double currentResult = 0;
    double displayValue = 0;


    CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton;
        clickedButton = (JButton) e.getSource();
        String dispFieldText = parent.displayField.getText();
        if (!"".equals(dispFieldText)) {
            displayValue = Double.parseDouble(dispFieldText);
        }
        String clickedButtonLabel = clickedButton.getText();
        parent.displayField.setText(dispFieldText +
                clickedButtonLabel);

        if (clickedButton == parent.buttonSign) {
            currentResult = displayValue * -1;
            parent.displayField.setText("" + currentResult);
        }
        if (clickedButton == parent.buttonC) {
            currentResult = 0;
            displayValue = 0;
            lastCommand = ' ';
            parent.displayField.setText(null);
        }
        if (clickedButton == parent.buttonPlus) {
            Calculate();
            lastCommand = '+';
        } else if (clickedButton == parent.buttonMinus) {
            Calculate();
            lastCommand = '-';
        } else if (clickedButton == parent.buttonMultiply) {
            Calculate();
            lastCommand = '*';
        } else if (clickedButton == parent.buttonDivide) {
            Calculate();
            lastCommand = '/';
        } else if (clickedButton == parent.buttonSquare) {
            Calculate();
            lastCommand = '^';
        }

        if (clickedButton == parent.buttonEqual) {
            Calculate();
            parent.displayField.setText("" + currentResult);
            lastCommand = ' ';
        }
    }

    public void Calculate() {
        if (lastCommand == '-') {
            currentResult = currentResult - displayValue;
        } else if (lastCommand == '+') {
            currentResult = currentResult + displayValue;
        } else if (lastCommand == '/') {
            currentResult = currentResult / displayValue;
        } else if (lastCommand == '*') {
            currentResult = currentResult * displayValue;
        } else if (lastCommand == '^') {
            currentResult = Math.pow(currentResult, displayValue);
        } else {
            currentResult = displayValue;
        }
        parent.displayField.setText(null);
    }
}