import java.util.Scanner;
class Point {
    protected int x;
    protected int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int xValue, int yValue) {
        this.x = xValue;
        this.y = yValue;
    }

    public void setX(int xValue) {
        this.x = xValue;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int yValue) {
        this.y = yValue;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "[" + this.x + "," + this.y + "]";
    }
}

class Circle extends Point {
    private double radius;

    public Circle() {
        super();
        this.radius = 1.0;
    }

    public Circle(int xValue, int yValue, double radiusValue) {
        super(xValue, yValue);
        this.radius = radiusValue;
    }

    public void setRadius(double radiusValue) {
        if (radiusValue >= 0) {
            this.radius = radiusValue;
        } else {
            System.out.println("Ban kinh khong the la so am.");
        }
    }

    public double getRadius() {
        return this.radius;
    }

    public double getDiameter() {
        return 2 * this.radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString() {
        return super.toString() + " Ban kinh: " + this.radius;
    }
}

public class Bai6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong hinh tron: ");
        int n = scanner.nextInt();
        Circle[] circles = new Circle[n];

        // Gọi hàm nhập thông tin các hình tròn
        nhap(circles, scanner);

        // Xuất thông tin của mỗi hình tròn
        for (Circle circle : circles) {
            System.out.printf("Hinh tron tai %s co ''duong kinh: %.2f, ''chu vi: %.2f, 'dien tich': %.2f%n",
                    circle.toString(), circle.getDiameter(), circle.getCircumference(), circle.getArea());
        }

        scanner.close();
    }

    public static void nhap(Circle[] circles, Scanner scanner) {
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Nhap thong tni cho duong tron " + (i + 1) + ":");

            System.out.print("x: ");
            int x = scanner.nextInt();

            System.out.print("y: ");
            int y = scanner.nextInt();

            System.out.print("Ban kinh: ");
            double banKinh = scanner.nextDouble();

            // Khởi tạo đối tượng Circle với các giá trị vừa nhập
            circles[i] = new Circle(x, y, banKinh);
        }
    }
}
