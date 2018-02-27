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
import trabajo_hoja_de_vida.rnegocio.dao.IArea_docente;
import trabajo_hoja_de_vida.rnegocio.entidades.Area_docente;
import trabajo_hoja_de_vida.rnegocio.impl.Area_docenteImpl;

/**
 *
 * @author Segovia
 */
public class FrmListaAreaDocente extends JInternalFrame {
     JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaAreaDocente(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado DetalleCompra");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("id Docente");
        modelo.addColumn("id Area");
        
        
        List<Area_docente> lista = new ArrayList<>();
        try {
            IArea_docente areadocenteDao = new Area_docenteImpl();
            lista = areadocenteDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Area_docente est : lista){
            modelo.addRow(new Object[] { est.getDocente(), est.getAreageneral()});
            }
           tabla.setModel(modelo); 
        }
}
