package us.waybright.legaltasktrackerfx.domain.enums;

/**
 *
 * @author Daniel Waybright
 */
public enum ActivityType {
    DRAFTING("Drafting"),
    RESEARCH("Research"),
    COURT("Court Time"),
    CORRESPONDANCE("Correspondance/Email/Text"),
    MEETINGS("Meetings"),
    DISCOVERY("Discovery"),
    PHONE("Phone Call"),
    PREPARATIONS("Preparations");
    
    private final String label;
    
    ActivityType(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }
}
