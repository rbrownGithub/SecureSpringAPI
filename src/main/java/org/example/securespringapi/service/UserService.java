package org.example.securespringapi.service;

import org.example.securespringapi.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;

/**
 * Service interface for managing user-related operations.
 */
public interface UserService {

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user to find
     * @return the User object, or null if no user is found
     */
    @Cacheable("users")
    User findByUsername(String username);

    /**
     * Saves a new user or updates an existing user in the database.
     *
     * @param user the User object to be saved
     * @return the saved User object
     */
    @CachePut(value = "users", key = "#user.username")
    User save(User user);

    /**
     * Generates a JWT token for the authenticated user.
     *
     * @param authentication the Authentication object containing user credentials
     * @return the generated JWT token as a String
     */
    String generateToken(Authentication authentication);

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to be deleted
     */
    @CacheEvict(value = "users", allEntries = true)
    void deleteUser(Long id);
}
