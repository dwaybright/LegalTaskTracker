package us.waybright.legaltasktrackerfx.util;

import java.io.IOException;
import java.util.Properties;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Daniel Waybright
 */
@Singleton
public class AppPropertiesImpl implements AppProperties {
    private static final Logger LOG = LoggerFactory.getLogger(AppPropertiesImpl.class);
    private Properties properties;
    
    @Override
    public String getVersion() {
        if(properties == null) {
            init();
        }
        
        return properties.getProperty("version");
    }
    
    private void init() {
        properties = new Properties();
        
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("project.properties"));
        } catch(IOException ex) {
            LOG.error("Unable to load properties file", ex);
        }
    }
}
