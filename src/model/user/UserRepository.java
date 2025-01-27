package model.user;

import model.IRepository;

import java.util.ArrayList;

public class UserRepository implements IRepository<User> {
    private static UserRepository instance;  // Instance unique du repository
    private ArrayList<User> entities;

    // Le constructeur privé pour empêcher la création de nouvelles instances
    private UserRepository() {
        this.entities = new ArrayList<>();
    }

    // Méthode statique pour accéder à l'instance unique
    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    @Override
    public User create(User entity) {
        this.entities.add(entity);
        return entity;
    }

    @Override
    public User getById(int id) {
        for (User user : entities) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getByName(String name) {
        for (User user : entities) {
            if (user.getName() == name) {
                return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return new ArrayList<>(entities); // Retourne une copie de la liste des entités
    }

    @Override
    public boolean deleteById(int id) {
        return entities.removeIf(entity -> entity.getId() == id); // Supprime les entités correspondant à l'ID
    }

    @Override
    public User updateById(int id, User user) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId() == id) {
                entities.set(i, user); // Remplace l'entité existante
                return user; // Retourne l'entité mise à jour
            }
        }
        return null; // Retourne null si aucune entité avec cet ID n'est trouvée
    }
}
