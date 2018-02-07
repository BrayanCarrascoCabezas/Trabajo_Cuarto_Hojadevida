package trabajo_hoja_de_vida.tests;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import trabajo_hoja_de_vida.rnegocio.dao.IAreaGeneral;
import trabajo_hoja_de_vida.rnegocio.entidades.AreaGeneral;
import trabajo_hoja_de_vida.rnegocio.entidades.Idioma;
import trabajo_hoja_de_vida.rnegocio.impl.AreaImpl;


public class AreaTest {
     public AreaTest() {
    }
    @Test
    public void testGeneral(){
        int filas=0;
        IAreaGeneral iareaDao=new AreaImpl();
        
       AreaGeneral area =new AreaGeneral(1, "primera descripcion");
       
       
        try {
            filas=iareaDao.insertar(area);
           System.out.println("Ingreso de " + filas + " Filas Correctas");
       } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filas>0, true);

        List<AreaGeneral> lista=new ArrayList<>();
        try {
            lista = iareaDao.obtener();
            for(AreaGeneral es:lista){
                System.out.println(es.getCodigo()+" "+es.getdescripcion());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
        }
        assertTrue(lista.size()>0);
    } 
}