import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {6, 2, 4, 7, 9, 5, 1, 8, 3, 6, 6};
        shellSort(arr);
//        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int length = arr.length;
        for (int i=length/2; i>0; i=i/2) {
        }
    }

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
