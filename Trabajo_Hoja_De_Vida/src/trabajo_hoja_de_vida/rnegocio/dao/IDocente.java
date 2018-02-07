/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.dao;

import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;
public interface IDocente {
    public int insertar(Docente docente) throws Exception;
    public int modificar(Docente docente) throws Exception;
    public int eliminar(Docente docente) throws Exception;
    public Docente obtener(int cod_docente) throws Exception;
    public List<Docente> obtener() throws Exception;    
}
