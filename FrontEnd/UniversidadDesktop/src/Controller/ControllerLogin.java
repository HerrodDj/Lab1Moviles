/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewLogin;
import exceptions.GlobalException;
import models.Model;
import models.Usuario;

/**
 *
 * @author demil
 */
public class ControllerLogin {

    public ControllerLogin(ViewLogin view) throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        this.domainModel = new Model();
        this.view = view;
        this.view.setController(this);
    }

    public boolean login(Usuario logUser) throws Exception {
        //model.setCurrent(logUser);
        try {
            if (domainModel.getUser(logUser.getCedula(), logUser.getContrasenia())) {
                UniversidadDesktop.UniversidadDesktop.PRINCIPAL_CONTROLLER.enter();
                view.setVisible(false);
                return true;
            }
        } catch (GlobalException e) {
            throw new GlobalException("Error Base");
        }
        return false;
    }
    
    
    public void logout(){
        view.setVisible(true);
        view.reset();
    }

    Model domainModel;
    ViewLogin view;
    //LoginModel model;

}
