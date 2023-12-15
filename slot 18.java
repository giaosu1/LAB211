//18.1
// Create a multithreaded program by creating a subclass of Thread and
// then creating, initializing, and staring two Thread objects from your
// class. The threads will execute concurrently and display Java is hot,
// aromatic, and invigorating to the console window
public class JavaThreadDemo extends Thread {
    private final String message;
    public JavaThreadDemo(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(message);
    }
    public static void main(String[] args) {
        Thread thread1 = new JavaThreadDemo("Java is hot!");
        thread1.start();
        Thread thread2 = new JavaThreadDemo("Java is aromatic!");
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Both threads finished!");
   }
}

//============================================================================================//
// 18.2
// Create a multithreaded program as in the previous exercise by creating
// the MyThread subclass of Thread. But create threads as objects of the
// class MyClass, which is not a subclass of Thread. MyClass will
// implement the runnable interface and objects of MyClass will be
// executed as threads by passing them as arguments to the Thread
// constructor
public class MultiThreadDemo {

    public static void main(String[] args) {
        // Create objects of MyClass with different messages
        MyClass message1 = new MyClass("Java is hot!");
        MyClass message2 = new MyClass("Java is aromatic!");

        // Create and start threads with the MyClass objects
        Thread thread1 = new Thread(message1);
        thread1.start();
        Thread thread2 = new Thread(message2);
        thread2.start();

        // Optionally, wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Both threads finished!");
    }
}

class MyClass implements Runnable {
    private String message;

    public MyClass(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(message);
    }
}

//============================================================================================//
// 18.3
// Write a program for inventory problem in this to illustrates the usage of
// synchronized keyword
class Inventory {
    private int stock;
    public Inventory(int initialStock) {
        this.stock = initialStock;
    }

    public synchronized void addStock(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot add negative stock!");
        }
        stock += amount;
        System.out.println("Added " + amount + " items. Current stock: " + stock);
    }

    public synchronized boolean removeStock(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot remove negative stock!");
        }
        if (stock < amount) {
            System.out.println("Not enough stock available. Current stock: " + stock);
            return false;
        }
        stock -= amount;
        System.out.println("Removed " + amount + " items. Current stock: " + stock);
        return true;
    }
    public int getStock() {
        return stock;
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(100);
        // Simulate concurrent access with multiple threads
        Thread thread1 = new Thread(() -> inventory.addStock(50));
        Thread thread2 = new Thread(() -> inventory.removeStock(25));
        Thread thread3 = new Thread(() -> inventory.removeStock(75));
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final stock: " + inventory.getStock());
    }
}


