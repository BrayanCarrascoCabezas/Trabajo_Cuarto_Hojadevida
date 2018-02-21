package trabajo_hoja_de_vida.rnegocio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajo_hoja_de_vida.accesodatos.Conexion;
import trabajo_hoja_de_vida.accesodatos.Parametro;
import trabajo_hoja_de_vida.rnegocio.dao.IExp_Directiva;
import trabajo_hoja_de_vida.rnegocio.entidades.Exp_Directiva;

public class Exp_DirectivaImpl implements IExp_Directiva{

    @Override
    public int insertar(Exp_Directiva expdirectiva) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Exp_Directiva  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, expdirectiva.getCodigoExp_D()));
        lstPar.add(new Parametro(2, expdirectiva.getCodigoE()));
        lstPar.add(new Parametro(3, expdirectiva.getEmpresa_Institucion()));
        lstPar.add(new Parametro(4, expdirectiva.getEntidades()));
        lstPar.add(new Parametro(5, expdirectiva.getFecha_Inicio()));
        lstPar.add(new Parametro(6, expdirectiva.getFecha_Final()));

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
    public int modificar(Exp_Directiva expdirectiva) throws Exception {
      int numFilasAfectadas = 0;
        String sql = "UPDATE expdirectiva"
                + "   SET CodigoExp_D=?, codigoE=?, Empresa_Institucion=?, Entidades=?, Fecha_Inicio=?, Fecha_Final=? "
                + " where CodigoExp_D=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, expdirectiva.getCodigoExp_D()));
        lstPar.add(new Parametro(2, expdirectiva.getCodigoE()));
        lstPar.add(new Parametro(3, expdirectiva.getEmpresa_Institucion()));
        lstPar.add(new Parametro(4, expdirectiva.getEntidades()));
        lstPar.add(new Parametro(5, expdirectiva.getFecha_Inicio()));
        lstPar.add(new Parametro(6, expdirectiva.getFecha_Final()));

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
    public int eliminar(Exp_Directiva expdirectiva) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM expdirectiva  where CodigoExp_D=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, expdirectiva.getCodigoExp_D()));       
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
    public Exp_Directiva obtener(int CodigoExp_D) throws Exception {
        Exp_Directiva expdirectiva = null;
        String sql = "SELECT * FROM expdirectiva where CodigoExp_D=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, CodigoExp_D));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
               
                expdirectiva = new Exp_Directiva();
                expdirectiva.setCodigoExp_D(rst.getInt(1));
                expdirectiva.setCodigoE(rst.getInt(2));
                expdirectiva.setEmpresa_Institucion(rst.getString(3));
                expdirectiva.setEntidades(rst.getString(4));
                expdirectiva.setFecha_Inicio(rst.getDate(5));
                expdirectiva.setFecha_Final(rst.getDate(6));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return expdirectiva;
    }

    @Override
    public  List<Exp_Directiva> obtener() throws Exception {
        List<Exp_Directiva> lista = new ArrayList<>();;
        String sql = "SELECT * FROM expdirectiva ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Exp_Directiva expdirectiva = null;
            while (rst.next()) {
                expdirectiva = new Exp_Directiva();
                expdirectiva.setCodigoExp_D(rst.getInt(1));
                expdirectiva.setCodigoE(rst.getInt(2));
                expdirectiva.setEmpresa_Institucion(rst.getString(3));
                expdirectiva.setEntidades(rst.getString(4));
                expdirectiva.setFecha_Inicio(rst.getDate(5));
                expdirectiva.setFecha_Final(rst.getDate(6));
                

                lista.add(expdirectiva);
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
