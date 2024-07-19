package com.yussuf.online_student.services;

import com.yussuf.online_student.model.Users;
import com.yussuf.online_student.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Users saveUsers(Users users) {
        return repository.save(users);
    }

    public List<Users> getAllUsers() {
        return repository.findAll();
    }
    public Optional<Users> getUsersById(Long id) {
        return repository.findById(id);
    }

    public Users updateUsers(Users Users) {
        return repository.save(Users);
    }

    public void deleteUsersById(Long id) {
        repository.deleteById(id);
    }
}
