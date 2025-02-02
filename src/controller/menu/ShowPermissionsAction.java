package controller.menu;

import model.user.User;
import view.UserView;

public class ShowPermissionsAction extends MenuAction {
    private final UserView view;
    private final User user;

    public ShowPermissionsAction(UserView view, User user) {
        this.view = view;
        this.user = user;
    }

    @Override
    public void execute() {
        if (user != null) {
            view.showUserPermissions(user);
        }
    }
}
