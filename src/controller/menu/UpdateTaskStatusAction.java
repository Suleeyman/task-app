package controller.menu;

import model.task.Status;
import model.task.TaskRepository;
import utils.EnumInputReader;
import utils.IntInputReader;
import view.TaskView;

public class UpdateTaskStatusAction extends MenuAction {
    private final TaskRepository taskRepository;
    private final TaskView view;

    public UpdateTaskStatusAction(TaskRepository taskRepository, TaskView view) {
        this.taskRepository = taskRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        view.showTaskList(taskRepository.getAll());
        int taskId = new IntInputReader().read("ID de la tâche à mettre à jour: ", "ID invalide");
        Status newStatus = new EnumInputReader<>(Status.class).read("Nouveau statut: ", "Statut invalide");

        var task = taskRepository.getById(taskId);
        if (task != null) {
            task.setStatus(newStatus);
            view.showMessage("Statut mis à jour avec succès.");
        } else {
            view.showMessage("Tâche non trouvée.");
        }
    }
}
