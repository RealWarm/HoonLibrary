package com.group.libraryapp.domain.book.loanhistory;


import javax.persistence.*;

@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String bookName;

    protected UserLoanHistory() {
    }

    public UserLoanHistory(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }
}
