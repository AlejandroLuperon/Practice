package FirstMissingPositive;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        int[] test1 = {1, 3, 6, 4, 1, 2};
        int[] test2 = {1, 2, 3};
        int[] test3 = {-1, -3};
        int[] test4 = {3, 4, -1, 1};
        int[] test5 = {7, 8, 9, 11, 12};
        int[] test6 = {1000,-1};
        //solution(test1);
        //solution(test2);
        //solution(test3);
        solution(test4);
        //solution(test5);
        //solution(test6);


    }

    public static void solution(int[] array) {
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

        ArrayList<Integer> hmm = new ArrayList<Integer>();

        while (leftCounter < leftSize && rightCounter < rightSize) {
            leftValue = left[leftCounter];
            rightValue = right[rightCounter];
            System.out.println("left"+ leftValue);
            System.out.println("right"+ rightValue);



            if (leftValue <= 0 && rightValue <= 0) {
                leftCounter++;
                rightCounter++;
                continue;
            } else if (leftValue <= 0 && rightValue > 0) {
                leftCounter++;
                array[arrayCounter] = rightValue;
                hmm.add(rightValue);
                rightCounter++;
                arrayCounter++;
                continue;
            } else if (rightValue <= 0 && leftValue > 0) {
                rightCounter++;
                array[arrayCounter] = leftValue;
                hmm.add(leftValue);
                leftCounter++;
                arrayCounter++;
                continue;
            }

            if (leftValue < rightValue) {
                array[arrayCounter] = leftValue;
                hmm.add(leftValue);
                leftCounter++;
            } else {
                array[arrayCounter] = rightValue;
                hmm.add(rightValue);
                rightCounter++;
            }
            arrayCounter++;
        }

        while (leftCounter < leftSize) {
            leftValue = left[leftCounter];
            if (leftValue <= 0) {
                leftCounter++;
                continue;
            }
            array[arrayCounter] = leftValue;
            hmm.add(leftValue);
            leftCounter++;
            arrayCounter++;
        }

        while (rightCounter < rightSize) {
            rightValue = right[rightCounter];
            if (rightValue <= 0) {
                rightCounter++;
                continue;
            }
            array[arrayCounter] = rightValue;
            hmm.add(rightValue);
            rightCounter++;
            arrayCounter++;
        }
        hmm.stream().forEach((item)->{
            System.out.println("Hmm: " + item);
        });
    }

    public static int getSmallestPositiveInteger(int[] array) {
        for (int item : array) {
            System.out.println(item);
        }
        return 0;
    }
}
