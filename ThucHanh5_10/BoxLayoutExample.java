import javax.swing.*;
import java.awt.*;

public class BoxLayoutExample {

    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("BoxLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Tạo JPanel chính với BoxLayout theo Y_AXIS (chiều dọc)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        // Tạo JPanel phụ để thêm các control theo chiều ngang (X_AXIS)
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.add(new JButton("Button 1"));
        panel1.add(new JButton("Button 2"));
        
        // Thêm panel1 vào JPanel chính
        mainPanel.add(panel1);
        
        // Tạo thêm JPanel khác để add các control theo X_AXIS
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(new JLabel("Label 1"));
        panel2.add(new JTextField(10));  // TextField dài 10 cột
        
        // Thêm panel2 vào JPanel chính
        mainPanel.add(panel2);
        
        // Thêm JPanel chính vào JFrame
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
