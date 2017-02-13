package us.waybright.legaltasktrackerfx.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author danielwaybright
 */
@Entity
@Table(name = "billing_address")
public class BillingAddress extends BaseEntity {
    private String name;
    private String street1;
    private String street2;
    private String street3;
    private String city;
    private String statecode;
    private String zipcode;
    private String phone;
    
    public BillingAddress() { }
    
    public BillingAddress(String name, String street1, String street2, String street3, String city, String statecode, String zipcode, String phone) {
        this.name = name;
        this.street1 = street1;
        this.street2 = street2;
        this.street3 = street3;
        this.city = city;
        this.statecode = statecode;
        this.zipcode = zipcode;
        this.phone = phone;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
