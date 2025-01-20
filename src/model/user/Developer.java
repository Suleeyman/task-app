package model.user;

public class Developer extends User {

    // Constructeur : on définit le rôle à "DEV"
    public Developer(String name) {
        super(name, Role.DEV);
    }
}
