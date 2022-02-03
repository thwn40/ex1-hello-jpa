package hellojpa;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {
    //주소
    private String city;

    public String getCity() {
        return city;
    }
    public Address(){

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }


    public String getZipcode() {
        return zipcode;
    }


    private String street;
    private String zipcode;
}
