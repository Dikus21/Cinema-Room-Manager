import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int size = 3;
        int[] box1 = new int[size];
        int[] box2 = new int[size];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            box1[i] = sc.nextInt();
        }
        for (int j = 0; j < size; j++) {
            box2[j] = sc.nextInt();
        }
        Arrays.sort(box1);
        Arrays.sort(box2);
        int compare = box1[0] - box2[0];
        for (int k = 1; k < size; k++) {
            if (incompatible(compare, box1, box2, k)) {
                System.out.println("Incompatible");
                break;
            } else if (k == size - 1 && compare > 0) {
                System.out.println("Box 1 > Box 2");
            } else if (k == size - 1 && compare < 0) {
                System.out.println("Box 1 < Box 2");
            }
        }
    }

    public static boolean incompatible(int init, int[] b1, int[] b2, int k) {
        if (init == 0) return true;
        if (init > 0) return b1[k] - b2[k] <= 0;
        return b1[k] - b2[k] >= 0;
    }
}