package controller.user;

import model.user.UserRepository;

public abstract class UserController implements IUserController {
    private UserRepository userRepository;

    abstract public UserRepository getUserRepository();
}
