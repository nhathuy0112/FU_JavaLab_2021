package P0061;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        if (width > length) {
            this.width = length;
            this.length = width;

        } else {
            this.width = width;
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void printResult() {
        System.out.println("----- Rectangle -----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.printf("Area: %.2f\n", getArea());
        System.out.printf("Perimeter: %.2f\n", getPerimeter());
    }

    public double getPerimeter() {
        return (width + length) * 2;
    }

    public double getArea() {
        return width * length;
    }
}
