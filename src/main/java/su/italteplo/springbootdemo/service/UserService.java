package su.italteplo.springbootdemo.service;

import su.italteplo.springbootdemo.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User saveUser(User user);

    void deleteUser(Long id);
}
