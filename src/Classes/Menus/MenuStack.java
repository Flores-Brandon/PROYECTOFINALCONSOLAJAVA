/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Menus;
import Classes.Information;
import java.util.Scanner;
import Classes.Enum.*;
import Classes.SubMenus.*;
/**
 *
 * @author andre
 */
public class MenuStack {
    public static String Name = "Stack";
    
    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static SubMenuStackS _ShowSubMenuStackS = new SubMenuStackS();
    public static SubMenuStackD _ShowSubMenuStackD = new SubMenuStackD();

    public static String[] _TypeStack = _Information.TypeStack;

    public MenuStack() { }

    public void CycleStack(int Operation) {
        do {
            Operation = 0;
            _ShowMenuStructures.PrintArray(_TypeStack, Name);
            System.out.print("Write the number of one option: ");
            Operation = Option(Operation);
        } while (Operation != _TypeStack.length);
        return;
    }

    private int Option(int option) {
        try {
            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) { }
        EnumTypeStack x = EnumTypeStack.values()[option];
        System.out.print("\033[H\033[2J");
        Menu(option, x);
        return option;
    }

    private void Menu(int Numer, EnumTypeStack Stacks) {
        switch (Stacks) {
            case StackStatic -> _ShowSubMenuStackS.MenuOption(Numer);

            case StackDinamic -> _ShowSubMenuStackD.MenuOption(Numer);
        }
    }
}
