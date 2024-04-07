package com.group.libraryapp.domain.book;

import com.group.libraryapp.dto.book.request.BookReturnRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id=null;

    @Column(nullable=false)
    private String name;

    protected Book(){}

    public Book(String name) {
        if(name==null||name.isBlank()){
            throw new IllegalArgumentException(
                    String.format("잘못된 name(%s)이 들어왔습니다", name));
        }//if
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
