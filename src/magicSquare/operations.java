package magicSquare;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class operations {
    private static Scanner userInput = new Scanner(System.in);
    private static Random arrayFiller = new Random();

    static int horizontalSum = 0, verticalSum = 0, leftToRightDiagonalSum = 0, rightToLeftDiagonalSum = 0;
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
        int row = (int) ((matrix.length/2) + 0.5);
        int column = row;
        int arrayDec = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                //Populates the array
                matrix[i][j] = arrayFiller.nextInt(90);
                //Horizontal Array Filler
                if (matrix[i][j] == matrix[row][j]) {
                    matrix[row][j] = 1;
                }
                //Vertical Array Filler
                else if (matrix[i][j] == matrix[i][column]) {
                    matrix[i][column] = 1;
                }
                //Left to Right Diagonal Array Filler
                else if (matrix[i][j] == matrix[i][i]) {
                    matrix[i][i] = 1;
                }
                //Right to Left Diagonal Array Filler
                else if (matrix[i][j] == matrix[i][arrayDec]) {
                    matrix[i][j] = 1;
                }
            }
            arrayDec--;
        }
        return matrix;
    }

    private static void useMatrix() {
        int[][] newMatrix = matrixCreator();
        int sum = 0;
        int row = (int) ((newMatrix.length/2) + 0.5);
        int column = row;

        System.out.println("The magic square with the size = " + newMatrix.length + " is:");
        if (newMatrix.length == 1) {
            sum += newMatrix[0][0];

            for (int[] i: newMatrix) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println("The " + newMatrix.length + "x" + newMatrix.length + " magic square adds up to " + sum);
        }
        else {

            //Summation of the middle row array
            for (int i = 0; i < newMatrix.length; i++) {
                horizontalSum += newMatrix[row][i];
            }

            //Summation of the middle column arrays
            for (int i = 0; i < newMatrix.length; i++) {
                verticalSum += newMatrix[i][column];
            }

            //Summation of the left diagonal  arrays
            for (int i = 0; i < newMatrix.length; i++) {
                leftToRightDiagonalSum += newMatrix[i][i];
            }

            //Summation of the right diagonal  arrays
            for (int i = newMatrix.length-1; i >= 0; i--) {
                rightToLeftDiagonalSum += newMatrix[i][i];
            }

            for (int[] i: newMatrix) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println("The " + newMatrix.length + "x" + newMatrix.length + " magic square adds up to " + verticalSum);
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
