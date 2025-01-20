package controller;

import model.user.User;

public class AuthenticationController {

    private UserController userController;

    public AuthenticationController(UserController userController) {
        this.userController = userController;
    }

    // Authentifier un utilisateur par ID
    public User authenticateUser(int id) {
        return userController.getUserById(id);
    }
}
