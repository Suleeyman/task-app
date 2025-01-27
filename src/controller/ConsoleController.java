package controller;

import controller.menu.*;
import controller.user.AuthenticationController;
import model.IModel;
import model.task.TaskRepository;
import model.user.User;
import model.user.UserRepository;
import utils.IntInputReader;
import view.IConsoleView;
import view.TaskView;
import view.UserView;

public class ConsoleController implements IConsoleController {
    public final IConsoleView view;
    public final IModel model;


    public ConsoleController(IConsoleView view, IModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public IConsoleView getView() {
        return view;
    }

    @Override
    public IModel getModel() {
        return model;
    }

    @Override
    public void processMenu(AuthenticationController authController) {
        TaskRepository tRepo = (TaskRepository) model.getTaskRepository();
        UserRepository uRepo = (UserRepository) model.getUserRepository();
        TaskView tView = new TaskView();
        UserView uView = new UserView();
        boolean running = true;

        while (running) {
            User currentUser = authController.processLogin();

            while (currentUser != null) {
                view.afficherMenu(currentUser);

                int choice = new IntInputReader().read("> ", "Entrée incorrecte.");
                MenuActionFactory actionFactory = new MenuActionFactory();

                actionFactory.registerAction(4, new ShowTasksAction(tRepo, tView));
                actionFactory.registerAction(5, new CreateTaskAction(tRepo, uRepo, tView));
                actionFactory.registerAction(6, new UpdateTaskStatusAction(tRepo, tView));
                actionFactory.registerAction(7, new DeleteTaskAction(tRepo, tView));
                actionFactory.registerAction(8, new UpdateTaskOwnerAction(tRepo, uRepo, tView, uView));
                actionFactory.registerAction(9, new ShowUsersAction(uRepo, uView));

                MenuAction action = actionFactory.getAction(choice);

                if (action != null) {
                    action.execute();
                } else {
                    view.afficherMessage("Option invalide. Essayez à nouveau.");
                }
            }
        }
    }

//    @Override
//    public void processMenu(AuthenticationController authController) {
//        TaskRepository tRepo = (TaskRepository) model.getTaskRepository();
//        UserRepository uRepo = (UserRepository) model.getUserRepository();
//        boolean running = true;
//        User currentUser;
//
//        // Authentification de l'utilisateur
//        while (running) {
//            currentUser = authController.processLogin();
//
//            while (currentUser != null) {
//                view.afficherMenu(currentUser);
//                int choice = (new IntInputReader()).read("> ", "Entrée incorrecte.");
//
//                switch (choice) {
//                    case 1:
//                        System.out.println("Vos droits : " + currentUser.getPermissions());
//                        break;
//                    case 2:
//                        authController.processLogout(currentUser);
//                        currentUser = null;
//                        break;
//                    case 3:
//                        view.printExitMessage();
//                        currentUser = null;
//                        running = false;
//                        break;
//                    case 4: {
//                        ArrayList<Task> tasks = tRepo.getAll();
//                        System.out.println("\n--------------------------");
//                        System.out.println("\tTask List");
//                        System.out.println("--------------------------");
//                        for (Task task : tasks) {
//                            System.out.println("[" + task.getId() + "] " + task.getTitle());
//                            System.out.println("Priorité : " + task.getPriority() + "\tÉtat : " + task.getStatus() + "\tAttribué à " + task.getAssignedUser().getName());
//                            System.out.println("---------------------------------------------------------");
//                        }
//                        break;
//                    }
//                    case 5: {
//                        System.out.println("\nCréation d'une nouvelle tâche\n");
//                        String title = (new StringInputReader()).read("Titre: ", "Titre invalide");
//                        Priority priority = (new EnumInputReader<>(Priority.class)).read("Priorité ", "Priorité invalide");
//                        Status status = (new EnumInputReader<>(Status.class)).read("Statue ", "Statue invalide");
//
//
//                        System.out.println("ID de l'utilisateur à affecter : \n");
//                        for (User user : uRepo.getAll()) {
//                            System.out.println("[" + user.getId() + "] " + user.getName());
//                        }
//                        int userId = (new IntInputReader()).read("> ", "ID Invalide");
//                        Task task = new DefaultTask(title, priority, status, uRepo.getById(userId));
//                        tRepo.create(task);
//                        break;
//                    }
//                    case 6: {
//                        System.out.println("ID de la taĉhe à marquer comme terminée : \n");
//                        ArrayList<Task> tasks = tRepo.getAll();
//                        for (Task task : tasks) {
//                            System.out.println("[" + task.getId() + "] " + task.getTitle());
//                        }
//                        int taskId = (new IntInputReader()).read("> ", "ID Invalide");
//                        tRepo.getById(taskId).setStatus(Status.TERMINE);
//                        break;
//                    }
//                    case 7: {
//                        if (currentUser.isAdmin()) {
//                            int taskId = (new IntInputReader()).read("ID de la taĉhe à supprimer", "ID Invalide");
//                            tRepo.deleteById(taskId);
//                        } else {
//                            System.out.println("Option non disponible pour ce rôle.");
//                        }
//                        break;
//                    }
//                    case 8:
//                        if (currentUser.isAdmin()) {
//                            int taskId = (new IntInputReader()).read("ID de la taĉhe à affecter", "ID Invalide");
//                            String userName = (new StringInputReader()).read("Nom utilisateur: ", "Nom invalide");
//                            tRepo.getById(taskId).setAssignedUser(uRepo.getByName(userName));
//                        } else {
//                            System.out.println("Option non disponible pour ce rôle.");
//                        }
//                        break;
//                    case 9:
//                        ArrayList<User> users = uRepo.getAll();
//                        System.out.println("\n--------------------------");
//                        System.out.println("\t  Les membres");
//                        System.out.println("--------------------------");
//                        for (User user : users) {
//                            System.out.println("[" + user.getId() + "] " + user.getName() + "(" + user.getRole() + ")");
//                            System.out.println("--------------------------");
//                        }
//                        break;
//                    default:
//                        System.out.println("Option invalide. Essayez à nouveau.");
//                }
//            }
//        }
//    }
}
