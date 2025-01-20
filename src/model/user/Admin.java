package model.user;

public class Admin extends User {

    // Constructeur : on définit le rôle à "ADMIN"
    public Admin(String name) {
        super(name, Role.ADMIN);
    }
}
