
package trabajo_hoja_de_vida.rnegocio.impl;

/**
 *
 * @author Mishell
 */
import java.sql.*;
import java.util.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.accesodatos.*;
public class Exp_CapacitadorImpl implements IExp_Capacitador{

    @Override
    public int insertar(Exp_Capacitador expCapacitador) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "Insert Into Exp_Capacitador (codigo_EC, codigoE, cod_CursoSeminario, Entidades, fecha_inicio, fecha_final) Values (?,?,?,?,?,?)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, expCapacitador.getCodigo_EC()));
        listParametro.add(new Parametro(2, expCapacitador.getExperiencia().getCodigoE()));
        listParametro.add(new Parametro(3, expCapacitador.getCursoSeminario().getCod_CursoSeminario()));
        listParametro.add(new Parametro(4, expCapacitador.getEntidades()));
        if (expCapacitador.getFecha_inicio()instanceof java.util.Date) {
            listParametro.add(new Parametro(5, new java.sql.Date(((java.util.Date) expCapacitador.getFecha_inicio()).getTime())));
        } else {
            listParametro.add(new Parametro(5, expCapacitador.getFecha_inicio()));
        }
        if (expCapacitador.getFecha_final()instanceof java.util.Date) {
            listParametro.add(new Parametro(6, new java.sql.Date(((java.util.Date) expCapacitador.getFecha_final()).getTime())));
        } else {
            listParametro.add(new Parametro(6, expCapacitador.getFecha_final()));
        }
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Exp_Capacitador expCapacitador) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Exp_Capacitador SET codigo_EC=?, codigoE=?, cod_CursoSeminario=?, Entidades=?, fecha_inicio=?, fecha_final=? WHERE codigo_EC=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, expCapacitador.getCodigo_EC()));
        listParametro.add(new Parametro(2, expCapacitador.getExperiencia().getCodigoE()));
        listParametro.add(new Parametro(3, expCapacitador.getCursoSeminario().getCod_CursoSeminario()));
        listParametro.add(new Parametro(4, expCapacitador.getEntidades()));
        if (expCapacitador.getFecha_inicio()instanceof java.util.Date) {
            listParametro.add(new Parametro(5, new java.sql.Date(((java.util.Date) expCapacitador.getFecha_inicio()).getTime())));
        } else {
            listParametro.add(new Parametro(5, expCapacitador.getFecha_inicio()));
        }
        if (expCapacitador.getFecha_final()instanceof java.util.Date) {
            listParametro.add(new Parametro(6, new java.sql.Date(((java.util.Date) expCapacitador.getFecha_final()).getTime())));
        } else {
            listParametro.add(new Parametro(6, expCapacitador.getFecha_final()));
        }
        listParametro.add(new Parametro(7, expCapacitador.getCodigo_EC()));
        Conexion conec=null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas=conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
        }finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Exp_Capacitador expCapacitador) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Exp_Capacitador WHERE codigo_EC=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, expCapacitador.getCodigo_EC()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;
    }

    @Override
    public Exp_Capacitador obtener(int codigo) throws Exception {
        Exp_Capacitador expCapacitador = null;
        String sql = "SELECT codigo_EC, codigoE, cod_CursoSeminario, Entidades, fecha_inicio, fecha_final FROM Exp_Capacitador where codigo_EC=?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        IExperiencia expDao=new ExperienciaImpl();
        Experiencia exp=null;
        ICusro_Seminario curSemDao=new Curso_SeminarioImpl();
        Curso_Seminario curSem=null;
        listadoParametros.add(new Parametro(1, codigo));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutaQuery(sql, listadoParametros);
            while (resultado.next()) {
                exp=new Experiencia();
                curSem=new Curso_Seminario();
                expCapacitador = new Exp_Capacitador();
                expCapacitador.setCodigo_EC(resultado.getInt(1));
                exp=expDao.obtener(resultado.getInt(2));
                expCapacitador.setExperiencia(exp);
                curSem=curSemDao.obtener(resultado.getInt(3));
                expCapacitador.setCursoSeminario(curSem);
                expCapacitador.setEntidades(resultado.getString(4));
                expCapacitador.setFecha_inicio(resultado.getDate(5));
                expCapacitador.setFecha_final(resultado.getDate(6));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return expCapacitador;
    }

    @Override
    public ArrayList<Exp_Capacitador> obtener() throws Exception {
        Exp_Capacitador expCapacitador = null;
        ArrayList<Exp_Capacitador> listaExpCap=new ArrayList<>();
        IExperiencia expDao=new ExperienciaImpl();
        Experiencia exp=null;
        ICusro_Seminario curSemDao=new Curso_SeminarioImpl();
        Curso_Seminario curSem=null;
        String sql = "SELECT codigo_EC, codigoE, cod_CursoSeminario, Entidades, fecha_inicio, fecha_final FROM Exp_Capacitador";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutaQuery(sql, null);
            while (resultado.next()) {
                exp=new Experiencia();
                curSem=new Curso_Seminario();
                expCapacitador = new Exp_Capacitador();
                expCapacitador.setCodigo_EC(resultado.getInt(1));
                exp=expDao.obtener(resultado.getInt(2));
                expCapacitador.setExperiencia(exp);
                curSem=curSemDao.obtener(resultado.getInt(3));
                expCapacitador.setCursoSeminario(curSem);
                expCapacitador.setEntidades(resultado.getString(4));
                expCapacitador.setFecha_inicio(resultado.getDate(5));
                expCapacitador.setFecha_final(resultado.getDate(6));
                listaExpCap.add(expCapacitador);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return listaExpCap;
    }
    
}
