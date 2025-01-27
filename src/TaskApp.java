import controller.ConsoleController;
import controller.user.AuthenticationController;
import model.Model;
import model.task.DefaultTask;
import model.task.Priority;
import model.task.TaskRepository;
import model.user.Admin;
import model.user.Developer;
import model.user.UserRepository;
import view.ConsoleView;

public class TaskApp {


    public static void main(String[] args) {
        loadAppData();
        Model model = new Model();

        System.out.println("=== Bienvenue dans l'application de gestion des tâches ===");

        ConsoleView view = new ConsoleView();
        ConsoleController controller = new ConsoleController(view, model);

        controller.processMenu(new AuthenticationController(model.getUserRepository()));
    }

    public static void loadAppData() {
        UserRepository uRepo = UserRepository.getInstance();
        TaskRepository tRepo = TaskRepository.getInstance();

        Admin admin_yavuz = new Admin("Yavuz");
        Developer dev_mingjie = new Developer("Mingjie");
        Developer dev_aloyse = new Developer("Aloyse");

        uRepo.create(admin_yavuz);
        uRepo.create(dev_mingjie);
        uRepo.create(dev_aloyse);

        tRepo.create(new DefaultTask("Corriger bug affichage", Priority.HAUTE, admin_yavuz));
        tRepo.create(new DefaultTask("Optimiser requêtes SQL", Priority.HAUTE, dev_mingjie));
        tRepo.create(new DefaultTask("Ajouter fonctionnalité recherche", Priority.MOYENNE, dev_aloyse));
        tRepo.create(new DefaultTask("Corriger crash au démarrage", Priority.HAUTE, dev_mingjie));
        tRepo.create(new DefaultTask("Refactorisation du code", Priority.MOYENNE, dev_aloyse));
        tRepo.create(new DefaultTask("Mise à jour des dépendances", Priority.BASSE, dev_mingjie));
        tRepo.create(new DefaultTask("Amélioration de l'interface utilisateur", Priority.MOYENNE, dev_aloyse));
        tRepo.create(new DefaultTask("Tests unitaires", Priority.MOYENNE, dev_mingjie));
        tRepo.create(new DefaultTask("Documentation API", Priority.BASSE, dev_aloyse));
        tRepo.create(new DefaultTask("Configurer CI/CD", Priority.HAUTE, admin_yavuz));

    }
}
