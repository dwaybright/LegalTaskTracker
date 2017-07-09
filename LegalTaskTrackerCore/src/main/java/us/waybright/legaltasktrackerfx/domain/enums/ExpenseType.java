package us.waybright.legaltasktrackerfx.domain.enums;

/**
 *
 * @author Daniel Waybright
 */
public enum ExpenseType {
    PRINTING_COPYING("Printing/Copying"),
    TRAVEL("Travel"),
    DELIVERY("Delivery"),
    LODGING_MEALS("Lodging/Meals");
    
    private final String label;
    
    ExpenseType(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }
}
