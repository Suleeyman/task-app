package controller;

import model.task.Priority;
import model.task.Status;
import model.task.Task;
import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private List<Task> tasks;
    private UserController userController;

    public TaskController(UserController userController) {
        this.userController = userController;
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Corriger bug affichage", "Résoudre le bug qui empêche l'affichage correct des images", Priority.HAUTE, userController.getUserById(3)));
        tasks.add(new Task("Optimiser requêtes SQL", "Améliorer les performances des requêtes de la base de données", Priority.HAUTE, userController.getUserById(3)));
        tasks.add(new Task("Ajouter fonctionnalité recherche", "Implémenter une barre de recherche pour les utilisateurs", Priority.MOYENNE, userController.getUserById(3)));
        tasks.add(new Task("Corriger crash au démarrage", "Résoudre le problème de crash lorsque l'application démarre", Priority.HAUTE, userController.getUserById(3)));
        tasks.add(new Task("Refactorisation du code", "Réorganiser le code pour améliorer la lisibilité", Priority.MOYENNE, userController.getUserById(3)));
        tasks.add(new Task("Mise à jour des dépendances", "Mettre à jour les librairies utilisées dans le projet", Priority.BASSE, userController.getUserById(2)));
        tasks.add(new Task("Amélioration de l'interface utilisateur", "Rendre l'IHM plus intuitive et esthétique", Priority.MOYENNE, userController.getUserById(2)));
        tasks.add(new Task("Tests unitaires", "Écrire des tests pour augmenter la couverture du code", Priority.MOYENNE, userController.getUserById(2)));
        tasks.add(new Task("Documentation API", "Documenter les endpoints pour les développeurs", Priority.BASSE, userController.getUserById(2)));
        tasks.add(new Task("Configurer CI/CD", "Mettre en place un pipeline d'intégration et déploiement continu", Priority.HAUTE, userController.getUserById(1)));

        this.tasks = tasks;
    }

    // Créer une nouvelle tâche
    public Task createTask(String title, String description, Priority priority, Status status, int userId) {
        Task task = new Task(title, description, priority, status, this.userController.getUserById(userId));
        tasks.add(task);
        return task;
    }

    // Récupérer toutes les tâches
    public List<Task> getAllTasks() {
        return tasks;
    }

    // Récupérer les tâches par statut
    public List<Task> getTasksByStatus(Status status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                result.add(task);
            }
        }
        return result;
    }

    // Récupérer les tâches d'un utilisateur (par User)
    public List<Task> getTaskFromUser(User user) {
        return getTaskFromUser(user.getId());
    }

    // Récupérer les tâches d'un utilisateur (par ID)
    public List<Task> getTaskFromUser(int userId) {
        List<Task> userTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getAssignedUser().getId() == userId) {
                userTasks.add(task);
            }
        }
        return userTasks;
    }

    // Assigner une tâche à un utilisateur
    public void assignTaskToUser(int taskId, int userId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setAssignedUser(this.userController.getUserById(userId));
                break;
            }
        }
    }
}
