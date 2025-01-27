package controller;

import controller.user.AuthenticationController;
import model.IModel;
import view.IConsoleView;

public interface IConsoleController {

    IConsoleView getView();

    IModel getModel();

    void processMenu(AuthenticationController authController);
}
