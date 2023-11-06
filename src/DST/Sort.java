package DST;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    //Exercice 2
    /**
     * Question 1 : Tri par insertion
     * @param array : Tableau à trier
     * Best case : O(n)
     * Avg case : O(n^2)
     * Worst case : O(n^2)
     */
    public static void insertionSort(int[] array) {
        for (int i = 0; i< array.length -1; i++) {
            int j = i;
            while(j >= 0 && array[j] > array[j+1]) {
                int temp = array[j+1];
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }


    public static void QuickSort(int[] array) {
        doQuickSort(array,0, array.length-1);
    }
    private static void doQuickSort(int[] array, int lowIndex, int highIndex){
        if (lowIndex >= highIndex) return;

        int pivotIndex = new Random().nextInt(highIndex-lowIndex) + lowIndex;
        int pivot = array[pivotIndex]; //Or just use array[highIndex];
        swap(array,pivotIndex,highIndex);

        int left = lowIndex, right = highIndex;
        while(left < right) {
            while(array[left] <= pivot && left < right) {
                left++;
            }
            while (array[right] >= pivot && left < right) {
                right--;
            }
            swap(array,left,right);
        }

        swap(array,left,highIndex);
        doQuickSort(array,lowIndex,left-1);
        doQuickSort(array,left+1, highIndex);
    }
    private static void swap(int[] array,int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public static void main(String[] args) {
        int[] tab = {8,5,7,1,9,3};
        insertionSort(tab);
        System.out.println(Arrays.toString(tab));
    }


}
