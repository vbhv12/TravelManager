package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class bookPackage extends JFrame implements ActionListener {
    JLabel l11,l12,l13,l14,l15;
    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
    String username;
    bookPackage(String username){
        this.username=username;
        setBounds(475,150,900,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel l1=new JLabel("Book Package :");
        l1.setBounds(100,10,200,30);
        l1.setFont(new Font("YU Mincho",Font.PLAIN,20));
        add(l1);


        JLabel l2=new JLabel("User Name :");
        l2.setBounds(40,70,200,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l2);

        l11=new JLabel();
        l11.setBounds(250,70,200,30);
        l11.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l11);

        JLabel l3=new JLabel("Select Package :");
        l3.setBounds(40,110,200,30);
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l3);

        c1=new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze package");
        c1.setBounds(250,110,200,30);
        add(c1);

        JLabel l4=new JLabel("Total Persons :");
        l4.setBounds(40,150,200,30);
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l4);

        t1=new JTextField("1");
        t1.setBounds(250,150,200,25);
        add(t1);

        JLabel l5=new JLabel("Identity :");
        l5.setBounds(40,190,100,30);
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l5);

        l12=new JLabel();
        l12.setBounds(250,190,200,30);
        l12.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l12);

        JLabel l6=new JLabel("Identity Number :");
        l6.setBounds(40,230,200,30);
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l6);

        l13=new JLabel();
        l13.setBounds(250,230,200,30);
        l13.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l13);

        JLabel l7=new JLabel("Phone Number :");
        l7.setBounds(40,270,200,30);
        l7.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l7);

        l14=new JLabel();
        l14.setBounds(250,270,200,30);
        l14.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l14);

        JLabel l8=new JLabel("Total Price :");
        l8.setBounds(40,310,200,30);
        l8.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l8);

        l15=new JLabel();
        l15.setBounds(250,310,200,30);
        l15.setForeground(new Color(148,0,211));
        l15.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l15);

        b1=new JButton("Check Price");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(50,380,120,25);
        add(b1);
        b1.addActionListener((ActionListener) this);

        b2=new JButton("Book Package");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(200,380,120,25);
        add(b2);
        b2.addActionListener((ActionListener) this);



        b3=new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setBounds(340,380,120,25);
        add(b3);
        b3.addActionListener((ActionListener) this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/booking-icon_.jpg"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(550,100,250,250);
        add(l9);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where email_id= '"+username+"'");
            while(rs.next()) {
                l11.setText(rs.getString("email_id"));
                l12.setText(rs.getString("id"));
                l13.setText(rs.getString("number"));
                l14.setText(rs.getString("phone_number"));
            }
        }
        catch(Exception e){

        }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String p=c1.getSelectedItem();
            int cost=0;
            if(p.equals("Gold Package")){
                cost+=25000;
            }
            else if(p.equals("Silver Package")){
                cost+=20000;
            }
            else{
                cost+=15000;
            }

            int persons=Integer.parseInt(t1.getText());
            cost=persons*cost;
            l15.setText("Rs: " +cost);

        }
        else if(ae.getSource()==b2){
                try{
                    Conn c=new Conn();
                    String sql="insert into bookPackage values('"+l11.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+l12.getText()+"','"+l13.getText()+"','"+l14.getText()+"','"+l15.getText()+"')";
                    System.out.println(sql);
                    c.s.executeUpdate("insert into bookpackage values('"+l11.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+l12.getText()+"','"+l13.getText()+"','"+l14.getText()+"','"+l15.getText()+"')");
                    JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                    this.setVisible(false);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
        }
        else{
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new bookPackage("").setVisible(true);
    }
}
