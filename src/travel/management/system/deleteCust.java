package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class deleteCust extends JFrame implements  ActionListener {
    JLabel ll1,ll2,ll3,ll4,ll5,ll6,ll7,ll8;
    String username="";
    JButton b1,b2;
    deleteCust(String username){
        this.username=username;
        setLayout(null);
        setBounds(360,200,750,500);
        setBackground(Color.WHITE);
        JLabel l10=new JLabel("Delete Customer");
        l10.setBounds(120,20,300,25);
        l10.setForeground(new Color(148,0,211));
        l10.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(l10);

        JLabel l1=new JLabel("Email Id :");
        l1.setBounds(30,75,150,25);
        add(l1);

        ll1=new JLabel();
        ll1.setBounds(220,75,150,25);
        add(ll1);


        JLabel l2=new JLabel("Identity Verification :");
        l2.setBounds(30,90+25,150,25);
        add(l2);
        ll2=new JLabel();
        ll2.setBounds(220,90+25,150,25);
        add(ll2);

        JLabel l3=new JLabel("Number :");
        l3.setBounds(30,130+25,150,25);
        add(l3);

        ll3=new JLabel();
        ll3.setBounds(220,130+25,150,25);
        add(ll3);

        JLabel l4=new JLabel("Name :");
        l4.setBounds(30,170+25,150,25);
        add(l4);
        ll4=new JLabel();
        ll4.setBounds(220,170+25,150,25);
        add(ll4);

        JLabel l5=new JLabel("Gender :");
        l5.setBounds(30,210+25,150,25);
        add(l5);

        ll5=new JLabel();
        ll5.setBounds(220,210+25,150,25);
        add(ll5);

        JLabel l6=new JLabel("Country :");
        l6.setBounds(30,250+25,150,25);
        add(l6);
        ll6=new JLabel();
        ll6.setBounds(220,250+25,150,25);
        add(ll6);

        JLabel l7=new JLabel("Address :");
        l7.setBounds(30,290+25,150,25);
        add(l7);
        ll7=new JLabel();
        ll7.setBounds(220,290+25,150,25);
        add(ll7);

        JLabel l8=new JLabel("Phone Number :");
        l8.setBounds(30,330+25,150,25);
        add(l8);
        ll8=new JLabel();
        ll8.setBounds(220,330+25,150,25);
        add(ll8);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/user_delete_.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(480,180,200,200);
        add(l9);


        b1=new JButton("Delete");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(40,410,100,25);
        add(b1);
          b1.addActionListener((ActionListener) this);

        b2=new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220,410,100,25);
        add(b2);
        b2.addActionListener((ActionListener) this);


        try{
            Conn c=new Conn();
            //"+username+"
            ResultSet rs=  c.s.executeQuery("select * from customer where email_id='"+username+"'");
            while(rs.next()){
                ll1.setText(rs.getString("email_id"));
                ll2.setText(rs.getString("id"));
                ll3.setText(rs.getString("number"));
                ll4.setText(rs.getString("name"));
                ll5.setText(rs.getString("gender"));
                ll6.setText(rs.getString("country"));
                ll7.setText(rs.getString("address"));
                ll8.setText(rs.getString("phone_number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new deleteCust("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
                try{
                    Conn c=new Conn();
                    c.s.executeUpdate("delete from account where username='"+username+"'");
                    c.s.executeUpdate("delete from bookhotel where email_id='"+username+"'");
                    c.s.executeUpdate("delete from customer where email_id='"+username+"'");
                    c.s.executeUpdate("delete from bookpackage where username='"+username+"'");

                    JOptionPane.showMessageDialog(null,"Customer Deleted Successfully!!!");
                    System.exit(0);
                }
                catch(Exception ae){
                    ae.printStackTrace();
                }
        }
        else{
            this.setVisible(false);
        }
    }
}
