package trabajo_hoja_de_vida.rnegocio.dao;

import java.util.List;
import trabajo_hoja_de_vida.rnegocio.entidades.Declaracion;

/**
 *
 * @author Segovia
 */
public interface IDeclaracion {
     public int insertar(Declaracion declaracion) throws Exception;
    public int modificar(Declaracion declaracion) throws Exception;
    public int eliminar(Declaracion declaracion) throws Exception;
    public Declaracion obtener(int Codigo_docente) throws Exception;
    public List<Declaracion> obtener() throws Exception;  
}
