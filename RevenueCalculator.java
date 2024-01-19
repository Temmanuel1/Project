package entities.all;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RevenueCalculator extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField revenueTextField;
    private JLabel resultLabel;

    public RevenueCalculator() {
        setTitle("Revenue Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        revenueTextField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Calculated Revenue: ");

        // Set layout
        setLayout(new GridLayout(3, 1));

        // Add components to the frame
        add(new JLabel("Revenue: "));
        add(revenueTextField);
        add(calculateButton);
        add(resultLabel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateRevenue();
            }
        });
    }

    private void calculateRevenue() {
        try {
            double revenue = Double.parseDouble(revenueTextField.getText());

            // Perform calculation (in this example, just doubling the revenue)
            double calculatedRevenue = 2 * revenue;

            resultLabel.setText("Calculated Revenue: " + String.format("%.2f", calculatedRevenue));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number for revenue.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RevenueCalculator().setVisible(true);
            }
        });
    }
}

