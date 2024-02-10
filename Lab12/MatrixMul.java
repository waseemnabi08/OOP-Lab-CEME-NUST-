import java.util.Scanner;

public class MatrixMul{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows for Matrix A: ");
        int rowA = input.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int colA = input.nextInt();
        System.out.print("Enter the number of rows for Matrix B: ");
        int rowB = input.nextInt();
        System.out.print("Enter the number of columns for Matrix B: ");
        int colB = input.nextInt();
        if(colA != rowB){
            System.out.println("Matrix Multiplication not possible (#colA != #rowB)");
            System.exit(0);
        }

        int matrixA[][] = inputMatrix("Matrix A", rowA, colA, input);
        System.out.println("Matrix A is:");
        display(matrixA);
        int matrixB[][] = inputMatrix("Matrix B", rowB, colB, input);
        System.out.println("Matrix B is:");
        display(matrixB);

        System.out.println("Resultant Matrix is: ");
        int result[][] = multiply(matrixA, matrixB);
        display(result);


    }


    public static int[][] inputMatrix(String matrixN, int rows, int cols, Scanner input)
    {
        System.out.println("Enter elments of " + matrixN);
        int matrix[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(matrixN + "[" + i + "]" + "[" + j + "] :");
                matrix[i][j] = input.nextInt();
            }
        }

        return matrix;

    }

    public static void display(int [][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] multiply(int [][] matrixA, int [][] matrixB){
        int rowA = matrixA.length;
        int colA = matrixA[0].length;
        int colB = matrixB[0].length;
        int result[][] = new int[rowA][colB];
        Thread threads[] = new Thread[rowA];

        for(int i = 0; i < rowA; i++){
            threads[i] = new Thread(new Multiply(i, matrixA, matrixB, result));
            threads[i].start();
        }

        for(int i = 0; i < rowA; i++){
            try{
                threads[i].join();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }

        return result;
    }
}
