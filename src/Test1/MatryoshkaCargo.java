package Test1;
import java.util.*;

public class MatryoshkaCargo {
    public static void main(String[] args) {
//        int[][] envelope = new int[][] {{5, 4} ,{6, 4}, {6, 7}, {2, 3}};
        int[][] envelope = new int[][] {{1, 10}, {1, 5}, {1, 2}};

        Arrays.sort(envelope,(a, b)-> {
            if(a[0] != b[0]) return a[0] - b[0];
            else return b[1]-a[1];
        });

        int[] arr = new int[envelope.length];

        for(int i = 0; i < envelope.length; i++) {
            arr[i] = envelope[i][1];
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        for(int i = 1; i < envelope.length; i++) {
            if(arr[i] > ans.get(ans.size() - 1)) {
                ans.add(arr[i]);
            } else {
                ans.set(lb(ans, arr[i]), arr[i]);
            }
        }
        System.out.println(ans.size());
    }

    public static int lb(ArrayList<Integer> ans, int num) {
        int low = 0;
        int high = ans.size()-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(ans.get(mid) == num) {
                return mid;
            } else if(ans.get(mid) > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
