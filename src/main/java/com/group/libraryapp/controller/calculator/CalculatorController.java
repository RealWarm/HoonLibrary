package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // 해당클래스를 컨트롤러로 등록한다.
public class CalculatorController {



    @GetMapping("/add")
    public int addTwoNumbers(
            CalculatorAddRequest request
    ){
        return request.getNumber1()+request.getNumber2();
    }//addTwoNumbers

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(
        @RequestBody CalculatorMultiplyRequest request
    ){
        return request.getNumber1()*request.getNumber2();
    }//multiplyTwoNumbers




}//end
