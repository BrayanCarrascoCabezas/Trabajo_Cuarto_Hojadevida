
package trabajo_hoja_de_vida.rnegocio.dao;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;
public interface ITitulo_Posgrado {
      public int insertar(Titulo_Posgrado titulo_prosgrado) throws Exception;
    public int modificar(Titulo_Posgrado titulo_prosgado) throws Exception;
    public int eliminar(Titulo_Posgrado titulo_prosgado) throws Exception;
    public Titulo_Posgrado obtener(int codigo) throws Exception;
    public List<Titulo_Posgrado> obtener() throws Exception;
}
