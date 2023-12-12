//7.1
//Write a program to create a class named shape. In this class we have three
//sub classes circle, triangle and square each class has two member function
//named draw () and erase (). Create these using polymorphism concepts

import java.util.Scanner;

abstract class Shape {
    public abstract void draw();
    public abstract void erase();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }

    @Override
    public void erase() {
        System.out.println("Erasing a circle with radius " + radius);
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a triangle with base " + base + " and height " + height);
    }

    @Override
    public void erase() {
        System.out.println("Erasing a triangle with base " + base + " and height " + height);
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square with side " + side);
    }

    @Override
    public void erase() {
        System.out.println("Erasing a square with side " + side);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter shape type (circle, triangle, square): ");
        String shapeType = scanner.nextLine();

        Shape shape = null;
        switch (shapeType) {
            case "circle":
                System.out.println("Enter radius: ");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;
            case "triangle":
                System.out.println("Enter base: ");
                double base = scanner.nextDouble();
                System.out.println("Enter height: ");
                double height = scanner.nextDouble();
                shape = new Triangle(base, height);
                break;
            case "square":
                System.out.println("Enter side: ");
                double side = scanner.nextDouble();
                shape = new Square(side);
                break;
            default:
                System.out.println("Invalid shape type!");
                return;
        }

        // Use polymorphism to call draw and erase methods
        shape.draw();
        shape.erase();
    }
}

/////=======================================================================================//////
//7.2
//Write a program to give a simple example for abstract class
public abstract class Shape {

    // Abstract method to calculate area
    public abstract double area();

    // Non-abstract method to draw the shape (optional)
    public void draw() {
        System.out.println("Drawing a generic shape...");
    }
}

public class Square extends Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(side, 2);
    }

    // Override the draw() method for Square
    @Override
    public void draw() {
        System.out.println("Drawing a square with side " + side);
    }
}

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    // Override the draw() method for Circle
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}

public class Main {

    public static void main(String[] args) {
        Shape square = new Square(5);
        Shape circle = new Circle(3);

        // Call the area() method using polymorphism
        System.out.println("Area of square: " + square.area());
        System.out.println("Area of circle: " + circle.area());

        // Call the draw() method (optional)
        square.draw();
        circle.draw();
    }
}

////================================================================================////
//7.3
//Write a program suppose, it is required to build a project consisting of a number of classes, 
// possibly using a large number of programmers. It is necessary to make sure that every class from 
// which all other classes in the project will be inherited. Since any new classes in the project must 
// inherit from the base class, programmers are not free to create a different interface. Therefore, 
// it can be guaranteed that all the classes in the project will respond to the same debugging commands.
public abstract class ProjectBase {
    // Define abstract methods for common debugging commands
    public abstract void printDebugInfo();
    public abstract void printState();
    // Optional helper methods for common functionalities
    public static void printSeparator() {
        System.out.println("--------------------------------");
    }
    public static void logMessage(String message) {
        System.out.println("[DEBUG] " + message);
    }
}

// Example subclasses inheriting from ProjectBase
class MyClass1 extends ProjectBase {
    private String name;
    private int value;
    public MyClass1(String name, int value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public void printDebugInfo() {
        System.out.println("MyClass1:");
        ProjectBase.logMessage("Name: " + name);
        ProjectBase.logMessage("Value: " + value);
    }
    @Override
    public void printState() {
        // Implement specific state printing logic for MyClass1
    }
}

class MyClass2 extends ProjectBase {
    private List < String > messages;
    public MyClass2(List < String > messages) {
        this.messages = messages;
    }
    @Override
    public void printDebugInfo() {
        System.out.println("MyClass2:");
        ProjectBase.logMessage("Number of messages: " + messages.size());
        // ... Add additional debug info specific to MyClass2 ...
    }
    @Override
    public void printState() {
        // Implement specific state printing logic for MyClass2
    }
}

// ... Add other classes inheriting from ProjectBase ...
// Example usage
ProjectBase obj1 = new MyClass1("Object1", 10);
ProjectBase obj2 = new MyClass2(Arrays.asList("Message1", "Message2"));
// Use common debugging commands provided by ProjectBase
obj1.printDebugInfo();
obj2.printDebugInfo();
ProjectBase.printSeparator();
obj1.printState();
obj2.printState();
