package model.task;

import model.user.User;

public class DefaultTask extends Task {
    public DefaultTask(String title, Priority priority, Status status, User assignedUser) {
        super(title, priority, status, assignedUser);
    }

    public DefaultTask(String title, Priority priority, User assignedUser) {
        this(title, priority, Status.EN_ATTENTE, assignedUser);
    }
}
