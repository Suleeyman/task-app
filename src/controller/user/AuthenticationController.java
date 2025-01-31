package controller.user;

import model.user.User;
import model.user.UserRepository;
import utils.IntInputReader;
import view.AuthView;

import java.util.ArrayList;

public class AuthenticationController {

    //    private User user;
    private final UserRepository userRepository;
    private final AuthView authView;

    //
    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.authView = new AuthView();
    }

    public User processLogin() {
        ArrayList<User> users = userRepository.getAll();
        int quit = users.size() + 1;
        authView.loginMessage();
        authView.printUsers(users);
        authView.printExit(quit);

        User currentUser = null;

        while (currentUser == null) { // Répéter jusqu'à ce qu'un utilisateur valide soit trouvé
            int id = (new IntInputReader()).read("> ", "Entrée incorrecte.");

            currentUser = userRepository.getById(id);

            if (currentUser == null && id == quit) {
                System.out.println("Aurevoir");
                System.exit(1);
            }

            if (currentUser == null) {
                System.out.println("Identifiant incorrecte, réessayez.");
            }
        }

        authView.welcomeMessage(currentUser);

        return currentUser; // Retourner l'utilisateur trouvé
    }

    public void processLogout(User currentUser) {
        authView.logoutMessage(currentUser);
        currentUser = null;
    }

}
