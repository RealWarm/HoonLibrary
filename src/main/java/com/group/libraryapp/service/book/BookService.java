package com.group.libraryapp.service.book;


import com.group.libraryapp.aop.LogExecutionTime;
import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Log4j2
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository,
                       UserLoanHistoryRepository userLoanHistoryRepository,
                       UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @LogExecutionTime
    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }


    @LogExecutionTime
    @Transactional
    public void loanBook(BookLoanRequest request){
        // 1. 책 정보 가져오기
        Book book = bookRepository.findByName(request.getBookName())
                        .orElseThrow(IllegalArgumentException::new);

        // 2. 대출기록 정보를 확인해서 대출 중인지 확인함
        if(userLoanHistoryRepository. // false : 대출중 / true : 반납
                existsByBookNameAndIsReturn(book.getName(), false)){
            // 3. 만약 대출중이라면 예외를 발생시킴
            throw new IllegalArgumentException("해당 책은 대출되어 있습니다.");
        }//if

        // 4. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        // 도메인 계층에 비즈니스 로직이 들어갔다.
        user.loanBook(book.getName());

        // 5. 유저 정보와 책 정보를 기반으로 userLoanHistory를 저장
//        userLoanHistoryRepository.save(
//                new UserLoanHistory(user, book.getName()));
    }

    @LogExecutionTime
    @Transactional
    public void returnBook(BookReturnRequest request){
        // 1. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
//        UserLoanHistory history = userLoanHistoryRepository
//                .findByUserIdAndBookName(user.getId(), request.getBookName())
//                .orElseThrow(IllegalArgumentException::new);
//        history.doReturn();
//        System.out.println("========================================");
        log.info("@@@@@@@@@+++++++++++++@@@@@@@@@@@@@@@@@+++++++++");
        // userLoanHistoryRepository.save(history); // 트랜잭션 사용하니깐 안해도됨
        user.returnBook(request.getBookName());

    }

    public void returnBook2(BookReturnRequest request){
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

    }
}




















