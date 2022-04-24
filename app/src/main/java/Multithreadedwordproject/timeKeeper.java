/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Multithreadedwordproject;

/**
 *
 * @author Jayden Kruger
 */
public class timeKeeper {
    private long startTimer;
    
    public timeKeeper () {
        startTimer = System.currentTimeMillis();
    }
    
    public void startTimer () {
        startTimer = System.currentTimeMillis();
    }
    
    public long elpasedTime () {
        return System.currentTimeMillis() - startTimer;
    }
}
