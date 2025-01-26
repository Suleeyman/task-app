package model.task;

import model.user.User;

public class DefaultTask extends Task {
    public DefaultTask(String title, String description, Priority priority, Status status, User assignedUser) {
        super(title, description, priority, status, assignedUser);
    }

    public DefaultTask(String title, String description, Priority priority, User assignedUser) {
        this(title, description, priority, Status.EN_ATTENTE, assignedUser);
    }
}
