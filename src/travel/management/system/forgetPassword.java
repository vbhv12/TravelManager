package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class forgetPassword extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    forgetPassword(){
            setBounds(400,300,800,380);
            getContentPane().setBackground(Color.white);
            setLayout(null);


            JPanel p1=new JPanel();
            p1.setLayout(null);
            p1.setBounds(30,30,500,280);
            add(p1);

            JLabel l1=new JLabel("Email Id");
            l1.setBounds(40,20,145,25);
            l1.setFont(new Font("Tahoma",Font.BOLD,14));
            p1.add(l1);

            b1=new JButton("Search");
            b1.setBackground(Color.gray);
            b1.setForeground(Color.white);
            b1.setBounds(380,20,100,25);
            p1.add(b1);
            b1.addActionListener((ActionListener) this);

            t1=new JTextField();
            t1.setBounds(200,20,150,25);
            p1.add(t1);
            t1.setBorder(BorderFactory.createEmptyBorder());

            JLabel l2=new JLabel("Name");
            l2.setBounds(40,60,145,25);
            l2.setFont(new Font("Tahoma",Font.BOLD,14));
            p1.add(l2);

            t2=new JTextField();
            t2.setBounds(200,60,150,25);
            p1.add(t2);

        t2.setBorder(BorderFactory.createEmptyBorder());

            JLabel l3=new JLabel("Security Question?");
            l3.setBounds(40,100,145,25);
            l3.setFont(new Font("Tahoma",Font.BOLD,14));
            p1.add(l3);

            t3=new JTextField();
            t3.setBounds(200,100,250,25);
            p1.add(t3);

        t3.setBorder(BorderFactory.createEmptyBorder());


            JLabel l4=new JLabel("Answer");
            l4.setBounds(40,140,145,25);
            l4.setFont(new Font("Tahoma",Font.BOLD,14));
            p1.add(l4);

            t4=new JTextField();
            t4.setBounds(200,140,150,25);
            p1.add(t4);
            t4.setBorder(BorderFactory.createEmptyBorder());

            b2=new JButton("Retrieve");
            b2.setBackground(Color.gray);
            b2.setForeground(Color.white);
            b2.setBounds(380,140,100,25);
            p1.add(b2);
        b2.addActionListener((ActionListener) this);


            JLabel l5=new JLabel("Password");
            l5.setBounds(40,180,145,25);
            l5.setFont(new Font("Tahoma",Font.BOLD,14));
            p1.add(l5);

            t5=new JTextField();
            t5.setBounds(200,180,150,25);
            p1.add(t5);
            t5.setBorder(BorderFactory.createEmptyBorder());

            b3=new JButton("Back");
            b3.setBackground(Color.gray);
            b3.setForeground(Color.white);
            b3.setBounds(150,230,100,25);
            p1.add(b3);
        b3.addActionListener((ActionListener) this);

             ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/ForgotPass_.png"));
            Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel l6=new JLabel(i3);
            l6.setBounds(530,20,250,250);
            add(l6);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public static void main(String[] args) {
        new forgetPassword().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Conn c=new Conn();
        if(e.getSource()==b1){
            String sql="select * from account where username='"+t1.getText()+"'";
            try {
                ResultSet rs=c.s.executeQuery(sql);
                while(rs.next()){
                     t2.setText(rs.getString("name"));
                     t3.setText(rs.getString("security"));
                }
            } catch (Exception ex) {
                System.out.println("Wrong username");
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==b2){
            String sql="select * from account where answer='"+t4.getText()+"' and username='"+t1.getText()+"'";
            try {
                ResultSet rs=c.s.executeQuery(sql);
                while(rs.next()){
                    String pass=rs.getString("password");
                    t5.setText(pass);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            this.setVisible(false);
            new login().setVisible(true);
        }

    }
}
