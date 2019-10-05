package FirstMissingPositive;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 1, 2};
        mergeSort(array, array.length);
        System.out.println(getSmallestPositiveInteger(array));

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

    public static int getSmallestPositiveInteger(int[] array) {
        int prevValue;
        int currentIndex = 1;
        int currentValue;
        boolean found = false;
        int result = 0;

        if (array[0] > 1) {
            return 1;
        }

        while (!found && currentIndex != array.length) {
            currentValue = array[currentIndex];
            prevValue = array[currentIndex - 1];
            if (currentValue < 2) {
                currentIndex++;
                continue;
            }

            if (currentValue == prevValue || currentValue - 1 == prevValue) {
                currentIndex++;
            } else {
                if (prevValue > 0) {
                    result = prevValue + 1;
                    found = true;
                } else {
                    result = 1;
                    found = true;
                }
            }
        }

        if (!found) {
            int lastValue = array[array.length - 1];
            if (lastValue < 0) {
                result = 1;
            } else {
                result = array[array.length - 1] + 1;
            }
        }

        return result;
    }
}
