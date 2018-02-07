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
import trabajo_hoja_de_vida.rnegocio.dao.IIdioma;
import trabajo_hoja_de_vida.rnegocio.entidades.Idioma;
import trabajo_hoja_de_vida.rnegocio.impl.IdiomaImpl;

/**
 *
 * @author SYSTEMarket-pc
 */
public class IdiomaTest {
     public IdiomaTest() {
    }
    @Test
    public void testGeneral(){
        int filas=0;
        IIdioma idiomaDao=new IdiomaImpl();
        
       Idioma idioma =new Idioma(1, "Frances");
        try {
            filas=idiomaDao.insertar(idioma);
           System.out.println("Ingreso de " + filas + " Filas Correctas");
       } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filas>0, true);

        List<Idioma> lista=new ArrayList<>();
        try {
            lista = idiomaDao.obtener();
            for(Idioma es:lista){
                System.out.println(es.getCodigo()+" "+es.getDescripcion());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(lista.size()>0);
    } 
}