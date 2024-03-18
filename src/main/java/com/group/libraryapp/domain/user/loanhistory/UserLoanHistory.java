package com.group.libraryapp.domain.user.loanhistory;


import com.group.libraryapp.domain.user.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 내가 다수이고 너가 한개다 > 대출 기록은 여러개고,
    // 기록을 소유하고 있는 사용자는 한명이다.
    @ManyToOne // n(학생):1(교실)
    private User user;
    private String bookName;
    private boolean isReturn; // 0 :false, 1:true

    protected UserLoanHistory() {
    }

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn(){
        this.isReturn=true;
    }

}
