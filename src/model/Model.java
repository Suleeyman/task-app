package model;

import model.task.TaskRepository;
import model.user.UserRepository;

public class Model implements IModel {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Model() {
        this.taskRepository = TaskRepository.getInstance();
        this.userRepository = UserRepository.getInstance();
    }

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
