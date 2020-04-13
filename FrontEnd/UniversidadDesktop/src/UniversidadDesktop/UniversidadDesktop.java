/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadDesktop;

import Controller.ControllerCarreras;
import Controller.ControllerCursos;
import Controller.ControllerLogin;
import Controller.ControllerPrincipal;
import ModelView.TablaModelView;
import ModelView.TablaModelView2;
import Service.ServiceMethodsCarrera;
import View.ViewCarreras;
import View.ViewCursos;
import View.ViewLogin;
import View.ViewPrincipal;
import exceptions.GlobalException;
import java.sql.SQLException;

/**
 *
 * @author demil
 */
public class UniversidadDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws GlobalException, SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        
        Service.ServiceMethodsCarrera sc = new ServiceMethodsCarrera();
        
        ViewLogin vl = new ViewLogin();
        ControllerLogin login_controller = new ControllerLogin(vl);
        LOGIN_CONTROLLER = login_controller;
        vl.setVisible(true);
        
        ViewPrincipal vp = new ViewPrincipal();
        ControllerPrincipal principal_controller = new ControllerPrincipal(vp);
        PRINCIPAL_CONTROLLER = principal_controller;
        vp.setVisible(false);
        
        ViewCarreras vc = new ViewCarreras();
        TablaModelView tm = new TablaModelView();
        ControllerCarreras carreras_controller = new ControllerCarreras(vc,tm);
        CARRERAS_CONTROLLER = carreras_controller;
        vc.setVisible(false);
        
        
        ViewCursos vcu = new ViewCursos();
        TablaModelView2 tm2 = new TablaModelView2();
        ControllerCursos cursos_controller = new ControllerCursos(vcu,tm2);
        CURSOS_CONTROLLER = cursos_controller;
        vcu.setVisible(false);
        
    }
    public static ControllerLogin LOGIN_CONTROLLER;
    public static ControllerPrincipal PRINCIPAL_CONTROLLER;
    public static ControllerCarreras CARRERAS_CONTROLLER;
    public static ControllerCursos CURSOS_CONTROLLER;
}
