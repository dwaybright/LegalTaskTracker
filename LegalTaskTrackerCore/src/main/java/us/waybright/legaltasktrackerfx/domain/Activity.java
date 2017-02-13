package us.waybright.legaltasktrackerfx.domain;

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
@Table(name = "activity")
public class Activity extends BaseEntity {    
    private Date dateCreated;
    private Date dateLastUpdated;
    private String submittedBy;
    private String activityType;    
    private Account account;
    
    
    public Activity() { }

    public Activity(String submittedBy, String activityType, Account account) {
        this.submittedBy = submittedBy;
        this.activityType = activityType;
        this.account = account;
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

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @ManyToOne
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
