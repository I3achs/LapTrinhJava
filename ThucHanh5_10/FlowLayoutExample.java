import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlowLayoutExample {

    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Change Background Color");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        // Thiết lập FlowLayout cho JFrame
        frame.setLayout(new FlowLayout());
        
        // Tạo 5 JButton với các tên và màu sắc khác nhau
        JButton redButton = new JButton("Red");
        JButton greenButton = new JButton("Green");
        JButton blueButton = new JButton("Blue");
        JButton yellowButton = new JButton("Yellow");
        JButton grayButton = new JButton("Gray");
        
        // Thêm các nút vào JFrame
        frame.add(redButton);
        frame.add(greenButton);
        frame.add(blueButton);
        frame.add(yellowButton);
        frame.add(grayButton);
        
        // Xử lý sự kiện khi nhấn các nút để thay đổi màu nền của JFrame
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.RED);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.GREEN);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.BLUE);
            }
        });

        yellowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.YELLOW);
            }
        });

        grayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.GRAY);
            }
        });
        
        frame.setLocationRelativeTo(null);
        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
