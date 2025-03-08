import java.util.Scanner;

public class SumOfMatrix 
{
    public static int[][] addMatrices(int[][] A, int[][] B, int rows, int columns) 
    {
        int[][] C = new int[rows][columns];

        for (int i = 0; i<rows; i++) 
        {
            for (int j = 0; j<columns; j++) 
            {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows in the matrixx: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns in the matrixx: ");
        int columns = scanner.nextInt();
        int[][] A = new int[rows][columns];
        int[][] B = new int[rows][columns];

        System.out.println("Enter elements of matrixx A:");
        for (int i = 0; i<rows; i++) 
        {
            for (int j = 0; j<columns; j++) 
            {
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements of matrixx B:");
        for (int i = 0; i<rows; i++) 
        {
            for (int j = 0; j<columns; j++) 
            {
                B[i][j] = scanner.nextInt();
            }
        }

        int[][] C = addMatrices(A,B,rows,columns);

        System.out.println("Addition of two matrices A and B is C:");
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
