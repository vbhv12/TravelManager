package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class loading extends JFrame implements Runnable{
    JProgressBar p;
    Thread t;
    String username;
    loading(String username){
        this.username=username;
        t=new Thread(this);
        setBounds(500,250,600,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel l1=new JLabel("Welcome to Diwan Travels");
        l1.setBounds(65,20,600,40);
        l1.setFont(new Font("Ralewat",Font.BOLD,35));
        l1.setForeground(new Color(148,0,211));
        add(l1);
        p=new JProgressBar();
        p.setStringPainted(true);
        p.setBounds(130,150,330,20);
        add(p);

        JLabel l2=new JLabel("Loading...");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma",Font.BOLD,16));
        l2.setBounds(255,175,100,20);
        add(l2);

        JLabel l3=new JLabel("Welcome "+username);
        l3.setForeground(new Color(148,0,211));
        l3.setFont(new Font("Tahoma",Font.BOLD,16));
        l3.setBounds(20,310,400,20);
        add(l3);
        t.start();
    }
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int m=p.getMaximum();
                int n=p.getValue();
                if(n<m){
                    p.setValue(p.getValue()+1);
                }
                else{
                    i=101;
                    setVisible(false);
                    new dashboard(username).setVisible(true);
                }
                Thread.sleep(50);
            }

        }
        catch(Exception e){

        }
    }
    public static void main(String[] args) {
        new loading("").setVisible(true);
    }
}
