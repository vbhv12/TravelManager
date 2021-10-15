package travel.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddDestinations  extends JFrame implements ActionListener {
    JTable t1=null;
    JTextField text1;
    JButton b1,b2;
    int i=0,j=0;
    DefaultTableModel model;
    String[] x={"S.No.","Destinations"};
    String[][] y=new String[150][2];
    AddDestinations(){
        setBounds(450,250,600,350);
        setLayout(null);
        JPanel p1=new JPanel();
        p1.setLayout(null);

        p1.setBackground(Color.BLACK);
        p1.setBounds(0,0,300,350);
        add(p1);
        JLabel l1=new JLabel("Destinations");
        add(l1);
        l1.setFont(new Font("Tahoma",Font.PLAIN,25));
        l1.setBounds(360,30,200,25);
        l1.setForeground(new Color(148,0,211));
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from dest");

            while(rs.next()){
                y[i][j++]=i+1+"";
                y[i][j]=rs.getString("name");
                i++;
                j=0;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        t1=new JTable(y,x);
        System.out.println(t1.getModel());
        JScrollPane scroll =new JScrollPane(t1);
        scroll.setBounds(0,0,300,400);
        p1.add(scroll);

        JLabel l2=new JLabel("Add Destinations");
        l2.setBounds(330,100,200,25);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l2);

        text1=new JTextField();
        text1.setBounds(330,130,200,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        add(text1);


        b1=new JButton("ADD");
        b1.setBounds(330,170,70,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        add(b1);
        b1.addActionListener((ActionListener)this);

        b2=new JButton("Delete");
        b2.setBounds(450,170,80,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        add(b2);
        b2.addActionListener((ActionListener) this);

    }

    public static void main(String[] args) {
        new AddDestinations().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1) {
           try {
               Conn c = new Conn();
               String dest = text1.getText();
               String sql = "insert into dest values ('" + dest + "')";
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
           try{
               Conn c=new Conn();
               System.out.println(dest1);
               c.s.executeUpdate("delete from dest where name='" + dest1 + "'");

               JOptionPane.showMessageDialog(null, "Destination Deleted Successfully!!!");
               this.setVisible(false);
               new CustomerDetails();
           }
           catch(Exception ae){
               ae.printStackTrace();
           }
       }
    }
}
