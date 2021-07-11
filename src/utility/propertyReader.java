package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyReader {
    private Properties properties = new Properties();
    FileInputStream propertyFile;

    {
        try {
            propertyFile = new FileInputStream("./src/utility/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getConfig(String key){
        try {
            properties.load(propertyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = (String) properties.get(key);
        return value;
    }


}
