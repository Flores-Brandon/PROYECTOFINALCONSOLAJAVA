/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SortingAlgorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author andre
 */
public class BucketSort {
     static Random rand = new Random();

    public BucketSort() {
    }

    static void printBucketState(List<Integer>[] buckets) {
        System.out.println("Current state of buckets:");
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            for (int item : buckets[i]) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void bucketSort(int[] array) {
        // Encuentra el valor máximo en el array
        int maxVal = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal)
                maxVal = array[i];
        }
        // Crea una lista de buckets vacíos
        List<Integer>[] buckets = new List[maxVal + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribuye los elementos en los buckets
        for (int i = 0; i < array.length; i++) {
            buckets[array[i]].add(array[i]);
        }
        printBucketState(buckets);

        // Ordena cada cubo individualmente
        for (int i = 0; i < buckets.length; i++) {
            buckets[i].sort(null);
        }
        printBucketState(buckets);

        // Concatena los elementos ordenados de cada cubo
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int item : buckets[i]) {
                array[index++] = item;
            }
        }
    }

    static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
