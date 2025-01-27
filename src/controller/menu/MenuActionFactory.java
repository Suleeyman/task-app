package controller.menu;

import java.util.HashMap;
import java.util.Map;

public class MenuActionFactory {
    private final Map<Integer, MenuAction> actions = new HashMap<>();

    public void registerAction(int option, MenuAction action) {
        actions.put(option, action);
    }

    public MenuAction getAction(int option) {
        return actions.get(option);
    }
}
