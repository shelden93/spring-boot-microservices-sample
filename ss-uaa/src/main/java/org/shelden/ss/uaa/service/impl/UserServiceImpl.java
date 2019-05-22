package org.shelden.ss.uaa.service.impl;

import org.shelden.ss.uaa.model.User;
import org.shelden.ss.uaa.repository.UserRepository;
import org.shelden.ss.uaa.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> byName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<User> all() {
        return repository.findAll();
    }

    @Override
    public Page<User> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
