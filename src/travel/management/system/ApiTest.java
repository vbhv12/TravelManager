package travel.management.system;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonArray;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ApiTest {
    String origin="";
    String dest="";
    String date="";
    ApiTest(String origin, String dest, String date) throws Exception {
        this.origin=origin;
        this.dest=dest;
        this.date=date;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/IN/INR/en-US/"+origin+"/"+dest+"/"+date+""))
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "5c975f79b5msh440b97b75dce90ep1ea7d5jsnf9652461695d")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String jsonString=response.body();
        new JsonFileWriiter(origin,dest,jsonString);
        System.out.println(jsonString);
        new jsonFileView(origin,dest).setVisible(true);
    }

}
