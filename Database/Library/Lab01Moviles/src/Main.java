
import Service.ServiceMethodsCarrera;
import Service.ServiceMethodsCurso;
import exceptions.NoDataException;
import java.sql.SQLException;
import models.Carrera;
import models.Curso;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author djenanehernandezrodriguez
 */
public class Main {

    public static void main(String[] args) throws NoDataException, Exception {
        System.out.print("Hola");
        // ServiceMethodsCarrera nS = new ServiceMethodsCarrera();
        //Carrera car = new Carrera("EIF1","Informatica2","Bachillerato");
        ServiceMethodsCurso sm = new ServiceMethodsCurso();
       // Curso cur = new Curso("LIX1066", "Ingenieria1", 5, 5, "INFO", 1, 2021);
        //System.out.println(cur.toString());
       // try {
          //  System.out.println(sm.eliminarCurso("LIX1066"));
            //  Boolean s=nS.eliminarCarrera(car.getCodigo());
            // System.out.print(s.booleanValue());
            //  System.out.println(sm.BuscarCursoPorCodigo("ING556").toString());
            
       // } catch (SQLException c) {
         //   System.out.printf("No funco");
        //}
        
        System.out.println(sm.listarCursosPorCarrera("LIX").toString());
        
    }
}
