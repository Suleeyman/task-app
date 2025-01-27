package view;

import model.user.User;

public interface IConsoleView {
    void afficherMenu(User currentUser);

    void afficherMessage(String msg);

    void printExitMessage();
}
