/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.dao;

import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;
public interface IResumen {
          public int insertar(Resumen resumen) throws Exception;
    public int modificar(Resumen resumen) throws Exception;
    public int eliminar(Resumen resumen) throws Exception;
    public Resumen obtener(int cod_docente) throws Exception;
    public List<Resumen> obtener() throws Exception;
    
    
    
}
