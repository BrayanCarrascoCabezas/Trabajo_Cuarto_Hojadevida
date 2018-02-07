package trabajo_hoja_de_vida.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import trabajo_hoja_de_vida.accesodatos.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
//////import trabajo_hoja_de_vida.rnegocio.impl.*;
import java.util.*;
import java.sql.*;
import trabajo_hoja_de_vida.rnegocio.impl.Curso_SeminarioImpl;

public class Curso_SeminarioTest {

    public Curso_SeminarioTest() {

    }

    @Test

    public void TestGeneral() {
        ICusro_Seminario curDao = new Curso_SeminarioImpl();

        //////////Test Insertar
        int filas = 0;
        Docente doc = new Docente(1, "060343704-7", "Andres", "Orozco", "LA PRIMAVERA", new java.util.Date(), "ao@gamil.com", "m", "0983140672");
        Curso_Seminario curs = new Curso_Seminario(doc, 1, "Actualizacion materia", 5, "RIOBAMBA", "actualizacion de saberes");

        try {
            filas = curDao.insertar(curs);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);

//////////////// MODIFICAR //////////////////////
//        int nfilas=0;
//        Docente doc = new Docente(1, "060343704-7", "Andres", "Orozco", "LA PRIMAVERA", new java.util.Date(), "ao@gamil.com", "m", "0983140672");
//        Curso_Seminario curs = new Curso_Seminario(doc, 2, "jINTELIGENCIA ARTIFICIAL", 15, "AMBATO", "ACTUALIZACION DE CONOCIMINETOS");
//        try {
//            nfilas=curDao.modificar(curs);
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
//            nfilas=curDao.eliminar(curs);
//            System.out.println("Eliminacion de : "+nfilas);
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        assertTrue(nfilas>0);

//        ////////////////////////////////POR CODIGO//////////////////////////////////////////////////////////
        Curso_Seminario nCUR = new Curso_Seminario();
        try {
            nCUR = curDao.obtener(1);
            System.out.println(nCUR.getDocente().getCod_docente() + "    " + nCUR.getCod_CursoSeminario() + "    " + nCUR.getNombreCS() + "    " + nCUR.getHoras() + "    " + nCUR.getUbicacion() + "    " + nCUR.getDescripcion());
        } catch (Exception e) {
        }
        assertEquals(nCUR != null, true);

        ///////////LISTADO///////////////////////
        ArrayList<Curso_Seminario> cursose = new ArrayList<>();
        
        try { 
            cursose = curDao.obtener();
            for (Curso_Seminario cursoser : cursose) {          
                System.out.println(cursoser.getDocente().getCod_docente() + "    " + cursoser.getCod_CursoSeminario() + "    " + cursoser.getNombreCS() + "    " + cursoser.getHoras() + "    " + cursoser.getUbicacion() + "    " + cursoser.getDescripcion());
            }
        } catch (Exception e) {
            
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(cursose.size() > 0);

    }

}
