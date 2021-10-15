package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17;
    String username="";
    dashboard(String username){
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1950,60);
        p1.setBackground(Color.black);
        add(p1);


        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,60,300,1000);
       // p2.setBackground(new Color(186,85,211));
        p2.setBackground(Color.black);
        add(p2);

        b1=new JButton("Add Personal Details");
        //b1.setBackground(new Color(186,85,211));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.setMargin(new Insets(0,0,0,60));
        b1.setBounds(0,0,300,50);
        //b1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b1);
        b1.addActionListener((ActionListener) this);

        b2=new JButton("Update Personal Details");
        b2.setBackground(new Color(186,85,211));
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.setMargin(new Insets(0,0,0,30));
        b2.setBounds(0,50,300,50);
        //b2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b2);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener((ActionListener) this);

        b3=new JButton("View Details");
        b3.setBackground(new Color(186,85,211));
        b3.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3.setBounds(0,100,300,50);

        b3.setMargin(new Insets(0,0,0,130));
        //b3.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b3);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener((ActionListener) this);

        b4=new JButton("Delete Personal Details");
        b4.setBackground(new Color(186,85,211));
        b4.setFont(new Font("Tahoma",Font.PLAIN,20));
        b4.setBounds(0,150,300,50);
        b4.setMargin(new Insets(0,0,0,35));
       // b4.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b4);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.addActionListener((ActionListener) this);

        b5=new JButton("Check Package");
        b5.setBackground(new Color(186,85,211));
        b5.setFont(new Font("Tahoma",Font.PLAIN,20));
        b5.setBounds(0,200,300,50);
        b5.setMargin(new Insets(0,0,0,110));
        //b5.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b5);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.addActionListener((ActionListener) this);

        b6=new JButton("Book Package");
        b6.setBackground(new Color(186,85,211));
        b6.setFont(new Font("Tahoma",Font.PLAIN,20));
        b6.setBounds(0,250,300,50);
        b6.setMargin(new Insets(0,0,0,115));
        //b6.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b6);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.addActionListener((ActionListener) this);

        b7=new JButton("View Booked Package");
        b7.setBackground(new Color(186,85,211));
        b7.setFont(new Font("Tahoma",Font.PLAIN,20));
        b7.setBounds(0,300,300,50);

        b7.setMargin(new Insets(0,0,0,40));
        //b7.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b7);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.addActionListener((ActionListener) this);
        /*
        b8=new JButton("View Hotels");
        b8.setBackground(new Color(186,85,211));
        b8.setFont(new Font("Tahoma",Font.PLAIN,20));
        b8.setBounds(0,350,300,50);

        b8.setMargin(new Insets(0,0,0,130));
        //b8.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b8);
        */

        b9=new JButton("Book Hotel");
        b9.setBackground(new Color(186,85,211));
        b9.setFont(new Font("Tahoma",Font.PLAIN,20));
        b9.setBounds(0,350,300,50);
        b9.setMargin(new Insets(0,0,0,135));
        //b9.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b9);
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.addActionListener((ActionListener) this);

        b10=new JButton("View Booked Hotel");
        b10.setBackground(new Color(186,85,211));
        b10.setFont(new Font("Tahoma",Font.PLAIN,20));
        b10.setBounds(0,400,300,50);

        b10.setMargin(new Insets(0,0,0,65));
        //b10.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b10);
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.addActionListener((ActionListener) this);

        b12=new JButton("Make Payments");
        b12.setBackground(new Color(186,85,211));
        b12.setFont(new Font("Tahoma",Font.PLAIN,20));
        b12.setBounds(0,450,300,50);
        b12.setMargin(new Insets(0,0,0,100));
        //b12.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b12);
        b12.setBackground(Color.black);
        b12.setForeground(Color.white);
        b12.addActionListener((ActionListener) this);


        b17=new JButton("Minimum Flight Prices");
        b17.setBackground(new Color(186,85,211));
        b17.setFont(new Font("Tahoma",Font.PLAIN,20));
        b17.setBounds(0,500,300,50);
        b17.setMargin(new Insets(0,0,0,50));
        //b12.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b17);
        b17.setBackground(Color.black);
        b17.setForeground(Color.white);
        b17.addActionListener((ActionListener) this);

        b13=new JButton("Calculator");
        b13.setBackground(new Color(186,85,211));
        b13.setFont(new Font("Tahoma",Font.PLAIN,20));
        b13.setBounds(0,550,300,50);
        b13.setMargin(new Insets(0,0,0,155));
        //b13.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b13);
        b13.setBackground(Color.black);
        b13.setForeground(Color.white);
        b13.addActionListener((ActionListener) this);

        b14=new JButton("Notepad");
        b14.setBackground(new Color(186,85,211));
        b14.setFont(new Font("Tahoma",Font.PLAIN,20));
        b14.setBounds(0,600,300,50);

        b14.setMargin(new Insets(0,0,0,165));
        //b14.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b14);
        b14.setBackground(Color.black);
        b14.setForeground(Color.white);
        b14.addActionListener((ActionListener) this);

        b15=new JButton("About");
        b15.setBackground(new Color(186,85,211));
        b15.setFont(new Font("Tahoma",Font.PLAIN,20));
        b15.setBounds(0,650,300,50);
        b15.setMargin(new Insets(0,0,0,190));
        p2.add(b15);
        b15.setBackground(Color.black);
        b15.setForeground(Color.white);
        b15.addActionListener((ActionListener)this);


        b16=new JButton("Logout");
        b16.setFont(new Font("Tahoma",Font.PLAIN,20));
        b16.setBounds(0,700,300,50);
        b16.setMargin(new Insets(0,0,0,190));
        p2.add(b16);
        b16.setBackground(new Color(186,85,211));
        b16.setForeground(Color.black);
        b16.addActionListener((ActionListener) this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dashboard_.jpg"));
        Image i2=i1.getImage().getScaledInstance(1950,1000, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,1950,1000);
        add(l1);

        JLabel l3=new JLabel("Dashboard");
        l3.setFont(new Font("Tahoma",Font.BOLD,30));
        l3.setForeground(Color.white);
        l3.setBounds(60,10,300,40);
        p1.add(l3);

        JLabel l4=new JLabel("We’re the ultimate trip planners....");
        l4.setBounds(500,175,1000,64);
        l4.setFont(new Font("Tahemo",Font.PLAIN,55));
        l4.setForeground(Color.white);
        l1.setLayout(null);
        l1.add(l4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            this.setVisible(false);
            new addCustomer(username).setVisible(true);
        }
        else if(e.getSource()==b2){
            this.setVisible(false);
            new updateCustomer(username).setVisible(true);
        }
        else if(e.getSource()==b3){
            this.setVisible(false);
            new viewDetails(username).setVisible(true);
        }
        else if(e.getSource()==b4){
            new deleteCust(username).setVisible(true);
        }
        else if(e.getSource()==b5){
            new checkPackage().setVisible(true);
        }
        else if(e.getSource()==b6){
            new bookPackage(username).setVisible(true);
        }
        else if(e.getSource()==b7){
            new viewPackage(username).setVisible(true);
        }
        else if(e.getSource()==b9){
            new bookHotel(username).setVisible(true);
        }
        else if(e.getSource()==b10){
            new viewBookedHotel(username).setVisible(true);
        }
        else if(e.getSource()==b12){
            new payment().setVisible(true);
        }
        else if(e.getSource()==b15){
            new About().setVisible(true);
        }
        else if(e.getSource()==b13){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch (Exception ex){

            }
        }
        else if(e.getSource()==b14){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception ex){

            }
        }
        else if(e.getSource()==b16){
            this.setVisible(false);
            new login().setVisible(true);
        }
        else if(e.getSource()==b17){
            new MinFlightPrices().setVisible(true);
        }
    }

    public static void main(String[] args) {

        new dashboard("").setVisible(true);
    }

}
