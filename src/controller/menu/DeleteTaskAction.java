package controller.menu;

import model.task.TaskRepository;
import utils.IntInputReader;
import view.TaskView;

public class DeleteTaskAction extends MenuAction {
    private final TaskRepository taskRepository;
    private final TaskView view;

    public DeleteTaskAction(TaskRepository taskRepository, TaskView view) {
        this.taskRepository = taskRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        view.showTaskList(taskRepository.getAll());
        int taskId = new IntInputReader().read("ID de la tâche à supprimer: ", "ID invalide");

        if (taskRepository.deleteById(taskId)) {
            view.showMessage("Tâche supprimée avec succès.");
        } else {
            view.showMessage("Tâche non trouvée.");
        }
    }
}
