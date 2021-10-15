package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class paytm extends JFrame {
    paytm(){
        openWebpage("https://paytm.com/");
    }
    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
