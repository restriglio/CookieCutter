package com.example.raulstriglio.sampleapp.db.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by raul.striglio on 01/12/17.
 */

public class Address implements Serializable {

    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String zipcode;


    public Address(String street, String suite, String city, String zipcode) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String city) {
        this.zipcode = zipcode;
    }

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(street);
        stringBuilder.append(", ");
        stringBuilder.append(suite);
        stringBuilder.append(", ");
        stringBuilder.append(city);
        stringBuilder.append(", ");
        stringBuilder.append(zipcode);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
