//13.1
// Write a program to illustrate usage of try/catch with finally clause

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchFinallyExample {
    public static void main(String[] args) {
        String fileName = "data.txt"; // Change this to your desired file
        try (FileReader reader = new FileReader(fileName)) {
            StringBuilder content = new StringBuilder();
            char[] buffer = new char[1024];
            int readBytes;
            while ((readBytes = reader.read(buffer)) != -1) {
                content.append(buffer, 0, readBytes);
            }
            System.out.println("File content: " + content.toString());
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: Reading file failed: " + e.getMessage());
        } finally {
            System.out.println("File closed.");
        }
    }
}
