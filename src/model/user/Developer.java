package model.user;

import java.util.Arrays;

public class Developer extends User {

    // Constructeur : on définit le rôle à "DEV"
    public Developer(String name) {
        super(name, Role.DEV, Arrays.asList(
                Permission.CREATE_TASK,
                Permission.READ_TASK,
                Permission.UPDATE_TASK,
                Permission.READ_USERS
        ));
    }
}
