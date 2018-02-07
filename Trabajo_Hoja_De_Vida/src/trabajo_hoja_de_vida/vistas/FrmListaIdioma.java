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
import trabajo_hoja_de_vida.rnegocio.dao.IIdioma;
import trabajo_hoja_de_vida.rnegocio.entidades.Idioma;
import trabajo_hoja_de_vida.rnegocio.impl.IdiomaImpl;

/**
 *
 * @author SYSTEMarket-pc
 */
public class FrmListaIdioma extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmListaIdioma(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Listado de Idiomas");
    tabla = new JTable();
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(tabla,BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        
        List<Idioma> lista = new ArrayList<>();
        try {
            IIdioma idiomaDao= new IdiomaImpl();
            lista = idiomaDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(Idioma est:lista){
            modelo.addRow(new Object[]{est.getCodigo(),est.getDescripcion().toString()});
        }
        tabla.setModel(modelo);
    }
    
}
