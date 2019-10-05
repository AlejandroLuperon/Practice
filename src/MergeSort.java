

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 1, 2};
        mergeSort(array, array.length);
        for (int item : array) {
            System.out.println(item);
        }

    }

    public static void mergeSort(int[] array, int size) {
        if (size < 2) {
            return;
        }
        int middle = size/2;
        int[] left = new int[middle];
        int[] right = new int[size - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        for (int i = middle; i < size; i++) {
            right[i-middle] = array[i];
        }

        mergeSort(left, left.length);
        mergeSort(right, right.length);
        merge(left, right, array);
    }

    public static void merge(int[] left, int[] right, int[] array) {
        int leftSize = left.length;
        int rightSize = right.length;

        int leftValue, rightValue;

        int leftCounter = 0;
        int rightCounter = 0;
        int arrayCounter = 0;

        while (leftCounter < leftSize && rightCounter < rightSize) {
            leftValue = left[leftCounter];
            rightValue = right[rightCounter];

            if (leftValue < rightValue) {
                array[arrayCounter] = leftValue;
                leftCounter++;
            } else {
                array[arrayCounter] = rightValue;
                rightCounter++;
            }
            arrayCounter++;
        }

        while (leftCounter < leftSize) {
            array[arrayCounter] = left[leftCounter];
            leftCounter++;
            arrayCounter++;
        }

        while (rightCounter < rightSize) {
            array[arrayCounter] = right[rightCounter];
            rightCounter++;
            arrayCounter++;
        }
    }
}
