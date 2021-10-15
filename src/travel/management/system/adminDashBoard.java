package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class adminDashBoard extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    String username="";
    adminDashBoard(String username){
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

        b1=new JButton("View All Customer Details");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.setMargin(new Insets(0,0,0,15));
        b1.setBounds(0,0+100,300,50);
        //b1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b1);
        b1.addActionListener((ActionListener) this);

        b2=new JButton("Add Destinations");
        b2.setBackground(new Color(186,85,211));
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.setMargin(new Insets(0,0,0,90));
        b2.setBounds(0,50+100,300,50);
        //b2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b2);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener((ActionListener) this);

        b3=new JButton("Add Hotels");
        b3.setBackground(new Color(186,85,211));
        b3.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3.setBounds(0,100+100,300,50);
        b3.setMargin(new Insets(0,0,0,150));
        //b3.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b3);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener((ActionListener) this);

        b4=new JButton("Start Planning....");
        b4.setBackground(new Color(186,85,211));
        b4.setFont(new Font("Tahoma",Font.PLAIN,20));
        b4.setBounds(0,150+100,300,50);
        b4.setMargin(new Insets(0,0,0,95));
        // b4.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b4);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.addActionListener((ActionListener) this);

        b5=new JButton("Calculator");
        b5.setBackground(new Color(186,85,211));
        b5.setFont(new Font("Tahoma",Font.PLAIN,20));
        b5.setBounds(0,200+100,300,50);
        b5.setMargin(new Insets(0,0,0,160));
        //b5.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b5);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.addActionListener((ActionListener) this);

        b6=new JButton("Notepad");
        b6.setBackground(new Color(186,85,211));
        b6.setFont(new Font("Tahoma",Font.PLAIN,20));
        b6.setBounds(0,250+100,300,50);
        b6.setMargin(new Insets(0,0,0,170));
        //b6.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b6);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.addActionListener((ActionListener) this);

        b7=new JButton("About");
        b7.setBackground(new Color(186,85,211));
        b7.setFont(new Font("Tahoma",Font.PLAIN,20));
        b7.setBounds(0,300+100,300,50);
        b7.setMargin(new Insets(0,0,0,190));
        //b7.setBorder(BorderFactory.createEmptyBorder());
        p2.add(b7);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.addActionListener((ActionListener) this);


        b8=new JButton("Logout");
        b8.setBackground(new Color(186,85,211));
        b8.setFont(new Font("Tahoma",Font.PLAIN,20));
        b8.setBounds(0,350+100,300,50);
        b8.setMargin(new Insets(0,0,0,190));
        p2.add(b8);
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.addActionListener((ActionListener) this);

        JLabel l3=new JLabel("Admin Dashboard");
        l3.setFont(new Font("Tahoma",Font.BOLD,30));
        l3.setForeground(Color.white);
        l3.setBounds(60,10,300,40);
        p1.add(l3);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/update.png"));
        Image i2=i1.getImage().getScaledInstance(250,500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(1300,300,250,500);
        add(l1);
        String name="Admin";
        username=username;
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from admin where username='"+ username+"'");
            while(rs.next()){
                name=rs.getString("name");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }


        JLabel l4=new JLabel("Welcome "+ name+"!!!!");
        l4.setBounds(600,175,1000,64);
        l4.setFont(new Font("Tahemo",Font.BOLD,55));
  //      l4.setForeground(Color.white);
        setLayout(null);
        add(l4);

        getContentPane().setBackground(new Color(255, 140, 0));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new CustomerDetails(username).setVisible(true);
        }
        else if(e.getSource()==b2){
            new AddDestinations().setVisible(true);
        }
        else if(e.getSource()==b3){
            new Hotels().setVisible(true);
        }
        else if(e.getSource()==b4){
            this.setVisible(false);
            new login().setVisible(true);
        }
        else if(e.getSource()==b5) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {

            }
        }
        else if(e.getSource()==b6){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }
                catch (Exception ex){

                }
        }
        else if(e.getSource()==b7){
            new About().setVisible(true);
        }
        else if(e.getSource()==b8){
            this.setVisible(false);
            new login().setVisible(true);
        }
    }

    public static void main(String[] args) {

        new adminDashBoard("").setVisible(true);
    }

}
