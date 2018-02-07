package trabajo_hoja_de_vida.tests;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.accesodatos.*;

/**
 *
 * @author Mishell
 */
public class Exp_CapacitadorTest {

    public Exp_CapacitadorTest() {
    }

    @Test
    public void testGeneral() {
IExp_Capacitador ECDao = new Exp_CapacitadorImpl();

        //////////Test Insertar
        int filas = 0;
        Docente doc = new Docente(1, "060343704-7", "Andres", "Orozco", "LA PRIMAVERA", new java.util.Date(), "ao@gamil.com", "m", "0983140672");
        Experiencia exp=new Experiencia(7, doc, 2, "Riobamba", "Docente");
        Curso_Seminario curs = new Curso_Seminario(doc, 1, "Actualizacion materia", 5, "RIOBAMBA", "actualizacion de saberes");
        Exp_Capacitador expCap=new Exp_Capacitador(1, exp, curs, "todas", new Date(), new Date());
        try {
            filas = ECDao.insertar(expCap);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);

//////////////// MODIFICAR //////////////////////
//        int nfilas=0;
//        Docente doc = new Docente(1, "060343704-7", "Andres", "Orozco", "LA PRIMAVERA", new java.util.Date(), "ao@gamil.com", "m", "0983140672");
//        Experiencia exp=new Experiencia(7, doc, 2, "Riobamba", "Docente");
//        Curso_Seminario curs = new Curso_Seminario(doc, 1, "Actualizacion materia", 5, "RIOBAMBA", "actualizacion de saberes");
//        Exp_Capacitador expCap=new Exp_Capacitador(1, exp, curs, "todas", new Date(), new Date());
//        try {
//            nfilas=ECDao.modificar(curs);
//            System.out.println("Se Modifico: "+nfilas+" Filas");
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        assertTrue(nfilas>0);

//////////////// ELIMINAR //////////////////////
//        int nfilas=0;
//        Docente doc = new Docente(1, "060343704-7", "Andres", "Orozco", "LA PRIMAVERA", new java.util.Date(), "ao@gamil.com", "m", "0983140672");
//        Curso_Seminario curs = new Curso_Seminario(doc, 2, "j,asndkjb", 6, "quito", "nose");
//        try {
//            nfilas=ECDao.eliminar(curs);
//            System.out.println("Eliminacion de : "+nfilas);
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        assertTrue(nfilas>0);

//        ////////////////////////////////POR CODIGO//////////////////////////////////////////////////////////
        Exp_Capacitador eCap = new Exp_Capacitador();
        try {
            eCap = ECDao.obtener(1);
            System.out.println(eCap.getCodigo_EC()+ "    " + eCap.getExperiencia().getCodigoE()+ "    " + eCap.getCursoSeminario().getCod_CursoSeminario()+ "    " + eCap.getEntidades()+ "    " + eCap.getFecha_inicio()+ "    " + eCap.getFecha_final());
        } catch (Exception e) {
        }
        assertEquals(eCap != null, true);

        ///////////LISTADO///////////////////////
        ArrayList<Exp_Capacitador> eCapacitadores = new ArrayList<>();
        
        try { 
            eCapacitadores=ECDao.obtener();
            for (Exp_Capacitador expCapaci : eCapacitadores) {          
                System.out.println(expCapaci.getCodigo_EC()+ "    " + expCapaci.getExperiencia().getCodigoE()+ "    " + expCapaci.getCursoSeminario().getCod_CursoSeminario()+ "    " + expCapaci.getEntidades()+ "    " + expCapaci.getFecha_inicio()+ "    " + expCapaci.getFecha_final());
            }
        } catch (Exception e) {
            
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(eCapacitadores.size() > 0);
    }
}
