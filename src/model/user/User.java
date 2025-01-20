package model.user;

public abstract class User {
    private static int idCounter = 1; // Static field to track IDs
    private int id;
    private String name;
    private Role role;

    // Constructeur
    public User(String name, Role role) {
        this.id = idCounter++; // Assign the current value and increment
        this.name = name;
        this.role = role;
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

    // Setters
    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "\n\r\tid=" + id +
                ",\n\r\tname='" + name + '\'' +
                ",\n\r\trole='" + role + '\'' +
                "\n\r}";
    }
}
