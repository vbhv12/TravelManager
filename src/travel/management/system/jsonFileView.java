package travel.management.system;

import com.teamdev.jxbrowser.deps.org.checkerframework.checker.units.qual.A;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class jsonFileView extends JFrame implements ActionListener{
    JTable t1=new JTable();
    JButton b1;
    JLabel l1;
    String ori,dest_;
    jsonFileView(String ori,String dest_) throws Exception {
        System.out.println("hello");
        this.ori=ori;
        this.dest_=dest_;
        JSONParser jsonParser=new JSONParser();
        FileReader reader=new FileReader("./jsonFile.json");
        Object obj=jsonParser.parse(reader);
        JSONObject flightobj=(JSONObject) obj;
        long minPrice= (long) 1e13;
        JSONArray array=(JSONArray)flightobj.get("Quotes");
        for(int i=0;i<array.size();i++){
            JSONObject address=(JSONObject) array.get(i);
            long price= (Long) address.get("MinPrice");
            minPrice=Math.min(price,minPrice);
        }

        JSONArray carriers=(JSONArray)flightobj.get("Carriers");
        String flightname="";
        for(int i=0;i<carriers.size();i++){
            JSONObject address=(JSONObject) carriers.get(i);
            flightname=(String) address.get("Name");
        }


        JSONArray places=(JSONArray) flightobj.get("Places");
        JSONObject origin=(JSONObject) places.get(0);
        String origin_place=(String) origin.get("Name");

        JSONObject dest=(JSONObject) places.get(1);
        String dest_place=(String) dest.get("Name");




        JPanel p1=new JPanel();
        p1.setLayout(null);

        if(minPrice==1e13){
            JLabel l2=new JLabel("Sorry,No flights available for this date...");
            l2.setBounds(40,50,500,50);
            l2.setFont(new Font("Tahoma",Font.PLAIN,20));
            add(l2);
        }

        else {

            l1=new JLabel("Minimum flight price");
            add(l1);
            l1.setForeground(new Color(148,0,211));
            l1.setBounds(85,10,200,25);
            l1.setFont(new Font("Tahoma",Font.PLAIN,20));
            String x[] = {"Origin", "Destination", "Minimum Price", "Airlines"};
            String y[][] = new String[1][4];
            y[0][0] = ori;
            y[0][1] = dest_;
            y[0][2] = "Rs :" + minPrice + "/-";
            y[0][3] = flightname;
            t1 = new JTable(y, x);
            JScrollPane scroll = new JScrollPane(t1);
            scroll.setBounds(0, 0, 500, 50);
            p1.add(scroll);
            p1.setBackground(Color.black);
            p1.setBounds(0, 50, 500, 50);


            add(p1);
        }

        setLayout(null);
        setBounds(500, 70, 500, 200);
        b1=new JButton("Close");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener((ActionListener) this);
        b1.setBounds(200,120,75,25);
        add(b1);
    }

    public static void main(String[] args) throws Exception {
        new jsonFileView("","").setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            this.setVisible(false);
    }
}
