/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Menus;
import java.util.*;
import Classes.Information;
import Classes.SortingAlgorithms.*;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class MenuAlgorithm {
    public static String Name = "Algorithm";

    public static Random _Random = new Random();
    public static Information _Information = new Information();
    public static MenuStructures _MenuStructures = new MenuStructures();
    public static BubbleSort _BubbleSort = new BubbleSort();
    public static CocktailSort _CocktailSort = new CocktailSort();
    public static InsertionSort _InsertionSort = new InsertionSort();
    public static BucketSort _BucketSort = new BucketSort();
    public static CountingSort _CountingSort = new CountingSort();
    public static MergeSort _MergeSort = new MergeSort();
    public static BinaryTreeSort _BinaryTreeSort = new BinaryTreeSort();
    public static PigeonholeSort _PigeonholeSort = new PigeonholeSort();
    public static RadixSort _RadixSort = new RadixSort();
    public static GnomeSort _GnomeSort = new GnomeSort();
    public static ShellSort _ShellSort = new ShellSort();
    public static CombSort _CombSort = new CombSort();
    public static SelectionSort _SelectionSort = new SelectionSort();
    public static HeapSort _HeapSort = new HeapSort();
    public static QuickSort _QuickSort = new QuickSort();

    public static String[] _TypeStack = _Information.TypeAlgorithm;

    public MenuAlgorithm() {
    }

    public void CycleAlgorithm(int Operation) {
        do {
            Operation = 0;
            _MenuStructures.PrintArray(_TypeStack, Name);
            System.out.print("Write the number of one option: ");
            Operation = Option(Operation);
        } while (Operation != _TypeStack.length);
        return;
    }

    private int Option(int option) {
        try {
            option = Integer.parseInt(System.console().readLine());
        } catch (Exception e) {
        }
        var x = EnumAlgorithm.values()[option];
        System.out.println();
        Menu(x);
        return option;
    }

    private void Menu(EnumAlgorithm Algorithm) {
        switch (Algorithm) {
            case None:
                break;
            case Bubblesort:
                Name = "Bubblesort";
                int[] a = Multipurpose();
                System.out.println("Original: ");
                Print(a);
                _BubbleSort.bubbleSort(a);
                System.out.println("Bubblesort: ");
                Print(a);
                break;
            case Cocktailsort:
                Name = "Cocktailsort";
                int[] b = Multipurpose();
                System.out.println("Original: ");
                Print(b);
                _CocktailSort.cocktailSort(b);
                System.out.println("Cocktailsort: ");
                Print(b);
                break;
            case Insertionsort:
                Name = "Insertionsort";
                int[] c = Multipurpose();
                System.out.println("Original: ");
                Print(c);
                _InsertionSort.insertionSortAlgorithm(c);
                System.out.println("Insertionsort: ");
                Print(c);
                break;
            case Bucketsort:
                Name = "Bucketsort";
                int[] d = GenerarVectorDouble();
                System.out.println("Original: ");
                Print(d);
                _BucketSort.bucketSort(d);
                System.out.println("Bucketsort: ");
                Print(d);
                break;

            case Countingsort:
                Name = "Countingsort";
                int[] e = Multipurpose();
                System.out.println("Original: ");
                Print(e);
                _CountingSort.sort(e);
                System.out.println("Countingsort: ");
                Print(e);
                break;
            case Mergesort:
                Name = "Mergesort";
                int[] f = Multipurpose();
                System.out.println("Original: ");
                Print(f);
                _MergeSort.mergeSort(f);
                System.out.println("Mergesort: ");
                Print(f);
                break;
            case Binarytreesort:
                Name = "Binarytreesort";
                int[] g = Multipurpose();
                System.out.println("Original: ");
                Print(g);
                _BinaryTreeSort.sort(g);
                System.out.println("Binarytreesort: ");
                Print(g);
                break;
            case Pigeonhole:
                Name = "Pigeonhole";
                int[] h = Multipurpose();
                System.out.println("Original: ");
                Print(h);
                _PigeonholeSort.pigeonholeSort(h);
                System.out.println("Pigeonhole: ");
                Print(h);
                break;
            case Radixsort:
                Name = "Radixsort";
                int[] i = Multipurpose();
                System.out.println("Original: ");
                Print(i);
                _RadixSort.Sort(i);
                System.out.println("Radixsort: ");
                Print(i);
                break;
            case Gnomesort:
                Name = "Gnomesort";
                int[] s = Multipurpose();
                System.out.println("Original: ");
                Print(s);
                _GnomeSort.sort(s);
                System.out.println("Gnomesort: ");
                Print(s);
                break;
            case Shellsort:
                Name = "Shellsort";
                int[] r = Multipurpose();
                System.out.println("Original: ");
                Print(r);
                _ShellSort.shellSort(r);
                System.out.println("Shellsort: ");
                Print(r);
                break;
            case Combsort:
                Name = "Combsort";
                a = Multipurpose();
                System.out.println("Original: ");
                Print(a);
                _CombSort.sort(a);
                System.out.println("Combsort: ");
                Print(a);
                break;
            case Selectionsort:
                Name = "Selectionsort";
                e = Multipurpose();
                System.out.println("Original: ");
                Print(e);
                _SelectionSort.sort(e);
                System.out.println("Selectionsort: ");
                Print(e);
                break;
            case Heapsort:
                Name = "Heapsort";
                int[] l = Multipurpose();
                System.out.println("Original: ");
                Print(l);
                _HeapSort.sort(l);
                System.out.println("Heapsort: ");
                Print(l);
                break;
            case Quicksort:
                Name = "Quicksort";
                c = Multipurpose();
                System.out.println("Original: ");
                Print(c);
                _QuickSort.quickSort(c, 0, c.length - 1);
                System.out.println("Quicksort: ");
                Print(c);
                break;
            case Exit:
                break;
        }
    }

    private int[] Multipurpose() {
        var x = 0;

        System.out.println();
        System.out.print("How many numbers would you like to add: ");
        x = Integer.parseInt(System.console().readLine());
        System.out.println("\t@Andres Vazquez I22050385 Algorithm: " + Name + "\n");
        int[] array = new int[x];

        for (int i = 0; i < array.length; i++) {
            array[i] = _Random.nextInt(10000);
        }
        return array;
    }

    public int[] GenerarVectorDouble() {
        var Minon = 0;
        var Lenght = 0;
        var values = 5;

        System.out.println();
        System.out.print("How many numbers would you like to add: ");
        Lenght = Integer.parseInt(System.console().readLine());
        System.out.println("\t@Andres Vazquez I22050385 Algorithm: " + Name + "\n");
        List<Integer> _List = new ArrayList<>();

        for (int i = Minon; i < Lenght; i++) {
            if (i < values) {
                int NewValor = _Random.nextInt();
                _List.add(NewValor);
            } else {
                break;
            }
        }
        return _List.stream().mapToInt(Integer::intValue).toArray();
    }

    private void Print(int[] collection) {
        System.out.print("[");
        for (var item : collection) {
            System.out.print(" " + item + ", ");
        }
        System.out.println("]\n");
    }
}
