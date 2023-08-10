import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        if(symmetricCheck(matrix, size))System.out.println("YES");
        else System.out.println("NO");
    }

    public static boolean symmetricCheck(int[][] matrix, int size){
        for (int k = 0; k < size; k++) {
            for (int l = k; l < size; l++) {
                if(matrix[k][l] != matrix[l][k])return false;
            }
        }
        return true;
    }
}