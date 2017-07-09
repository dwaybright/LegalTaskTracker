package us.waybright.legaltasktrackerfx;

import com.google.inject.AbstractModule;
import us.waybright.legaltasktrackerfx.gui.StageManager;
import us.waybright.legaltasktrackerfx.gui.StageManagerImpl;
import us.waybright.legaltasktrackerfx.util.AppProperties;
import us.waybright.legaltasktrackerfx.util.AppPropertiesImpl;

/**
 *
 * @author Daniel Waybright
 */
public class LegalTaskTrackerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StageManager.class).to(StageManagerImpl.class);
        bind(AppProperties.class).to(AppPropertiesImpl.class);
    }
    
}
