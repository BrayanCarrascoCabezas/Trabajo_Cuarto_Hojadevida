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
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;

/**
 *
 * @author WILCXMAC
 */
public class FrmListaAdicional extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmListaAdicional(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Lista Adicional");
    tabla = new JTable();
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(tabla,BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addRow(new Object[]{"COD DOCTOR ","DESCRIPCION"});
        
        List<Adicional> lista = new ArrayList<>();
        try {
            IAdicional docenteDao= new AdicionalImpl();
            lista = docenteDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(Adicional est:lista){
            modelo.addRow(new Object[]{est.getDocente().getCod_docente(),est.getDescripcion().toString()});
        }
        tabla.setModel(modelo);
    }
}
