import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaiPhuongTrinhBac2 extends JFrame {
    // Declare components
    private JTextField txtSoA, txtSoB, txtSoC;
    private JTextArea txtKetqua;
    private JButton btnGiai, btnXoa, btnThoat;

    // Constructor
    public GiaiPhuongTrinhBac2() {
        // Set up the frame
        setTitle("Giải phương trình bậc 2");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Title Label (North)
        JLabel lblTieuDe = new JLabel("Giải phương trình bậc 2", JLabel.CENTER);
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
        lblTieuDe.setForeground(Color.BLUE);
        add(lblTieuDe, BorderLayout.NORTH);

        // Center panel for inputs and result
        JPanel panelCenter = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        panelCenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "Nhập a, b, c:"));

        // Input fields and labels
        JLabel lblSoA = new JLabel("a:");
        JLabel lblSoB = new JLabel("b:");
        JLabel lblSoC = new JLabel("c:");
        JLabel lblKetQua = new JLabel("Kết quả:");

        txtSoA = new JTextField(10);
        txtSoB = new JTextField(10);
        txtSoC = new JTextField(10);
        txtKetqua = new JTextArea(3, 20); // Create a JTextArea for result display
        txtKetqua.setLineWrap(true); // Enable word wrap
        txtKetqua.setWrapStyleWord(true); // Wrap on word boundaries
        txtKetqua.setEditable(false); // Result field should not be editable

        JScrollPane scrollPane = new JScrollPane(txtKetqua); // Add scroll pane for the text area
        scrollPane.setPreferredSize(new Dimension(250, 60)); // Adjust the size of the scroll pane

        // Positioning components
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelCenter.add(lblSoA, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panelCenter.add(txtSoA, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        panelCenter.add(lblSoB, gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST;
        panelCenter.add(txtSoB, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        panelCenter.add(lblSoC, gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.anchor = GridBagConstraints.WEST;
        panelCenter.add(txtSoC, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        panelCenter.add(lblKetQua, gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        panelCenter.add(scrollPane, gbc);

        add(panelCenter, BorderLayout.CENTER);

        // Panel for buttons (SOUTH)
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelButtons.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 2), "Chọn tác vụ"));

        btnGiai = new JButton("Giải");
        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");

        panelButtons.add(btnGiai);
        panelButtons.add(btnXoa);
        panelButtons.add(btnThoat);

        add(panelButtons, BorderLayout.SOUTH); // Add buttons panel to the bottom

        // Button listeners
        btnGiai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveEquation();
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });
    }

    // Method to solve the quadratic equation
    private void solveEquation() {
        try {
            double a = Double.parseDouble(txtSoA.getText());
            double b = Double.parseDouble(txtSoB.getText());
            double c = Double.parseDouble(txtSoC.getText());

            if (a == 0) {
                txtKetqua.setText("Đây không phải là phương trình bậc 2.");
                return;
            }

            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                txtKetqua.setText("Phương trình vô nghiệm.");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                txtKetqua.setText("Phương trình có nghiệm kép: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                txtKetqua.setText("Phương trình có 2 nghiệm phân biệt:\nx1 = " + x1 + "\nx2 = " + x2);
            }
        } catch (NumberFormatException e) {
            txtKetqua.setText("Vui lòng nhập các giá trị hợp lệ.");
        }
    }

    // Method to clear the text fields
    private void clearFields() {
        txtSoA.setText("");
        txtSoB.setText("");
        txtSoC.setText("");
        txtKetqua.setText("");
    }

    // Main method to run the program
    public static void main(String[] args) {
        GiaiPhuongTrinhBac2 frame = new GiaiPhuongTrinhBac2();
        frame.setVisible(true);
    }
}
