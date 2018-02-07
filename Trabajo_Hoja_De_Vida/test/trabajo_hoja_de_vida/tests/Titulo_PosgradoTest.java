/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.tests;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.accesodatos.*;
public class Titulo_PosgradoTest {

    public Titulo_PosgradoTest() {
    }
    @Test
    public void testGeneral() {
ITitulo_Posgrado TPOsDao = new Titulo_PosgradoImpl();
     //////////Test Insertar
        int filas = 0;
        Docente doc = new Docente(1, "060343704-7", "Andres", "Orozco", "LA PRIMAVERA", new java.util.Date(), "ao@gamil.com", "m", "0983140672");
        Titulo_Posgrado tpos=new Titulo_Posgrado(1,doc,"Ecuador","Master seguridad informatica","PUCE");
        
        try {
            filas = TPOsDao.insertar(tpos);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);
    }
    //////////////// MODIFICAR //////////////////////
//        int nfilas=0;
//        Docente doc = new Docente(1, "060343704-7", "Andres", "Orozco", "LA PRIMAVERA", new java.util.Date(), "ao@gamil.com", "m", "0983140672");
//         Titulo_Posgrado tpos=new Titulo_Posgrado(1,doc,"Ecuador","Master seguridad informatica","PUCE");
//        try {
//            nfilas=TPOsDao.modificar(tpos);
//            System.out.println("Se Modifico: "+nfilas+" Filas");
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        assertTrue(nfilas>0);
    //////////////// ELIMINAR //////////////////////
//        int nfilas=0;
//        Docente doc = new Docente(1, "060343704-7", "Andres", "Orozco", "LA PRIMAVERA", new java.util.Date(), "ao@gamil.com", "m", "0983140672");
//        Titulo_Posgrado tpos=new Titulo_Posgrado(1,doc,"Ecuador","Master seguridad informatica","PUCE");
//        try {
//            nfilas=TPOsDao.eliminar(tpos);
//            System.out.println("Eliminacion de : "+nfilas);
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        assertTrue(nfilas>0);
//        ////////////////////////////////POR CODIGO//////////////////////////////////////////////////////////
//        Titulo_Posgrado tPos = new Titulo_Posgrado();
//        try {
//            tPos = TPOsDao.obtener(1);
//            System.out.println(tPos.getCodTitulo_posgrado()+ "    " + tPos.getDocente().getCod_docente()+ "    " + tPos.getPais()+ "    " + tPos.getTitulo_posgrado()+ "    " + tPos.getUniversidad()+ "    " );
//        } catch (Exception e) {
//        }
//        assertEquals(tPos != null, true);
        ///////////LISTADO///////////////////////
//        ArrayList<Titulo_Posgrado> tposgrado = new ArrayList<>();
//        
//        try { 
//            tposgrado=TPosDao.obtener();
//            for (Titulo_Posgrado tituposgra : tposgrado) {          
//                System.out.println(tituposgra.getCodTitulo_posgrado()+ "    " + tituposgra.getDocente().getCod_docente()+ "    " + tituposgra.getPais()+ "    " + tituposgra.getTitulo_posgrado()+ "    " +tituposgra.getUniversidad()+ "    " );
//            }
//        } catch (Exception e) {
//            
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertTrue(tposgrado.size() > 0);
    }



