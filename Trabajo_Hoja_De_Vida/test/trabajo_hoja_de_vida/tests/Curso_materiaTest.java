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
import trabajo_hoja_de_vida.rnegocio.dao.ICursoMateria;
import trabajo_hoja_de_vida.rnegocio.entidades.Curso_Materia;
import trabajo_hoja_de_vida.rnegocio.impl.Curso_MateriaImpl;

/**
 *
 * @author Usuario
 */
public class Curso_materiaTest {
     public Curso_materiaTest() {
    }
    @Test
    public void testGeneral(){
        int filas=0;
        ICursoMateria cursomDao=new Curso_MateriaImpl();
        
       
       
       
        try {
            filas=cursomDao.insertar(cursomDao.obtener(filas));
           System.out.println("Ingreso de " + filas + " Filas Correctas");
       } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filas>0, true);

        List<Curso_Materia> lista=new ArrayList<>();
        try {
            lista = cursomDao.obtener();
            for(Curso_Materia es:lista){
                System.out.println(es.getCurso_Materia()+" "+es.getCodigoC()+" "+es.getCodigoM());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
        }
        assertTrue(lista.size()>0);
    } 
}
