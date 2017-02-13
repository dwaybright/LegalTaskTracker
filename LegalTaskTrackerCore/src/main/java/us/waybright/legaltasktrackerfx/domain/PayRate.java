package us.waybright.legaltasktrackerfx.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Daniel Waybright
 */
@Entity
@Table(name = "payrate")
public class PayRate extends BaseEntity {
    private String description;
    private BigDecimal baseCost;
    private BigDecimal taxRate;
    private BigDecimal markupRate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public BigDecimal getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getMarkupRate() {
        return markupRate;
    }

    public void setMarkupRate(BigDecimal markupRate) {
        this.markupRate = markupRate;
    }
}
