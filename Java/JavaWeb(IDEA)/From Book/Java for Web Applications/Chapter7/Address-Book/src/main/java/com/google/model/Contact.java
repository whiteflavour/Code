package com.google.model;

import java.util.Date;

/**
 * Contact POJO.
 *
 * @author Liao, wrox
 * @date 2021-3-26
 */
public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String birthday;
    private Date createdDate;


    public Contact() {}
    public Contact(String firstName, String lastName, String phoneNumber, String address, String birthday, Date  createdDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.createdDate = createdDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public int compareTo(Contact contact) {
        int result = firstName.compareTo(contact.getFirstName());
        if (result == 0) {
            return lastName.compareTo(contact.getLastName());
        }
        return result;
    }
}
