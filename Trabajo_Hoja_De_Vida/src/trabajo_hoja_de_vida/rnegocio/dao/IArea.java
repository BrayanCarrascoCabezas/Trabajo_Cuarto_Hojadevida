package trabajo_hoja_de_vida.rnegocio.dao;

import java.awt.geom.Area;
import java.util.List;
//import trabajo_hoja_de_vida.rnegocio.entidades.Area;
import trabajo_hoja_de_vida.rnegocio.entidades.Titulo_Pregado;

/**
 *
 * @author eddyf
 */
public interface IArea {
    public int insertar(Area area) throws Exception;
    
    public int modificar(Area area) throws Exception;
    public int eliminar(Area area) throws Exception;
    public Area obtener(int codigo) throws Exception;
    public List<Area> obtener() throws Exception; 

    public int insertar(trabajo_hoja_de_vida.rnegocio.entidades.Area area);
}
