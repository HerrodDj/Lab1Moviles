/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewPrincipal;

/**
 *
 * @author demil
 */
public class ControllerPrincipal {

    public ControllerPrincipal(ViewPrincipal view) {
        this.view = view;
    }
    
    public void BtnCarrera(){
        //cuando existan mas pantallas se llama al controller de cada una y se instancia el metodo hide() correspondiente 
        //application.Application.FUNCIONARIOS_CONTROLLER.hide();
        view.setVisible(false);
    }     
    
    public void BtnCursos(){
        //cuando existan mas pantallas se llama al controller de cada una y se instancia el metodo hide() correspondiente 
        //application.Application.FUNCIONARIOS_CONTROLLER.hide();
        view.setVisible(false);
    }  
    public void enter(){
        this.show();
    }
   
    public void show(){
        view.setVisible(true);
    }
    ViewPrincipal view;
}
