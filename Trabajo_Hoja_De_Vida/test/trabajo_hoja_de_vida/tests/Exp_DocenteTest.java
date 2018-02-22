
package trabajo_hoja_de_vida.tests;

import java.util.*;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.accesodatos.*;

public class Exp_DocenteTest {

    public Exp_DocenteTest() {
    }
    @Test
    public void testGeneral() {
    IExp_Docente ECDao = new Exp_DocenteImpl();

        //////////Test Insertar
        int filas = 0;
        Docente doc = new Docente(1, "060343704-7", "Andres", "Orozco", "LA PRIMAVERA", "1880-10-08",  "m" , "ao@gamil.com", "0983140672");
        Experiencia exp=new Experiencia(1, doc, 2, "Riobamba", "Docente");
        Curso cur=new Curso(1, "Paralelo A");
        Materia mat=new Materia(1, "Matematicas");
//        Curso_Materia curma=new Curso_Materia(1, 1, 1);
//        Curso_Seminario curs = new Curso_Seminario(doc, 1, "Actualizacion materia", 5, "RIOBAMBA", "actualizacion de saberes");
//        Exp_Docente expDoc=new Exp_Docente(1, exp/*, curma*/ , "UNACH", new Date(), new Date());
        try {
//            filas = ECDao.insertar(expDoc);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);
    
    
    Exp_Docente eDoc = new Exp_Docente();
        try {
            eDoc = ECDao.obtener(1);
            System.out.println(eDoc.getCodigo_Ex_D()+ "    " + eDoc.getExperiencia().getCodigoE()+"    " /*+ eDoc.getCursomateria().getCurso_Materia()*/+"    "+eDoc.getInstitucion()+ "    " + eDoc.getFechainicio()+ "    " + eDoc.getFechafinal());
        } catch (Exception e) {
        }
        assertEquals(eDoc != null, true);

        ///////////LISTADO///////////////////////
        ArrayList<Exp_Docente> eDocentes = new ArrayList<>();
        
        try { 
            eDocentes=ECDao.obtener();
            for (Exp_Docente expDocente : eDocentes) {          
                System.out.println(expDocente.getCodigo_Ex_D()+ "    " + expDocente.getExperiencia().getCodigoE()+"    "/*+expDocente.getCursomateria().getCurso_Materia()*/+"    " + expDocente.getInstitucion()+ "    " + expDocente.getFechainicio()+ "    " + expDocente.getFechafinal());
            }
        } catch (Exception e) {
            
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(eDocentes.size() > 0);
    }
}
