package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.ResultSet;

public  class login extends JFrame implements ActionListener{
        JButton b1,b2,b3;
        JTextField t1,t3;
        JPasswordField t2;
        Choice c1;
    login(){
            setLayout(null);
            getContentPane().setBackground(Color.white);
            setBounds(400,200,800,400);

            JPanel p1=new JPanel();
            p1.setBounds(0,0,350,400);
            p1.setBackground(new Color(148,0,211));
            add(p1);
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/login.png"));
            Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel l1=new JLabel(i3);
            p1.setLayout(null);
            l1.setBounds(20,50,300,300);
            p1.add(l1);


            JPanel p2=new JPanel();
            p2.setLayout(null);
            p2.setBounds(350,0,450,400);

            add(p2);

            JLabel l2=new JLabel("Email Id");
            l2.setBounds(60,20,100,25);
            l2.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
            p2.add(l2);

            t1=new JTextField();
            t1.setBounds(60,60,250,25);
            t1.setBorder(BorderFactory.createEmptyBorder());
            p2.add(t1);


            JLabel l3=new JLabel("Password");
            l3.setBounds(60,105,100,25);
            l3.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
            p2.add(l3);

            t2=new JPasswordField();
            t2.setBounds(60,145,250,25);
            t2.setBorder(BorderFactory.createEmptyBorder());
            p2.add(t2);

            JLabel l4=new JLabel("Account Type");
            l4.setBounds(60,185,150,25);
            l4.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
            p2.add(l4);

            c1=new Choice();
            c1.add("Admin");
            c1.add("Customer");
            c1.setBounds(60,225,250,27);
            p2.add(c1);

            b1=new JButton("Login");
            b1.setBounds(60,225+45,150,25);
            b1.setBackground(new Color(148,0,211));
            b1.setForeground(Color.WHITE);
            b1.setBorder(BorderFactory.createEmptyBorder());
            b1.addActionListener((ActionListener) this);
            p2.add(b1);

            b2=new JButton("Signup");
            b2.setBounds(230,225+45,130,25);
            b2.setBackground(Color.WHITE);
            b2.setForeground(new Color(148,0,211));
            b2.setBorder(new LineBorder(new Color(148,0,211)));
            b2.addActionListener((ActionListener) this);
            p2.add(b2);

            b3=new JButton("Forgot Password?");
            b3.setBounds(130,315,160,25);
            b3.setBackground(Color.WHITE);
            b3.setForeground(new Color(148,0,211));
            b3.setBorder(new LineBorder(new Color(148,0,211)));
            b3.addActionListener((ActionListener) this);
            p2.add(b3);

            setVisible(true);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void actionPerformed(ActionEvent ae){

               if(ae.getSource()==b1){
                    try{
                        Conn c=new Conn();
                        String username=t1.getText();
                        String password=t2.getText();
                        String user=c1.getSelectedItem();
                        System.out.println(user);
                        if(user.equals("Customer")){
                            user="account";
                        }
                        else {
                            user = "admin";
                        }
                        String sql = "select * from " + user + " where username='" + username + "' and password='" + password + "'";
                        ResultSet rs = c.s.executeQuery(sql);
                        if (rs.next()) {
                            System.out.println(user);
                            if(user.equals("account"))
                                new loading(username).setVisible(true);
                            else new adminDashBoard(username).setVisible(true);
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Login credentials are invalid");
                        }
                    }
                    catch (Exception e){ }
               }
               else if(ae.getSource()==b2){
                   this.setVisible(false);
                   new signup().setVisible(true);

               }
               else{
                    this.setVisible(false);
                    new forgetPassword().setVisible(true);
               }
        }
}
