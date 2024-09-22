import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai1 extends JFrame implements ActionListener {
    private JButton blueButton;
    private JButton greenButton;
    private JButton helloButton;

    public Bai1() {
        // Set up the frame
        setTitle("Demo Button");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create buttons
        blueButton = new JButton("Blue");
        greenButton = new JButton("green");
        helloButton = new JButton("Hello");

        // Add action listeners to buttons
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);
        helloButton.addActionListener(this);

        // Add buttons to frame
        add(blueButton);
        add(greenButton);
        add(helloButton);
        
        // Đặt cửa sổ ở giữa màn hình
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == helloButton) {
            JOptionPane.showMessageDialog(this, "Hello!");
        } else if (event.getSource() == blueButton) {
            getContentPane().setBackground(Color.BLUE);
        } else if (event.getSource() == greenButton) {
            getContentPane().setBackground(Color.green);
        }
    }

    public static void main(String[] args) {
        // Run the GUI application
        new Bai1();
    }
}

