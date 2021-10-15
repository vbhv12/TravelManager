package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements  ActionListener{
    String s="";
    JButton b1;
    About(){
        setUndecorated(true);
        setBounds(550,200,500,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);


        JLabel l1=new JLabel("Travel Manager");
        l1.setBounds(170,10,400,80);
        l1.setForeground(new Color(186,85,211));
        l1.setFont(new Font("Tahoma",Font.BOLD,24));
        add(l1);



        s="                                   About Project \n" +
                " \n"+
                "The objective of the Travel and Tourism Management System project is to develop a system that automates the processes and activities of a travel and tourism agency. \n" +
                "The purpose is to design a system using which one can perform all operations related to traveling and sight-seeing.\n" +
                "The system allows one to easily access the relevant information and make necessary travel arrangements. Users can decide about places they want to visit and make bookings online for travel and accommodation.";
        TextArea t1=new TextArea(s,10,40,Scrollbar.VERTICAL);
        add(t1);
        t1.setEditable(false);
        t1.setFont(new Font("Tahoma",Font.PLAIN,18));
        t1.setBounds(20,100,450,300);

        b1=new JButton("Close");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(210,420,80,30);
        add(b1);
        b1.addActionListener((ActionListener) this);
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
