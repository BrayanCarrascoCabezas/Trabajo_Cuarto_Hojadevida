/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.dao;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;
/**
 *
 * @author Davidssito Campos
 */
public interface ITitulo_Pregado {
    public int insertar(Titulo_Pregado titulo_pregado) throws Exception;
    public int modificar(Titulo_Pregado titulo_pregado) throws Exception;
    public int eliminar(Titulo_Pregado titulo_pregado) throws Exception;
    public Titulo_Pregado obtener(int codTituloPre) throws Exception;
    public ArrayList<Titulo_Pregado> obtener() throws Exception; 
    
}
