/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.math.BigDecimal;

/**
 *
 * @author andre
 * @param <T>
 */
public class Node<T> implements Comparable<Node<T>> {
    public Node<T> next;
    public T data;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(Node<T> anotherData) {
        if (isNumerical(data) && isNumerical(anotherData.getData())) {
            long value1 = Long.parseLong(data.toString());
            long value2 = Long.parseLong(anotherData.getData().toString());
            return Long.compare(value1, value2);
        }

        if (isNumerical(data) && (anotherData.getData() instanceof String || anotherData.getData() instanceof Character)) {
            long value1 = Long.parseLong(data.toString());
            long value2 = anotherData.getData().toString().length();
            return Long.compare(value1, value2);
        }

        if (isNumerical(anotherData.getData()) && (data instanceof String || data instanceof Character)) {
            long value1 = data.toString().length();
            long value2 = Long.parseLong(anotherData.getData().toString());
            return Long.compare(value1, value2);
        }

        if (data instanceof Comparable<?> && anotherData.getData() instanceof Comparable<?>) {
            return Integer.compare(data.toString().length(), anotherData.getData().toString().length());
        }

        return 0;
    }

    private boolean isNumerical(Object value) {
        return value instanceof Byte || value instanceof Short || value instanceof Integer ||
               value instanceof Long || value instanceof Float || value instanceof Double ||
               value instanceof BigDecimal;
    }
}
