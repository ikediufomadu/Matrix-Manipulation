package magicSquare;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class operations {
    private static Scanner userInput = new Scanner(System.in);
    private static Random arrayFiller = new Random();

    private static int matrixSize() {
        int size;

        System.out.print("Enter the size of magic square (positive & odd) : ");
        size = userInput.nextInt();

        if (size % 2 == 0) {
            System.out.println("INPUT ERROR!!! Invalid size.");
            System.exit(0);
        }
        return size;
    }

    private static int[][] matrixCreator() {
        int[][] matrix = new int[matrixSize()][matrixSize()];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = arrayFiller.nextInt();
            }
        }
        return matrix;
    }

    private static void useMatrix() {
        int[][] newMatrix = matrixCreator();
        int sum = 0;

        System.out.println("The magic square with the size = " + newMatrix.length + " is:");
        if (newMatrix.length == 1) {
            sum += newMatrix[0][0];

            for (int[] i: newMatrix) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println("The " + newMatrix.length + "x" + newMatrix.length + " magic square adds up to " + sum);
        }
        else {
            double row = (newMatrix.length/2) - 0.5;
            double column = row;

            for (int i = 0; i < row; i++) {
                sum += newMatrix[i][i];
            }
        }
    }

    public static void continueMethod() {
        useMatrix();
        System.out.println("Do you want to continue (Y/N): ");
        char answer = userInput.next().charAt(0);
        if (answer == 'Y' || answer == 'y') {
            continueMethod();
        }
    }
}
