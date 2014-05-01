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
public class TimeManagement {
    Timer t;
    
    public TimeManagement(TimerSet ts) {
        t = new Timer(1000, new AC(ts));
    }
    
    public void setDelay(int d) {
        t.setDelay(d);
    }
    
    static class AC implements ActionListener
    {
        TimerSet ts;
        int time;
        public AC(TimerSet ts) {
            this.ts = ts;
            time = 0;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            ts.setTime(++time);
        }
        
    }
}
