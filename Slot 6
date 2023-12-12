//6.3
//Write a program to give the example for method overriding concepts.
//Write a program to give the example for ‘super’ keyword

class Shape {
    // Base class method to calculate area (abstract method)
    public abstract double area();
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    // Override the area method for Square
    @Override
    public double area() {
        return side * side;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Override the area method for Circle
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape square = new Square(5);
        Shape circle = new Circle(3);

        System.out.println("Area of Square: " + square.area());
        System.out.println("Area of Circle: " + circle.area());
    }
}
