/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SortingAlgorithms;

/**
 *
 * @author andre
 */
public class ShellSort {
    public ShellSort() {
    }

    public void shellSort(int[] array) {
        // Obtener la longitud del array
        int n = array.length;
        // Obtener el tamaño de espacio entre elementos
        int gap = n / 2;

        System.out.println("\nInicio del algoritmo Shell Sort:");

        // Mientras el espacio entre elementos sea mayor que 0
        while (gap > 0) {
            System.out.println("\nGap actual: " + gap);

            // Aplicar el algoritmo de inserción para cada "subarray" con el tamaño de gap
            for (int i = gap; i < n; i++) {
                // Guardar el valor actual del elemento en una variable temporal
                int temp = array[i];
                int j = i;

                System.out.println("\nComparando " + temp + " con los elementos en su subarray:");

                // Realizar la inserción
                while (j >= gap && array[j - gap] > temp) {
                    // Desplazar elementos hacia la derecha hasta encontrar la posición correcta
                    array[j] = array[j - gap];
                    j -= gap;

                    printArray(array);
                }

                // Colocar el valor temporal en la posición correcta en el subarray
                array[j] = temp;
                System.out.println("Insertar " + temp + " en la posición " + j + " del subarray:");
                printArray(array);
            }

            // Reducir el espacio entre elementos a la mitad en cada iteración
            gap /= 2;
        }

        System.out.println("\nFin del algoritmo Shell Sort:");
    }

    private void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
