/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.ComThreadVersao4;

/**
 *
 * @author kelly
 */
public class SimpleThread extends Thread {
    public SimpleThread(String str) {
        super(str);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        System.out.println("DONE! " + getName());
    }
    
    
    public static void main (String[] args) {
        new SimpleThread("Jamaica").start();
        new SimpleThread("Fiji").start();
        
        /* A saída de cada thread se mistura com a outra já que os programas são concorrentes*/
        /* Quando o loop termina, o thread morre
        Quando os dois threads morrem (o original já está morto), o programa termina*/
    }
}