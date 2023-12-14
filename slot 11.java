//11.3
// Create class box and box3d. box3d is extended class of box. The above
// two classes going to pull fill following requirement
//   Include constructor.
//   set value of length, breadth, height
//   Find out area and volume.
// Note: Base class and sub classes have respective methods and instance variables.
public class Box {
    private double length;
    private double breadth;
    private double height;

    public Box() {
        this(0, 0, 0); // Default constructor with all dimensions set to 0
    }
    public Box(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getLength() {
        return length;
    }
    public double getBreadth() {
        return breadth;
    }
    public double getHeight() {
        return height;
    }
    public double getArea() {
        return 2 * (length * breadth + breadth * height + height * length);
    }
    public double getVolume() {
        return length * breadth * height;
    }
}


///////////////
//
public class Box3D extends Box {

    public Box3D() {
        super(); // Call the default constructor of the parent class
    }

    public Box3D(double length, double breadth, double height) {
        super(length, breadth, height); // Call the parent class constructor with arguments
    }

    // You can add additional methods specific to Box3D here,
    // such as calculations involving diagonals or surface area of different faces

}

