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
 * @author Usuario
 */
public interface ICursoMateria {
    public int insertar(Curso_Materia cursomateria) throws Exception;
    public int modificar(Curso_Materia curso) throws Exception;
    public int eliminar(Curso_Materia curso) throws Exception;
    public Curso_Materia obtener(int Curso_Materia) throws Exception;
    public List<Curso_Materia> obtener() throws Exception;   
}
