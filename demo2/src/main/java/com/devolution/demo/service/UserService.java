package com.devolution.demo.service;

import com.devolution.demo.entity.Apartaments;
import com.devolution.demo.entity.Hotels;
import com.devolution.demo.entity.User;
import com.devolution.demo.repository.UserRepository;
import com.devolution.demo.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserRequest userRequest) {
        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());

        userRepository.save(user);
        return user;
    }

    public User updateUser(Long id, UserRequest userRequest) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            user.get().setAge(userRequest.getAge());
            user.get().setName(userRequest.getName());
            userRepository.save(user.get());
            return user.get();
        }
        return new User();
    }

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseGet(User::new);
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findUsers();
        return users;
    }

    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return "User was deleted successfully";
        }
        return "User was not found";
    }

    public void test(){
        Apartaments ap = new Apartaments();
        if(ap.getIs_reservated()){
            System.out.println("apartament is already reserved");
        };

    }

}
