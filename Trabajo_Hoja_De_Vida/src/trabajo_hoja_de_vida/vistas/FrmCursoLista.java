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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.dao.ICurso;
import trabajo_hoja_de_vida.rnegocio.entidades.Curso;
import trabajo_hoja_de_vida.rnegocio.impl.CursoImpl;

/**
 *
 * @author FabricioConstante
 */
public class FrmCursoLista extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmCursoLista(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Listado de Cursos");
    tabla = new JTable();
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(tabla,BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        
        List<Curso> lista = new ArrayList<>();
        try {
            ICurso cursoDao= new CursoImpl();
            lista = cursoDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(Curso est:lista){
            modelo.addRow(new Object[]{est.getCodigo(),est.getDescripcion().toString()});
        }
        tabla.setModel(modelo);
    }
    
}
