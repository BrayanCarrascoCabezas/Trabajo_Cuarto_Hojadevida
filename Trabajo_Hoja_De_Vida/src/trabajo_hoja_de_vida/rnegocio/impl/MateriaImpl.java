
package trabajo_hoja_de_vida.rnegocio.impl;

/**
 *
 * @author JOSEPH
 */
import com.sun.javafx.scene.control.skin.VirtualFlow;
import trabajo_hoja_de_vida.accesodatos.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MateriaImpl implements IMateria {

    @Override
    public int insertar(Materia materia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into materia (nombre) values (?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, materia.getNombre()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Materia materia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  materia set descripcion=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, materia.getNombre()));
        lstPar.add(new Parametro(2, materia.getCodigo()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Materia materia) throws Exception {
        int numFilasAfectadas = 0;
        return numFilasAfectadas;
    }

    @Override
    public Materia obtener(int codigo) throws Exception {
        Materia materia = null;
         String sql = "select codigo, nombre from materia where codigo=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                materia= new Materia();
                materia.setCodigo(rst.getInt(1));
                materia.setNombre(rst.getString(2));            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return materia;
    }

    @Override
    public List<Materia> obtener() throws Exception {
        List<Materia> lista = new ArrayList<>();
         String sql = "select codigo, nombre from materia";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Materia materia= null;
            while(rst.next()){
                materia= new Materia();
                materia.setCodigo(rst.getInt(1));
                materia.setNombre(rst.getString(2));
                lista.add(materia);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
