package model;

import model.task.Task;
import model.user.User;

public interface IModel {
    IRepository<Task> getTaskRepository();

    IRepository<User> getUserRepository();
}
