package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Hotels extends JFrame implements ActionListener {
    JTable t1;
    String[] x={"S.No.","Hotel Name","Charges per day","Ac Charges","Location"};
    String[][] y=new String[120][5];
    int i=0,j=0;
    JButton b1,b2;
    JTextField text0,text1,text2,text3;
    Choice c1;
    Hotels(){
        setLayout(null);
        setBounds(200,100,1000,400);
        JPanel p1=new JPanel();
        p1.setBackground(Color.BLACK);
        add(p1);

        JLabel l1=new JLabel("Hotels");
        l1.setBounds(715,25,200,25);
        l1.setForeground(new Color(148,0,211));
        l1.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(l1);

        p1.setBounds(0,0,650,400);
        p1.setLayout(null);
        ResultSet rs = null;
        try{
            Conn c=new Conn();
            String sql="select * from hotels";
            rs=c.s.executeQuery(sql);
            while(rs.next()){
                y[i][j++]=i+1+"";
                y[i][j++]=rs.getString("name");
                y[i][j++]="Rs: "+rs.getString("cost_per_day");
                y[i][j++]="Rs: "+rs.getString("ac_charges");
                y[i][j++]=rs.getString("location");
                i++;
                j=0;
            }
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
        t1=new JTable(y,x);

        t1.getColumnModel().getColumn(0).setPreferredWidth(50);
        t1.getColumnModel().getColumn(4).setPreferredWidth(150);
        JScrollPane scroll =new JScrollPane(t1);
        scroll.setBounds(0,0,650,400);
        p1.add(scroll);


        JLabel l2=new JLabel("Hotel Name");
        l2.setBounds(675,65,200,25);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l2);

        text0=new JTextField();
        text0.setBounds(675,95,200,25);
        text0.setBorder(BorderFactory.createEmptyBorder());
        add(text0);



        JLabel l3=new JLabel("Charges per day");
        l3.setBounds(675,125,200,25);
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l3);

        text1=new JTextField();
        text1.setBounds(675,150,200,25);
        text1.setBorder(BorderFactory.createEmptyBorder());
        add(text1);


        l2=new JLabel("AC Charges");
        l2.setBounds(675,180,200,25);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l2);

        text2=new JTextField();
        text2.setBounds(675,205,200,25);
        text2.setBorder(BorderFactory.createEmptyBorder());
        add(text2);


        l3=new JLabel("Location");
        l3.setBounds(675,235,200,25);
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l3);

        c1=new Choice();
        try{
            Conn c=new Conn();
            rs=c.s.executeQuery("Select * from dest ");
            while(rs.next()){
                c1.add(rs.getString("name"));
            }
        }
        catch (Exception e){

        }
        c1.setBounds(675,260,200,25);
        add(c1);


        b1=new JButton("ADD");
        b1.setBounds(675,300,70,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        add(b1);
        b1.addActionListener((ActionListener)this);

        b2=new JButton("Delete");
        b2.setBounds(780,300,80,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        add(b2);
        b2.addActionListener((ActionListener) this);

    }

    public static void main(String[] args) {
        new Hotels().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                Conn c = new Conn();
                String hotel = text0.getText();
                String dayC=text1.getText();
                String ac_c=text2.getText();
                String Loc=c1.getSelectedItem();
                String sql = "insert into hotels values ('" + hotel + "','" + dayC + "','" + ac_c + "','" + Loc + "')";
                System.out.println(sql);
                c.s.executeUpdate(sql);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Added Data Successfully!!");
            this.setVisible(false);
        }
        else{
            int row=t1.getSelectedRow();
            System.out.println(row);
            String dest1=t1.getModel().getValueAt(row,1).toString();
            String loc=t1.getModel().getValueAt(row,4).toString();
            try{
                Conn c=new Conn();
                System.out.println(dest1);
                System.out.println(loc);
                c.s.executeUpdate("delete from hotels where name='" + dest1 + "' and location='"+loc+"'");

                JOptionPane.showMessageDialog(null, "Hotel Deleted Successfully!!!");
                this.setVisible(false);
                new CustomerDetails();
            }
            catch(Exception ae){
                ae.printStackTrace();
            }
        }

    }
}
