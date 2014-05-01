/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hilos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Main {
    
    static int b;
    static int x;
    static int x1,x2,y1,y2;
    static int time;
    static int delay;
    //static Ventana v;
    static VentanaAuto va;
    static Timer t;
    static Timer t2;
    static TimeManagement tm;
    static TimerSet ts;
    
    public static void main(String[] args) {
        ts = new TimerSet();
        tm = new TimeManagement(ts);
        ts.setManager(tm);
        ts.setVisible(true);
        tm.t.start();
        /*b = 6;
        x = 5;
        v = new Ventana(b);
        t = new Timer(10, new AC(b));
        t.start();*/
        /*x1 = 350;
        y1 = 250;
        x2 = 5;
        y2 = 50;
        time = 0;
        delay = 10;
        
        va = new VentanaAuto();
        va.setLayout(null);
        va.setPlaces(x1,y1,x2,y2);
        va.setVisible(true);
        t = new Timer(delay, new AC2());
        t2 = new Timer(delay, new AC3(0));
        
        t.start();*/
        
    }
    
    static class AC implements ActionListener {
        
        int c;
        int b;
        
        public AC(int b) {
            this.b = b;
            this.c = 0;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            c = (int) (Math.random() * b);
            //v.setBall(c);
        }
    }
    
    static class AC2 implements ActionListener {
        
        int cx;
        int cy;
        
        public AC2() {
            cx = x1;
            cy = y1;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cx == x2 && cy == y2) {
                t.stop();
                va.mostrar("Done! in " + time + " ms.");
                
                x2 = x1;
                y2 = y1;
                t2.start();
            } else {
                if(cx == x2) {
                    if(cy < y2) cy++;
                    else cy--;
                } else if(cy == y2) {
                    if(cx < x2) cx++;
                    else cx--;
                } else {
                    if(cx < x2) cx++;
                    else cx--;
                    if(cy < y2) cy++;
                    else cy--;
                }
                va.mover(cx,cy);
            }
            time += delay;
        }
    }
    
    static class AC3 implements ActionListener {
        
        final int C = 5000;
        int cap;
        
        public AC3(int c) {
            cap = c;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cap >= C) {
                t2.stop();
                va.mostrar("Full! Returning...");
                cap = 0;
                t.start();
            } else {
                cap += delay;
            }
        }
    }
}
