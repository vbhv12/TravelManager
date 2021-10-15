package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payment extends JFrame implements ActionListener {
    JButton b1,b2;
    payment(){
        setBounds(450,240,700,400);
        setLayout(null);
        getContentPane().setBackground(Color.white);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/paytm.png"));
        Image i2=i1.getImage().getScaledInstance(700,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l8=new JLabel(i3);
        l8.setBounds(0,0,700,400);
        add(l8);

        b1=new JButton("Pay");
        b1.setBounds(450,20,80,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        l8.add(b1);
        b1.addActionListener((ActionListener)this);


        b2=new JButton("Back");
        b2.setBounds(550,20,80,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        l8.add(b2);
        b2.addActionListener((ActionListener)this);
    }

    public static void main(String[] args) {
        new payment().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
          this.setVisible(false);
          new paytm();
        }
        else{
            this.setVisible(false);
        }
    }
}
