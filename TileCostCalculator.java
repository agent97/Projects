/**
 * Created by agent97 on 8/1/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TileCostCalculator extends JFrame {

    private JTextField wField, lField, aField, cField, ucField;

    public SwingUI() {
        JLabel wLabel = new JLabel("Enter width of tiled area", SwingConstants.RIGHT),
        lLabel = new JLabel("Enter length of tiled area", SwingConstants.RIGHT),
        aLabel = new JLabel("Tiled area ", SwingConstants.RIGHT),
        cLabel = new JLabel("Cost to tile $", SwingConstants.RIGHT),
        ucLabel = new JLabel("Cost per unit of tile $", SwingConstants.RIGHT);

        wField = new JTextField(10);
        lField = new JTextField(10);
        aField = new JTextField(10);
        aField.setEditable(false);
        cField = new JTextField(10);
        cField.setEditable(false);
        ucField = new JTextField(10);

        JButton calcButton = new JButton("Calculate Cost");
        calcButton.addActionListener(new CalcListener());
        JButton doneButton = new JButton("Done");
        doneButton.addActionListener(new DoneListener());

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(6, 2));

        pane.add(wLabel);
        pane.add(wField);
        pane.add(lLabel);
        pane.add(lField);
        pane.add(ucLabel);
        pane.add(ucField);
        pane.add(aLabel);
        pane.add(aField);
        pane.add(cLabel);
        pane.add(cField);
        pane.add(calcButton);
        pane.add(doneButton);

        setTitle("Tile Cost Calculator");
        setSize(640, 480);
        setLocation(10, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new TileCostCalculator();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class CalcListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Double width = new Double(wField.getText()),
                   length = new Double(lField.getText()),
                   unitCost = new Double(ucField.getText()),
                   area = width * length, cost = area * unitCost;

            aField.setText(area.toString());
            cField.setText(cost.toString());
        }
    }

    private class DoneListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
