package controller;

import model.user.Admin;
import model.user.Developer;
import model.user.Role;
import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
        // Initialisation avec des utilisateurs par défaut (par exemple)
        users.add(new Admin("Alice"));
        users.add(new Developer("Bob"));
        users.add(new Developer("Charlie"));
    }

    // Créer un utilisateur
    public User createUser(String name, Role role) {
        User user;
        if (role == Role.ADMIN) {
            user = new Admin(name);
        } else {
            user = new Developer(name);
        }
        users.add(user);
        return user;
    }

    // Récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return users;
    }

    // Trouver un utilisateur par ID
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // Retourne null si aucun utilisateur trouvé
    }

    // Trouver un utilisateur par nom
    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
}
