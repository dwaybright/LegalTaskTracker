package us.waybright.legaltasktrackerfx.gui;

import us.waybright.legaltasktrackerfx.gui.enums.StyleDescriptor;
import us.waybright.legaltasktrackerfx.gui.enums.NodeDescriptor;
import com.google.inject.Inject;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.inject.Singleton;
import us.waybright.legaltasktrackerfx.util.AppProperties;

/**
 *
 * @author Daniel Waybright
 */
@Singleton
public final class StageManagerImpl implements StageManager {
    private static final String WINDOW_TITLE = "JavaFX and Maven - ";
    
    private Stage stage;
    private AppProperties properties;
    
    @Override
    public void initStage(final Stage stage) throws IOException {
        this.stage = stage;
        this.stage.setTitle(WINDOW_TITLE + properties.getVersion());        
        setScene(NodeDescriptor.MAIN_WINDOW, StyleDescriptor.MAIN);
        this.stage.show();
    }
    
    @Override
    public void setScene(NodeDescriptor node, StyleDescriptor style) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(node.getResourcePath()));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(style.getResourcePath());
        
        stage.setScene(scene);
    }
    
    @Inject
    public void setAppProperties(AppProperties properties) {
        this.properties = properties;
    }
}
