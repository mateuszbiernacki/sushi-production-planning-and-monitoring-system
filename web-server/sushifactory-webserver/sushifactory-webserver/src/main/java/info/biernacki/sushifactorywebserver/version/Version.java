package info.biernacki.sushifactorywebserver.version;


import java.io.IOException;
import java.util.Properties;

public class Version {

    public String getAppVersion() {
        return appVersion;
    }

    private String appVersion;

    Version()  {
        Properties properties = new Properties();
        try {
            properties.load(VersionController.class.getClassLoader().getResourceAsStream("application.properties"));
            this.appVersion = properties.getProperty("app.version");
        } catch (IOException e){
            this.appVersion = "no version specified";
            //TODO log problem with properties file
        }
    }
}
