package com.group.libraryapp.test;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id = null;
    private String name;
    @OneToOne
    private Address address;

    protected Person() {
    }

    public void setAddress(Address address) {
        this.address = address;
        this.address.setPerson(this);
    }
}
