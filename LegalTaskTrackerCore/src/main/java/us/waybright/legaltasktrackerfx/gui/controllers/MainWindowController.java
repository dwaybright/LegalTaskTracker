package us.waybright.legaltasktrackerfx.gui.controllers;

import com.google.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.waybright.legaltasktrackerfx.gui.StageManager;
import us.waybright.legaltasktrackerfx.gui.enums.NodeDescriptor;

/**
 * FXML Controller class
 *
 * @author Daniel Waybright
 */
public class MainWindowController implements Initializable {
    private static final Logger LOG = LoggerFactory.getLogger(MainWindowController.class);
    private static BorderPane MAIN_WINDOW_BORDER_PANE;
    private static ResourceBundle RESOURCE_BUNDLE;
    
    private StageManager stageManager;
    
    @FXML private BorderPane MainWindowBorderPane;   
    
    // Menu Items
    @FXML private MenuItem MenuFileClose;
    @FXML private MenuItem MenuHelpAbout;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MAIN_WINDOW_BORDER_PANE = MainWindowBorderPane;
        RESOURCE_BUNDLE = rb;
        
        changeCenterNode(NodeDescriptor.HOME);
    }
    
    public static void changeCenterNode(NodeDescriptor centerNode) {
        try {
            Parent centerScene = FXMLLoader.load(MainWindowController.class.getResource(centerNode.getResourcePath()), RESOURCE_BUNDLE);
            MAIN_WINDOW_BORDER_PANE.setCenter(centerScene);
        } catch (IOException ioex) {
            LOG.error("Unable to load new scene.", ioex);
        }
    }
    
    @FXML
    private void clickMenuHelpAbout(ActionEvent event) {
        int x = 5;
    }
    
    @FXML
    private void clickMenuFileClose(ActionEvent event) {
        Platform.exit();
    }
    
    @Inject
    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }
}
