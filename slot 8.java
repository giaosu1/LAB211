// 8.1
// Write a program to create interface A in this interface we have two
// method meth1 and meth2. Implements this interface in another class
// named MyClass
interface A {
    void meth1();
    void meth2();
}
class MyClass implements A {
    @Override
    public void meth1() {
        System.out.println("MyClass: meth1 called!");
    }
    @Override
    public void meth2() {
        System.out.println("MyClass: meth2 called!");
    }
}
public class Main {
    public static void main(String[] args) {
        A obj = new MyClass(); // Create an object of MyClass implementing interface A
        obj.meth1(); // Call meth1 using the interface reference
        obj.meth2();
    }
}
////============================================================================================================////
// 8.2
// Write a program to give example for multiple inheritance in Java
interface Drawable {
    void draw();
}
interface Shape {
    double getArea();
}
class Square implements Drawable, Shape {
    private double side;
    @Override
    public void draw() {
        System.out.println("Drawing a square with side " + side);
    }
    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }
}
////============================================================================================================////
// 8.3
// Write a program to create interface named test. In this interface the member function is square. 
// Implement this interface in arithmetic class. 
// Create one new class called ToTestInt in this class use the object of arithmetic class

// Interface named "test" with a member function "square"
interface Test {
    int square(int num);
}
// Arithmetic class implementing the "Test" interface
class Arithmetic implements Test {
    @Override
    public int square(int num) {
        return num * num;
    }
}
// Class named "ToTestInt" using an object of "Arithmetic" class
class ToTestInt {
    private Arithmetic arithmeticObj;

    public ToTestInt() {
        this.arithmeticObj = new Arithmetic(); // Create an instance of Arithmetic class
    }
    public int testSquare(int num) {
        return arithmeticObj.square(num); // Use the square function from the Arithmetic object
    }
}
// Example usage
public class Main {
    public static void main(String[] args) {
        ToTestInt tester = new ToTestInt();
        int result = tester.testSquare(5);
        System.out.println("Square of 5 is: " + result); // Output: Square of 5 is: 25
    }
}
