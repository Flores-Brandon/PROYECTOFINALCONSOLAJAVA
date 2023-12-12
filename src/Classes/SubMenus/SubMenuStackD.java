/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SubMenus;
import java.util.Random;
import java.util.Scanner;
import Classes.*;
import Classes.Menus.MenuStructures;
import Classes.DataStructures.StackDinamic;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class SubMenuStackD {
    public static String Name = "Dynamic Stack";

    public static Random _Random = new Random();
    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static StackDinamic<Integer> _Items = new StackDinamic<>();

    public static String[] _OptionList = _Information.Stack;

    public SubMenuStackD() { }

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
        EnumOperationsStack x = EnumOperationsStack.values()[option];
        System.out.print("\033[H\033[2J");
        Method(x);
        return option;
    }

    public void Method(EnumOperationsStack Stack) {
        int Data = 0;
        switch (Stack) {
            case Generate -> {
                System.out.print("How many numbers would you like to add: ");
                try {
                    Data = Integer.parseInt(new Scanner(System.in).nextLine());
                } catch (NumberFormatException e) { }
                for (int i = 0; i < Data; i++) {
                    _Items.push(_Random.nextInt(100000));
                }
                System.out.println("Finish");
                new Scanner(System.in).nextLine();
            }

            case Push -> {
                System.out.println("Insert one data: ");
                try {
                    Data = Integer.parseInt(new Scanner(System.in).nextLine());
                } catch (NumberFormatException e) { }
                _Items.push(Data);
            }

            case Pop -> _Items.pop();

            case Peek -> {
                System.out.println("Peek");
                _Items.peek();
                new Scanner(System.in).nextLine();
            }

            case Contains -> {
                System.out.print("Contains: " + _Items.count);
                new Scanner(System.in).nextLine();
            }

            case Show -> {
                _Items.show(_Items);
                new Scanner(System.in).nextLine();
            }
        }
    }
}
