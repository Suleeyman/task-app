package controller.menu;

import model.task.*;
import model.user.UserRepository;
import utils.EnumInputReader;
import utils.IntInputReader;
import utils.StringInputReader;
import view.TaskView;

public class CreateTaskAction extends MenuAction {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskView view;

    public CreateTaskAction(TaskRepository taskRepository, UserRepository userRepository, TaskView view) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        String title = new StringInputReader().read("Titre: ", "Titre invalide");
        Priority priority = new EnumInputReader<>(Priority.class).read("Priorité: ", "Priorité invalide");
        Status status = new EnumInputReader<>(Status.class).read("Statut: ", "Statut invalide");

        int userId = new IntInputReader().read("ID de l'utilisateur à affecter: ", "ID invalide");
        Task task = new DefaultTask(title, priority, status, userRepository.getById(userId));
        taskRepository.create(task);

        view.showMessage("Tâche créée avec succès.");
    }
}
