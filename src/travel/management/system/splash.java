package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class splash {
    splashFrame frame;
    splash(){
        frame=new splashFrame();
        frame.setVisible(true);
        int x=1;
        for(int i=1;i<=500;i+=4,x+=4){
            frame.setLocation(750-((x+i)/2),375-(i/2));
            frame.setSize(x+i,i);
            try{
                Thread.sleep(10);
            }
            catch (Exception e){

            }
        }
        frame.setVisible(true);
    }
}

class splashFrame extends JFrame implements Runnable{
        Thread t1;
        public void run(){
            try{
                Thread.sleep(5000);
                this.setVisible(false);
                new login().setVisible(true);
            }
            catch (Exception e){

            }
        }
        splashFrame(){
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/splash_.jpg"));
            Image i2=i1.getImage().getScaledInstance(1000,500, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel l1=new JLabel(i3);
            add(l1);
            setUndecorated(true);
            t1=new Thread(this);
            t1.start();
        // setBounds(200,200,1000,500);
        }
}