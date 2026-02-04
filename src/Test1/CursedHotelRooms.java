package Test1;

public class CursedHotelRooms {
    public static void main(String[] args) {
        int lower = 1;
        int upper = 20;
        int n = (upper-lower)+1;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = lower;
            lower++;

        }
    }
}
