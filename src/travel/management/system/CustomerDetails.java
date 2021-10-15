package travel.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class CustomerDetails extends JFrame implements ActionListener {
    JPanel p1,p2;
    JTable t1=new JTable();
    JButton b1,b2;
    JTextField text1;
    String x[]={"Email Id","Name","Package","Days","Identity","Number","Phone Number","Destination","Hotel","Total Cost"};
    String username="";
    String y[][]=new String[100][10];
    int i=0,j=0;
    CustomerDetails(){
        super("Customer Details");
    }
    CustomerDetails(String username){
        p1=new JPanel(new BorderLayout());
        p2=new JPanel();
        this.username=username;
        setLayout(null);
        setBounds(200,100,1200,500);
        p1.setLayout(null);
        p1.setBounds(0,0,1200,500);
        getContentPane().setBackground(Color.WHITE);
        JLabel l1=new JLabel("Customers Detail");
        l1.setBounds(520,0,200,25);
        p1.add(l1);
        updateTable();

        JLabel l2=new JLabel("Select any Row to be deleted..");
        l2.setBounds(40,430,300,27);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        p1.add(l2);

        b1=new JButton("Delete");
        b1.setBounds(500,430,100,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        p1.add(b1);
        add(p1);
        b1.addActionListener((ActionListener) this);
    }

    public void updateTable() {
        ResultSet rs = null;
        try{
            Conn c=new Conn();
            String sql="select c.email_id,name,package,days,c.id,c.number,phone,dest,hotel,price,t_price from customer c inner join bookpackage bp on c.email_id=bp.username inner join bookhotel bh on bp.username=bh.email_id ";
            rs=c.s.executeQuery(sql);
            while(rs.next()){
                y[i][j++]=rs.getString("email_id");
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("package");
                y[i][j++]=rs.getString("days");
                y[i][j++]=rs.getString("id");
                y[i][j++]=rs.getString("number");
                y[i][j++]=rs.getString("phone");
                y[i][j++]=rs.getString("dest");
                y[i][j++]=rs.getString("hotel");
                String[] price=rs.getString("price").split(" ");
                String[] t_price=rs.getString("t_price").split(" ");
                String Mprice=t_price[1].substring(0,t_price[1].length()-2);
                System.out.println(price[1]+" "+Mprice);
                int cost=Integer.parseInt(price[1]);
                int cost1=Integer.parseInt(Mprice);
                int t_cost=cost+cost1;
                y[i][j]="Rs :"+t_cost+"/-";
                i++;
                j=0;
            }
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
        finally {
            try{
                rs.close();
            }
            catch (Exception e){
                
            }
        }

        t1=new JTable(y,x);
        t1.getColumnModel().getColumn(0).setPreferredWidth(150);
        JScrollPane scroll =new JScrollPane(t1);
        scroll.setBounds(5,20,1175,400);
        p1.add(scroll);
    }


    public static void main(String[] args) {
        new CustomerDetails("").setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            int row=t1.getSelectedRow();
            System.out.println(row);
            username=t1.getModel().getValueAt(row,0).toString();
            try{
                    Conn c=new Conn();
                    System.out.println(username);
                    c.s.executeUpdate("delete from account where username='" + username + "'");
                    c.s.executeUpdate("delete from bookhotel where email_id='" + username + "'");
                    c.s.executeUpdate("delete from customer where email_id='" + username + "'");
                    c.s.executeUpdate("delete from bookpackage where username='" + username + "'");

                    JOptionPane.showMessageDialog(null, "Customer Deleted Successfully!!!");
                    this.setVisible(false);
                    new CustomerDetails();
            }
            catch(Exception ae){
                ae.printStackTrace();
            }


        }


    }


}

