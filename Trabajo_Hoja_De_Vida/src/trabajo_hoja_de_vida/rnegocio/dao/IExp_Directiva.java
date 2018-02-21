package trabajo_hoja_de_vida.rnegocio.dao;


import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;
public interface IExp_Directiva {
    public int insertar(Exp_Directiva expdirectiva) throws Exception;

    public int modificar(Exp_Directiva expdirectiva) throws Exception;

    public int eliminar(Exp_Directiva expdirectiva) throws Exception;

    public Exp_Directiva obtener(int CodigoExp_D) throws Exception;

    public List<Exp_Directiva> obtener() throws Exception;
    
}