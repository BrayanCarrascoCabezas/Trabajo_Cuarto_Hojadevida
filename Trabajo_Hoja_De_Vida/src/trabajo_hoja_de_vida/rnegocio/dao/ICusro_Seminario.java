package trabajo_hoja_de_vida.rnegocio.dao;

import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;

public interface ICusro_Seminario {

    public int insertar(Curso_Seminario curso_seminario) throws Exception;

    public int modificar(Curso_Seminario curso_seminario) throws Exception;

    public int eliminar(Curso_Seminario curso_seminario) throws Exception;

    public Curso_Seminario obtener(int codigo) throws Exception;

    public List<Curso_Seminario> obtener() throws Exception;

}
