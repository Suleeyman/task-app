package view;

import model.task.Task;
import model.user.Role;
import model.user.User;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    public Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcomeScreen() {
        System.out.println("=============================");
        System.out.println("\tBienvenue dans To-Do List\t");
        System.out.println("=============================");
    }

    public int showLoginPrompt(List<User> users) {
        System.out.println("=== Bienvenue dans l'application de gestion des tâches ===");
        System.out.println("Veuillez vous identifier :");
        for (User user : users) {
            System.out.println(user.getName() + " [" + user.getId() + "]");
        }
        System.out.print("> ");
        return scanner.nextInt();
    }

    public void showMainMenu(User user) {
        System.out.println("\nBonjour, " + user.getName() + " (" + user.getRole() + ") !");
        System.out.println("\nMenu :");
        System.out.println("Afficher vos droits \t\t[0]");
        System.out.println("Afficher vos tâches \t\t[1]");
        System.out.println("Modifier l'état d'une tâche \t[2]");
        if (user.getRole() == Role.ADMIN) {
            System.out.println("Créer une tâche concernant \t[3]");
        }
        System.out.println("Déconnexion \t\t\t[4]");
        System.out.println("Éteindre le programme \t\t[5]");
        System.out.print("> ");
    }

    public void showTaskList(List<Task> tasks) {
        System.out.println("\n--------------------------");
        System.out.println("\tTask List");
        System.out.println("--------------------------");
        for (Task task : tasks) {
            System.out.println("[" + task.getId() + "] " + task.getDescription());
            System.out.println(this.getTaskDetails(task));
            System.out.println("---------------------------------");
        }
    }

    private String getTaskDetails(Task task) {
        return "Priorité : " + task.getPriority() + "\tÉtat : " + task.getStatus() + "\tAttribué à l'utilisateur ID : " + task.getAssignedUser().getName();
    }

    public void showConfirmationMessage(String message) {
        System.out.println("✅ " + message);
    }

    public void showErrorMessage(String message) {
        System.out.println("❌ " + message);
    }

    public void showLogoutMessage(User user) {
        System.out.println("\nCiao, " + user.getName() + " !");
    }

    public void showExitMessage() {
        System.out.println("\nMerci d'avoir utilisé To-Do List. À bientôt !");
    }

    public void showUserRights(User user) {
        System.out.println("\n---------------------------");
        System.out.println("Vos droits en tant que " + user.getRole());
        System.out.println("---------------------------");

        switch (user.getRole()) {
            case ADMIN:
                System.out.println("- Créer des tâches");
                System.out.println("- Attribuer des tâches à des utilisateurs");
                System.out.println("- Modifier l'état des tâches");
                System.out.println("- Afficher toutes les tâches");
                break;

            case DEV:
                System.out.println("- Consulter vos tâches");
                System.out.println("- Modifier l'état de vos tâches");
                break;

            default:
                System.out.println("Aucun droit défini pour ce rôle.");
                break;
        }

        System.out.println("---------------------------");
    }

}
