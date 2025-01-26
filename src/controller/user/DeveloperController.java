package controller.user;

import model.user.UserRepository;
import utils.IntInputReader;
import view.user.DeveloperView;

import java.util.Map;

public class DeveloperController extends UserController {
    private final DeveloperView developerView;
    private final UserRepository userRepository;

    // Définition d'un Map liant un choix à une action
    private static final Map<Integer, String> CHOICES = Map.of(
            1, "Afficher vos droits",
            2, "Créer une tâche",
            3, "Consulter les tâches",
            4, "Modifier l'état d'une tâche",
            5, "Déconnexion",
            6, "Quitter l'application"
    );

    public DeveloperController(DeveloperView developerView, UserRepository userRepository) {
        this.developerView = developerView;
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return this.userRepository;
    }

    @Override
    public void processMenu() {
        // Afficher le menu avec les actions
        developerView.printMenu(CHOICES);

        // Utiliser IntInputReader pour lire un choix valide
        int choice = (new IntInputReader()).read("> ", "Choix invalide.");

        // Exécution de l'action correspondante
        executeAction(choice);
    }

    @Override
    public void executeAction(int choice) {
        // Appel de l'action directement via le Map
        switch (choice) {
            case 1 -> showRights();
            case 2 -> createTask();
            case 3 -> viewTasks();
            case 4 -> editTaskStatus();
            case 5 -> logout();
            case 6 -> quitApplication();
        }
    }

    // Méthodes représentant les actions
    private void showRights() {
        System.out.println("Vous avez les droits d'administrateur.");
    }

    private void createTask() {
        System.out.println("Création d'une nouvelle tâche...");
    }

    private void viewTasks() {
        System.out.println("Liste des tâches disponibles...");
    }

    private void editTaskStatus() {
        System.out.println("Modification de l'état d'une tâche...");
    }

    private void logout() {
        System.out.println("Déconnexion en cours...");
    }

    private void quitApplication() {
        System.out.println("Fermeture de l'application. À bientôt !");
        System.exit(0); // Quitter l'application
    }
}
