package com.group.libraryapp.test;

import javax.persistence.*;


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private String city;
    private String street;
    @OneToOne(mappedBy = "address") // 연관관계의 주인이 아닌쪽에 사용해야한다.(주인에게 메여있다.)
    private Person person;

    public Address() {
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}//
// 연관관계의 주인에 따라 객체가 연결되는 기준이 된다.