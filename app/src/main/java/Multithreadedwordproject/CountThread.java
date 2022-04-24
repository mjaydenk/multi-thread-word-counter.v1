/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Multithreadedwordproject;

/**
 *
 * @author Jayden Kruger
 */
public class CountThread implements Runnable {

    ThreadBase base;
    Thread t;
    boolean flagDone = false;
    
    CountThread (ThreadBase base) {
        this.base = base;
        t = new Thread (this, "Consumer");
    }
    
    @Override
    public void run() {
        
        while (!flagDone) {
            flagDone = base.get();
        }
    }
    
}
