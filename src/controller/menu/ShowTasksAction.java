package controller.menu;

import model.task.TaskRepository;
import view.TaskView;

public class ShowTasksAction extends MenuAction {
    private final TaskRepository taskRepository;
    private final TaskView view;

    public ShowTasksAction(TaskRepository taskRepository, TaskView view) {
        this.taskRepository = taskRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        view.showTaskList(taskRepository.getAll());
    }
}
