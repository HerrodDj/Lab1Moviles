/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadDesktop;

import Controller.ControllerLogin;
import View.ViewCarreras;
import View.ViewLogin;

/**
 *
 * @author demil
 */
public class UniversidadDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewLogin vl = new ViewLogin();
        ControllerLogin login_controller = new ControllerLogin(vl);
        LOGIN_CONTROLLER = login_controller;
        vl.setVisible(true);
    }
    public static ControllerLogin LOGIN_CONTROLLER;
}
