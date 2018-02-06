/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajo_hoja_de_vida.accesodatos.Conexion;
import trabajo_hoja_de_vida.accesodatos.Parametro;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.dao.IExperiencia;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.entidades.Experiencia;

/**
 *
 * @author CRISTIAN
 */
public class ExperienciaImpl implements IExperiencia {

    @Override
    public int insertar(Experiencia experiencia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Experiencia  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, experiencia.getCodigoE()));
        lstPar.add(new Parametro(2, experiencia.getDocente().getCod_docente()));
        lstPar.add(new Parametro(3, experiencia.getAños()));
        lstPar.add(new Parametro(4, experiencia.getLugar()));
        lstPar.add(new Parametro(5, experiencia.getDescripcion()));

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
    public int modificar(Experiencia experiencia) throws Exception {
      int numFilasAfectadas = 0;
        String sql = "UPDATE Experiencia"
                + "   SET codigoE=?, cod_docente=?, años=?, lugar=?, descripcion=? "
                + " where codigoE=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, experiencia.getCodigoE()));
        lstPar.add(new Parametro(2, experiencia.getDocente().getCod_docente()));
        lstPar.add(new Parametro(3, experiencia.getAños()));
        lstPar.add(new Parametro(4, experiencia.getLugar()));
        lstPar.add(new Parametro(5, experiencia.getDescripcion()));

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
    public int eliminar(Experiencia experiencia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM experiencia  where codigoE=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, experiencia.getCodigoE()));
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
    public Experiencia obtener(int codigoE) throws Exception {
        Experiencia experiencia = null;
        Docente docente = null;
        IDocente docenteDao = new DocenteImpl();
        String sql = "SELECT * FROM Experiencia where codigoE=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoE));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
                docente = new Docente();
                docente = docenteDao.obtener(rst.getInt(2));
                experiencia = new Experiencia();
                experiencia.setCodigoE(rst.getInt(1));
                experiencia.setDocente(docente);
                experiencia.setAños(rst.getInt(3));
                experiencia.setLugar(rst.getString(4));
                experiencia.setDescripcion(rst.getString(5));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return experiencia;
    }

    @Override
    public List<Experiencia> obtener() throws Exception {
        List<Experiencia> lista = new ArrayList<>();
        Docente docente = null;
        IDocente docenteDao = new DocenteImpl();
        String sql = "SELECT * FROM experiencia ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Experiencia experiencia = null;
            while (rst.next()) {
                docente = new Docente();
                docente = docenteDao.obtener(rst.getInt(2));
                experiencia = new Experiencia();
                experiencia.setCodigoE(rst.getInt(1));
                experiencia.setDocente(docente);
                experiencia.setAños(rst.getInt(3));
                experiencia.setLugar(rst.getString(4));
                experiencia.setDescripcion(rst.getString(5));

                lista.add(experiencia);
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
