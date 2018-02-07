
package trabajo_hoja_de_vida.rnegocio.dao;

/**
 *
 * @author Mishell
 */
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;
public interface IExp_Capacitador {
    public int insertar(Exp_Capacitador expCapacitador) throws Exception;

    public int modificar(Exp_Capacitador expCapacitador) throws Exception;

    public int eliminar(Exp_Capacitador expCapacitador) throws Exception;

    public Exp_Capacitador obtener(int codigo) throws Exception;

    public ArrayList<Exp_Capacitador> obtener() throws Exception;
    
}
