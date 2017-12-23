import java.util.Scanner;

/**
 * <h1>Static Methods : Geometry</h1>
 * Methods are commonly used to break a problem down into small manageable pieces
 * This also allows for efficiencies, since the method can be called as many times as needed without rewriting the code each time.
 * <b>Note:</b> Giving proper comments in your program makes it more
 * user friendly and it is assumed as a high quality code.
 *
 * @author  Michael Dorfman
 * @version 1.0
 * @since   10/06/2017
 */

public class Geometry
{
    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args)
    {
        int choice;       // The user's choice
        double value = 0; // The method's return value
        char letter;      // The user's Y or N decision
        double radius;    // The radius of the circle
        double length;    // The length of the rectangle
        double width;     // The width of the rectangle
        double height;    // The height of the triangle
        double base;      // The base of the triangle
        double side1;     // The first side of the triangle
        double side2;     // The second side of the triangle
        double side3;     // The third side of the triangle

        // Create a scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // The do loop allows the menu to be displayed first
        do
        {
            // TASK #1 Call the printMenu method
            PrintMenu();
            choice = keyboard.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("Enter the radius of " +
                            "the circle: ");
                    radius = keyboard.nextDouble();

                    // TASK #3 Call the circleArea method and
                    // store the result in the value variable
                    value = CircleArea(radius);
                    System.out.println("The area of the " +
                            "circle is " + value);
                    break;
                case 2:
                    System.out.print("Enter the length of " +
                            "the rectangle: ");
                    length = keyboard.nextDouble();
                    System.out.print("Enter the width of " +
                            "the rectangle: ");
                    width = keyboard.nextDouble();

                    // TASK #3 Call the rectangleArea method and
                    // store the result in the value variable
                    value = RectangleArea(length, width);
                    System.out.println("The area of the " +
                            "rectangle is " + value);
                    break;
                case 3:
                    System.out.print("Enter the height of " +
                            "the triangle: ");
                    height = keyboard.nextDouble();
                    System.out.print("Enter the base of " +
                            "the triangle: ");
                    base = keyboard.nextDouble();

                    // TASK #3 Call the triangleArea method and
                    // store the result in the value variable
                    value = TriangleArea(base, height);
                    System.out.println("The area of the " +
                            "triangle is " + value);
                    break;
                case 4:
                    System.out.print("Enter the radius of " +
                            "the circle: ");
                    radius = keyboard.nextDouble();

                    // TASK #3 Call the circumference method and
                    // store the result in the value variable
                    value = CircleCircumference(radius);
                    System.out.println("The circumference " +
                            "of the circle is " +
                            value);
                    break;
                case 5:
                    System.out.print("Enter the length of " +
                            "the rectangle: ");
                    length = keyboard.nextDouble();
                    System.out.print("Enter the width of " +
                            "the rectangle: ");
                    width = keyboard.nextDouble();

                    // TASK #3 Call the perimeter method and
                    // store the result in the value variable
                    RectanglePerimeter(length, width);
                    System.out.println("The perimeter of " +
                            "the rectangle is " +
                            value);
                    break;
                case 6:
                    System.out.print("Enter the length of " +
                            "side 1 of the " +
                            "triangle: ");
                    side1 = keyboard.nextDouble();
                    System.out.print("Enter the length of " +
                            "side 2 of the " +
                            "triangle: ");
                    side2 = keyboard.nextDouble();
                    System.out.print("Enter the length of " +
                            "side 3 of the " +
                            "triangle: ");
                    side3 = keyboard.nextDouble();

                    // TASK #3 Call the perimeter method and
                    // store the result in the value variable
                    value = TrianglePerimeter(side1, side2, side3);
                    System.out.println("The perimeter of " +
                            "the triangle is " +
                            value);
                    break;
                default:
                    System.out.println("You did not enter " +
                            "a valid choice.");
            }
            keyboard.nextLine(); // Consume the new line

            System.out.println("Do you want to exit " +
                    "the program (Y/N)?: ");
            String answer = keyboard.nextLine();
            letter = answer.charAt(0);

        } while(letter != 'Y' && letter != 'y');
    }

    // TASK #1 Create the printMenu method here
    /**
     * This Method Prints Data to Screen
     */
    static public void PrintMenu()
    {
        System.out.println("This is a geometry calculator");
        System.out.println("Choose what you would like to calculate");
        System.out.println("1. Find the area of a circle");
        System.out.println("2. Find the area of a rectangle");
        System.out.println("3. Find the area of a triangle");
        System.out.println("4. Find the circumference of a circle");
        System.out.println("5. Find the perimeter of a rectangle");
        System.out.println("6. Find the perimeter of a triangle");
        System.out.println("Enter the number of your choice:");
    }
    // TASK #2 Create the value-returning methods here
    /**
     * circleArea that takes in the radius of the circle and returns the area
     * @param radius Circle Radius
     * @return Area of the Circle
     */
    static public double CircleArea(double radius)
    {
        return Math.PI * Math.pow(radius,2);
    }

    /**
     * rectangleArea that takes in the length and width of the rectangle and returns the area
     * @param length Length of the rectangle
     * @param width Width of the rectangle
     * @return Rectangle Area
     */
    static public double RectangleArea(double length, double width)
    {
        return length * width;
    }

    /**
     * triangleArea that takes in the base and height of the triangle and returns the area
     * @param base Base of the Triangle
     * @param height Height of the Triangle
     * @return The Triangle Area
     */
    static public double TriangleArea(double base, double height)
    {
        return (1/2) * base * height;
    }

    /**
     * circleCircumference that takes in the radius of the circle and returns the circumference
     * @param radius - Radius of the circle
     * @return Circumference of the circle
     */
    static public double CircleCircumference(double radius)
    {
        return 2 * Math.PI * radius;
    }

    /**
     * rectanglePerimeter that takes in the length and the width of the rectangle and returns the perimeter
     * @param length - Length of the rectangle
     * @param width Width of the rectangle
     * @return The perimeter of the rectangle
     */
    static public double RectanglePerimeter(double length, double width)
    {
        return (2 * length) + (2 * width);
    }

    /**
     * trianglePerimeter that takes in the lengths of the three sides of the triangle and returns the perimeter
     * @param S1 Side 1 of Triangle
     * @param S2 Side 2 of Triangle
     * @param S3 Side 3 of Triangle
     * @return Sum of all 3 sides
     */
    static public double TrianglePerimeter(double S1, double S2, double S3)
    {
        return S1 + S2 + S3;
    }

    // TASK #4 Write javadoc comments for each method
}