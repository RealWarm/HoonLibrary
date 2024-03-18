package com.group.libraryapp.dto.loan;

public class LoanCreateRequest {
    public String userName;
    public String bookName;

    public LoanCreateRequest(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }
}//end
