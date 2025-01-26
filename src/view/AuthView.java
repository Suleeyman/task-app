package view;

import model.user.User;

import java.util.List;

public class AuthView {
    public void loginMessage() {
        System.out.println("\nVeuillez vous identifier :");
    }

    public void logoutMessage(User user) {
        System.out.println("\nAurevoir " + user.getName());
    }

    public void welcomeMessage(User user) {
        System.out.println("\nBonjour, " + user.getName() + " (" + user.getRole() + ") !");
    }

    public void printUsers(List<User> users) {
        for (User user : users) {
            System.out.println("[" + user.getId() + "] " + user.getName());
        }
    }

}