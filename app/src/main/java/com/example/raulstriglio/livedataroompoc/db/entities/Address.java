package com.example.raulstriglio.livedataroompoc.db.entities;

import android.arch.persistence.room.Ignore;
import android.provider.Telephony;

import javax.inject.Inject;

/**
 * Created by raul.striglio on 01/12/17.
 */

public class Address {

    private String street;

    private String number;

    private String neighborhood;



    public Address(String street, String number, String neighborhood){
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public String toString(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(street);
        stringBuilder.append(", ");
        stringBuilder.append(number);
        stringBuilder.append(", ");
        stringBuilder.append(neighborhood);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
