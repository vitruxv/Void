/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author rs245c
 */
public class Menus {
    
    
    public void Menus(){
        
        
    
}
    
    
    public void getHelpMenu() {

        System.out.println("\n............................");
        System.out.println("<Load>");
        System.out.println("<Save>");
        System.out.println("<Fire>");
        System.out.println("<Jump>");
        System.out.println("<Locate>");
        System.out.println("<Channel> (Not Ready)");
        System.out.println("<Exit>");
        System.out.println("<Scan> (Not Ready)");
        System.out.println("............................\n\n");

    }
    
    public void getbuildMenu() {

        menuBar();
        if (factory > 0) {

            pause1();
            soundTyping();
            commandPal();
            System.out.println(" Link established...");
            commandPal();
            System.out.println(" Loading build options...");
            pause1();
            menuBar();
            if (level ==1){
                level1BuildOptions();
            }
            else if (level ==2){
                System.out.println("Display Level 2 options.");
            }
        }    
           else {
            System.out.println(" \nFactory not Online...");
        } 
        
    }
}
