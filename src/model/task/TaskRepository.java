package model.task;

import model.IRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements IRepository<Task> {
    private static TaskRepository instance; // Instance unique de la classe
    private final List<Task> entities;

    // Constructeur privé pour empêcher l'instanciation directe
    private TaskRepository() {
        this.entities = new ArrayList<>();
    }

    // Méthode statique pour récupérer l'instance unique
    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    @Override
    public Task create(Task entity) {
        this.entities.add(entity);
        return entity; // Retourne la tâche ajoutée
    }

    @Override
    public Task getById(int id) {
        for (Task task : entities) {
            if (task.getId() == id) {
                return task; // Retourne la tâche correspondante
            }
        }
        return null; // Retourne null si aucune tâche avec cet ID n'est trouvée
    }

    @Override
    public ArrayList<Task> getAll() {
        return new ArrayList<>(entities); // Retourne une copie de la liste des tâches
    }

    @Override
    public boolean deleteById(int id) {
        return entities.removeIf(task -> task.getId() == id); // Supprime la tâche par ID
    }

    @Override
    public Task updateById(int id, Task task) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId() == id) {
                entities.set(i, task); // Remplace la tâche existante
                return task; // Retourne la tâche mise à jour
            }
        }
        return null; // Retourne null si aucune tâche avec cet ID n'est trouvée
    }
}
