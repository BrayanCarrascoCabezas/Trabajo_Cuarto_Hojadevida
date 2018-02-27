package trabajo_hoja_de_vida.tests;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import trabajo_hoja_de_vida.rnegocio.dao.IExp_Directiva;
import trabajo_hoja_de_vida.rnegocio.entidades.Exp_Directiva;
import trabajo_hoja_de_vida.rnegocio.impl.Exp_DirectivaImpl;
import trabajo_hoja_de_vida.accesodatos.*;

public class Exp_DirectivaTest {
     public Exp_DirectivaTest() {
    }
    @Test
    public void testGeneral(){
        int filas=0;
        IExp_Directiva expdirectivaDao=new Exp_DirectivaImpl();
        
       Exp_Directiva expdirectiva = new Exp_Directiva(7,3,"UNACH","PHD",(8/2/2018),(3/4/2019));
        try {
            filas=expdirectivaDao.insertar(expdirectiva);
           System.out.println("Ingreso de " + filas + " Filas Correctas");
       } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filas>0, true);

        List<Exp_Directiva> lista=new ArrayList<>();
        try {
            lista = expdirectivaDao.obtener();
            for(Exp_Directiva ec:lista){
                System.out.println(ec.getCodigoExp_D()+" "+ec.getCodigoE()+" "+ec.getEmpresa_Institucion()+" "+ec.getEntidades()+" "+ec.getFecha_Inicio()+" "+ec.getFecha_Final());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
        }
        assertTrue(lista.size()>0);
    } 
}
    


