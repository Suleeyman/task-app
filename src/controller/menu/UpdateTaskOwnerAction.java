package controller.menu;

import model.task.TaskRepository;
import model.user.UserRepository;
import utils.IntInputReader;
import utils.StringInputReader;
import view.TaskView;
import view.UserView;

public class UpdateTaskOwnerAction extends MenuAction {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskView taskView;
    private final UserView userView;

    public UpdateTaskOwnerAction(TaskRepository taskRepository, UserRepository userRepository, TaskView taskView, UserView userView) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskView = taskView;
        this.userView = userView;
    }

    @Override
    public void execute() {
        taskView.showTaskList(taskRepository.getAll());
        int taskId = new IntInputReader().read("ID de la tâche à mettre à jour: ", "ID invalide");

        var task = taskRepository.getById(taskId);
        if (task != null) {
            userView.showUserLists(userRepository.getAll());
            String userName = new StringInputReader().read("Nom de l'utilisateur à assigner: ", "Nom invalide");

            var user = userRepository.getByName(userName);
            if (user != null) {
                task.setAssignedUser(user);
                System.out.println("Utilisateur assigné avec succès.");
            } else {
                System.out.println("Utilisateur non trouvé.");
            }
        } else {
            System.out.println("Tâche non trouvée.");
        }
    }
}
