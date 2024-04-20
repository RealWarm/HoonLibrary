package com.group.libraryapp.domain.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserLoanHistoryRepository
        extends JpaRepository<UserLoanHistory, Long> {
    // select * from user_loan_history where book_name = ? and is_return =?;
    boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);

    // select * from user_loan_history where user_id = ? and book_name = ?;
    Optional<UserLoanHistory> findByUserIdAndBookName(Long userId, String bookName);

//    @Query("select i from UserLoanHistory i where i.user.id=:itemDetail and i.bookName=:book_name ")
//    Optional<UserLoanHistory> findByUserIdAAndBookNameJPQL(@Param("userId")Long userId, @Param("bookName")String bookName);
}
