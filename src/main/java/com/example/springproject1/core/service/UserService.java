package com.example.springproject1.core.service;

import com.example.springproject1.core.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Page<User> findAll(Pageable pageable);
    User findById(Long id);
    User save (User user);
    void deleteById (Long id);
}
