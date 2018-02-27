/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;
import trabajo_hoja_de_vida.rnegocio.dao.ICurso;
import trabajo_hoja_de_vida.rnegocio.entidades.Curso;
import trabajo_hoja_de_vida.rnegocio.impl.CursoImpl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author FabricioConstante
 */
public class FrmCursoLista extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmCursoLista(){
        this.setSize(400,300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        this.setBackground(Color.getHSBColor(100,60,270).brighter());
        lblTitulo=new JLabel("Listado de Cursos");
        tabla = new JTable();
        this.add(lblTitulo,BorderLayout.NORTH);
        this.add(tabla,BorderLayout.NORTH);
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
            modelo.addRow(new Object[]{est.getCodigo(),est.getDescripcion()});
        }
        tabla.setModel(modelo);
    }
    
}