/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.dao;

import java.util.List;
import trabajo_hoja_de_vida.rnegocio.entidades.Area_docente;

/**
 *
 * @author Segovia
 */
public interface IArea_docente {
     public int insertar(Area_docente area_docente) throws Exception;
    public int modificar(Area_docente area_docente) throws Exception;
    public int eliminar(Area_docente area_docente) throws Exception;
    public Area_docente obtener(int Codigo) throws Exception;
    public List<Area_docente> obtener() throws Exception;  
}
