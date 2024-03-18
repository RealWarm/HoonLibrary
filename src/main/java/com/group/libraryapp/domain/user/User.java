package com.group.libraryapp.domain.user;

import javax.persistence.*;

// 엔티티 : 저장되고, 관리되어야 하는 데이터
@Entity // 스프링이 객체와 테이블을 같은 것으로 보겠다.
public class User {
    @Id // 해당 필드를 pk로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // pk는 자동 생성되는 값이다.
    // MySQL의 auto_increment와 대응
    private Long id = null;
    @Column(nullable = false, length = 20, name = "name") // name varchar(20)
    private String name;
    private Integer age;

    protected User() {} //?????????????

    public User(String name, Integer age) {
        if(name==null| name.isBlank()){
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
}
