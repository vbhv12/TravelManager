package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class checkPackage extends JFrame {
    checkPackage(){
        setBounds(475,150,700,500);

        String[] package1=new String[]{"Gold Package","6 Days and 7 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Welcome Drinks","Guide Assistance Included","Get This Package Only For Rs:25,000/-","package1.jpg"};
        String[] package2=new String[]{"Silver Package","5 Days and 6 Nights","Free Entrance Tickets","Half Day City Tour","Daily Buffet","Night Safari","Cruise with Dinner","Get This Package Only For Rs:20,000/-","package2.jpg"};
        String[] package3=new String[]{"Bronze Package","3 Days and 4 Nights","Free Taxi Services","Night Clubbing","High tea ","Welcome Drinks","Horse Riding","Get This Package Only For Rs:15,000/-","package3.jpg"};

        JTabbedPane pane=new JTabbedPane();
        JPanel p1=createPackage(package1);

        JPanel p2=createPackage(package2);

        JPanel p3=createPackage(package3);

        pane.addTab("Package 1",null,p1);
        pane.addTab("Package 2",null,p2);
        pane.addTab("Package 3",null,p3);
        add(pane, BorderLayout.CENTER);
    }
    public JPanel createPackage(String[] pack){

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(192,192,192));


        JLabel l1=new JLabel(pack[0]);
        l1.setBounds(50,5,300,30);
        l1.setForeground(Color.BLUE);
        //l1.setForeground(new Color(255,215,0));
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l1);

        JLabel l2=new JLabel(pack[1]);
        l2.setBounds(30,60,300,30);
       // l2.setForeground(new Color());
        l2.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l2);

        JLabel l3=new JLabel(pack[2]);
        l3.setBounds(30,110,300,30);
        // l2.setForeground(new Color());
        l3.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l3);

        JLabel l4=new JLabel(pack[3]);
        l4.setBounds(30,160,300,30);
        // l2.setForeground(new Color());
        l4.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l4);

        JLabel l5=new JLabel(pack[4]);
        l5.setBounds(30,210,300,30);
        // l2.setForeground(new Color());
        l5.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l5);

        JLabel l6=new JLabel(pack[5]);
        l6.setBounds(30,260,300,30);
        // l2.setForeground(new Color());
        l6.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l6);

        JLabel l7=new JLabel(pack[6]);
        l7.setBounds(30,310,300,30);
        // l2.setForeground(new Color());
        l7.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l7);

        JLabel l9=new JLabel(pack[7]);
        l9.setBounds(155,370,400,30);
         l9.setForeground(Color.RED);
        l9.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l9);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/"+pack[8]));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(400,25,250,300);
        p1.add(l12);


         return p1;
    }
    public static void main(String[] args) {
        new checkPackage().setVisible(true);
    }

}
