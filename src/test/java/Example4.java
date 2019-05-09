import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Example4 {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("example4.json"));

          //write code here to print all the type of phone no and the corresponding no

            JSONObject jsonObject =  (JSONObject) obj;
            Map<String,Object> dataMap = jsonObject;

            List<Map<String,String>> phoneDataList = (JSONArray)dataMap.get("phoneNumber");

            for(int i =0; i< phoneDataList.size(); i++)
            {
                System.out.print("Phone number is " + phoneDataList.get(i).get("number"));
                System.out.println(" And Type is " + phoneDataList.get(i).get("type"));
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