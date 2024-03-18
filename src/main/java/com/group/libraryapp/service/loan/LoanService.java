package com.group.libraryapp.service.loan;

import com.group.libraryapp.domain.book.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.book.loanhistory.LoanRepository;
import com.group.libraryapp.dto.loan.LoanCreateRequest;

public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }//init

    public void saveLoan(LoanCreateRequest request){
        loanRepository.save(new UserLoanHistory(request.userName, request.bookName));
    }

}//end
