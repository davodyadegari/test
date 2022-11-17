package file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MessageLoader{

    private static Properties prop = new Properties();

    static {
        InputStream in;
        try {
            in = new FileInputStream("/home/raha/workspace/atm-/file/message.properties");
            prop.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMessage(String key){
        String message = prop.getProperty(key);
        return message;
    }
}
