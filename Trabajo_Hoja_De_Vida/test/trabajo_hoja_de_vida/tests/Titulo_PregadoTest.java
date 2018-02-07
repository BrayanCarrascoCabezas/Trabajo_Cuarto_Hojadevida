
package trabajo_hoja_de_vida.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import trabajo_hoja_de_vida.accesodatos.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;

public class Titulo_PregadoTest {
    
    public Titulo_PregadoTest() {
    }
    
    @Test
    public void pruebageneral() throws Exception{
        ITitulo_Pregado recDao=new Titulo_PregadoImpl();
       
//TEST INSERTAR
//TEST INSERTAR
////
//        int filas = 0;
//        Docente doc=new Docente(1, "1234567890", "david", "campos","la conda","1991-01-01","gggg@","m","098793558");
//        Titulo_Pregado nTP=new Titulo_Pregado(10,doc , "españa", "PHD ","CATOLICA");
//        try {
//            filas = recDao.insertar(nTP);
//            System.out.println("filas Insertadas:" + filas);
//        } catch (Exception e) {
//        }
//        assertTrue(filas > 0);
//        
       
//TEST OBTENER POR CODIGO

//       Titulo_Pregado tp = new Titulo_Pregado();
//        try {
//            tp = recDao.obtener(1);
//            System.out.println(tp.getCodTituloPre() + "\t\t" + tp.getDocente().getCod_docente() + "\t\t" + tp.getPais() + "\t\t" + tp.getTitulo_pregado() + "\t\t" +tp.getUniversidad()+ "\n\n");
//        } catch (Exception e) {
//        }
//        assertEquals(tp != null, true);
        
//TEST LISTADO
//
//        ArrayList<Titulo_Pregado> titulos = new ArrayList<>();
//        try {
//            titulos = recDao.obtener();
//            for (Titulo_Pregado nT : titulos) {
//                System.out.println(nT.getCodTituloPre() + "\t\t" + nT.getDocente().getCod_docente() + "\t\t" + nT.getPais() + "\t\t" + nT.getTitulo_pregado() + "\t\t" +nT.getUniversidad()+ "\n\n");
//            }
//        } catch (Exception e) {
//        }
//        assertTrue(titulos.size() > 0);



        /////////////// MODIFICAR //////////////////////
        int nfilas=0;
        Docente doc = new Docente(1, "0603437047", "Andres", "Orozco", "LA PRIMAVERA", "2017-01-02", "ao@gamil.com", "m", "0983140672");
        Titulo_Pregado curs = new Titulo_Pregado(1, doc, "rio", "DR", "UNACH");
        try {
            nfilas=recDao.modificar(curs);
            System.out.println("Se Modifico: "+nfilas+" Filas");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        assertTrue(nfilas>0);

//////////////// ELIMINAR //////////////////////
//        int nfilas=0;
//        Docente doc = new Docente(1, "0603437047", "Andres", "Orozco", "LA PRIMAVERA", "2017-01-02", "ao@gamil.com", "m", "0983140672");
//        Titulo_Pregado curs = new Titulo_Pregado(10, doc, "j,quito", "phd", "central");
//        try {
//            nfilas=recDao.eliminar(curs);
//            System.out.println("Eliminacion de : "+nfilas);
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
//        assertTrue(nfilas>0);
    }

}
