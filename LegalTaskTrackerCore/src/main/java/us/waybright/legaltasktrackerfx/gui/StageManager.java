package us.waybright.legaltasktrackerfx.gui;

import us.waybright.legaltasktrackerfx.gui.enums.StyleDescriptor;
import us.waybright.legaltasktrackerfx.gui.enums.NodeDescriptor;
import java.io.IOException;
import javafx.stage.Stage;


/**
 *
 * @author Daniel Waybright
 */
public interface StageManager {
    
    public void initStage(final Stage stage) throws IOException;
    
    public void setScene(NodeDescriptor node, StyleDescriptor style) throws IOException;
}
