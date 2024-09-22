import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Bai4 extends JFrame {
    private JTextField txtParam1, txtParam2, txtResult;
    private JRadioButton rbtnSquare, rbtnRectangle, rbtnCircle;
    private ButtonGroup shapeGroup;
    private JButton btnCalculate, btnClear, btnExit;

    public Bai4() {
        // Tạo tiêu đề cho cửa sổ
        setTitle("Tính chu vi và diện tích hình học");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10)); // Thêm khoảng cách giữa các phần

        // Panel chứa các trường nhập liệu và kết quả
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Khoảng cách giữa các thành phần
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Các ô nhập liệu
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(new JLabel("Tham số 1:"), gbc);
        gbc.gridx = 1;
        txtParam1 = new JTextField(10);
        centerPanel.add(txtParam1, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        centerPanel.add(new JLabel("Tham số 2 (nếu cần):"), gbc);
        gbc.gridx = 1;
        txtParam2 = new JTextField(10);
        centerPanel.add(txtParam2, gbc);

        // Ô hiển thị kết quả với kích thước lớn hơn
        gbc.gridy++;
        gbc.gridx = 0;
        centerPanel.add(new JLabel("Kết quả:"), gbc);
        gbc.gridx = 1;
        txtResult = new JTextField(20);  // Tăng kích thước ô kết quả
        txtResult.setEditable(false);
        centerPanel.add(txtResult, gbc);

        // Panel chứa các RadioButton bên phải
        JPanel rightPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        rbtnSquare = new JRadioButton("Hình vuông");
        rbtnRectangle = new JRadioButton("Hình chữ nhật");
        rbtnCircle = new JRadioButton("Hình tròn");

        shapeGroup = new ButtonGroup();
        shapeGroup.add(rbtnSquare);
        shapeGroup.add(rbtnRectangle);
        shapeGroup.add(rbtnCircle);

        rightPanel.add(rbtnSquare);
        rightPanel.add(rbtnRectangle);
        rightPanel.add(rbtnCircle);

        // Panel chứa các nút hành động bên dưới
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnCalculate = new JButton("Thực hiện");
        btnClear = new JButton("Xóa");
        btnExit = new JButton("Thoát");

        bottomPanel.add(btnCalculate);
        bottomPanel.add(btnClear);
        bottomPanel.add(btnExit);

        // Thêm các panel vào cửa sổ chính
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        // Xử lý sự kiện cho các nút
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void calculate() {
        try {
            DecimalFormat df = new DecimalFormat("#.##"); // Chỉ hiển thị 2 chữ số sau dấu phẩy
            if (rbtnSquare.isSelected()) {
                double side = Double.parseDouble(txtParam1.getText());
                double perimeter = 4 * side;
                double area = side * side;
                txtResult.setText("Chu vi: " + df.format(perimeter) + ", Diện tích: " + df.format(area));
            } else if (rbtnRectangle.isSelected()) {
                double length = Double.parseDouble(txtParam1.getText());
                double width = Double.parseDouble(txtParam2.getText());
                double perimeter = 2 * (length + width);
                double area = length * width;
                txtResult.setText("Chu vi: " + df.format(perimeter) + ", Diện tích: " + df.format(area));
            } else if (rbtnCircle.isSelected()) {
                double radius = Double.parseDouble(txtParam1.getText());
                double perimeter = 2 * Math.PI * radius;
                double area = Math.PI * radius * radius;
                txtResult.setText("Chu vi: " + df.format(perimeter) + ", Diện tích: " + df.format(area));
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một loại hình khối.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ.");
        }
    }

    private void clearFields() {
        txtParam1.setText("");
        txtParam2.setText("");
        txtResult.setText("");
        shapeGroup.clearSelection();
    }

    public static void main(String[] args) {
        Bai4 frame = new Bai4();
        frame.setVisible(true);
    }
}
