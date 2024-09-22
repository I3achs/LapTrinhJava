import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai3 extends JFrame implements ActionListener {
    private JTextField textN;
    private JLabel labelKq;

    public Bai3() {
        // Cấu hình Frame
        setTitle("Kiểm Tra Số Chính Phương");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Tạo các thành phần
        JLabel labelN = new JLabel("Nhập số nguyên n: ");
        textN = new JTextField(10);
        JButton btnKiemTra = new JButton("Kiểm tra SCP");
        labelKq = new JLabel(""); // Label để hiển thị kết quả

        // Đăng ký sự kiện cho nút
        btnKiemTra.addActionListener(this);

        // Thêm các thành phần vào Frame
        add(labelN);
        add(textN);
        add(btnKiemTra);
        add(labelKq);
        
        // Đặt cửa sổ ở giữa màn hình
        setLocationRelativeTo(null);

        // Hiển thị Frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(textN.getText());
            if (n < 0) {
                labelKq.setText("Số không thể âm!");
                return;
            }
            int sqrt = (int) Math.sqrt(n);
            if (sqrt * sqrt == n) {
                labelKq.setText(n + " là số chính phương.");
            } else {
                labelKq.setText(n + " không phải là số chính phương.");
            }
        } catch (NumberFormatException ex) {
            labelKq.setText("Vui lòng nhập số nguyên hợp lệ.");
        }
    }

    public static void main(String[] args) {
        new Bai3();
    }
}
