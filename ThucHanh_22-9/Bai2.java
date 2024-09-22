import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai2 extends JFrame implements ActionListener, KeyListener {
    private JTextField textA, textB, textKetQua;
    private JButton btnThucHien, btnTiepTuc, btnThoat;
    private boolean daTinhKQ = false; // Biến kiểm tra đã tính kết quả hay chưa

    public Bai2() {
        // Cấu hình Frame
        setTitle("Giải Phương Trình Bậc 1");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tạo panel chính sử dụng GridBagLayout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Các thành phần
        JLabel labelA = new JLabel("Nhập a: ");
        textA = new JTextField(20); // Đặt số ký tự trong JTextField
        textA.addKeyListener(this);

        JLabel labelB = new JLabel("Nhập b: ");
        textB = new JTextField(20); // Đặt số ký tự trong JTextField
        textB.addKeyListener(this);

        JLabel labelKetQua = new JLabel("Kết quả: ");
        textKetQua = new JTextField(20);
        textKetQua.setEditable(false);

        // Sử dụng GridBagConstraints để sắp xếp các thành phần
        gbc.insets = new Insets(5, 5, 5, 5); // Khoảng cách giữa các thành phần
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nhập a
        gbc.gridx = 0; gbc.gridy = 0; // Cột 0, dòng 0
        inputPanel.add(labelA, gbc);

        gbc.gridx = 1; gbc.gridy = 0; // Cột 1, dòng 0
        inputPanel.add(textA, gbc);

        // Nhập b
        gbc.gridx = 0; gbc.gridy = 1; // Cột 0, dòng 1
        inputPanel.add(labelB, gbc);

        gbc.gridx = 1; gbc.gridy = 1; // Cột 1, dòng 1
        inputPanel.add(textB, gbc);

        // Kết quả
        gbc.gridx = 0; gbc.gridy = 2; // Cột 0, dòng 2
        inputPanel.add(labelKetQua, gbc);

        gbc.gridx = 1; gbc.gridy = 2; // Cột 1, dòng 2
        inputPanel.add(textKetQua, gbc);

        // Thêm inputPanel vào BorderLayout.CENTER
        add(inputPanel, BorderLayout.CENTER);

        // Tạo panel chứa các nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnThucHien = new JButton("Thực hiện");
        btnTiepTuc = new JButton("Tiếp tục");
        btnThoat = new JButton("Thoát");

        // Đăng ký sự kiện cho các nút
        btnThucHien.addActionListener(this);
        btnTiepTuc.addActionListener(this);
        btnThoat.addActionListener(this);

        // Thêm các nút vào buttonPanel
        buttonPanel.add(btnThucHien);
        buttonPanel.add(btnTiepTuc);
        buttonPanel.add(btnThoat);

        // Thêm buttonPanel vào phía dưới của BorderLayout
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Đặt cửa sổ ở giữa màn hình
        setLocationRelativeTo(null);

        // Hiển thị Frame
        setVisible(true);
    }

    private void tinhKetQua() {
        try {
            double a = Double.parseDouble(textA.getText());
            double b = Double.parseDouble(textB.getText());

            if (a == 0) {
                if (b == 0) {
                    textKetQua.setText("PT vô số nghiệm");
                } else {
                    textKetQua.setText("PT vô nghiệm");
                }
            } else {
                double nghiem = -b / a;
                textKetQua.setText("x = " + nghiem);
            }
            daTinhKQ = true; // Đánh dấu đã tính kết quả
        } catch (NumberFormatException ex) {
            textKetQua.setText("Vui lòng nhập số hợp lệ");
        }
    }

    private void batDauLai() {
        textA.setText("");
        textB.setText("");
        textKetQua.setText("");
        textA.requestFocus();
        daTinhKQ = false; // Đánh dấu chưa tính kết quả
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThucHien) {
            tinhKetQua(); // Tính kết quả khi nhấn nút Thực hiện
        } else if (e.getSource() == btnTiepTuc) {
            batDauLai(); // Bắt đầu lại khi nhấn nút Tiếp tục
        } else if (e.getSource() == btnThoat) {
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!daTinhKQ) {
                // Nếu chưa tính kết quả, chuyển focus
                if (e.getSource() == textA) {
                    textB.requestFocus();
                } else if (e.getSource() == textB) {
                    tinhKetQua(); // Tính kết quả khi nhấn Enter ở textB
                }
            } else {
                // Nếu đã tính kết quả, bắt đầu lại
                batDauLai();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    public static void main(String[] args) {
        new Bai2();
    }
}
