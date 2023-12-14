////---------------------------------------------------------------------------------------------////
// 9.1
// Write a class called ColourChecking. Define a color with red = 193, green
// =255 and blue = 183. No separate the rgb values. Find the Hue, saturation
// and brightness of this color

public class ColourChecking {
    public static void main(String[] args) {
        // Define RGB values
        int red = 193;
        int green = 255;
        int blue = 183;
        // Calculate maximum and minimum values
        int max = Math.max(red, Math.max(green, blue));
        int min = Math.min(red, Math.min(green, blue));
        // Calculate brightness
        float brightness = (float) max / 255.0f;
        // Calculate saturation
        float saturation = 0.0f;
        if (max != 0) {
            saturation = (float) (max - min) / max;
        }
        // Calculate hue
        float hue = 0.0f;
        if (max == red) {
            hue = (float) (green - blue) / (max - min);
        } else if (max == green) {
            hue = 2.0f + (float) (blue - red) / (max - min);
        } else if (max == blue) {
            hue = 4.0f + (float) (red - green) / (max - min);
        }
        hue = hue % 6.0f;
        // Print HSB values
        System.out.println("Hue: " + hue);
        System.out.println("Saturation: " + saturation);
        System.out.println("Brightness: " + brightness);
    }
}

////---------------------------------------------------------------------------------------------////
// 9.2
// Write a program to check the font class method as follows: Create a font TimesRoman bold and Italic size 12. 
// In this object use the font methods. Then display the attributes of the font
import java.awt.Font;
public class FontTester {
    public static void main(String[] args) {
        // Create a Font object with desired properties
        Font font = new Font("TimesRoman", Font.BOLD | Font.ITALIC, 12);
        // Print basic font information
        System.out.println("Font Name: " + font.getName());
        System.out.println("Font Style: " + (font.isBold() ? "Bold" : "Plain") + ", " + (font.isItalic() ? "Italic" : "Regular"));
        System.out.println("Font Size: " + font.getSize());
        // Access additional attributes (optional)
        System.out.println("Font Family: " + font.getFamily());
        System.out.println("Font Style Code: " + font.getStyle());
        // Display font sample (optional)
        String sampleText = "This is a sample text in TimesRoman 12pt Bold Italic.";
        System.out.println("\nSample Text:");
        System.out.println(sampleText);
    }
}

////---------------------------------------------------------------------------------------------////
// 9.3
// Write a program to find the solution for the following problems using Recursion
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // base case
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // recursive call
    }
    public static void main(String[] args) {
        // Example usage
        int result = fibonacci(5);
        System.out.println("The 5th Fibonacci number is: " + result);
    }
}
