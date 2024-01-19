package entities.all;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaCalculatorApp extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField widthTextField;
    private JTextField heightTextField;
    private JLabel resultLabel;

    public AreaCalculatorApp() {
        setTitle("Area Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        widthTextField = new JTextField(10);
        heightTextField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Area: ");

        // Set layout
        setLayout(new GridLayout(4, 1));

        // Add components to the frame
        add(new JLabel("Width: "));
        add(widthTextField);
        add(new JLabel("Height: "));
        add(heightTextField);
        add(calculateButton);
        add(resultLabel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateArea();
            }
        });
    }

    private void calculateArea() {
        try {
            double width = Double.parseDouble(widthTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());
            double area = width * height;
            resultLabel.setText("Area: " + area);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AreaCalculatorApp().setVisible(true);
            }
        });
    }
}
