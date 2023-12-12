/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Menus;
import java.util.Scanner;
import Classes.Information;
import Classes.SubMenus.*;
import Classes.Enum.*;
import Classes.DataStructures.DoublyListLinked;
/**
 *
 * @author andre
 */
public class MenuList {
    public static String Name = "List";

    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static SubMenu_SL _ShowSubMenu_SL = new SubMenu_SL();
    public static SubMenu_CL _ShowSubMenu_CL = new SubMenu_CL();
    public static SubMenu_DLL _ShowSubMenu_DLL = new SubMenu_DLL();
    public static SubMenu_CDLL _ShowSubMenu_CDLL = new SubMenu_CDLL();

    public String[] _TypeList = _Information.TypeList;
    public static String[] _OptionList = _Information.List;

    public MenuList() {
    }

    public void cycleList(int operation) {
        do {
            operation = 0;
            _ShowMenuStructures.PrintArray(_TypeList, Name);
            System.out.print("Write the number of one option: ");
            operation = option(operation);
        } while (operation != _TypeList.length);
    }

    private int option(int option) {
        try {
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
        } catch (Exception e) {
        }
        System.out.println();
        menu(option, EnumTypeList.values()[option]);
        return option;
    }

    private void menu(int number, EnumTypeList lists) {
        switch (lists) {
            case SimpleList:
                _ShowSubMenu_SL.menuOption(number);
                break;

            case CircularList:
                _ShowSubMenu_CL.MenuOption(number);
                break;

            case DoubleLinkedlist:
                _ShowSubMenu_DLL.MenuOption(number);
                break;

            case CircularDoubleLinkedList:
                _ShowSubMenu_CDLL.MenuOption(number);
                break;
        }
    }
}
