package view.user;

import java.util.Map;

public class DeveloperView implements UserView {

    @Override
    public void printMenu(Map<Integer, String> actions) {
        System.out.println("=============================");
        System.out.println("       Menu Développeur      ");
        System.out.println("=============================");

        // Afficher les options du menu
        for (Map.Entry<Integer, String> entry : actions.entrySet()) {
            System.out.println("[" + entry.getKey() + "] - " + entry.getValue());
        }

        System.out.println("=============================");
    }
}