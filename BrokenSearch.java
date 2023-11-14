


public class BrokenSearch {
    public static int brokenSearch(int[] arr, int k) {
        int start = findStart(arr, 0, arr.length-1);
        if(k > arr[arr.length-1]){
            return binarySearch(arr, k, 0, start);
        } else {
            return binarySearch(arr, k, start, arr.length);
        }
    }

    public static int findStart(int[] arr, int left, int right){
        if(arr.length == 1 || arr[0] < arr[arr.length-1]){
            return 0;
        }
        int mid = (left + right) / 2;
        if(arr[mid] > arr[mid+1]){
            return mid + 1;
        }
        else if(arr[mid] < arr[arr.length-1]){
            return findStart(arr, left, mid);
        } else {
            return findStart(arr, mid + 1, right);
        }
    }

    public static int binarySearch(int[] arr, int x, int left, int right) {
        if (right <= left) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (x < arr[mid]) {
            return binarySearch(arr, x, left, mid);
        } else {
            return binarySearch(arr, x, mid + 1, right);
        }
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        assert 6 == brokenSearch(arr, 5);
    }
}
