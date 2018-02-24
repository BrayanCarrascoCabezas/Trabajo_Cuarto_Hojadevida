package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.*;

public class FrmListaCursoSeminario extends JInternalFrame {

    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public FrmListaCursoSeminario() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        //this.setClosable(true);
        titulo = new JLabel("LISTADO DE ESTUDIANTES");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();

    }

    public void cargarTabla() {
        setTitle("LISTAR CURSO SEMINARIO");
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo Docente");

        modelo.addColumn("Codigo Curso Seminario");
        modelo.addColumn("NUMERO Curso Seminario");

        modelo.addColumn("Horas Curso Seminario");

        modelo.addColumn("Ubicacion");

        modelo.addColumn("Descripcion");

        List<Curso_Seminario> lista = new ArrayList<>();
        try {
            ICusro_Seminario estDao = new Curso_SeminarioImpl();
            lista = estDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Curso_Seminario est : lista) {
            modelo.addRow(new Object[]{est.getDocente().getCod_docente(), est.getCod_CursoSeminario(), est.getNombreCS(), est.getHoras(), est.getUbicacion(), est.getDescripcion()});
        }
        tabla.setModel(modelo);
    }

}
