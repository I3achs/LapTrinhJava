import java.util.Scanner;

class HinhTamGiac {
    private int ma; // Cạnh a
    private int mb; // Cạnh b
    private int mc; // Cạnh c

    // Constructor mặc định
    public HinhTamGiac() {
        this.ma = 0;
        this.mb = 0;
        this.mc = 0;
    }

    // Constructor với 3 cạnh
    public HinhTamGiac(int a, int b, int c) {
        if (a < 0) {
            System.out.println("Canh a khong hop le. a = 0.");
            this.ma = 0;
        } else {
            this.ma = a;
        }
        if (b < 0) {
            System.out.println("Canh b khong hop le. b = 0.");
            this.mb = 0;
        } else {
            this.mb = b;
        }
        if (c < 0) {
            System.out.println("Canh c khong hop le. c = 0.");
            this.mc = 0;
        } else {
            this.mc = c;
        }

        if (!laTamGiac()) {
            System.out.println("Khong phai la hinh tam giac. Gan cac canh bang 0.");
            this.ma = 0;
            this.mb = 0;
            this.mc = 0;
        }
    }

    public int getCanhA() {
        return ma;
    }

    public void setCanhA(int v) {
        if (v > 0) {
            this.ma = v;
            if (!laTamGiac()) {
                System.out.println("Khong phai hinh tam giac sau khi gan canh a. Giu nguyen.");
                this.ma = 0;
            }
        } else {
            System.out.println("Canh a khong hop le.");
        }
    }

    public int getCanhB() {
        return mb;
    }

    public void setCanhB(int v) {
        if (v > 0) {
            this.mb = v;
            if (!laTamGiac()) {
                System.out.println("Khong phai hinh tam giac sau khi gan canh b. Giu nguyen.");
                this.mb = 0;
            }
        } else {
            System.out.println("Canh b khong hop le.");
        }
    }

    public int getCanhC() {
        return mc;
    }

    public void setCanhC(int v) {
        if (v > 0) {
            this.mc = v;
            if (!laTamGiac()) {
                System.out.println("Khong phai hinh tam giac sau khi gan canh c. Giu nguyen.");
                this.mc = 0;
            }
        } else {
            System.out.println("Canh c khong hop le.");
        }
    }

    public boolean laTamGiac() {
        return (ma + mb > mc) && (ma + mc > mb) && (mb + mc > ma);
    }

    public boolean laTamGiac(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public int getChuVi() {
        return ma + mb + mc;
    }

    public double getDienTich() {
        double p = getChuVi() / 2.0;
        return Math.sqrt(p * (p - ma) * (p - mb) * (p - mc));
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập ba cạnh
        System.out.print("Nhap canh a: ");
        int a = scanner.nextInt();
        System.out.print("Nhap canh b: ");
        int b = scanner.nextInt();
        System.out.print("Nhap canh c: ");
        int c = scanner.nextInt();

        // Khởi tạo hình tam giác
        HinhTamGiac hinhTamGiac = new HinhTamGiac(a, b, c);

        // Kiểm tra và xuất chu vi và diện tích
        if (hinhTamGiac.laTamGiac()) {
            System.out.println("Chu vi cua hing tam giac: " + hinhTamGiac.getChuVi());
            System.out.printf("Dien tich cau hinh tam giac: %.2f%n", hinhTamGiac.getDienTich());
        } else {
            System.out.println("Hinh tam giac khong hop le.");
        }

        scanner.close();
    }
}

