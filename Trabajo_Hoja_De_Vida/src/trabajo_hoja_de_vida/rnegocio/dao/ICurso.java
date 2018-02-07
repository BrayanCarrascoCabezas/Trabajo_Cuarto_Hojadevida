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
 * @author FabricioConstante
 */
public interface ICurso {
    public int insertar(Curso curso) throws Exception;
    public int modificar(Curso curso) throws Exception;
    public int eliminar(Curso curso) throws Exception;
    public Curso obtener(int codigo) throws Exception;
    public List<Curso> obtener() throws Exception;    
}