/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rs245c
 */
public class Factory {
    
    public static void main(String[] args) {
        
    
    String[ ] aryType = new String[3] ;

    aryType[0] = "";
    aryType[1] = "";
    aryType[2] = "";
    String userinput = "";
    
    if(aryType[0].equalsIgnoreCase("Factory"))
    {
        System.out.println("You have created a Factory Ship.");
    }
    else if (aryType[1].equalsIgnoreCase("Fighter"))
    {
        System.out.println("You have created a Fighter.");
    }
    else if (aryType[2].equalsIgnoreCase("Scavenger"))
    {
        System.out.println("You have created a Scavenger.");
    }
    else 
    {
        System.out.println("Invalid Input.");
    }
            
                
            
    }
    
  
            
    
}
