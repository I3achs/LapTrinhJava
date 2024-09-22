import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Bai5 extends JFrame implements ActionListener {
    private JTextField textSoPhanTu, textPhanTu, textMangDaNhap, textTong, textMangSapXep;
    private JButton btnNhap, btnThucHien, btnXoa, btnThoat;
    private int[] mang;
    private int count = 0; // Đếm số phần tử đã nhập
    private int soPhanTu = 0;

    public Bai5() {
        // Cấu hình Frame
        setTitle("Quản Lý Mảng");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Tạo các thành phần
        JLabel lblSoPhanTu = new JLabel("Nhập số phần tử mảng:");
        textSoPhanTu = new JTextField(10);
        JLabel lblPhanTu = new JLabel("Nhập phần tử:");
        textPhanTu = new JTextField(10);
        JLabel lblMangDaNhap = new JLabel("Mảng đã nhập:");
        textMangDaNhap = new JTextField(10);
        textMangDaNhap.setEditable(false);
        JLabel lblTong = new JLabel("Tổng các phần tử:");
        textTong = new JTextField(10);
        textTong.setEditable(false);
        JLabel lblMangSapXep = new JLabel("Mảng sắp xếp:");
        textMangSapXep = new JTextField(10);
        textMangSapXep.setEditable(false);

        // Tạo các nút
        btnNhap = new JButton("Nhập");
        btnThucHien = new JButton("Thực hiện");
        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");

        // Đăng ký sự kiện
        btnNhap.addActionListener(this);
        btnThucHien.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);

        // Thêm các thành phần vào Frame
        add(lblSoPhanTu);
        add(textSoPhanTu);
        add(lblPhanTu);
        add(textPhanTu);
        add(lblMangDaNhap);
        add(textMangDaNhap);
        add(lblTong);
        add(textTong);
        add(lblMangSapXep);
        add(textMangSapXep);
        add(btnNhap);
        add(btnThucHien);
        add(btnXoa);
        add(btnThoat);

        // Đặt cửa sổ ở giữa màn hình
        setLocationRelativeTo(null);

        // Hiển thị Frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNhap) {
            // Xử lý nhập phần tử vào mảng
            try {
                if (soPhanTu == 0) {
                    soPhanTu = Integer.parseInt(textSoPhanTu.getText());
                    mang = new int[soPhanTu];
                }
                
                if (count < soPhanTu) {
                    int phanTu = Integer.parseInt(textPhanTu.getText());
                    mang[count] = phanTu;
                    count++;

                    // Hiển thị mảng đã nhập
                    textMangDaNhap.setText(Arrays.toString(Arrays.copyOf(mang, count)));
                    textPhanTu.setText(""); // Xóa textfield phần tử sau khi nhập
                }

                if (count == soPhanTu) {
                    JOptionPane.showMessageDialog(this, "Đã nhập đủ số phần tử.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ.");
            }

        } else if (e.getSource() == btnThucHien) {
            // Xử lý tính tổng và sắp xếp mảng
            if (count == soPhanTu) {
                int tong = 0;
                for (int value : mang) {
                    tong += value;
                }
                textTong.setText(String.valueOf(tong));

                // Sắp xếp mảng giảm dần
                Arrays.sort(mang);
                int[] mangGiamDan = new int[soPhanTu];
                for (int i = 0; i < soPhanTu; i++) {
                    mangGiamDan[i] = mang[soPhanTu - i - 1];
                }

                textMangSapXep.setText(Arrays.toString(mangGiamDan));
            } else {
                JOptionPane.showMessageDialog(this, "Chưa nhập đủ số phần tử.");
            }

        } else if (e.getSource() == btnXoa) {
            // Xóa dữ liệu
            textSoPhanTu.setText("");
            textPhanTu.setText("");
            textMangDaNhap.setText("");
            textTong.setText("");
            textMangSapXep.setText("");
            soPhanTu = 0;
            count = 0;
            mang = null;

        } else if (e.getSource() == btnThoat) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Bai5();
    }
}
