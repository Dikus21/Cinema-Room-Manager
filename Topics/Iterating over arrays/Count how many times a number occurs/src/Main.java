import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        int result = 0;
        for (int k:arr) {
            if (k == num) {
                result++;
            }
        }
        System.out.println(result);
    }
}