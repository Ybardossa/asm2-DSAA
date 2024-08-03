/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7code;

public class AlgorithmEfficiency {

    // O(1) - Constant Time Complexity
  public static int accessElement(int[] array, int index) {
    return array[index];
}

    // O(N) - Linear Time Complexity
    public static int findMaxElement(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // O(log N) - Logarithmic Time Complexity (Binary Search)
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }

    // O(N^2) - Quadratic Time Complexity (Bubble Sort)
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // O(N log N) - Linearithmic Time Complexity (Merge Sort)
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 6, 2, 7, 4, 1};

        // O(1) - Constant Time
        System.out.println("O(1) - Element at index 3: " + accessElement(array, 3));

        // O(N) - Linear Time
        System.out.println("O(N) - Maximum element: " + findMaxElement(array));

        // O(log N) - Logarithmic Time (Binary Search requires sorted array)
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 6;
        System.out.println("O(log N) - Binary Search: Element " + target + " found at index: " + binarySearch(sortedArray, target));

        // O(N^2) - Quadratic Time
        bubbleSort(array);
        System.out.print("O(N^2) - Bubble Sort: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // O(N log N) - Linearithmic Time
        int[] unsortedArray = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.print("O(N log N) - Merge Sort: ");
        for (int num : unsortedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
