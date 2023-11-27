
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {
         private static final Scanner sc = new Scanner(System.in);
    
	// Function to print N Fibonacci Number
	static void Fibonacci(int N)
	{
		int num1 = 0, num2 = 1;

		int counter = 0;

		// Iterate till counter is N
		while (counter < N) {

			// Print the number
			System.out.print(num1 + " ");

			// Swap
			int num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
			counter = counter + 1;
		}
	}
        
	// Driver Code
	public static void main(String args[])
	{
		// Given Number N
                System.out.print("Please enter the size for Fibonacci series: ");
                int N = Integer.parseInt(sc.nextLine());
                
                System.out.print("\nFibonacci series: ");
		// Function Call
		Fibonacci(N);
                
	}
}
