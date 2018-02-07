
package trabajo_hoja_de_vida.rnegocio.dao;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;
public interface IExp_Profecional {
    public int insertar(Exp_Profecional exp_profecional) throws Exception;
    public int modificar(Exp_Profecional exp_profecional) throws Exception;
    public int eliminar(Exp_Profecional exp_profecional) throws Exception;
    public Exp_Profecional  obtener(int Codigo_Ex_P) throws Exception;
    public List<Exp_Profecional> obtener() throws Exception; 
    
}
