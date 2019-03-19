import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {6, 2, 4, 7, 9, 5, 1, 8, 3, 6, 6};
        System.out.println(Arrays.toString(arr));
//        shellSort(arr);//希尔排序
//        heapSort(arr);//堆排序
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序方法
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int m, temp;
        for (int i=length/2; i>0; i=i/2) {
            for (int n=i; n<length; n++) {
                for (m=n; m>=i && arr[m]<arr[m-i]; m=m-i) {
                    temp = arr[m];
                    arr[m] = arr[m-i];
                    arr[m-i] = temp;
                }
            }
        }
    }

    /**
     * 堆排序方法
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int temp;
        for (int i=arr.length/2-1; i>=0; i--) {
            changeAdjust(arr, i, arr.length);
        }
        for (int i=arr.length-1; i>0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            changeAdjust(arr, 0, i);
        }
    }

    public static void changeAdjust(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k=2*i+1; k<length; k=2*k+1) {
            if (k+1<length && arr[k]<arr[k+1]) {
                k = k+1;
            }
            if (arr[k]>temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
