/**
 * Created by agent97 on 8/6/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MortgageCalculator extends JFrame {
    private JLabel termLabel, interestLabel, answerLabel;
    private JComboBox compoundBox;
    private JTextField termField, amtField, interestField, answerField;
    private JButton clearButton, calcButton, doneButton;
    private String[] compoundOptions = {"Yearly", "Monthly", "Weekly", "Daily"};

    public MortgageCalculator() {
        termLabel = new JLabel("Mortgage Term (in years) and Amount (in dollars) ", SwingConstants.RIGHT);
        interestLabel = new JLabel("Interest rate %", SwingConstants.RIGHT);
        answerLabel = new JLabel("Your mortgage payments will be ", SwingConstants.RIGHT);

        termField = new JTextField(10);
        amtField = new JTextField(10);
        interestField = new JTextField(10);
        answerField = new JTextField((10));
        answerField.setEditable(false);

        compoundBox = new JComboBox(compoundOptions);

        clearButton = new JButton("Clear");
        calcButton = new JButton("Calc");
        doneButton = new JButton("Done");

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 3));

        clearButton.addActionListener(new ClearListener());
        calcButton.addActionListener(new CalcListener());
        doneButton.addActionListener(new DoneListener());

        pane.add(termLabel);
        pane.add(termField);
        pane.add(amtField);

        pane.add(interestLabel);
        pane.add(interestField);
        pane.add(compoundBox);

        pane.add(answerLabel);
        pane.add(answerField);
        pane.add(new JLabel());

        pane.add(clearButton);
        pane.add(calcButton);
        pane.add(doneButton);

        setTitle("Mortgage Payment Calculator");
        setSize(640, 480);
        setLocation(10, 200);
        setVisible(true);

    }

    private class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            termField.setText("");
            interestField.setText("");
            answerField.setText("");
        }
    }

    private class CalcListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int compound = compoundBox.getSelectedIndex();
            double term = Double.parseDouble(termField.getText()),
                    amount = Double.parseDouble(amtField.getText()),
                    iRate = Double.parseDouble(interestField.getText()),
                    interest = iRate / 100,
                    payment;

            switch(compound) {
                case 0: break;
                case 1: interest /= 12.0; term *= 12.0; break;
                case 2: interest /= 52.0; term *= 52.0; break;
                case 3: interest /= 365.0; term *= 365.0; break;
                default: System.err.println("Error: No compound term selected.");
                    System.exit(1);
            }

            payment = (amount * (interest * Math.pow(interest + 1, term))) / (Math.pow(interest + 1, term) - 1);
            payment = Math.round(payment * 100.0) / 100.0;
            answerField.setText("" + payment);
        }
    }

    private class DoneListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JFrame m = new MortgageCalculator();
        m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
