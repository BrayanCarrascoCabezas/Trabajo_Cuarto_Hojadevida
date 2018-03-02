
package trabajo_hoja_de_vida.tests;

import java.util.*;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.accesodatos.*;

public class Exp_DirectivaTest {

    public Exp_DirectivaTest() {
    }
    @Test
    public void testGeneral() {
    IExp_Directiva ECDao = new Exp_DirectivaImpl();

        //////////Test Insertar
        int filas = 0;
        Docente doc = new Docente(1, "0604957787-7", "Edwin", "Guaman", "Agua Potable", "1995-10-08",  "m" , "ea@gamil.com", "0989890788");
        Experiencia exp=new Experiencia(1, doc, 2, "Riobamba", "Docente");
        try {
//            filas = ECDao.insertar(expDoc);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);
    
    
    Exp_Directiva eDoc = new Exp_Directiva();
        try {
            eDoc = ECDao.obtener(1);
            System.out.println(eDoc.getCodigoExp_D()+ "    " + eDoc.getExperiencia()+"    " +"    "+eDoc.getEntidades()+ "    " + eDoc.getFecha_Inicio()+ "    " + eDoc.getFecha_Final());
        } catch (Exception e) {
        }
        assertEquals(eDoc != null, true);

        ///////////LISTADO///////////////////////
        ArrayList<Exp_Directiva> eDocentes = new ArrayList<>();
        
        try { 
            eDocentes=ECDao.obtener();
            for (Exp_Directiva expDocente : eDocentes) {          
                System.out.println(expDocente.getCodigoExp_D()+ "    " + expDocente.getExperiencia()+"    "+"    " + expDocente.getEmpresa_Institucion()+ "    "+"    " + expDocente.getEntidades()+ "    " + expDocente.getFecha_Inicio()+ "    " + expDocente.getFecha_Final());
            }
        } catch (Exception e) {
            
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(eDocentes.size() > 0);
    }
}
