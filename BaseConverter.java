/**
 * Created by agent97 on 8/6/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseConverter extends JFrame {
    private JComboBox box1, box2;
    private JTextField input;
    private JTextArea output;

    public BaseConverter() {
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel convert = new JLabel("Convert");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = 2;
        pane.add(convert, c);

        input = new JTextField(10);
        c.gridx = 2;
        c.gridwidth = 4;
        pane.add(input, c);

        JLabel from = new JLabel("from");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        pane.add(from, c);

        String[] box1Options = {"Binary", "Decimal"};
        box1 = new JComboBox(box1Options);
        String[] box2Options = {"Decimal", "Binary"};
        box2 = new JComboBox(box2Options);
        
        c.gridx = 2;
        c.gridwidth = 4;
        pane.add(box1, c);

        JLabel to = new JLabel("to");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        pane.add(to, c);

        c.gridx = 2;
        c.gridwidth = 4;
        pane.add(box2, c);

        output = new JTextArea(2, 20);
        output.setEditable(false);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 6;
        pane.add(output, c);

        JButton calc = new JButton("Convert");
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = "",
                        inText = input.getText();
                int inBase = box1.getSelectedIndex();

                switch(inBase) {
                    case 0:
                        answer = binToDec(inText);
                        break;
                    case 1:
                        answer = decToBin(inText);
                        break;
                    default: System.err.println("Error: No base selected for input.");
                        System.exit(1);
                }

                output.setText(answer);
            }
        });
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        pane.add(calc, c);

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                output.setText("");
            }
        });
        c.gridx = 2;
        pane.add(clear, c);

        JButton done = new JButton("Done");
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        c.gridx = 4;
        pane.add(done, c);

        setSize(new Dimension(400, 200));
        setVisible(true);
    }

    private String binToDec(String in) {
        int answer = 0;
        for(int i = 1; i <= in.length(); i++) {
            answer += Integer.parseInt("" + in.charAt(i - 1)) * Math.pow(2, in.length() - i);
        }

        return "" + answer;
    }

    private String decToBin(String in) {
        String answer = "";
        int a = Integer.parseInt(in);
        while(a != 0) {
            answer = (a % 2) + answer;
            a /= 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        JFrame b = new BaseConverter();
        b.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
