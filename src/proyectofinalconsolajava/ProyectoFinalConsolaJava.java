/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinalconsolajava;
import Classes.Menus.MenuStructures;
import Classes.*;
/**
 *
 * @author andre
 */
public class ProyectoFinalConsolaJava {
            

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           int Option = 0;
            MenuStructures Menu = new MenuStructures();
     do
    {
     Option = 0;
     Menu.PrintArray(Menu._TypeDataStructures, Menu.Name);
    System.out.print("Write the number of one option: ");
     Option = Menu.Option(Option);
    } while (Option != 7);
           
           
           
    }
    
}
