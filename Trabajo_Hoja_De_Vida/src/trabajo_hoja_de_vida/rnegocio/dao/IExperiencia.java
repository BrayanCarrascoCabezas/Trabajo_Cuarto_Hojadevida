/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.dao;

import java.util.List;
import trabajo_hoja_de_vida.rnegocio.entidades.Experiencia;

/**
 *
 * @author CRISTIAN
 */
public interface IExperiencia {
     public int insertar(Experiencia experiencia) throws Exception;
    public int modificar(Experiencia experiencia) throws Exception;
    public int eliminar(Experiencia experiencia) throws Exception;
    public Experiencia obtener(int codigoE) throws Exception;
    public List<Experiencia> obtener() throws Exception; 
}
