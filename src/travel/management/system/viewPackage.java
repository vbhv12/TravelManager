package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewPackage extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1;
    String username;
    viewPackage(String username){
        this.username=username;
        setBounds(475,200,700,450);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel head=new JLabel("VIEW PACKAGE DETAILS");
        head.setBounds(60,10,300,30);
        head.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(head);

        JLabel l11=new JLabel("Email ID :");
        l11.setBounds(30,70,200,30);
        add(l11);

        l1=new JLabel();
        l1.setBounds(250,70,200,30);
        add(l1);

        JLabel l12=new JLabel("Package:");
        l12.setBounds(30,110,200,30);
        add(l12);

        l2=new JLabel();
        l2.setBounds(250,110,200,30);
        add(l2);


        JLabel l13=new JLabel("Total Packages:");
        l13.setBounds(30,150,200,30);
        add(l13);

        l3=new JLabel();
        l3.setBounds(250,150,200,30);
        add(l3);

        JLabel l14=new JLabel("Identity:");
        l14.setBounds(30,190,200,30);
        add(l14);

        l4=new JLabel();
        l4.setBounds(250,190,200,30);
        add(l4);

        JLabel l15=new JLabel("Number:");
        l15.setBounds(30,230,200,30);
        add(l15);

        l5=new JLabel();
        l5.setBounds(250,230,200,30);
        add(l5);

        JLabel l16=new JLabel("Phone:");
        l16.setBounds(30,270,200,30);
        add(l16);

        l6=new JLabel();
        l6.setBounds(250,270,200,30);
        add(l6);

        JLabel l17=new JLabel("Price:");
        l17.setBounds(30,310,200,30);
        add(l17);

        l7=new JLabel();
        l7.setBounds(250,310,200,30);
        add(l7);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel1.jpg"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l8=new JLabel(i3);
        l8.setBounds(350,50,350,300);
        add(l8);


        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from bookpackage where username='"+username+"'");
            while(rs.next()){
                l1.setText(rs.getString("username"));
                l2.setText(rs.getString("package"));
                l3.setText(rs.getString("persons"));
                l4.setText(rs.getString("id"));
                l5.setText(rs.getString("number"));
                l6.setText(rs.getString("phone"));
                l7.setText(rs.getString("price"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

         b1=new JButton("Back");
        b1.setBounds(150,350,150,25);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        add(b1);
        b1.addActionListener((ActionListener) this);


    }
    public static void main(String[] args) {
        new viewPackage("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            this.setVisible(false);
        }
    }
}
