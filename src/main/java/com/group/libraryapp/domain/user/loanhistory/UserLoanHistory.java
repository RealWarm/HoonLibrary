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
    @ManyToOne // n(학생):1(교실) > 연관관계의 주인은 무조건 숫자가 많은쪽(N) 이다.
    // N:M 관계 (@ManyToMany) 는 구조가 복잡하고,
    // 테이블이 직관적으로 매핑되지 않아 사용하지 않는 것을 추천
    @JoinColumn(nullable = false)
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

    public String getBookName(){
        return this.bookName;
    }


}
