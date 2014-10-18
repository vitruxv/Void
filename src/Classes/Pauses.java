/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mondo
 */
public class Pauses {
    
    public void Pauses(){
    
}
    public void pause1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pause2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pause3() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pause4() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pause5() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Void.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
