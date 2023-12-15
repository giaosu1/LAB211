//17.1
// Write a program to get the input from the user and store it into file.
// Using Reader and Writer file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInputToFile {

    public static void main(String[] args) throws IOException {

        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text to be written to file: ");
        String input = scanner.nextLine();

        // File path
        String filePath = "user_input.txt"; // Change this to your desired path

        // Write input to file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(input);
            System.out.println("Input successfully written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Read back input from file (optional)
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                System.out.println("Read back input from file: " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}


//================================================================================================//
// 17.2
// Write a program to create a class MyThread in this class a constructor,
// call the base class constructor, using super and starts the thread. The run
// method of the class starts after this. It can be observed that both main
// thread and created child thread are executed concurrently
public class MyThread extends Thread {

    public MyThread() {
        super(); // Call the base class constructor
        System.out.println("Child thread constructor called.");
        start(); // Start the thread immediately
    }

    @Override
    public void run() {
        System.out.println("Child thread started running.");
        // Simulate some work done by the child thread
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds to simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Main thread started.");
        MyThread childThread = new MyThread(); // Create and start the child thread

        // Simulate some work done by the main thread
        for (int i = 0; i < 3; i++) {
            System.out.println("Main thread: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second to simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Waiting for child thread to finish...");
        try {
            childThread.join(); // Wait for the child thread to finish before continuing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads finished execution.");
    }
}
//================================================================================================//
// 17.4
// Write a program to create two threads. In this class we have one
// constructor used to start the thread and run it. Check whether these two
// threads are run are not
public class ThreadChecker {

    private static boolean thread1Running = false;
    private static boolean thread2Running = false;

    public static void main(String[] args) {
        // Create thread 1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread1Running = true;
                System.out.println("Thread 1 started!");
                // Simulate some work for thread 1
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread1Running = false;
                System.out.println("Thread 1 finished!");
            }
        });

        // Create thread 2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread2Running = true;
                System.out.println("Thread 2 started!");
                // Simulate some work for thread 2
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread2Running = false;
                System.out.println("Thread 2 finished!");
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Check thread status
        while (thread1Running || thread2Running) {
            if (thread1Running) {
                System.out.println("Thread 1 is still running.");
            }
            if (thread2Running) {
                System.out.println("Thread 2 is still running.");
            }
            try {
                Thread.sleep(500); // Check status every 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Both threads finished execution.");
    }
}

