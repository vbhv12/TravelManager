package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class signup extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField t1,t2,t4;
    JPasswordField t3;
    Choice c1,c2;
    signup(){
        setBounds(450,250,700,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setBackground(new Color(148,0,211));
        p1.setBounds(0,0,400,400);
        add(p1);
        p1.setLayout(null);

        JLabel l1=new JLabel("Email Id");
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setBounds(50,40,130,25);
        p1.add(l1);

        t1=new JTextField();
        t1.setBounds(190,40,180,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        add(t1);

        JLabel l2=new JLabel("Name");
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setBounds(50,80,130,25);
        p1.add(l2);

         t2=new JTextField();
        t2.setBounds(190,80,180,25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        add(t2);

        JLabel l3=new JLabel("Password");
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setBounds(50,120,130,25);
        p1.add(l3);

        t3=new JPasswordField();
        t3.setBounds(190,120,180,25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        add(t3);

        JLabel l4=new JLabel("Security Question");
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setBounds(50,160,130,25);
        p1.add(l4);

        c1=new Choice();
        c1.add("Fav Character from squid game?");
        c1.add("Your pet Name?");
        c1.add("Your lucky Number?");
        c1.add("Your childhood superhero?");
        c1.add("Your Birth city?");

        c1.setBounds(190,160,180,25);
        p1.add(c1);

        JLabel l5=new JLabel("Answer");
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setBounds(50,195,130,25);
        p1.add(l5);

         t4=new JTextField();
        t4.setBounds(190,195,180,25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);

        JLabel l6=new JLabel("Account Type");
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        l6.setBounds(50,235,130,25);
        p1.add(l6);

        c2=new Choice();
        c2.add("Admin");
        c2.add("Customer");
        c2.setBounds(190,235,180,25);
        p1.add(c2);

        b1=new JButton("Create");
        b1.setBounds(80,285,100,30);
        b1.setFont(new Font("Tahoma",Font.BOLD,14));
        b1.setBackground(Color.white);
        b1.setForeground(new Color(148,0,211));
        b1.addActionListener((ActionListener) this);
        p1.add(b1);

        b2=new JButton("Back");
        b2.setFont(new Font("Tahoma",Font.BOLD,14));
        b2.setBounds(250,285,100,30);
        b2.setBackground(Color.white);
        b2.setForeground(new Color(148,0,211));
        b2.addActionListener((ActionListener) this);
        p1.add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/signup.png"));
        JLabel l7=new JLabel(i1);
        l7.setBounds(400,20,300,300);
        add(l7);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
                String username=t1.getText();
                String name=t2.getText();
                String password=t3.getText();
                String security=c1.getSelectedItem();
                String answer=t4.getText();
                String user=c2.getSelectedItem();
                System.out.println(user);
                if(user.equals("Customer")) {
                  String query = "insert into account values('" + username + "','" + name + "','" + password + "','" + security + "','" + answer + "')";
                  try {
                      Conn c = new Conn();
                      c.s.executeUpdate(query);
                      JOptionPane.showMessageDialog(null, "Customer Account Created Successfully");
                      this.setVisible(false);
                      new login().setVisible(true);
                  } catch (Exception e) {
                        e.printStackTrace();
                  }
              }
              else{
                  String query = "insert into admin values('" + username + "','" + name + "','" + password + "','" + security + "','" + answer + "')";
                  try {
                      Conn c = new Conn();
                      c.s.executeUpdate(query);
                      JOptionPane.showMessageDialog(null, "Admin Account Created Successfully");
                      this.setVisible(false);
                      new login().setVisible(true);
                  } catch (Exception e) {

                  }
              }
        }
        else{
            new  login().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new signup().setVisible(true);
    }
}
