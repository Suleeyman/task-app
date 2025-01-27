package model.task;

import model.IEntity;
import model.user.User;

public abstract class Task implements IEntity {
    private static int counterId = 1; // Static field to track IDs
    private int id;
    private String title;
    private Priority priority;
    private Status status;
    private User assignedUser; // Référence à l'utilisateur associé

    // Constructeur
    public Task(String title, Priority priority, Status status, User assignedUser) {
        this.id = counterId++; // Assign the current value and increment
        this.title = title;
        this.priority = priority;
        this.status = status; // Par défaut, le statut est EN_ATTENTE
        this.assignedUser = assignedUser; // Utilisateur associé à la tâche
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    // Setters avec retour de `this`
    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public Task setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public Task setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Task setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
        return this;
    }

    @Override
    public String toString() {
        return "Task{" +
                "\n\r\tid=" + id +
                ",\n\r\ttitle='" + title + '\'' +
                ",\n\r\tpriority=" + (priority) +
                ",\n\r\tstatus=" + status +
                ",\n\r\tassignedUser=" + (assignedUser != null ? assignedUser.getName() : "Aucun") +
                "\n\r}";
    }
}
