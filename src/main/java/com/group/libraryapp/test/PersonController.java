package com.group.libraryapp.test;


import org.springframework.stereotype.Service;

@Service
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


}//end
