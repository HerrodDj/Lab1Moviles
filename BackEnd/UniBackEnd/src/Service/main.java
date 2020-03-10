/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import exceptions.NoDataException;
import java.util.List;
import models.Carrera;
import models.Curso;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class main {
    public static void main(String[]args) throws InstantiationException, ClassNotFoundException, IllegalAccessException, NoDataException, Exception{
         ServiceMethodsCurso  su= ServiceMethodsCurso.obtenerInstancia();
         Curso c = new Curso("BIO123", "Botanica",4, 4,"CIEN", 1, 2022);
         if(su.eliminarCurso("BIO123")){
             System.out.println("No valio");         
         }else {
                  System.out.println("Valio");
         }

     System.out.println(su.listarTodos().toString());
    }
    
}
