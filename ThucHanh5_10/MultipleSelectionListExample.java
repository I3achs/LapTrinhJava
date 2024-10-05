import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultipleSelectionListExample {

    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Multiple Selection Lists");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new FlowLayout());

        // Tạo danh sách trái (JList) với các màu
        String[] colors = {"Black", "Blue", "Cyan", "Dark Gray", "Gray"};
        JList<String> leftList = new JList<>(colors);
        leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);  // Cho phép chọn nhiều mục
        JScrollPane leftScrollPane = new JScrollPane(leftList); // Thêm JList vào JScrollPane

        // Tạo danh sách phải (JList) rỗng
        DefaultListModel<String> rightListModel = new DefaultListModel<>();
        JList<String> rightList = new JList<>(rightListModel);
        JScrollPane rightScrollPane = new JScrollPane(rightList);

        // Tạo nút "Copy >>>"
        JButton copyButton = new JButton("Copy >>>");

        // Xử lý sự kiện khi nhấn nút "Copy"
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy các mục được chọn từ danh sách trái
                java.util.List<String> selectedValues = leftList.getSelectedValuesList();
                
                // Thêm các mục vào danh sách phải
                for (String value : selectedValues) {
                    if (!rightListModel.contains(value)) {  // Tránh trùng lặp
                        rightListModel.addElement(value);
                    }
                }
            }
        });

        // Thêm các thành phần vào JFrame
        frame.add(leftScrollPane);
        frame.add(copyButton);
        frame.add(rightScrollPane);

        frame.setLocationRelativeTo(null);
        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
