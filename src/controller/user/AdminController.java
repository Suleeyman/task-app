package controller.user;

import model.user.UserRepository;
import utils.IntInputReader;
import view.user.AdminView;

import java.util.Map;

public class AdminController extends UserController {
    private final AdminView adminView;
    private final UserRepository userRepository;

    // Définition d'une constante pour les choix possibles dans le menu
    private static final Map<Integer, String> CHOICES = Map.of(
            1, "Afficher vos droits",
            2, "Créer une tâche",
            3, "Consulter les tâches",
            4, "Modifier une tâche",
            5, "Supprimer une tâche",
            6, "Affecter une tâche à un utilisateur",
            7, "Déconnexion",
            8, "Quitter l'application"
    );

    public AdminController(AdminView adminView, UserRepository userRepository) {
        this.adminView = adminView;
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return this.userRepository;
    }

    @Override
    public void processMenu() {
        // Afficher le menu avec les actions
        adminView.printMenu(CHOICES);


        // Utiliser IntInputReader pour lire un choix valide
        int choice = (new IntInputReader()).read("> ", "Choix invalide...");

        // Exécution de l'action correspondante
        executeAction(choice);
    }

    @Override
    public void executeAction(int choice) {
        // Dynamique en fonction du choix, la méthode correspondante est appelée
        switch (choice) {
            case 1 -> showRights();
            case 2 -> createTask();
            case 3 -> viewTasks();
            case 4 -> editTask();
            case 5 -> deleteTask();
            case 6 -> assignTask();
            case 7 -> logout();
            case 8 -> quitApplication();
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

    private void editTask() {
        System.out.println("Modification d'une tâche...");
    }

    private void deleteTask() {
        System.out.println("Suppression d'une tâche...");
    }

    private void assignTask() {
        System.out.println("Affectation d'une tâche à un utilisateur...");
    }

    private void logout() {
        System.out.println("Déconnexion en cours...");
    }

    private void quitApplication() {
        System.out.println("Fermeture de l'application. À bientôt !");
        System.exit(0); // Quitter l'application
    }
}
