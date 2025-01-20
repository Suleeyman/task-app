import controller.TaskController;
import controller.UserController;
import model.task.Priority;
import model.task.Task;
import model.user.Admin;
import model.user.Developer;
import model.user.Role;
import model.user.User;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class TaskApp {

    public static void main(String[] args) {
        // Initialisation des contrôleurs et de la vue
        UserController userController = new UserController();
        TaskController taskController = new TaskController(userController);
        ConsoleView consoleView = new ConsoleView();

        // Affichage de l'écran d'accueil
        consoleView.showWelcomeScreen();

        // Identification de l'utilisateur
        List<User> users = userController.getAllUsers();
        boolean programRunning = true;

        // Menu principal
        while (programRunning) {
            int userId = consoleView.showLoginPrompt(users);
            User currentUser = userController.getUserById(userId);
            if (currentUser == null) {
                continue;
            }
            boolean userSessionActive = true;
            while (userSessionActive) {
                // Menu principal
                consoleView.showMainMenu(currentUser);
                int choice = consoleView.scanner.nextInt();

                switch (choice) {
                    case 0 -> consoleView.showUserRights(currentUser);
                    case 1 -> consoleView.showTaskList(taskController.getTaskFromUser(currentUser));
                    case 2 -> System.out.println("Modifier l'état d'une tâche (à implémenter)");
                    case 3 -> {
                        if (currentUser.getRole() == Role.ADMIN) {
                            System.out.println("Créer une tâche (à implémenter)");
                        } else {
                            consoleView.showErrorMessage("Vous n'avez pas les droits nécessaires.");
                        }
                    }
                    case 4 -> {
                        consoleView.showLogoutMessage(currentUser);
                        userSessionActive = false; // Quitte la session utilisateur
                    }
                    case 5 -> {
                        consoleView.showExitMessage();
                        programRunning = false; // Quitte l'application
                        userSessionActive = false; // Arrête la session utilisateur
                    }
                    default -> consoleView.showErrorMessage("Option invalide !");
                }
            }
        }
    }

    public void displayWelcome() {
        System.out.println("=============================");
        System.out.println("\tBienvenue dans To-Do List\t");
        System.out.println("=============================");
    }

    public List<Task> seedTasks(Developer dev1, Developer dev2, Admin admin) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Corriger bug affichage", "Résoudre le bug qui empêche l'affichage correct des images", Priority.HAUTE, dev1));
        tasks.add(new Task("Optimiser requêtes SQL", "Améliorer les performances des requêtes de la base de données", Priority.HAUTE, dev2));
        tasks.add(new Task("Ajouter fonctionnalité recherche", "Implémenter une barre de recherche pour les utilisateurs", Priority.MOYENNE, dev1));
        tasks.add(new Task("Corriger crash au démarrage", "Résoudre le problème de crash lorsque l'application démarre", Priority.HAUTE, dev2));
        tasks.add(new Task("Refactorisation du code", "Réorganiser le code pour améliorer la lisibilité", Priority.MOYENNE, dev1));
        tasks.add(new Task("Mise à jour des dépendances", "Mettre à jour les librairies utilisées dans le projet", Priority.BASSE, dev2));
        tasks.add(new Task("Amélioration de l'interface utilisateur", "Rendre l'IHM plus intuitive et esthétique", Priority.MOYENNE, dev1));
        tasks.add(new Task("Tests unitaires", "Écrire des tests pour augmenter la couverture du code", Priority.MOYENNE, dev2));
        tasks.add(new Task("Documentation API", "Documenter les endpoints pour les développeurs", Priority.BASSE, dev1));
        tasks.add(new Task("Configurer CI/CD", "Mettre en place un pipeline d'intégration et déploiement continu", Priority.HAUTE, admin));

        return tasks;
    }
}
