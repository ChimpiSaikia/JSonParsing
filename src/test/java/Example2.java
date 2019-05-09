import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example2 {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("example2.json"));

          //write code here to print all the cars for each person

            JSONArray listOfPeople = (JSONArray) obj;

            List<Map<String,Object>> actualData = listOfPeople;

            for(int i =0; i< listOfPeople.size(); i++)
            {
                System.out.println("The cars of " + actualData.get(i).get("name"));
                List <String> list = (List<String>)actualData.get(i).get("cars");
                for (int j =0; j<list.size();j++)
                    System.out.println(list.get(j));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}