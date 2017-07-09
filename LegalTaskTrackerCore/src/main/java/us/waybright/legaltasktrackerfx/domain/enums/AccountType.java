package us.waybright.legaltasktrackerfx.domain.enums;

/**
 *
 * @author Daniel Waybright
 */
public enum AccountType {
    CIVIL("Civil"),
    CHILDREN("Children"),
    CONTRACT("Contract"),
    CRIMINAL("Criminal"),
    FAMILY_ADOPTION_GUARDIAN("Family/Adoption Guardian"),
    FAMILY_CHILD_SUPPORT("Family/Child Support"),
    FAMILY_DIVORCE("Family/Divorce"),
    GOVERNMENT("Government"),
    PROBATE("Probate"),
    REAL_ESTATE("Real Estate"),
    WILL("Will");
    
    private final String label;
    
    AccountType(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }
}
