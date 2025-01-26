package controller;

import controller.user.UserController;
import model.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private List<Task> tasks;
    private UserController userController;

    public TaskController(UserController userController) {
        this.userController = userController;
        List<Task> tasks = new ArrayList<>();
        this.tasks = tasks;
    }

//    // Créer une nouvelle tâche
//    public Task createTask(String title, String description, Priority priority, Status status, int userId) {
//        Task task = new Task(title, description, priority, status, this.userController.getUserById(userId));
//        tasks.add(task);
//        return task;
//    }
//
//    // Récupérer toutes les tâches
//    public List<Task> getAllTasks() {
//        return tasks;
//    }
//
//    // Récupérer les tâches par statut
//    public List<Task> getTasksByStatus(Status status) {
//        List<Task> result = new ArrayList<>();
//        for (Task task : tasks) {
//            if (task.getStatus() == status) {
//                result.add(task);
//            }
//        }
//        return result;
//    }
//
//    // Récupérer les tâches d'un utilisateur (par User)
//    public List<Task> getTaskFromUser(User user) {
//        return getTaskFromUser(user.getId());
//    }
//
//    // Récupérer les tâches d'un utilisateur (par ID)
//    public List<Task> getTaskFromUser(int userId) {
//        List<Task> userTasks = new ArrayList<>();
//        for (Task task : tasks) {
//            if (task.getAssignedUser().getId() == userId) {
//                userTasks.add(task);
//            }
//        }
//        return userTasks;
//    }
//
//    // Assigner une tâche à un utilisateur
//    public void assignTaskToUser(int taskId, int userId) {
//        for (Task task : tasks) {
//            if (task.getId() == taskId) {
//                task.setAssignedUser(this.userController.getUserById(userId));
//                break;
//            }
//        }
//    }
}
