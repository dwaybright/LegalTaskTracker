package us.waybright.legaltasktrackerfx.gui.enums;

import java.net.URL;

/**
 *
 * @author Daniel Waybright
 */
public enum NodeDescriptor {
    CLIENT_LIST("/fxml/ClientViewer.fxml"),
    HOME("/fxml/Home.fxml"),
    MAIN_WINDOW("/fxml/MainWindow.fxml");
    
    private final String resourcePath;
    
    NodeDescriptor(String resourcePath) {
        this.resourcePath = resourcePath;
    }
    
    public final String getResourcePath() {
        return resourcePath;
    }
}
