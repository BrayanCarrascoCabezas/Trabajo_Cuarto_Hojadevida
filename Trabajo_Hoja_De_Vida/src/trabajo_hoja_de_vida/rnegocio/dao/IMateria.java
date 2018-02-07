package trabajo_hoja_de_vida.rnegocio.dao;

import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;
public interface IMateria {
    public int insertar(Materia materia) throws Exception;
    public int modificar(Materia materia) throws Exception;
    public int eliminar(Materia materia) throws Exception;
    public Materia obtener(int codigo) throws Exception;
    public List<Materia> obtener() throws Exception;    
}
