package org.shelden.ss.uaa.controller;

import org.shelden.ss.uaa.model.User;
import org.shelden.ss.uaa.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> all() {
        return userService.all();
    }

    @GetMapping("/list")
    public Page<User> list(@PageableDefault(sort = {"name"}) Pageable pageable) {
        return userService.list(pageable);
    }
}
