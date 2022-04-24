/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Multithreadedwordproject;

import java.util.Scanner;

/**
 *
 * @author Jayden Kruger
 */
public class ThreadBase {
    boolean flagSet = false;
    boolean flagDone = false;
    int n;
    long wordCount = 0;
    int wordCounter = 0;
    Scanner reader;
    String word;
    
    public ThreadBase () {
        
    }
    
    //listens for the set command and then porcesses word length
    synchronized boolean get () {
        while (!flagSet) 
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception error caught: " + e.toString());
            }
        wordCount += word.length();
        flagSet = false;
        notify();
        return flagDone;
    }
    
    //fetches words and passes them to the get method
    synchronized boolean put () {
        while (flagSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception error caught: " + e.toString());
            }
        if (reader.hasNextLine()) {
            word = reader.nextLine();
            wordCounter++;
            flagSet = true;
            notify();
        } else {
            flagDone = true;
            flagSet = true;
            notify();
            return flagDone;
        }
        return flagDone;
    }
    
    public void setInputStream (Scanner reader) {
        this.reader = reader;
    }
    
    public long getWordLegnth () {
        return wordCount;
    }
    
    public int getWordAmount () {
        return wordCounter;
    }
}
