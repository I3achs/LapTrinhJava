import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên dương n
        System.out.print("Nhap so nguyen duong n: ");
        int n = scanner.nextInt();

        // Nhập số nguyên dương n với kiểm tra hợp lệ
        while (n < 0) {
            System.out.println("Vui long nhap lai. Hay nhap 1 so nguyen duong.");
            System.out.print("Nhap so nguyen duong n: ");
            n = scanner.nextInt();
        }

        // Tính giai thừa
        long giaiThua = tinhGiaiThua(n);
        System.out.println(n + "! = " + giaiThua);

        scanner.close();
    }

    // Hàm tính giai thừa
    public static long tinhGiaiThua(int n) {
        long ketQua = 1;
        for (int i = 1; i <= n; i++) {
            ketQua *= i;
        }
        return ketQua;
    }
}

