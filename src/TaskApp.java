import controller.user.AuthenticationController;
import model.task.DefaultTask;
import model.task.Priority;
import model.task.TaskRepository;
import model.user.Admin;
import model.user.Developer;
import model.user.User;
import model.user.UserRepository;

public class TaskApp {

    public User currentUser;

    public static void main(String[] args) {
        TaskApp app = new TaskApp();
        app.loadApp();
        app.printWelcome();

        AuthenticationController authController = new AuthenticationController(UserRepository.getInstance());
        app.currentUser = authController.processLogin();

        System.out.println(app.currentUser.toString());

//        if (app.currentUser.getRole() == Role.ADMIN) {
//
//        }

        // Menu principal
//        while (programRunning) {
//            authView.loginMessage();
//        }
    }

    public void printWelcome() {
        System.out.println("=== Bienvenue dans l'application de gestion des tâches ===");
    }

    public void loadApp() {
        UserRepository uRepo = UserRepository.getInstance();
        TaskRepository tRepo = TaskRepository.getInstance();

        Admin admin_yavuz = new Admin("Yavuz");
        Developer dev_mingjie = new Developer("Mingjie");
        Developer dev_aloyse = new Developer("Aloyse");

        uRepo.create(admin_yavuz);
        uRepo.create(dev_mingjie);
        uRepo.create(dev_aloyse);

        tRepo.create(new DefaultTask("Corriger bug affichage", "Résoudre le bug qui empêche l'affichage correct des images", Priority.HAUTE, admin_yavuz));
        tRepo.create(new DefaultTask("Optimiser requêtes SQL", "Améliorer les performances des requêtes de la base de données", Priority.HAUTE, dev_mingjie));
        tRepo.create(new DefaultTask("Ajouter fonctionnalité recherche", "Implémenter une barre de recherche pour les utilisateurs", Priority.MOYENNE, dev_aloyse));
        tRepo.create(new DefaultTask("Corriger crash au démarrage", "Résoudre le problème de crash lorsque l'application démarre", Priority.HAUTE, dev_mingjie));
        tRepo.create(new DefaultTask("Refactorisation du code", "Réorganiser le code pour améliorer la lisibilité", Priority.MOYENNE, dev_aloyse));
        tRepo.create(new DefaultTask("Mise à jour des dépendances", "Mettre à jour les librairies utilisées dans le projet", Priority.BASSE, dev_mingjie));
        tRepo.create(new DefaultTask("Amélioration de l'interface utilisateur", "Rendre l'IHM plus intuitive et esthétique", Priority.MOYENNE, dev_aloyse));
        tRepo.create(new DefaultTask("Tests unitaires", "Écrire des tests pour augmenter la couverture du code", Priority.MOYENNE, dev_mingjie));
        tRepo.create(new DefaultTask("Documentation API", "Documenter les endpoints pour les développeurs", Priority.BASSE, dev_aloyse));
        tRepo.create(new DefaultTask("Configurer CI/CD", "Mettre en place un pipeline d'intégration et déploiement continu", Priority.HAUTE, admin_yavuz));

    }
}
