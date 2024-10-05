import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {

    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Thiết lập BorderLayout cho JFrame
        frame.setLayout(new BorderLayout());
        
        // Tạo các thành phần (component)
        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton westButton = new JButton("West");
        JButton eastButton = new JButton("East");
        
        // Thêm JTable vào JScrollPane để đưa vào vùng Center
        String[][] data = {
            {"1", "John", "Doe"},
            {"2", "Jane", "Roe"},
            {"3", "Jim", "Beam"}
        };
        String[] columnNames = {"ID", "First Name", "Last Name"};
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Thêm các thành phần vào các vùng của BorderLayout
        frame.add(northButton, BorderLayout.NORTH);
        frame.add(southButton, BorderLayout.SOUTH);
        frame.add(westButton, BorderLayout.WEST);
        frame.add(eastButton, BorderLayout.EAST);
        frame.add(scrollPane, BorderLayout.CENTER); // Table sẽ tự động co giãn
        
        frame.setLocationRelativeTo(null);
        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
