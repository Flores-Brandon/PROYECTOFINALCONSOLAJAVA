/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SubMenus;
import java.util.Random;
import java.util.Scanner;
import Classes.Information;
import Classes.Menus.*;
import Classes.DataStructures.*;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class SubMenuQueue {
    public static String Name = "Queue";

    public static Random _Random = new Random();
    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static Queue _Items = new Queue();

    public static String[] _OptionList = _Information.Queue;

    public SubMenuQueue() { }

    public void MenuOption(int Operation) {
        do {
            Operation = 0;
            _ShowMenuStructures.PrintArray(_OptionList, Name);
            System.out.print("Write the number of one option: ");
            Operation = Option(Operation);
        } while (Operation != _OptionList.length - 1);
    }

    private int Option(int option) {
        try {
            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) { }
        System.out.print("\033[H\033[2J");
        Method(EnumOperationsQueue.values()[option]);
        return option;
    }

    public void Method(EnumOperationsQueue Stack) {
        int Data = 0;
        switch (Stack) {
            case Generate -> {
                System.out.print("Generate: ");
                try {
                    Data = Integer.parseInt(new Scanner(System.in).nextLine());
                } catch (NumberFormatException e) { }
                for (int i = 0; i < Data; i++) {
                    _Items.Enqueue(_Random.nextInt(100000));
                }
                System.out.println("Finish");
                new Scanner(System.in).nextLine();
            }

            case Enqueue -> {
                System.out.println("How many numbers would you like to add: ");
                try {
                    Data = Integer.parseInt(new Scanner(System.in).nextLine());
                } catch (NumberFormatException e) { }
                _Items.Enqueue(Data);
            }

            case Dequeue -> _Items.Dequeue();

            case Show -> {
                _Items.Show();
                new Scanner(System.in).nextLine();
            }

            case Clear -> _Items.clear();
        }
    }
}
