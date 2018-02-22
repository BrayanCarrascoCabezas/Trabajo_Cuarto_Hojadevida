
package trabajo_hoja_de_vida.rnegocio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajo_hoja_de_vida.accesodatos.Conexion;
import trabajo_hoja_de_vida.accesodatos.Parametro;
import trabajo_hoja_de_vida.rnegocio.dao.IExp_Profecional;
import trabajo_hoja_de_vida.rnegocio.dao.IExperiencia;
import trabajo_hoja_de_vida.rnegocio.entidades.Exp_Profecional;
import trabajo_hoja_de_vida.rnegocio.entidades.Experiencia;

public class Exp_ProfecionalImpl implements IExp_Profecional {

    @Override
    public int insertar(Exp_Profecional exp_profecional) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Exp_Profecional  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, exp_profecional.getCodigoExp()));
        lstPar.add(new Parametro(2, exp_profecional.getExperiencia().getCodigoE()));
        lstPar.add(new Parametro(3, exp_profecional.getEmpresa_nstitucion()));
        lstPar.add(new Parametro(4, exp_profecional.getPosicion()));
        lstPar.add(new Parametro(5, exp_profecional.getFecha_inicio()));
        lstPar.add(new Parametro(6, exp_profecional.getFecha_final()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Exp_Profecional exp_profecional) throws Exception {
      int numFilasAfectadas = 0;
        String sql = "UPDATE exp_profecional"
                + "   SET codigoExp=?, codigoE=?, empresa_nstitucion=?, posicion=?, fecha_inicio=?, fecha_final=? "
                + " where codigoExp=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, exp_profecional.getCodigoExp()));
        lstPar.add(new Parametro(2, exp_profecional.getExperiencia().getCodigoE()));
        lstPar.add(new Parametro(3, exp_profecional.getEmpresa_nstitucion()));
        lstPar.add(new Parametro(4, exp_profecional.getPosicion()));
        lstPar.add(new Parametro(5, exp_profecional.getFecha_inicio()));
        lstPar.add(new Parametro(6, exp_profecional.getFecha_final()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }  

    @Override
    public int eliminar(Exp_Profecional exp_profecional) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM exp_profecional  where codigoExp=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, exp_profecional.getCodigoExp()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

   @Override
    public Exp_Profecional obtener(int codigoExp) throws Exception {
        Exp_Profecional exp_profecional = null;
        String sql = "SELECT codigoExp, codigoE, empresa_nstitucion, posicion, fecha_inicio,"
                + "fecha_final FROM exp_profecional where codigoExp=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoExp));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
               
                exp_profecional = new Exp_Profecional();
                exp_profecional.setCodigoExp(rst.getInt(1));
                IExperiencia experienciadao = new ExperienciaImpl();
                Experiencia experiencia = experienciadao.obtener(rst.getInt(2));;
                exp_profecional.setEmpresa_nstitucion(rst.getString(3));
                exp_profecional.setPosicion(rst.getString(4));
                exp_profecional.setFecha_inicio(rst.getDate(5));
                exp_profecional.setFecha_final(rst.getDate(6));
                exp_profecional.setExperiencia(experiencia);
                exp_profecional.setExperiencia(experiencia);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return exp_profecional;
    }

    @Override
    public List<Exp_Profecional> obtener() throws Exception {
        List<Exp_Profecional> lista = new ArrayList<>();;
        String sql = "SELECT codigoExp, codigoE, empresa_nstitucion, posicion, fecha_inicio,"
                + "fecha_final FROM exp_profecional ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Exp_Profecional exp_profecional = null;
            while (rst.next()) {
                exp_profecional = new Exp_Profecional();
                exp_profecional.setCodigoExp(rst.getInt(1));
                 IExperiencia experienciadao = new ExperienciaImpl();
                Experiencia experiencia = experienciadao.obtener(rst.getInt(2));
                exp_profecional.setExperiencia(experiencia);
                exp_profecional.setEmpresa_nstitucion(rst.getString(3));
                exp_profecional.setPosicion(rst.getString(4));
                exp_profecional.setFecha_inicio(rst.getDate(5));
                exp_profecional.setFecha_final(rst.getDate(6));
                lista.add(exp_profecional);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return lista;
    }
}
