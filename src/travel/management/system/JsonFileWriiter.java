package travel.management.system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriiter {
    String jsonStr="";
    public JsonFileWriiter(String ori,String dest,String jsonStr) throws Exception {
        this.jsonStr=jsonStr;

        try {
            File myObj = new File("JsonFile.json");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        try{
            FileWriter fw=new FileWriter("JsonFile.json");
            fw.write(jsonStr);
            fw.close();

    } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Success");

    }

}
