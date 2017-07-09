package us.waybright.legaltasktrackerfx.gui.controllers;

import com.google.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.waybright.legaltasktrackerfx.gui.StageManager;
import us.waybright.legaltasktrackerfx.gui.enums.NodeDescriptor;

/**
 * FXML Controller class
 *
 * @author Daniel Waybright
 */
public class HomeController implements Initializable {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    
    @FXML Button viewClientsButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handleClientsButton(ActionEvent event) {
        MainWindowController.changeCenterNode(NodeDescriptor.CLIENT_LIST);
    }
}
