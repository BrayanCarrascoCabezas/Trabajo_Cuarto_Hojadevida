/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.dao.IExperiencia;
import trabajo_hoja_de_vida.rnegocio.entidades.Experiencia;
import trabajo_hoja_de_vida.rnegocio.impl.ExperienciaImpl;

/**
 *
 * @author CRISTIAN
 */
public class FrmListaExperiencia extends JInternalFrame {
 JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaExperiencia() {
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo =new JLabel("Listado Experiencia");
    tabla = new JTable();
    jscTabla= new JScrollPane(tabla); 
    this.add(lblTitulo, BorderLayout.NORTH);
    this.add(jscTabla, BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Docente");
        modelo.addColumn("Años");
        modelo.addColumn("Lugar");
        modelo.addColumn("Descripcion");
        
        List<Experiencia>lista= new ArrayList<>();
        try {
            IExperiencia experienciaDao = new ExperienciaImpl();
            lista = experienciaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Experiencia cli : lista){
            modelo.addRow(new Object[]{ cli.getCodigoE(),cli.getDocente(),cli.getAños(),cli.getLugar()
                    ,cli.getDescripcion().toString()});
        }
        tabla.setModel(modelo);
    }
    }
    



