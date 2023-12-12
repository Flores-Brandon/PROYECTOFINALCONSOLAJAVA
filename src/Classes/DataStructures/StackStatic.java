/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataStructures;

/**
 *
 * @author andre
 */
public class StackStatic<T> {
     T[] elements;
     int ability;
     int contain;

    public StackStatic(int ability) {
        this.ability = ability;
        this.elements = (T[]) new Object[ability];
        this.contain = 0;
    }

    public void push(T element) {
        if (count() < ability) {
            elements[contain] = element;
            contain++;
        } else {
            System.out.println("Stack FULL!!!");
        }
    }

    public T pop() {
        if (contain > 0) {
            contain--;
            T element = elements[contain];
            elements[contain] = null; // Restoring the value to its default value (null for references)
            return element;
        } else {
            System.out.println("Void Stack");
            return null; // Default value for type T (null for references)
        }
    }

    public T peek() {
        if (contain > 0) {
            System.out.println(elements[contain - 1]);
            return elements[contain - 1];
        } else {
            System.out.println("Void Stack");
            return null; // Default value for type T
        }
    }

    public void show(StackStatic<T> stack) {
        if (count() == 0) {
            System.out.println("Void Stack");
            return;
        }
        System.out.println("=== My Stack Static ===");
        while (count() > 0) {
            System.out.println(pop());
        }
    }

    public int count() {
        return contain;
    }
}
