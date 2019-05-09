import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example3 {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("example3.json"));

          //write code here to print all the titles and the associated categories
            JSONObject jsonObject =  (JSONObject) obj;
            JSONObject response = (JSONObject) jsonObject.get("responseData");
            JSONObject feedObj = (JSONObject) response.get("feed");

            List<HashMap<String,?>> listOfEntries = (List< HashMap<String,?>>)feedObj.get("entries");

            for(int i=0; i<listOfEntries.size(); i++)
            {
                System.out.println("The Title is" +listOfEntries.get(i).get("title"));
                System.out.println("The associated Categories" +listOfEntries.get(i).get("categories"));
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