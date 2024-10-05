import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome1 extends JFrame {
    private JTextField FullName;  // Field for entering full name
    private JRadioButton Mr, Mss;  // Radio buttons for prefix selection
    private JButton Welcome, Clear, Cancel;  // Buttons for actions
    private JTextField resultField;  // JTextField to display results

    // Constructor
    public Welcome1() {
        // Set up frame
        setTitle("Welcome!");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Center panel for input and radio buttons
        JPanel panelCenter = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Full name input field
        JLabel lblName = new JLabel("Full name:");
        FullName = new JTextField(20);
        JLabel lblResult = new JLabel("Result: ");
        resultField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0; panelCenter.add(lblName, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panelCenter.add(FullName, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panelCenter.add(lblResult, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panelCenter.add(resultField, gbc);

        // Radio buttons panel
        JPanel panelRadio = new JPanel(new GridLayout(1, 2));
        panelRadio.setBorder(BorderFactory.createTitledBorder("Chọn xưng hô:"));

        Mr = new JRadioButton("Mr. ");
        Mss = new JRadioButton("Mss. ");

        ButtonGroup group = new ButtonGroup();
        group.add(Mr);
        group.add(Mss);

        panelRadio.add(Mr);
        panelRadio.add(Mss);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; // Span two columns
        panelCenter.add(panelRadio, gbc);

        add(panelCenter, BorderLayout.CENTER);

        // Buttons panel at the bottom
        JPanel panelButtons = new JPanel(new GridLayout(1, 3, 10, 10));
        Welcome = new JButton("Welcome");
        Clear = new JButton("Clear");
        Cancel = new JButton("Cancel");

        panelButtons.add(Welcome);
        panelButtons.add(Clear);
        panelButtons.add(Cancel);

        add(panelButtons, BorderLayout.SOUTH); // Add buttons panel to the top

        // Action listeners for buttons
        Welcome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayResult();
            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the program
            }
        });
    }

    // Method to display the result in JTextField
    private void displayResult() {
        String name = FullName.getText().trim();
        String prefix = "";

        if (Mr.isSelected()) {
            prefix = "Mr. ";
        } else if (Mss.isSelected()) {
            prefix = "Mss. ";
        }

        if (!name.isEmpty() && !prefix.isEmpty()) {
            resultField.setText("Xin chào " + prefix + name + "!"); // Display greeting in JTextField
        } else {
            resultField.setText("Vui lòng nhập tên và chọn xưng hô."); // Display error message
        }
    }

    // Method to clear the fields
    private void clearFields() {
        FullName.setText("");
        Mr.setSelected(false);
        Mss.setSelected(false);
        resultField.setText(""); // Clear the JTextField
    }

    // Main method to run the program
    public static void main(String[] args) {
        Welcome1 frame = new Welcome1();
        frame.setVisible(true);
    }
}
