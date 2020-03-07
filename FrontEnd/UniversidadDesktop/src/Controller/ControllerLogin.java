/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewLogin;
import models.Model;
import models.Usuario;

/**
 *
 * @author demil
 */
public class ControllerLogin {

    public ControllerLogin(ViewLogin view) {
        this.domainModel = new Model();
        this.view = view;
        view.setController(this);
    }

    public void login(Usuario logUser) throws Exception {
        //model.setCurrent(logUser);
        Usuario real = domainModel.getUser(logUser.getCedula(), logUser.getContrasenia());
        view.setVisible(false);
        //application.Application.APPLICATION_CONTROLLER.enter();
    }

    Model domainModel;    
    ViewLogin view;
    //LoginModel model;
    
}
