package controller.menu;

import model.user.UserRepository;
import view.UserView;

public class ShowUsersAction extends MenuAction {
    private final UserRepository userRepository;
    private final UserView view;

    public ShowUsersAction(UserRepository userRepository, UserView view) {
        this.userRepository = userRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        view.showUserLists(userRepository.getAll());
    }
}
