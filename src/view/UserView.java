package view;

import model.user.User;

import java.util.ArrayList;

public class UserView {
    public void showUserLists(ArrayList<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
