package us.waybright.legaltasktrackerfx;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import us.waybright.legaltasktrackerfx.gui.StageManager;
import us.waybright.legaltasktrackerfx.util.HibernateHelper;

/**
 *
 * @author Daniel Waybright
 */
public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        HibernateHelper.init();
        
        Injector injector = Guice.createInjector(new LegalTaskTrackerModule());
        StageManager stageManager = injector.getInstance(StageManager.class);
        stageManager.initStage(stage);
    }
    
    @Override
    public void stop() {
        HibernateHelper.close();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
