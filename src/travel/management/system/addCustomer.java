package travel.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addCustomer extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6;
    JComboBox c1;
    JRadioButton r1,r2;
    JButton b1,b2;
    String username="";
    JLabel l11,l12;
    addCustomer(String username){
        setUndecorated(true);
        this.username=username;
        setBounds(400,150,800,500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel l1=new JLabel("Email Id :");
        l1.setBounds(30,50,150,25);
        add(l1);

        l11=new JLabel();
        l11.setBounds(220,50,150,25);
        add(l11);

        JLabel l2=new JLabel("Identity Verification :");
        l2.setBounds(30,90,150,25);
        add(l2);
        c1=new JComboBox(new String[]{"Passport","Aadhar Card","Pan Card"});
        c1.setBounds(220,90,150,25);
        add(c1);

        JLabel l3=new JLabel("Number :");
        l3.setBounds(30,130,150,25);
        add(l3);
        t2=new JTextField();
        t2.setBounds(220,130,150,25);
        add(t2);

        JLabel l4=new JLabel("Name :");
        l4.setBounds(30,170,150,25);
        add(l4);
        l12=new JLabel();
        l12.setBounds(220,170,150,25);
        add(l12);

        JLabel l5=new JLabel("Gender :");
        l5.setBounds(30,210,150,25);
        add(l5);

        r1=new JRadioButton("Male");
        r1.setBounds(220,210,70,25);
        r1.setBackground(Color.white);
        add(r1);
        r2=new JRadioButton("Female");
        r2.setBounds(300,210,70,25);
        r2.setBackground(Color.white);
        add(r2);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);bg.add(r2);

        JLabel l6=new JLabel("Country :");
        l6.setBounds(30,250,150,25);
        add(l6);
        t4=new JTextField();
        t4.setBounds(220,250,150,25);
        add(t4);

        JLabel l7=new JLabel("Address :");
        l7.setBounds(30,290,150,25);
        add(l7);
        t5=new JTextField();
        t5.setBounds(220,290,150,25);
        add(t5);

        JLabel l8=new JLabel("Phone Number :");
        l8.setBounds(30,330,150,25);
        add(l8);
        t6=new JTextField();
        t6.setBounds(220,330,150,25);
        add(t6);


        b1=new JButton("Add");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(70,410,100,25);
        add(b1);
        b1.addActionListener((ActionListener) this);



        b2=new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220,410,100,25);
        add(b2);
        b2.addActionListener((ActionListener) this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/Personal details_.jpg"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(450,100,250,250);
        add(l9);
        try{
            Conn c=new Conn();
            ResultSet rs=  c.s.executeQuery("select * from account where username='"+username+"'");
            while(rs.next()){

                    l11.setText(rs.getString("username"));
                    l12.setText(rs.getString("name"));
            }
        }
        catch(Exception e){

        }

    }

    public static void main(String[] args) {
       new addCustomer("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email_id=l11.getText();
        String id= (String) c1.getSelectedItem();
        String number=t2.getText();
        String name=l12.getText();
        String radio=null;
        if(r1.isSelected()){
            radio="Male";
        }
        else if(r2.isSelected()){
            radio="Female";
        }
        String country=t4.getText();
        String address=t5.getText();
        String phone_number=t6.getText();


        String sql="insert into customer values('"+email_id+"','"+id+"','"+number+"','"+name+"','"+radio+"','"+country+"','"+address+"','"+phone_number+"')";
        if(e.getSource()==b1){
                try{
                    Conn c=new Conn();
                    c.s.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Customer Details Added!!");
                    this.setVisible(false);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                new dashboard(username).setVisible(true);
        }
        else{
            this.setVisible(false);
            new dashboard(username).setVisible(true);
        }
    }
}
