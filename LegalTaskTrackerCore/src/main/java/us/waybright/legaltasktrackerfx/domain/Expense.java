package us.waybright.legaltasktrackerfx.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Daniel Waybright
 */
@Entity
@Table(name = "expense")
public class Expense extends BaseEntity {
    private Date dateCreated;
    private Date dateLastUpdated;
    private String submittedBy;
    private String expenseType;
    private String description;
    private int numberUnits;
    private String unitDescription;
    private BigDecimal costPerUnit;
    private Account account;
    

    public Expense() { }

    public Expense(Account account, String submittedBy, String expenseType, String description, int numberUnits, String unitDescription, BigDecimal costPerUnit) {
        this.account = account;
        this.dateCreated = new Date();
        this.dateLastUpdated = new Date();
        this.submittedBy = submittedBy;
        this.expenseType = expenseType;
        this.description = description;
        this.numberUnits = numberUnits;
        this.unitDescription = unitDescription;
        this.costPerUnit = costPerUnit;
    }
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberUnits() {
        return numberUnits;
    }

    public void setNumberUnits(int numberUnits) {
        this.numberUnits = numberUnits;
    }

    public String getUnitDescription() {
        return unitDescription;
    }

    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription;
    }

    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(BigDecimal costPerUnit) {
        this.costPerUnit = costPerUnit;
    }
    
    @ManyToOne
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
