package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 엔티티 : 저장되고, 관리되어야 하는 데이터
@Entity // 스프링이 객체와 테이블을 같은 것으로 보겠다.
public class User {
    @Id // 해당 필드를 pk로 설정
    // pk는 자동 생성되는 값이다.
    // MySQL의 auto_increment와 대응
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20, name = "name") // name varchar(20)
    private String name;
    private Integer age;
    // 1:n
    // 연관관계의 주인이 아닌쪽에 mappedBy를 해야한다.
    @OneToMany(mappedBy = "user",
                cascade = CascadeType.ALL, // 폭포처럼 흘러 연결되어 있는 객체도 함께 저장되거나 삭제
                orphanRemoval = true, //객체간의 관계가 끊어진 테이터를 자동으로 제거하는 옵션
                fetch = FetchType.EAGER)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    protected User() {}

    public User(String name, Integer age) {
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 이름 (%s)이 들어왔습니다.",  name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String name){
        this.name=name;
    }

    public void loanBook(String bookName){
        this.userLoanHistories.add(new UserLoanHistory(this, bookName));
    }

    public void returnBook(String bookName){
        UserLoanHistory targetHistory = this.userLoanHistories.stream()
                .filter(history -> history.getBookName().equals(bookName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        targetHistory.doReturn();
    }
}
