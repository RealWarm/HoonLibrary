package com.group.libraryapp.service.user;


import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
// IOException과 같은 Checked Exception은 롤백이 일어나지 않는다.
// 물론 서비스 계층에서는 IOException과 같은 에러가 날 일은 거의 없다.
// 영속성 컨텍스트는 트랜잭션의 주기와 같다. >> 트랜잭션 > 영속성 컨텍스트 > 변경감지
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository){
        this.userRepository=userRepository;
    }//init

    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    @Transactional(readOnly=true)
    public List<UserResponse> getUsers(){
        List<User> users =userRepository.findAll();
        return  users.stream()
                // .map(user->new UserResponse(user.getId(), user.getName(), user.getAge()))
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest request){
        // select * from user where id = ?;
        // Optional<User>
        User user = userRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        user.updateName(request.getName());
//        userRepository.save(user); // 변경감지
    }

    public void deleteUser(String name){
        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);
    }

}
