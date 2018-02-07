
package trabajo_hoja_de_vida.rnegocio.dao;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;


public interface IExp_Docente {
    public int insertar (Exp_Docente exp_docente) throws Exception;
    public int modificar (Exp_Docente exp_docente) throws Exception;
    public int eliminar (Exp_Docente exp_docente) throws Exception;
    public Exp_Docente obtener(int codigo) throws Exception;
    public ArrayList<Exp_Docente> obtener () throws Exception;
}
