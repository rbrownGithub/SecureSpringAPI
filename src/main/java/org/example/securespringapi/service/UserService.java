package org.example.securespringapi.service;

import org.example.securespringapi.model.User;
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
    User findByUsername(String username);

    /**
     * Saves a new user or updates an existing user in the database.
     *
     * @param user the User object to be saved
     * @return the saved User object
     */
    User save(User user);

    /**
     * Generates a JWT token for the authenticated user.
     *
     * @param authentication the Authentication object containing user credentials
     * @return the generated JWT token as a String
     */
    String generateToken(Authentication authentication);
}
