package entities.all;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Investment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField amountField;
    private JTextField rateField;

    public Investment() {
        setTitle("Investment Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Amount Tab
        JPanel amountPanel = new JPanel();
        amountPanel.setLayout(new FlowLayout());
        amountField = new JTextField(10);
        amountPanel.add(new JLabel("Amount: "));
        amountPanel.add(amountField);
        tabbedPane.addTab("Amount", amountPanel);

        // Rate of Return Tab
        JPanel ratePanel = new JPanel();
        ratePanel.setLayout(new FlowLayout());
        rateField = new JTextField(10);
        ratePanel.add(new JLabel("Rate of Return: "));
        ratePanel.add(rateField);
        tabbedPane.addTab("Rate of Return", ratePanel);

        // Calculate Tab
        JPanel calculatePanel = new JPanel();
        calculatePanel.setLayout(new FlowLayout());
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        calculatePanel.add(calculateButton);
        tabbedPane.addTab("Calculate", calculatePanel);

        getContentPane().add(tabbedPane);

        setVisible(true);
    }

    private void calculate() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            double rate = Double.parseDouble(rateField.getText());

            // Perform your calculation here
            double result = amount * (1 + rate / 100);

            JOptionPane.showMessageDialog(this, "Calculation result: " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Investment();
            }
        });
    }
}

