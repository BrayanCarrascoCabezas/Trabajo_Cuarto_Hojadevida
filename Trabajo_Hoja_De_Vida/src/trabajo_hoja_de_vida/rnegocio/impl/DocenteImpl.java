/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.impl;
import com.sun.javafx.tk.FocusCause;
import trabajo_hoja_de_vida.accesodatos.*;
import trabajo_hoja_de_vida.accesodatos.Parametro;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class DocenteImpl implements IDocente {

    @Override
    public int insertar(Docente docente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into docente  values "
                + "(?,?,?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, docente.getCodigo()));
        lstPar.add(new Parametro(2, docente.getCedula()));
        lstPar.add(new Parametro(3, docente.getNombres()));
        lstPar.add(new Parametro(4, docente.getApellidos()));
        lstPar.add(new Parametro(5, docente.getDireccion()));
        lstPar.add(new Parametro(6, docente.getFecha_nac()));
        lstPar.add(new Parametro(7, docente.getSexo()));
        lstPar.add(new Parametro(8, docente.getEmail()));
        lstPar.add(new Parametro(9, docente.getTelefono()));
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
    public int modificar(Docente docente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE docente"
                + "   SET codigo=?, cedula=?, nombres=?, apellidos=?, fecha_nac=?, "
                + "fecha_ing=?, telefono=?, sexo=?, direccion=?, cod_curso=?"
                + " where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, docente.getCodigo()));
        lstPar.add(new Parametro(2, docente.getCedula()));
        lstPar.add(new Parametro(3, docente.getNombres()));
        lstPar.add(new Parametro(4, docente.getApellidos()));
        lstPar.add(new Parametro(5, docente.getDireccion()));
        lstPar.add(new Parametro(6, docente.getFecha_nac()));
        lstPar.add(new Parametro(7, docente.getSexo()));
        lstPar.add(new Parametro(8, docente.getEmail()));
        lstPar.add(new Parametro(9, docente.getTelefono()));
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
    public int eliminar(Docente docente) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM docente  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, docente.getCodigo()));       
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
    public Docente obtener(int codigo) throws Exception {
        Docente docente = null;
        String sql = "SELECT * FROM docente where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                docente = new Docente();
                docente.setCodigo(rst.getInt(1));
                docente.setCedula(rst.getString(2));
                docente.setNombres(rst.getString(3));
                docente.setApellidos(rst.getString(4));
                docente.setDireccion(rst.getString(5));
                docente.setFecha_nac(rst.getDate(6));
                docente.setSexo(rst.getString(7));
                docente.setEmail(rst.getString(8));
                docente.setTelefono(rst.getString(9));
                   
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return docente;
    }

    @Override
    public List<Docente> obtener() throws Exception {
        List<Docente> lista = new ArrayList<>();
         String sql = "SELECT * FROM docente ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Docente docente=null;
            while (rst.next()) {
                docente = new Docente();
                docente.setCodigo(rst.getInt(1));
                docente.setCedula(rst.getString(2));
                docente.setNombres(rst.getString(3));
                docente.setApellidos(rst.getString(4));
                docente.setDireccion(rst.getString(5));
                docente.setFecha_nac(rst.getDate(6));
                docente.setSexo(rst.getString(7));
                docente.setEmail(rst.getString(8));
                docente.setTelefono(rst.getString(9));
                lista.add(docente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
}
