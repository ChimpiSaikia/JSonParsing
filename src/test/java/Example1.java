import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Example1 {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("example1.json"));

            JSONObject jsonObject =  (JSONObject) obj;

           //write code here to parse the json

            //print all the platforms

            Map<String,Object> dataList = jsonObject;
            System.out.println(dataList.size());
            List<HashMap<String,?>> listOfPlatforms = (List< HashMap<String,?>>)dataList.get("platforms");
            System.out.println("Platforms");
            for(int i =0; i<listOfPlatforms.size(); i++) {
                System.out.print("Name  "+listOfPlatforms.get(i).get("name"));
                System.out.println("  Id  "+listOfPlatforms.get(i).get("id"));

            }
            Map<String,?> esrbRatingList = (Map<String,?>)jsonObject.get("esrbRating");

            System.out.println("The code of esrbRating is:" +esrbRatingList.get("code"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}