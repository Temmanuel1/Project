package entities.all;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanCalculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField amountTextField;
    private JTextField periodTextField;
    private JTextField returnTextField;
    private JLabel resultLabel;

    public LoanCalculator() {
        setTitle("Loan Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        amountTextField = new JTextField(10);
        periodTextField = new JTextField(10);
        returnTextField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Monthly Payment: ");

        // Set layout
        setLayout(new GridLayout(5, 1));

        // Add components to the frame
        add(new JLabel("Loan Amount: "));
        add(amountTextField);
        add(new JLabel("Loan Period (in months): "));
        add(periodTextField);
        add(new JLabel("Annual Return Rate (%): "));
        add(returnTextField);
        add(calculateButton);
        add(resultLabel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateLoanPayment();
            }
        });
    }

    private void calculateLoanPayment() {
        try {
            double amount = Double.parseDouble(amountTextField.getText());
            int period = Integer.parseInt(periodTextField.getText());
            double annualReturnRate = Double.parseDouble(returnTextField.getText());

            // Calculate monthly payment using the formula for loan payment
            double monthlyInterestRate = (annualReturnRate / 100) / 12;
            double monthlyPayment = (amount * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate, -period));

            resultLabel.setText("Monthly Payment: " + String.format("%.2f", monthlyPayment));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoanCalculator().setVisible(true);
            }
        });
    }

	public JTextField getAmountTextField() {
		return amountTextField;
	}

	public void setAmountTextField(JTextField amountTextField) {
		this.amountTextField = amountTextField;
	}

	public JTextField getPeriodTextField() {
		return periodTextField;
	}

	public void setPeriodTextField(JTextField periodTextField) {
		this.periodTextField = periodTextField;
	}

	public JTextField getReturnTextField() {
		return returnTextField;
	}

	public void setReturnTextField(JTextField returnTextField) {
		this.returnTextField = returnTextField;
	}

	public JLabel getResultLabel() {
		return resultLabel;
	}

	public void setResultLabel(JLabel resultLabel) {
		this.resultLabel = resultLabel;
	}
}
