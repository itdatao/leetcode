package leetcode.offer;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName QuicSort.java
 * @Date 2023-02-17 16:13:00
 */
public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int left = start, right = end, pivot = arr[start];
            while (left < right) {
                // 右面的数字大于标准数时，右边的数的位置不变，指针向左移一个位置
                while (left < right && arr[right] > pivot) {
                    right--;
                }
                // 右边的数字及下标小于或等于基本数，将右边的数放到左边
                if (left < right) {
                    arr[left] = arr[right];
                    left++;
                }
                //左边的数字小于或等于标准数时，左边的数的位置不变，指针向右移一个位置
                while (left < right && arr[left] <= pivot) {
                    left++;
                }
                // 左边的数字大于基本数，将左边的数放到右边
                arr[right] = arr[left];
            }
            // 一趟循环结束，此时left=right，将基数放到这个重合的位置，
            arr[left] = pivot;
            quickSort(arr, start, left);
            quickSort(arr, left + 1, end);
        }


    }

    public static void main(String[] args) {
        int array[] = {10, 5, 3, 1, 7, 2, 8};
        System.out.println("排序之前：");
        for (int element : array) {
            System.out.print(element + " ");
        }

        quickSort(array, 0, array.length - 1);

        System.out.println("\n排序之后：");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

}
