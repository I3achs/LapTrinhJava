import java.util.Scanner;

public class Bai4 {
    private int[][] maTran;
    private int n; // Số hàng
    private int m; // Số cột

    // Hàm nhập ma trận
    public void nhapMaTran() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so hang n: ");
        n = scanner.nextInt();
        System.out.print("Nhap so cot m: ");
        m = scanner.nextInt();
        maTran = new int[n][m];

        System.out.println("Nhap cac phan tu cua ma tran:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("Nhap phan tu [%d][%d]: ", i, j);
                maTran[i][j] = scanner.nextInt();
            }
        }
    }

    // Hàm in ma trận
    public void inMaTran() {
        System.out.println("Ma tran vua nhap la:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", maTran[i][j]);
            }
            System.out.println();
        }
    }

    // Hàm tìm phần tử nhỏ nhất
    public int timPhanTuNhoNhat() {
        int min = maTran[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maTran[i][j] < min) {
                    min = maTran[i][j];
                }
            }
        }
        return min;
    }

    // Hàm tìm phần tử lẻ lớn nhất
    public int timPhanTuLeLonNhat() {
        int maxLe = Integer.MIN_VALUE;
        boolean foundOdd = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maTran[i][j] % 2 != 0) {
                    foundOdd = true;
                    if (maTran[i][j] > maxLe) {
                        maxLe = maTran[i][j];
                    }
                }
            }
        }
        return foundOdd ? maxLe : -1; // Trả về -1 nếu không tìm thấy số lẻ
    }

    // Hàm tìm hàng có tổng lớn nhất
    public int timHangTongLonNhat() {
        int maxTong = Integer.MIN_VALUE;
        int hangMax = -1;

        for (int i = 0; i < n; i++) {
            int tong = 0;
            for (int j = 0; j < m; j++) {
                tong += maTran[i][j];
            }
            if (tong > maxTong) {
                maxTong = tong;
                hangMax = i;
            }
        }
        return hangMax; // Trả về chỉ số hàng có tổng lớn nhất
    }

    public static void main(String[] args) {
        Bai4 mt = new Bai4();
        
        // Nhập ma trận
        mt.nhapMaTran();
        
        // In ma trận
        mt.inMaTran();
        
        // Tìm phần tử nhỏ nhất
        int min = mt.timPhanTuNhoNhat();
        System.out.println("Phan tu nho nhat: " + min);
        
        // Tìm phần tử lẻ lớn nhất
        int maxLe = mt.timPhanTuLeLonNhat();
        if (maxLe != -1) {
            System.out.println("Phan tu le lon nhat la: " + maxLe);
        } else {
            System.out.println("Ma tran khong co phan tu le.");
        }
        
        // Tìm hàng có tổng lớn nhất
        int hangMax = mt.timHangTongLonNhat();
        System.out.println("Hang co tong lon nhat la: " + hangMax);
    }
}

