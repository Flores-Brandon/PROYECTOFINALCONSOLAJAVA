/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SortingAlgorithms;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author andre
 */
public class QuickSort {
 private static Random random = new Random();

    private static int option, containExchange, containPartition, containRecursive;

    public QuickSort() {
    }

    private static void swap(int[] array, int indexOne, int indexTwo) {
        int temporary = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temporary;
    }

    private static int partition(int[] array, int firstIndex, int lastIndex) {
        containPartition++;
        int indexPivot;
        switch (option) {
            case 1:
                indexPivot = firstIndex;
                break;

            case 2:
                indexPivot = (int) Math.floor((double) (lastIndex + firstIndex) / 2);
                break;

            case 3:
                indexPivot = lastIndex;
                break;

            default:
                indexPivot = random.nextInt(lastIndex - firstIndex + 1) + firstIndex;
                break;
        }
        swap(array, firstIndex, indexPivot);
        printSwap(array, firstIndex, indexPivot);
        containExchange++;
        int pivot = array[firstIndex];
        int left = firstIndex + 1;
        int right = lastIndex;
        while (true) {
            while (left <= right && array[left] <= pivot) {
                left += 1;
            }
            while (left <= right && array[right] >= pivot) {
                right -= 1;
            }
            if (right < left) {
                break;
            }
            swap(array, left, right);
            printSwap(array, left, right);
            containExchange++;
            left += 1;
            right -= 1;
        }
        swap(array, firstIndex, right);
        printSwap(array, firstIndex, right);
        containExchange++;
        return right;
    }

    public static void quickSort(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            containRecursive++;
            int indexPivot = partition(array, firstIndex, lastIndex);
            quickSort(array, firstIndex, indexPivot - 1);
            quickSort(array, indexPivot + 1, lastIndex);
        }
    }

    public static void print(int[] array) {
        quickSort(array, 0, array.length - 1);
        System.out.print("\nResult: [ " + Arrays.toString(array) + " ]");
        System.out.println("\nSwap: " + containExchange + "\nPartitions: " + containPartition + "\nRecursion: " + containRecursive);
        containExchange = 0;
        containPartition = 0;
        containRecursive = 0;
    }

    private static void printSwap(int[] array, int left, int right) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            if (right == i && left == i) {
                System.out.print(array[i]);
            } else if (i == left || i == right) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i]);
            }
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");
    }

    public static int[] generateVector(int min, int length, int val) {
        List<Integer> list = new ArrayList<>();
        for (int i = min; i < length; i++) {
            if (i < val) {
                int newValue = random.nextInt(length - min + 1) + min;
                if (list.contains(newValue)) {
                    i--;
                    continue;
                }
                list.add(newValue);
            } else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }   
}
