package view;

import model.user.User;

public class ConsoleView implements IConsoleView {

    @Override
    public void afficherMenu(User user) {
        System.out.print("\n1. Afficher mes droits");
        System.out.print("\t2. Déconnexion");
        System.out.println("\t3. Quitter le programme");

        // Menu de gestion des tâches (options différentes en fonction du rôle)
        System.out.print("4. Afficher les tâches");
        System.out.print("\t5. Créer une tâche");
        System.out.println("\t6. Modifier l'état d'une tâche");

        // Les options suivantes sont réservées à l'admin
        if (user.isAdmin()) {
            System.out.print("7. Supprimer une tâche");
            System.out.print("\t8. Affecter une tâche à un utilisateur");
            System.out.println("\t9. Afficher tous les membres");
        }
    }

    @Override
    public void afficherMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printExitMessage() {
        afficherMessage("Fin du programme...");
    }
}
