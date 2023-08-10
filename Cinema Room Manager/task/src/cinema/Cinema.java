package cinema;
import java.util.Scanner;

public class Cinema {
    protected static int income = 0;
    protected static int bookedSeats = 0;
    protected static int totalIncome = 0;
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int cols = sc.nextInt();
        char[][] cinemaSeat = new char[rows+1][cols+1];
        seatGenerator(cinemaSeat);
        Menu(cinemaSeat);
    }

    public static void Menu(char[][] matrix){
        System.out.printf("%n1. Show the seats%n" +
                "2. Buy a ticket%n" +
                "3. Statistics%n" +
                "0. Exit%n");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
            case 0 -> {}
            case 1 -> {
                printSeat(matrix);
                Menu(matrix);
            }
            case 2 -> {
                seatSelector(matrix);
                Menu(matrix);
            }
            case 3 -> {
                statistic(matrix);
                Menu(matrix);
            }
            default -> {
                System.out.println("Unrecognized number");
                Menu(matrix);
            }

        }

    }

    public static void statistic(char[][] matrix){
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        int totalSeat = rows * cols;
        if(totalIncome == 0){
            if(totalSeat <= 60){
                totalIncome = totalSeat * 10;
            }
            else {
                totalIncome = ((rows/2 * 10) + (rows - rows/2) * 8) * cols;
            }
        }
        float bookedPercentage = (float) bookedSeats /totalSeat * 100;
        System.out.printf("%nNumber of purchased tickets: %d%n" +
                "Percentage: %.2f%%%n" +
                "Current income: $%d%n" +
                "Total income: $%d%n", bookedSeats, bookedPercentage, income, totalIncome);
    }

    public static void seatSelector(char[][] matrix){
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        Scanner sc = new Scanner(System.in);
        System.out.printf("%nEnter a row number:%n");
        int seatRow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatCol = sc.nextInt();

        if(seatRow > rows || seatCol > cols){
            System.out.println("Wrong input!");
            seatSelector(matrix);
            return;
        }

        if(matrix[seatRow][seatCol] == 'B'){
            System.out.println("That ticket has already been purchased!");
            seatSelector(matrix);
            return;
        } else {
            matrix[seatRow][seatCol] = 'B';
            bookedSeats += 1;
        }

        int totalSeat = rows * cols;
        int price = 0;
        if(totalSeat <= 60){
            price += 10;
        }
        else {
            if(seatRow <= rows/2) {
                price += 10;
            } else {
                price += 8;
            }
        }
        income += price;
        System.out.printf("Ticket price: $%d%n", price);
    }

    public static void seatGenerator(char[][] matrix) {
        System.out.printf("%nCinema:%n");
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            int cols = matrix[i].length;
            for (int j = 0; j < cols; j++) {
                if(i == 0 && j == 0){
                    matrix[i][j] = ' ';
                }
                else if(i == 0){
                    matrix[i][j] = (char) (j + '0');
                }
                else if(j == 0){
                    matrix[i][j] = (char) (i + '0');
                }
                else {
                    matrix[i][j] = 'S';
                }
            }
        }
    }

    public static void printSeat(char[][] matrix) {
        System.out.printf("%nCinema:%n");
        for (char[] rowMatrix : matrix) {
            for (char colMatrix : rowMatrix) {
                System.out.print(colMatrix + " ");
            }
            System.out.println();
        }
    }
}