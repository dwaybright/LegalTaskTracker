package us.waybright.legaltasktrackerfx.controllers.manage;

/**
 *
 * @author Daniel Waybright
 */
public enum NodeDescriptor {
    CLIENT_LIST("/fxml/ClientViewer.fxml");
    
    private final String resourcePath;
    
    NodeDescriptor(String resourcePath) {
        this.resourcePath = resourcePath;
    }
    
    public final String getResourcePath() {
        return resourcePath;
    }
}
