/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Menus;
import Classes.Information;
import Classes.SubMenus.*;
import java.util.Scanner;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class MenuQueue {
    public static String Name = "Queue";

    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static SubMenuQueue _SubMenuQueue = new SubMenuQueue();
    public static SubMenuCircularQueue _SubMenuCircular = new SubMenuCircularQueue();
    public static SubMenuPriorityQueue _SubMenuPriorityQueue = new SubMenuPriorityQueue();

    public static String[] _TypeQueue = _Information.TypeQueue;

    public MenuQueue() { }

    public void CycleQueue(int Operation) {
        do {
            Operation = 0;
            _ShowMenuStructures.PrintArray(_TypeQueue, Name);
            System.out.print("Write the number of one option: ");
            Operation = Option(Operation);
        } while (Operation != _TypeQueue.length);
    }

    private int Option(int option) {
        try {
            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) { }
        System.out.print("\033[H\033[2J");
        Menu(option, EnumTypeQueue.values()[option]);
        return option;
    }

    private void Menu(int Numer, EnumTypeQueue Stacks) {
        switch (Stacks) {
            case Queue -> _SubMenuQueue.MenuOption(Numer);

            case CircularQueue -> _SubMenuCircular.menuOption(Numer);

            case PriorityQueues -> _SubMenuPriorityQueue.MenuOption(Numer);
        }
    }
}
