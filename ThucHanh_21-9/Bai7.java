import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DatPhong {
    private String tenKhach;
    private String diaChi;
    private int soNgay;
    private String loaiPhong;
    private boolean karaoke;
    private boolean anSang;
    private boolean tv;
    private boolean internet;
    private boolean mayNuocNong;

    private static final int GIA_PHONG_DON = 300000;
    private static final int GIA_PHONG_DOI = 350000;
    private static final int GIA_PHONG_BA = 400000;

    private static final int GIA_KARAOKE = 50000;
    private static final int GIA_AN_SANG = 15000;
    private static final int GIA_TV = 10000;
    private static final int GIA_INTERNET = 10000;
    private static final int GIA_MAY_NUOC_NONG = 10000;

    public DatPhong(String tenKhach, String diaChi, int soNgay, String loaiPhong,
                    boolean karaoke, boolean anSang, boolean tv, boolean internet, boolean mayNuocNong) {
        this.tenKhach = tenKhach;
        this.diaChi = diaChi;
        this.soNgay = soNgay;
        this.loaiPhong = loaiPhong;
        this.karaoke = karaoke;
        this.anSang = anSang;
        this.tv = tv;
        this.internet = internet;
        this.mayNuocNong = mayNuocNong;
    }

    public double tinhThanhTien() {
        int giaPhong = switch (loaiPhong.toLowerCase()) {
            case "phòng đơn" -> GIA_PHONG_DON;
            case "phòng đôi" -> GIA_PHONG_DOI;
            case "phòng ba" -> GIA_PHONG_BA;
            default -> 0;
        };

        double thanhTien = giaPhong * soNgay;
        if (karaoke) thanhTien += GIA_KARAOKE;
        if (anSang) thanhTien += GIA_AN_SANG * soNgay;
        if (tv) thanhTien += GIA_TV * soNgay;
        if (internet) thanhTien += GIA_INTERNET * soNgay;
        if (mayNuocNong) thanhTien += GIA_MAY_NUOC_NONG * soNgay;

        return thanhTien;
    }

    public String getThongTin() {
        return "Tên khách: " + tenKhach +
               "\nĐịa chỉ: " + diaChi +
               "\nSố ngày ở: " + soNgay +
               "\nLoại phòng: " + loaiPhong +
               "\nKaraoke: " + (karaoke ? "Có" : "Không") +
               "\nĂn sáng: " + (anSang ? "Có" : "Không") +
               "\nTV: " + (tv ? "Có" : "Không") +
               "\nInternet: " + (internet ? "Có" : "Không") +
               "\nMáy nước nóng: " + (mayNuocNong ? "Có" : "Không") +
               "\nThành tiền: " + String.format("%.0f", tinhThanhTien()) + "đ\n--------------------------";
    }
}

public class Bai7 extends JFrame {
    private JTextField tenKhachField, diaChiField, soNgayField;
    private JRadioButton phongDonButton, phongDoiButton, phongBaButton;
    private JCheckBox karaokeCheck, anSangCheck, tvCheck, internetCheck, mayNuocNongCheck;
    private JTextArea resultArea;
    private JButton submitButton;
    private ButtonGroup loaiPhongGroup;

    private double tongTien = 0;

    public Bai7() {
        setTitle("Quản Lý Khách Sạn");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        // Panel thông tin khách
        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
        tenKhachField = new JTextField(20);
        diaChiField = new JTextField(20);
        soNgayField = new JTextField(5);
        infoPanel.add(new JLabel("Tên khách:"));
        infoPanel.add(tenKhachField);
        infoPanel.add(new JLabel("Địa chỉ:"));
        infoPanel.add(diaChiField);
        infoPanel.add(new JLabel("Số ngày ở:"));
        infoPanel.add(soNgayField);

        // Panel loại phòng
        JPanel roomPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        roomPanel.setBorder(BorderFactory.createTitledBorder("Loại phòng"));
        phongDonButton = new JRadioButton("Phòng đơn");
        phongDoiButton = new JRadioButton("Phòng đôi");
        phongBaButton = new JRadioButton("Phòng ba");
        loaiPhongGroup = new ButtonGroup();
        loaiPhongGroup.add(phongDonButton);
        loaiPhongGroup.add(phongDoiButton);
        loaiPhongGroup.add(phongBaButton);
        roomPanel.add(phongDonButton);
        roomPanel.add(phongDoiButton);
        roomPanel.add(phongBaButton);

        // Panel tiện nghi
        JPanel facilitiesPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        facilitiesPanel.setBorder(BorderFactory.createTitledBorder("Tiện nghi"));
        tvCheck = new JCheckBox("TV");
        internetCheck = new JCheckBox("Internet");
        mayNuocNongCheck = new JCheckBox("Máy nước nóng");
        facilitiesPanel.add(tvCheck);
        facilitiesPanel.add(internetCheck);
        facilitiesPanel.add(mayNuocNongCheck);

        // Panel dịch vụ
        JPanel servicesPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        servicesPanel.setBorder(BorderFactory.createTitledBorder("Dịch vụ"));
        karaokeCheck = new JCheckBox("Karaoke");
        anSangCheck = new JCheckBox("Ăn sáng");
        servicesPanel.add(karaokeCheck);
        servicesPanel.add(anSangCheck);

        // Nút submit
        submitButton = new JButton("Nhập thông tin");

        // Khu vực kết quả
        resultArea = new JTextArea(15, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Thêm các panel vào mainPanel
        mainPanel.add(infoPanel);
        mainPanel.add(roomPanel);
        mainPanel.add(facilitiesPanel);
        mainPanel.add(servicesPanel);
        mainPanel.add(submitButton);
        
        // Thêm mainPanel và scrollPane vào JFrame
        add(mainPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Sự kiện khi nhấn nút submit
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenKhach = tenKhachField.getText();
                String diaChi = diaChiField.getText();
                int soNgay = Integer.parseInt(soNgayField.getText());
                String loaiPhong = "";

                if (phongDonButton.isSelected()) {
                    loaiPhong = "Phòng đơn";
                } else if (phongDoiButton.isSelected()) {
                    loaiPhong = "Phòng đôi";
                } else if (phongBaButton.isSelected()) {
                    loaiPhong = "Phòng ba";
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn loại phòng!");
                    return;
                }

                boolean karaoke = karaokeCheck.isSelected();
                boolean anSang = anSangCheck.isSelected();
                boolean tv = tvCheck.isSelected();
                boolean internet = internetCheck.isSelected();
                boolean mayNuocNong = mayNuocNongCheck.isSelected();

                DatPhong datPhong = new DatPhong(tenKhach, diaChi, soNgay, loaiPhong, karaoke, anSang, tv, internet, mayNuocNong);
                resultArea.append(datPhong.getThongTin());

                tongTien += datPhong.tinhThanhTien();

                // Reset input fields
                tenKhachField.setText("");
                diaChiField.setText("");
                soNgayField.setText("");
                loaiPhongGroup.clearSelection();
                karaokeCheck.setSelected(false);
                anSangCheck.setSelected(false);
                tvCheck.setSelected(false);
                internetCheck.setSelected(false);
                mayNuocNongCheck.setSelected(false);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Bai7();
    }
}



