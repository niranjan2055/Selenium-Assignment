package utility;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testDataReader {
    JSONParser jsonParser = new JSONParser();
    FileReader reader;
    private static JSONObject testData;

    {
        try {
            reader = new FileReader("./src/utility/data.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Object obj;
    { try {
            obj = jsonParser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        testData = (JSONObject) obj;

    }
    public String getValue(String key){
        String value = (String) testData.get(key);
        return value;

    }


}
