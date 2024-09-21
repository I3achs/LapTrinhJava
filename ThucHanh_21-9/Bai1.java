import java.util.Scanner;

public class Bai1 {
    // Hàm tìm UCLN
    public static int ucln(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // Hàm tìm BCNN
    public static int bcnn(int a, int b) {
        return (a * b) / ucln(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập 2 số a và b
        System.out.print("Nhap so a: ");
        int a = scanner.nextInt();
        System.out.print("Nhap so b: ");
        int b = scanner.nextInt();

        // Tính UCLN và BCNN
        int uclnValue = ucln(a, b);
        int bcnnValue = bcnn(a, b);

        // In kết quả
        System.out.println("UCLN cua " + a + " va " + b + " la: " + uclnValue);
        System.out.println("BCNN cua " + a + " va " + b + " la: " + bcnnValue);
        
        scanner.close();
    }
}

