package view;

import model.task.Task;

import java.util.List;

public class TaskView {
    public void showTaskList(List<Task> tasks) {
        System.out.println("\n--------------------------");
        System.out.println("\tTask List");
        System.out.println("--------------------------");
        for (Task task : tasks) {
            System.out.println("[" + task.getId() + "] " + task.getTitle());
            System.out.println("Priorité : " + task.getPriority() + "\tÉtat : " + task.getStatus() + "\tAttribué à l'utilisateur ID : " + task.getAssignedUser().getName());
            System.out.println("---------------------------------");
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}