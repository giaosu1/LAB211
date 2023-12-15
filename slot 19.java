//19.1
// Write a program to show how synchronized methods and objects
// monitors are used to coordinate access to a common object by multiple
// threads. Clue use first program of this section for use will synchronized
// methods
class Inventory {

    private int stock;
    private final Object monitor = new Object(); // Object monitor for synchronized access

    public Inventory(int initialStock) {
        this.stock = initialStock;
    }

    public synchronized void addStock(int amount) { // Synchronized method
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot add negative stock!");
        }
        synchronized (monitor) { // synchronized block using object monitor
            stock += amount;
            System.out.println("Added " + amount + " items. Current stock: " + stock);
        }
    }

    public boolean removeStock(int amount) {
        synchronized (monitor) { // synchronized block using object monitor
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
    }

    public int getStock() {
        synchronized (monitor) { // synchronized block using object monitor
            return stock;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory(100);

        // Simulate concurrent access with multiple threads
        Thread thread1 = new Thread(() -> inventory.addStock(50));
        Thread thread2 = new Thread(() -> inventory.removeStock(25));
        Thread thread3 = new Thread(() -> {
            synchronized (inventory) { // Synchronized block on inventory object
                System.out.println("Current stock from thread 3: " + inventory.getStock());
            }
        });

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

//============================================================================================//
// 19.2
// Write a complex program to illustrate how the thread priorities? Imagine
// that the first thread has just begun to run, even before it has a chance to
// do anything. Now comes the higher priority thread that wants to run as
// well. Now the higher priority thread has to do its work before the first
// thread starts
public class PriorityDemo {

    public static void main(String[] args) throws InterruptedException {

        // Thread with lowest priority (1)
        Thread lowPriorityThread = new Thread(() -> {
            try {
                System.out.println("Low priority thread trying to acquire lock...");
                synchronized (PriorityDemo.class) { // Acquire lock on shared class
                    System.out.println("Low priority thread acquired lock!");
                    try {
                        Thread.sleep(5000); // Simulate work (5 seconds)
                        System.out.println("Low priority thread releasing lock.");
                    } finally {
                        PriorityDemo.class.notifyAll(); // Notify waiting threads
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // Set lowest priority

        // Thread with high priority (10)
        Thread highPriorityThread = new Thread(() -> {
            try {
                System.out.println("High priority thread waiting for lock...");
                synchronized (PriorityDemo.class) { // Wait for lock release
                    PriorityDemo.class.wait(); // Wait for notification
                    System.out.println("High priority thread acquired lock!");
                    try {
                        Thread.sleep(2000); // Simulate work (2 seconds)
                        System.out.println("High priority thread releasing lock.");
                    } finally {
                        PriorityDemo.class.notifyAll(); // Notify waiting threads
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // Set highest priority

        // Start low priority thread first
        lowPriorityThread.start();
        Thread.sleep(100); // Give low priority thread a head start

        // Start high priority thread
        highPriorityThread.start();

        // Wait for both threads to finish
        lowPriorityThread.join();
        highPriorityThread.join();

        System.out.println("Both threads finished execution.");
    }
}

