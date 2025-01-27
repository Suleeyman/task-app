package model.user;

import model.IEntity;

import java.util.List;

public abstract class User implements IEntity {
    private static int counterId = 1; // Static field to track IDs
    private int id;
    private String name;
    private Role role;
    private List<Permission> permissions;

    // Constructeur
    public User(String name, Role role, List<Permission> permissions) {
        this.id = counterId++; // Assign the current value and increment
        this.name = name;
        this.role = role;
        this.permissions = permissions;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

    @Override
    public String toString() {
        return "User{" +
                "\n\r\tid=" + id +
                ",\n\r\tname='" + name + '\'' +
                ",\n\r\trole='" + role + '\'' +
                "\n\r}";
    }

    public boolean isAdmin() {
        return role == Role.ADMIN;
    }
}
