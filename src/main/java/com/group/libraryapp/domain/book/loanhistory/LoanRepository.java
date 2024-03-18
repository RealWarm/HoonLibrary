package com.group.libraryapp.domain.book.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<UserLoanHistory, Long> {
}
