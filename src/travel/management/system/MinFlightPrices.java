package travel.management.system;

import com.mysql.cj.protocol.Resultset;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MinFlightPrices extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6;
    JComboBox c1;
    JRadioButton r1,r2;
    JButton b1,b2;
    String username="";
    JLabel l11,l12;
    JDateChooser date;
    DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    MinFlightPrices(){
        setBounds(400,150,700,360);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1=new JLabel("Enter details to find Minimum price of flights");
        l1.setBounds(90,10,420,30);
        l1.setForeground(new Color(148,0,211));
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);

        JLabel l2=new JLabel("Please Enter Iata Codes Of Airports");
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l2);
        l2.setBounds(30,90,300,25);
        JLabel l3=new JLabel("From :");
        l3.setBounds(30,130,150,25);
        add(l3);
        t2=new JTextField("DEL");
        t2.setBounds(220,130,150,25);
        add(t2);

        JLabel l4=new JLabel("To :");
        l4.setBounds(30,170,150,25);
        add(l4);
        t3=new JTextField("BOM");
        t3.setBounds(220,170,150,25);
        add(t3);


        JLabel l8=new JLabel("Departure Date :");
        l8.setBounds(30,210,150,25);
        add(l8);

        date=new JDateChooser();
        date.setDateFormatString("yyyy-MM-dd");
        date.setBounds(220,210,150,25);
        add(date);


        b1=new JButton("Search");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(70,260,100,25);
        add(b1);
        b1.addActionListener((ActionListener) this);



        b2=new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220,260,100,25);
        add(b2);
        b2.addActionListener((ActionListener) this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/Airplane_.png"));
        Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(450,100,150,150);
        add(l9);

    }

    public static void main(String[] args) {

        new MinFlightPrices().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String dates=((JTextField) date.getDateEditor().getUiComponent()).getText();
        System.out.println(dates);
        if(e.getSource()==b1){
            try {
                new ApiTest(t2.getText(),t3.getText(),dates+"");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            this.setVisible(false);
        }
        else{
            this.setVisible(false);
            new dashboard(username).setVisible(true);
        }
    }
}
