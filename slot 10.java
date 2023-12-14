//10.3
// Create class Number with only one private instance variable as a double primitive type. To include the following methods 
// (include respective constructors) isZero( ), isPositive(), isNegative( ), isOdd( ), isEven( ), isPrime(), isAmstrong() 
// the above methods return boolean primitive type. getFactorial(), getSqrt(), getSqr(), sumDigits(),
// getReverse() the above methods return double primitive type. void listFactor(), void dispBinary()
public class Number {
    private double num;

    // Constructors
    public Number() {
        this.num = 0.0;
    }
  
    public Number(double num) {
        this.num = num;
    }
  
    // Boolean methods
    public boolean isZero() {
        return Math.abs(num) < 1e-10; // Account for floating-point precision
    }
    public boolean isPositive() {
        return num > 0.0;
    }
    public boolean isNegative() {
        return num < 0.0;
    }
    public boolean isOdd() {
        return Math.abs(num % 2) > 1e-10; // Account for floating-point precision
    }
    public boolean isEven() {
        return Math.abs(num % 2) < 1e-10; // Account for floating-point precision
    }
    public boolean isPrime() {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0.0) {
                return false;
            }
        }
        return true;
    }
    public boolean isAmstrong() {
        int digits = (int) Math.floor(Math.log10(num)) + 1;
        double sum = 0;
        double temp = num;
        while (temp > 0) {
            double digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == num;
    }
    // Double methods
    public double getFactorial() {
        if (num < 0) {
            return Double.NaN; // Not defined for negative numbers
        }
        double factorial = 1.0;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
    public double getSqrt() {
        if (num < 0) {
            return Double.NaN; // Not defined for negative numbers
        }
        return Math.sqrt(num);
    }
    public double getSqr() {
        return num * num;
    }
    public double sumDigits() {
        double sum = 0;
        double temp = num;
        while (temp > 0) {
            double digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        return sum;
    }
    public double getReverse() {
        double reversed = 0;
        double temp = num;
        while (temp > 0) {
            double digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        return reversed;
    }
    // Void methods
    public void listFactor() {
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(i + ", " + num / i);
            }
        }
    }
    public void dispBinary() {
        System.out.println("Binary representation of " + num + ": " + Long.toBinaryString((long) num)); // Use Long for larger numbers
    }
}
