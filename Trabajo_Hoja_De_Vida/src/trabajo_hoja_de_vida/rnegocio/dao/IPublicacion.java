/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.dao;

import java.util.List;
import trabajo_hoja_de_vida.rnegocio.entidades.Publicacion;

public interface IPublicacion {
    public int insertar(Publicacion publicacion) throws Exception;
    public int modificar(Publicacion publicacion) throws Exception;
    public int eliminar(Publicacion publicacion) throws Exception;
    public Publicacion obtener(int codigo) throws Exception;
    public List<Publicacion> obtener() throws Exception;
}
