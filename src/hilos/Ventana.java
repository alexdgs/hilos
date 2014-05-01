/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hilos;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author User
 */
public class Ventana extends JFrame{
    
    ArrayList<JLabel> balls;
    
    public Ventana(int b) {
        
        balls = new ArrayList<>();
        
        for(int i = 1; i <= b; i++) {
            JLabel ball = new JLabel("MyBall " + i,new ImageIcon("src/img/ball" + i + ".png"),JLabel.LEFT);
            this.add(ball);
            ball.setBounds(5,i*35,100,30);
            ball.setVisible(true);
            balls.add(ball);
        }
        
        setLayout(null);
        setTitle("Timer Practice");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setBall(int i) {
        balls.get(i).setLocation((balls.get(i).getX()+5)%300, balls.get(i).getY());
    }
}
