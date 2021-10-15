package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewBookedHotel extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1;
    String username;
    viewBookedHotel(String username){
        this.username=username;
        setBounds(475,200,700,450);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel head=new JLabel("View Destination and Booked Hotel");
        head.setBounds(60,10,500,30);
        head.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(head);

        JLabel l11=new JLabel("Email ID :");
        l11.setBounds(30,70,200,30);
        add(l11);

        l1=new JLabel();
        l1.setBounds(250,70,200,30);
        add(l1);

        JLabel l12=new JLabel("Destination :");
        l12.setBounds(30,110,200,30);
        add(l12);

        l2=new JLabel();
        l2.setBounds(250,110,200,30);
        add(l2);


        JLabel l13=new JLabel("Booked Hotel :");
        l13.setBounds(30,150,200,30);
        add(l13);

        l3=new JLabel();
        l3.setBounds(250,150,200,30);
        add(l3);

        JLabel l14=new JLabel("Number of Days:");
        l14.setBounds(30,190,200,30);
        add(l14);

        l4=new JLabel();
        l4.setBounds(250,190,200,30);
        add(l4);

        JLabel l15=new JLabel("Room Type:");
        l15.setBounds(30,230,200,30);
        add(l15);

        l5=new JLabel();
        l5.setBounds(250,230,200,30);
        add(l5);

        JLabel l16=new JLabel("Hotel Price:");
        l16.setBounds(30,270,200,30);
        add(l16);

        l6=new JLabel();
        l6.setBounds(250,270,200,30);
        add(l6);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/newcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(370,420,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l8=new JLabel(i3);
        l8.setBounds(350,40,370,420);
        add(l8);


        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from bookhotel where email_id='"+username+"'");
            while(rs.next()){
                l1.setText(rs.getString("email_id"));
                l2.setText(rs.getString("dest"));
                l3.setText(rs.getString("hotel"));
                l4.setText(rs.getString("days"));
                l5.setText(rs.getString("ac_inc")+" Room");
                l6.setText(rs.getString("t_price"));

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
        new viewBookedHotel("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            this.setVisible(false);
        }
    }
}
