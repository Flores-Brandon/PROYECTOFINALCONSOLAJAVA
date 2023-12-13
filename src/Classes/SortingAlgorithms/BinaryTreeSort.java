/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SortingAlgorithms;
import Classes.BinaryTreeNode;
/**
 *
 * @author andre
 */

public class BinaryTreeSort {
    private BinaryTreeNode root;

    public BinaryTreeSort() {
    }

    public void sort(int[] arr) {
        // Construir el árbol binario
        for (int value : arr) {
            root = insert(root, value);
        }

        // Recorrer el árbol en orden para obtener los elementos ordenados
        int index = 0;
        inOrderTraversal(root, arr, index);
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int value) {
        if (node == null) {
            return new BinaryTreeNode(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    private void inOrderTraversal(BinaryTreeNode node, int[] arr, int index) {
        if (node != null) {
            inOrderTraversal(node.left, arr, index);
            arr[index] = node.value;
            inOrderTraversal(node.right, arr, ++index);
        }
    }
}
