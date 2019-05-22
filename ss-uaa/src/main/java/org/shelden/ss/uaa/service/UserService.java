package org.shelden.ss.uaa.service;

import org.shelden.ss.uaa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * The interface UserService.
 */
public interface UserService {

    /**
     * Fetch user by name.
     *
     * @param name the name
     * @return the optional with user
     */
    Optional<User> byName(String name);

    /**
     * Fetch list of all users.
     *
     * @return the list of users
     */
    List<User> all();

    /**
     * Fetch page by pageable parameters.
     *
     * @param pageable the pageable
     * @return the page of users
     */
    Page<User> list(Pageable pageable);

    /**
     * Saves user and create event log statement.
     *
     * @param user the user
     * @return the user
     */
    User save(User user);
}
