/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.dao;

import java.util.List;
import trabajo_hoja_de_vida.rnegocio.entidades.*;

/**
 *
 * @author WILCXMAC
 */
public interface IAdicional {
        public int insertar(Adicional adicional) throws Exception;
    public int modificar(Adicional adicional) throws Exception;
    public int eliminar(Adicional adicional) throws Exception;
    public Adicional obtener(int codigo) throws Exception;
    public List<Adicional> obtener() throws Exception;    
}
