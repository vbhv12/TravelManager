package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class bookHotel extends JFrame implements  ActionListener{
    Choice c1,c2,c3;
    JTextField t1;
    JLabel l21,l81,l91,l101;
    JButton b1,b2,b3;
    String username="";
    bookHotel(String username){
        this.username=username;
        setBounds(405,150,900,500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1=new JLabel("Book Hotel And Select Destination");
        l1.setFont(new Font("Tahoma",Font.PLAIN,24));
        l1.setBounds(100,0,500,30);
        add(l1);

        JLabel l2=new JLabel("Email Id :");
        l2.setBounds(40,70,200,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l2);

         l21=new JLabel();
        l21.setBounds(250,70,150,30);
        l21.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l21);

        JLabel l3=new JLabel("Select Destination :");
        l3.setBounds(40,110,200,30);
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l3);

        c2=new Choice();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from dest");
            while(rs.next()){
                c2.add(rs.getString("name"));
            }
        }
        catch (Exception e){

        }
        c2.setBounds(250,110,150,30);
        add(c2);
        c2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("Select * from hotels where location ='"+ c2.getSelectedItem()+"'");
                    c1.removeAll();
                    while(rs.next()){
                        c1.add(rs.getString("name"));
                    }
                }
                catch (Exception ae){

                }
            }
        });

        JLabel l4=new JLabel("Select Hotel :");
        l4.setBounds(40,150,200,30);
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l4);

        c1=new Choice();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from hotels where location ='"+ c2.getSelectedItem()+"'");
            while(rs.next()){
                c1.add(rs.getString("name"));
            }
        }
        catch (Exception e){

        }
        c1.setBounds(250,150,150,30);
        add(c1);

        JLabel l5=new JLabel("Number of Days :");
        l5.setBounds(40,190,200,30);
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l5);

        t1=new JTextField("1");
        t1.setBounds(250,190,150,20);
        add(t1);


        JLabel l6=new JLabel("Ac or Non Ac :");
        l6.setBounds(40,230,200,30);
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l6);

        c3=new Choice();
        c3.add("AC");
        c3.add("NON AC");
        c3.setBounds(250,230,150,30);
        add(c3);


        JLabel l7=new JLabel("Identity :");
        l7.setFont(new Font("Tahoma",Font.PLAIN,16));
        l7.setBounds(40,270,300,30);
        add(l7);

         l81=new JLabel();
        l81.setBounds(250,270,200,16);
        l81.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l81);


        JLabel l9=new JLabel("Number :");
        l9.setFont(new Font("Tahoma",Font.PLAIN,16));
        l9.setBounds(40,310,300,30);
        add(l9);

         l91=new JLabel();
        l91.setBounds(250,310,200,16);
        l91.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l91);

        JLabel l10=new JLabel("Total Price :");
        l10.setFont(new Font("Tahoma",Font.PLAIN,16));
        l10.setBounds(40,350,300,30);
        add(l10);

        l101=new JLabel();
        l101.setBounds(250,350,200,16);
        l101.setForeground(new Color(148,0,211));
        l101.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l101);

        b1=new JButton("Check Price");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(50,400,120,25);
        add(b1);
        b1.addActionListener((ActionListener) this);

        b2=new JButton("Book Package");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(200,400,120,25);
        add(b2);
        b2.addActionListener((ActionListener) this);

        b3=new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setBounds(340,400,120,25);
        add(b3);
        b3.addActionListener((ActionListener) this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/book_hotel.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l11=new JLabel(i3);
        l11.setBounds(550,100,300,300);
        add(l11);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where email_id='"+username+"'");
            while(rs.next()){
                l21.setText(rs.getString("email_id"));
                l81.setText(rs.getString("id"));
                l91.setText(rs.getString("number"));
            }
        }
        catch(Exception e){
                e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1){
                try {
                    Conn c=new Conn();
                    ResultSet rs =c.s.executeQuery("select * from hotels where name ='"+ c1.getSelectedItem()+"'");

                    while(rs.next()){
                        int cost=Integer.parseInt(rs.getString("cost_per_day"));
                        int ac=Integer.parseInt(rs.getString("ac_charges"));
                        int days=Integer.parseInt(t1.getText());

                        String a_c=c3.getSelectedItem();
                        if(a_c.equals("AC")){
                            cost+=ac;
                        }
                        cost*=days;
                        l101.setText("Rs: "+cost+"/-");
                    }
                }
                catch (Exception exp){
                        exp.printStackTrace();
                }
            }
            else if(e.getSource()==b2){
                    try{
                        Conn c=new Conn();
                        c.s.executeUpdate("insert into bookhotel values('"+l21.getText()+"','"+c2.getSelectedItem()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+c3.getSelectedItem()+"','"+l81.getText()+"','"+l101.getText()+"','"+l91.getText()+"')");
                        JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                        this.setVisible(false);
                    }
                    catch(Exception ex){
                            ex.printStackTrace();
                    }
            }
            else{
                    this.setVisible(false);
            }
    }
    public static void main(String[] args) {
        new bookHotel("").setVisible(true);
    }
}
