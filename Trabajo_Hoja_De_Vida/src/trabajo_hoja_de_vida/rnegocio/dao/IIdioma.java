/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.dao;

import java.util.List;
import trabajo_hoja_de_vida.rnegocio.entidades.Idioma;

/**
 *
 * @author SYSTEMarket-pc
 */
public interface IIdioma {
    public int insertar(Idioma idioma) throws Exception;
    public int modificar(Idioma idioma) throws Exception;
    public int eliminar(Idioma idioma) throws Exception;
    public Idioma obtener(int codigo) throws Exception;
    public List<Idioma> obtener() throws Exception;
}
