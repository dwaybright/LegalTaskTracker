package us.waybright.legaltasktrackerfx.controllers.manage;

/**
 *
 * @author Daniel Waybright
 */
public enum StyleDescriptor {
    MAIN("/styles/Styles.css");
    
    private final String resourcePath;
    
    StyleDescriptor(String resourcePath) {
        this.resourcePath = resourcePath;
    }
    
    public final String getResourcePath() {
        return resourcePath;
    }
}
