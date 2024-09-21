import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen duong n: ");
        int n = scanner.nextInt();

        // Nhập số nguyên dương n với kiểm tra hợp lệ
        while (n < 1) {
            System.out.println("Vui long nhap lai. Hay nhap 1 so nguyen duong.");
            System.out.print("Nhap so nguyen duong n: ");
            n = scanner.nextInt();
        }

        // Tính tổng S
        double tongS = tinhTongS(n);
        System.out.printf("Tong S = 1 + 1/2^2 + 1/3^2 + ... + 1/%d^2 = %.5f%n", n, tongS);

        scanner.close();
    }

    // Hàm tính tổng S
    public static double tinhTongS(int n) {
        double ketQua = 0.0;
        for (int i = 1; i <= n; i++) {
            ketQua += 1.0 / (i * i);
        }
        return ketQua;
    }
}

