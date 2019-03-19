import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {6, 2, 4, 7, 9, 5, 1, 8, 3, 6, 6};
        System.out.println(Arrays.toString(arr));
        arr = countingSort(arr);//计数排序
//        mergeSort(arr);//归并排序
//        shellSort(arr);//希尔排序
//        heapSort(arr);//堆排序
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 计数排序方法，这个适用于正整数的数组，不适用负数和小数
     * @param arr
     */
    public static int[] countingSort(int[] arr) {
        int[] b = new int[arr.length];
        int max = arr[0], min = arr[0];
        for (int n : arr) {
            if (n>max) {
                max = n;
            }
            if (n<min) {
                min = n;
            }
        }
        int k = max - min +1;
        int[] c = new int[k];
        for (int i=0; i<arr.length; i++) {
            c[arr[i]-min]++;
        }
        for (int i=1; i<k; i++) {
            c[i] += c[i-1];
        }
        for (int i=arr.length-1; i>=0; i--) {
            b[c[arr[i]-min]-1] = arr[i];
            c[arr[i]-min]--;
        }
        return b;
    }

    /**
     * 归并排序方法，调用mergeRecursionMethod方法
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeRecursionMethod(arr, temp, 0, arr.length-1);
    }

    public static void mergeRecursionMethod(int[] arr, int[] temp, int start, int end) {
        if (start<end) {
            int mid = (start+end)/2;
            mergeRecursionMethod(arr, temp, start, mid);
            mergeRecursionMethod(arr, temp, mid+1, end);
            int p1 = start, p2 = mid+1, k = start;
            while (p1<=mid && p2<=end) {
                if (arr[p1]>arr[p2]) {
                    temp[k++] = arr[p2++];
                } else {
                    temp[k++] = arr[p1++];
                }
            }
            while (p1<=mid) {
                temp[k++] = arr[p1++];
            }
            while (p2<=end) {
                temp[k++] = arr[p2++];
            }
            for (int i=start; i<=end; i++) {
                arr[i] = temp[i];
            }
        }
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
     * 堆排序方法，调用changeAdjust方法
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
