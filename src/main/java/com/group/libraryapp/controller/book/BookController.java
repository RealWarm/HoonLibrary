package com.group.libraryapp.controller.book;


import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.loan.LoanCreateRequest;
import com.group.libraryapp.service.book.BookService;
import com.group.libraryapp.service.loan.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    public final BookService bookService;
    public final LoanService loanService;

    public BookController(BookService bookService,
                          LoanService loanService) {
        this.bookService = bookService;
        this.loanService = loanService;
    }

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request){
        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
    public void saveLoan(@RequestBody LoanCreateRequest request){

    }


}//end
