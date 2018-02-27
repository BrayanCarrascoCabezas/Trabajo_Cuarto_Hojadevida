/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.tests;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import trabajo_hoja_de_vida.rnegocio.dao.IExp_Directiva;
import trabajo_hoja_de_vida.rnegocio.entidades.Exp_Directiva;
import trabajo_hoja_de_vida.rnegocio.impl.Exp_DirectivaImpl;

/**
 *
 * @author Usuario
 */
public class Exp_DirectivaTest {
    public Exp_DirectivaTest(){
    
    }
    @Test
    public void testGeneral(){
        int filas=0;
        IExp_Directiva expdirectivaDao=new Exp_DirectivaImpl();
        
       Exp_Directiva expdirectiva =new Exp_Directiva(1,3,"UNACH","PHD",(8/2/2018),(3/4/2019));
        try {
            filas=expdirectivaDao.insertar(expdirectiva);
           System.out.println("Ingreso de " + filas + " Filas Correctas");
       } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filas>0, true);
        
            Exp_Directiva expD = new Exp_Directiva();
        try {
            expD  = expdirectivaDao.obtener(1);
            System.out.println(expD.getCodigoExp_D()+" "+expD.getCodigoE()+" "+expD.getEmpresa_Institucion()+" "+expD.getEntidades()+" "+expD.getFecha_Inicio()+" "+expD.getFecha_Final());
        } catch (Exception e) {
        }
        assertEquals(expD != null, true);

        List<Exp_Directiva> lista=new ArrayList<>();
        try {
            lista = expdirectivaDao.obtener();
            for(Exp_Directiva es:lista){
                System.out.println(es.getCodigoExp_D()+" "+es.getCodigoE()+" "+es.getEmpresa_Institucion()+" "+es.getEntidades()+" "+es.getFecha_Inicio()+" "+es.getFecha_Final());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(lista.size()>0);
    } 
}
