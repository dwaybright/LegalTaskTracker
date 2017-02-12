package us.waybright.legaltasktrackerfx.domain;

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel Waybright
 */
@Entity
@Table(name = "client")
public class Client extends BaseEntity { 
    private String displayName;
    private int clientNumber;
    private boolean active;
    private Date dateCreated;
    private Date dateLastUpdated;
    private String firstName;
    private String middleName;
    private String lastName;
    private Set<Account> accounts;

    
    public Client() { }
    
    public Client(String displayName, int clientNumber, boolean active, String first, String middle, String last) {
        this.displayName = displayName;
        this.clientNumber = clientNumber;
        this.active = active;
        this.dateCreated = new Date();
        this.dateLastUpdated = new Date();
        this.firstName = first;
        this.middleName = middle;
        this.lastName = last;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @OneToMany(mappedBy = "client")
    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
