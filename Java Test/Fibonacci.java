import java.util.Scanner;

public class Fibonacci 
{
    public static void printFibonacci(int n) 
    {
        if (n <= 0) return;
        int num1 = 0, num2 = 1;
        System.out.print(num1);
        
        for (int i = 1; i < n; i++) 
        {
            System.out.print(" " + num2);
            int next = num1 + num2;
            num1 = num2;
            num2 = next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of digits to be printed (n): ");
        int n = scanner.nextInt();
        printFibonacci(n);
    }
}
