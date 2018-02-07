package trabajo_hoja_de_vida.rnegocio.impl;

import trabajo_hoja_de_vida.accesodatos.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import java.util.*;
import java.sql.*;

public class Curso_SeminarioImpl implements ICusro_Seminario {

    @Override
    public int insertar(Curso_Seminario curso_seminario) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Curso_Seminario (cod_Docente, cod_CursoSeminario, nombreCS, horas, ubicacion, descripcion ) values (?,?,?,?,?,?)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, curso_seminario.getDocente().getCod_docente()));
        listParametro.add(new Parametro(2, curso_seminario.getCod_CursoSeminario()));
        listParametro.add(new Parametro(3, curso_seminario.getNombreCS()));
        listParametro.add(new Parametro(4, curso_seminario.getHoras()));
        listParametro.add(new Parametro(5, curso_seminario.getUbicacion()));
        listParametro.add(new Parametro(6, curso_seminario.getDescripcion()));

        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Curso_Seminario curso_seminario) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Curso_Seminario SET cod_Docente=? cod_CursoSeminario=? nombreCS=? horas=? ubicacion=? descripcion=? WHERE cod_CursoSeminario=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, curso_seminario.getDocente().getCod_docente()));
        listParametro.add(new Parametro(2, curso_seminario.getCod_CursoSeminario()));
        listParametro.add(new Parametro(3, curso_seminario.getNombreCS()));
        listParametro.add(new Parametro(4, curso_seminario.getHoras()));
        listParametro.add(new Parametro(5, curso_seminario.getUbicacion()));
        listParametro.add(new Parametro(6, curso_seminario.getDescripcion()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Curso_Seminario curso_seminario) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Curso_Seminario WHERE cod_CursoSeminario=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, curso_seminario.getCod_CursoSeminario()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Curso_Seminario obtener(int codigo) throws Exception {
        Curso_Seminario cursose = null;
        Docente nDoc = null;
        IDocente donDao = new DocenteImpl();
        String sql = "SELECT cod_Docente, cod_CursoSeminario, nombreCS, horas, ubicacion, descripcion FROM Curso_Seminario where cod_CursoSeminario=?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        listadoParametros.add(new Parametro(1, codigo));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutaQuery(sql, listadoParametros);
            while (resultado.next()) {
                cursose = new Curso_Seminario();
                nDoc = new Docente();
                nDoc = donDao.obtener(resultado.getInt(1));
                cursose.setDocente(nDoc);
                cursose.setCod_CursoSeminario(resultado.getInt(2));
                cursose.setNombreCS(resultado.getString(3));
                cursose.setHoras(resultado.getInt(4));
                cursose.setUbicacion(resultado.getString(5));
                cursose.setDescripcion(resultado.getString(6));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return cursose;
    }

    @Override
    public ArrayList<Curso_Seminario> obtener() throws Exception {
        ArrayList<Curso_Seminario> lista = new ArrayList<>();
        Docente nDoc = null;
        IDocente donDao = new DocenteImpl();
        String sql = "SELECT cod_Docente, cod_CursoSeminario, nombreCS, horas, ubicacion, descripcion FROM Curso_Seminario";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutaQuery(sql, null);
            Curso_Seminario cursosec = null;
            while (resultado.next()) {
                cursosec = new Curso_Seminario();
                nDoc = new Docente();
                nDoc = donDao.obtener(resultado.getInt(1));
                cursosec.setDocente(nDoc);
                cursosec.setCod_CursoSeminario(resultado.getInt(6));
                cursosec.setNombreCS(resultado.getString(2));
                cursosec.setHoras(resultado.getInt(3));
                cursosec.setUbicacion(resultado.getString(4));
                cursosec.setDescripcion(resultado.getString(5));
                
                lista.add(cursosec);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (conec != null) {
                conec.desconectar();
            }
        }
        return lista;
    }

}
