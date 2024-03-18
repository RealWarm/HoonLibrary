package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    @Autowired
    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(UserCreateRequest request){
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers(){
        return userJdbcRepository.getUsers();
    }

    public void updateUser(
            UserUpdateRequest request
    ){
        boolean isUserNotExistById= userJdbcRepository.isUserNotExistById(request.getId());
        if(isUserNotExistById){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(String name){
        userJdbcRepository.deleteUser(name);
    }

}//end
