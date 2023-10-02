package Variables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configProperties {
    public static Properties property;
    private static String configpath = "Configuration/configsettings.properties";

    public static void initializePropertyFile()
    {
           property =new Properties();
        InputStream instm = null;
        try {
            instm = new FileInputStream(configpath);
            property.load(instm);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
