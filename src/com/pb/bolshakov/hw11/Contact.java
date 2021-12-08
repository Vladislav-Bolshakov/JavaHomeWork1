package com.pb.bolshakov.hw11;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Contact implements Serializable {
    private String name;
    private String dateOfBirth;
    private String phone;
    private String address;
    private String lastEditTimeStamp;

    private ArrayList<String> attachedPhoneNumbers;

    public Contact(String name, String dateOfBirth,String phone, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.attachedPhoneNumbers = new ArrayList<>();
        changed();
    }
    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", lastEditTimeStamp='" + lastEditTimeStamp + '\'' +
                '}';
    }
    private void changed() {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Europe/Ukraine"));
        this.lastEditTimeStamp = format.format(new GregorianCalendar().getTime());
    }
  }
