package us.waybright.legaltasktrackerfx.domain;

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel Waybright
 */
@Entity
@Table(name = "account")
public class Account extends BaseEntity {
    private int accountNumber;
    private Date dateCreated;
    private Date dateLastUpdated;    
    private String accountType;
    private boolean active;
    private Client client;
    private BillingAddress billingAddress;    
    private Set<Expense> expenses;
    private Set<Activity> activities;
    
    
    public Account() { }
    
    public Account(Client client, int accountNumber, String accountType, boolean active) {
        this.client = client;
        this.accountNumber = accountNumber;
        this.dateCreated = new Date();
        this.dateLastUpdated = new Date();
        this.accountType = accountType;
        this.active = active;
    }
    
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    @OneToOne
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    @OneToMany(mappedBy = "account")
    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }
    
    @OneToMany(mappedBy = "account")
    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }
}
