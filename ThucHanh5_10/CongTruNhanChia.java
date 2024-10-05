import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CongTruNhanChia extends JFrame {
    // Declare components
    private JTextField txtSoA, txtSoB, txtKetQua;
    private JRadioButton rbtnCong, rbtnTru, rbtnNhan, rbtnChia;
    private JButton btnGiai, btnXoa, btnThoat;
    
    // Constructor
    public CongTruNhanChia() {
        // Set up the frame
        setTitle("Cộng - Trừ - Nhân - Chia");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Title Label (North)
        JLabel lblTieuDe = new JLabel("Cộng Trừ Nhân Chia", JLabel.CENTER);
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
        lblTieuDe.setForeground(Color.BLUE);
        add(lblTieuDe, BorderLayout.NORTH);

        // Left panel for buttons
        JPanel panelButtons = new JPanel(new GridLayout(3, 1, 10, 10));
        panelButtons.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 2), "Chọn tác vụ"));
        
        btnGiai = new JButton("Giải");
        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");
        
        panelButtons.add(btnGiai);
        panelButtons.add(btnXoa);
        panelButtons.add(btnThoat);
        
        add(panelButtons, BorderLayout.WEST);
        
        // Center panel for inputs and radio buttons
        JPanel panelCenter = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        panelCenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "nhập 2 số a và b:"));

        // Input fields and labels
        JLabel lblSoA = new JLabel("nhập a:");
        JLabel lblSoB = new JLabel("nhập b:");
        JLabel lblKetQua = new JLabel("Kết quả:");

        txtSoA = new JTextField(10);
        txtSoB = new JTextField(10);
        txtKetQua = new JTextField(15);
        txtKetQua.setEditable(false); // Result field should not be editable

        // Positioning components
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelCenter.add(lblSoA, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panelCenter.add(txtSoA, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        panelCenter.add(lblSoB, gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST;
        panelCenter.add(txtSoB, gbc);

        // Radio buttons for operations
        JPanel panelRadio = new JPanel(new GridLayout(2, 2));
        panelRadio.setBorder(BorderFactory.createTitledBorder("Chọn phép toán:"));

        rbtnCong = new JRadioButton("Cộng");
        rbtnTru = new JRadioButton("Trừ");
        rbtnNhan = new JRadioButton("Nhân");
        rbtnChia = new JRadioButton("Chia");

        ButtonGroup group = new ButtonGroup();
        group.add(rbtnCong);
        group.add(rbtnTru);
        group.add(rbtnNhan);
        group.add(rbtnChia);

        panelRadio.add(rbtnCong);
        panelRadio.add(rbtnTru);
        panelRadio.add(rbtnNhan);
        panelRadio.add(rbtnChia);

        gbc.gridx = 1; gbc.gridy = 2;
        panelCenter.add(panelRadio, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        panelCenter.add(lblKetQua, gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.WEST;
        panelCenter.add(txtKetQua, gbc);

        add(panelCenter, BorderLayout.CENTER);

        // Button listeners
        btnGiai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
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

    // Method to calculate the result based on selected operation
    private void calculateResult() {
        try {
            double a = Double.parseDouble(txtSoA.getText());
            double b = Double.parseDouble(txtSoB.getText());

            double result = 0;

            if (rbtnCong.isSelected()) {
                result = a + b;
            } else if (rbtnTru.isSelected()) {
                result = a - b;
            } else if (rbtnNhan.isSelected()) {
                result = a * b;
            } else if (rbtnChia.isSelected()) {
                if (b != 0) {
                    result = a / b;
                } else {
                    txtKetQua.setText("Không thể chia cho 0!");
                    return;
                }
            } else {
                txtKetQua.setText("Vui lòng chọn phép toán!");
                return;
            }

            txtKetQua.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            txtKetQua.setText("Vui lòng nhập số hợp lệ!");
        }
    }

    // Method to clear the text fields
    private void clearFields() {
        txtSoA.setText("");
        txtSoB.setText("");
        txtKetQua.setText("");
        rbtnCong.setSelected(false);
        rbtnTru.setSelected(false);
        rbtnNhan.setSelected(false);
        rbtnChia.setSelected(false);
    }

    // Main method to run the program
    public static void main(String[] args) {
        CongTruNhanChia frame = new CongTruNhanChia();
        frame.setVisible(true);
    }
}
