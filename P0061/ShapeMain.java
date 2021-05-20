package P0061;

public class ShapeMain {
    public static void main(String[] args) {
        String option = "Y";
        while (option.equals("Y")) {
            System.out.println("Please input side width of Rectangle:");
            double width = Validation.checkDouble(Validation.sc.next());
            System.out.println("Please input length of Rectangle:");
            double length = Validation.checkDouble(Validation.sc.next());

            System.out.println("Please input radius of Circle:");
            double radius = Validation.checkDouble(Validation.sc.next());

            System.out.println("Please input side A of Triangle:");
            double sideA = Validation.checkDouble(Validation.sc.next());
            System.out.println("Please input side B of Triangle:");
            double sideB = Validation.checkDouble(Validation.sc.next());
            System.out.println("Please input side C of Triangle:");
            double sideC = Validation.checkDouble(Validation.sc.next());

            Rectangle rectangle = new Rectangle(width, length);
            rectangle.printResult();

            Circle circle = new Circle(radius);
            circle.printResult();

            if (Validation.checkTriangle(sideA, sideB, sideC)) {
                Triangle triangle = new Triangle(sideA, sideB, sideC);
                triangle.printResult();
            } else
                System.out.println("Invalid triangle");
            System.out.print("Do you want to continue? (Y/N): ");
            option = Validation.sc.next();
        }
    }
}
