/**
 * Created by agent97 on 8/6/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangeCalculator extends JFrame {
    private JLabel dueLabel, paidLabel, changeLabel;
    private JTextField dueField, paidField, changeField;
    private JButton clearButton, calcButton, doneButton;

    public ChangeCalculator() {
        Container pane = getContentPane();
        GridBagLayout layout = new GridBagLayout();
        pane.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1.0;
        c.weighty = 1.0;

        dueLabel = new JLabel("Total amount due: ");
        dueField = new JTextField(10);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(dueLabel, c);
        c.gridx = 3;
        pane.add(dueField, c);

        paidLabel = new JLabel("Total amount paid: ");
        paidField = new JTextField(10);
        c.gridx = 0;
        c.gridy = 1;
        pane.add(paidLabel, c);
        c.gridx = 3;
        pane.add(paidField, c);

        changeLabel = new JLabel("Change due: ");
        changeField = new JTextField(10);
        changeField.setEditable(false);
        c.gridx = 0;
        c.gridy = 2;
        pane.add(changeLabel, c);
        c.gridx = 3;
        pane.add(changeField, c);

        calcButton = new JButton("Calculate");
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double due = Double.parseDouble(dueField.getText()),
                        paid = Double.parseDouble(paidField.getText()),
                        change = Math.round((paid - due) * 100.0) / 100.0;

                changeField.setText("" + change);
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(calcButton, c);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dueField.setText("");
                paidField.setText("");
                changeField.setText("");
            }
        });
        c.gridx = 2;
        pane.add(clearButton, c);

        doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        c.gridx = 4;
        pane.add(doneButton, c);

        setSize(new Dimension(300, 200));
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame c = new ChangeCalculator();
        c.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
