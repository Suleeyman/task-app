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

/**
 * Implémentation du console contrôleur
 */
public class ConsoleController implements IConsoleController {
    public final IConsoleView view;
    public final IModel model;


    public ConsoleController(IConsoleView view, IModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * @return IConsoleView
     */
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
                if (choice == 2) {
                    currentUser = null;
                }
                if (choice == 3) {
                    currentUser = null;
                    running = false;
                }

                MenuActionFactory actionFactory = new MenuActionFactory();

                actionFactory.registerAction(1, new ShowPermissionsAction(new UserView(), currentUser));
                actionFactory.registerAction(4, new ShowTasksAction(tRepo, tView));
                actionFactory.registerAction(5, new CreateTaskAction(tRepo, uRepo, tView));
                actionFactory.registerAction(6, new UpdateTaskStatusAction(tRepo, tView));
                actionFactory.registerAction(7, new DeleteTaskAction(tRepo, tView));
                actionFactory.registerAction(8, new UpdateTaskOwnerAction(tRepo, uRepo, tView, uView));
                actionFactory.registerAction(9, new ShowUsersAction(uRepo, uView));

                MenuAction action = actionFactory.getAction(choice);

                if (action != null) {
                    action.execute();
                }
            }
        }
    }
}
