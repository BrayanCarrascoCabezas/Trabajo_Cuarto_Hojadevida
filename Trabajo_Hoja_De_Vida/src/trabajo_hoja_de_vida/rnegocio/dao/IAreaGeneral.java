package trabajo_hoja_de_vida.rnegocio.dao;

import java.util.*;
//import trabajo_hoja_de_vida.rnegocio.entidades.Area;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.accesodatos.*;

/**
 *
 * @author eddyf
 */
public interface IAreaGeneral {

    public int insertar(AreaGeneral areaGeneral) throws Exception;

    public int modificar(AreaGeneral areaGeneral) throws Exception;

    public int eliminar(AreaGeneral areaGeneral) throws Exception;

    public AreaGeneral obtener(int codigo) throws Exception;

    public ArrayList<AreaGeneral> obtener() throws Exception;

}
