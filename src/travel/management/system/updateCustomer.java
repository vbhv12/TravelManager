package travel.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateCustomer extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JComboBox c1;
    JRadioButton r1,r2;
    JButton b1,b2;
    JLabel email,name;
    String username="";
    updateCustomer(String username){
        setUndecorated(true);
        this.username=username;
        setBounds(400,150,800,500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l10=new JLabel("UPDATE CUSTOMER DETAILS");
        l10.setBounds(50,20,300,25);
        l10.setForeground(new Color(148,0,211));
        l10.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l10);

        JLabel l1=new JLabel("Email Id :");
        l1.setBounds(30,50,150,25);
        add(l1);
        email=new JLabel();
        email.setBounds(220,50,150,25);
        add(email);

        JLabel l2=new JLabel("Identity Verification :");
        l2.setBounds(30,90,150,25);
        add(l2);


        t8=new JTextField();
        t8.setBounds(220,90,150,25);
        add(t8);

        JLabel l3=new JLabel("Number :");
        l3.setBounds(30,130,150,25);
        add(l3);
        t2=new JTextField();
        t2.setBounds(220,130,150,25);
        add(t2);

        JLabel l4=new JLabel("Name :");
        l4.setBounds(30,170,150,25);
        add(l4);
        name=new JLabel();
        name.setBounds(220,170,150,25);
        add(name);

        JLabel l5=new JLabel("Gender :");
        l5.setBounds(30,210,150,25);
        add(l5);

        t7=new JTextField();
        t7.setBounds(220,210,150,25);
        add(t7);

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


        b1=new JButton("Update");
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

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/update_details__.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(450,100,250,250);
        add(l9);
        try{
            Conn c=new Conn();
            ResultSet rs=  c.s.executeQuery("select * from customer where email_id='"+username+"'");
            while(rs.next()){
                email.setText(rs.getString("email_id"));
                t8.setText(rs.getString("id"));
                t2.setText(rs.getString("number"));
                name.setText(rs.getString("name"));
                t7.setText(rs.getString("gender"));
                t4.setText(rs.getString("country"));
                t5.setText(rs.getString("address"));
                t6.setText(rs.getString("phone_number"));
            }
        }
        catch(Exception e){
                e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new updateCustomer("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
               String email_id=email.getText();
                String id=t8.getText();
               String number=t2.getText();
               String name_=name.getText();
               String radio=t7.getText();
               String country=t4.getText();
               String address=t5.getText();
               String phone_number=t6.getText();
               String sql="update customer set email_id='"+email_id+"',id='"+id+"',number='"+number+"',name='"+name_+"',gender='"+radio+"',country='"+country+"',address='"+address+"',phone_number='"+phone_number+"' where email_id='"+email_id+"'";
               try{
                Conn c=new Conn();
                c.s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Customer Details Updated!!");
                this.setVisible(false);
                new dashboard(username).setVisible(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            this.setVisible(false);
            new dashboard(username).setVisible(true);
        }
    }
}
