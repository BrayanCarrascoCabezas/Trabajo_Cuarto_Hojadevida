/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.dao;

import java.util.List;
import trabajo_hoja_de_vida.rnegocio.entidades.Idioma_Docente;

/**
 *
 * @author Usuario
 */
public interface Iidioma_Docente {

    public int insertar(Idioma_Docente idioma_docente) throws Exception;
    public int modificar(Idioma_Docente idioma_docente) throws Exception;
    public int eliminar(Idioma_Docente idioma_docente) throws Exception;
    public Idioma_Docente obtener(int codigo) throws Exception;
    public List<Idioma_Docente> obtener() throws Exception;  

    
}

