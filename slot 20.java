// 20.2
// Write a program that will display check boxes and option buttons they
// are numbered from1 to. Use a textbox to display the number those
// corresponding boxes or button checked.
import javax.swing.*;
import java.awt.event.*;

public class CheckboxDemo extends JFrame implements ItemListener {

    private final JCheckBox[] checkboxes;
    private final JRadioButton[] radioButtons;
    private final JTextField textField;

    public CheckboxDemo() {
        super("Checkbox and Option Button Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create and add checkboxes
        checkboxes = new JCheckBox[5];
        for (int i = 0; i < checkboxes.length; i++) {
            checkboxes[i] = new JCheckBox("Option " + (i + 1));
            checkboxes[i].addItemListener(this);
            add(checkboxes[i]);
        }

        // Add a space
        add(Box.createVerticalStrut(10));

        // Create and add radio buttons
        radioButtons = new JRadioButton[5];
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton("Option " + (i + 1));
            radioButtons[i].addItemListener(this);
            group.add(radioButtons[i]);
            add(radioButtons[i]);
        }

        // Add a space
        add(Box.createVerticalStrut(10));

        // Create and add text field
        textField = new JTextField(10);
        textField.setEditable(false);
        add(textField);

        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String selection = "";
        if (e.getSource() instanceof JCheckBox) {
            // Update selection for checkboxes
            for (int i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].isSelected()) {
                    selection += (i + 1) + ", ";
                }
            }
        } else if (e.getSource() instanceof JRadioButton) {
            // Update selection for radio buttons (only one selected)
            JRadioButton selectedButton = (JRadioButton) e.getSource();
            selection = selectedButton.getText();
        }

        // Remove trailing comma and space
        if (!selection.isEmpty()) {
            selection = selection.substring(0, selection.length() - 2);
        }

        // Update text field with the selection
        textField.setText(selection);
    }

    public static void main(String[] args) {
        new CheckboxDemo();
    }
}

//===============================================================================================//
// 20.3
// Write a program to create a simple calculator.

import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Calculator!");

        while (true) {
            System.out.println("\nPlease enter the first number:");
            double num1 = scanner.nextDouble();

            System.out.println("Please choose an operation (+, -, *, /):");
            String operator = scanner.next();

            System.out.println("Please enter the second number:");
            double num2 = scanner.nextDouble();

            double result = calculate(num1, operator, num2);

            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

            System.out.println("Do you want to calculate again? (y/n)");
            String answer = scanner.next();

            if (!answer.equals("y")) {
                break;
            }
        }

        System.out.println("Thank you for using the Simple Calculator!");
    }

    private static double calculate(double num1, String operator, double num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed!");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator!");
        }
    }
}
