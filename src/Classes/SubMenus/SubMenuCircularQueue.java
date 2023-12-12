/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SubMenus;
import java.util.Random;
import Classes.Information;
import Classes.Menus.*;
import Classes.DataStructures.*;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class SubMenuCircularQueue {
    public static String Name = "Circular Queue";

    private static Random random = new Random();
    private static Information information = new Information();
    private static MenuStructures showMenuStructures = new MenuStructures();
    private static CircularQueue items = new CircularQueue(20);

    private static String[] optionList = information.Queue;

    public SubMenuCircularQueue() {
    }

    public void menuOption(int operation) {
        do {
            operation = 0;
            showMenuStructures.PrintArray(optionList, Name);
            System.out.print("Write the number of one option: ");
            operation = option(operation);
        } while (operation != optionList.length - 1);
    }

    private int option(int option) {
        try {option = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {}
        var x =EnumOperationsQueue.values()[option];
        System.out.println();
        methods(x);
        return option;
    }

    public void methods(EnumOperationsQueue stack) {
        int data = 0;
        switch (stack) {
            case Generate -> {
                System.out.print("Generate: ");
                try {
                    data = Integer.parseInt(System.console().readLine());
                } catch (NumberFormatException e) {
                }
                for (int i = 0; i < data; i++) {
                    items.enqueue(random.nextInt(100000));
                }
                System.out.println("Finish");
            }

            case Enqueue -> {
                System.out.println("How many numbers would you like to add: ");
                try {
                    data = Integer.parseInt(System.console().readLine());
                } catch (NumberFormatException e) {
                }
                items.enqueue(data);
            }

            case Dequeue -> items.dequeue();

            case Show -> items.show();

            case Clear -> items.clear();
        }
    }
}
