/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;


import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.*;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.impl.DocenteImpl;

/**
 *
 * @author Usuario
 */
public class FrmListaDocente extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmListaDocente(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Listado de docente");
    tabla = new JTable();
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(tabla,BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Direccion");
        modelo.addColumn("Fecha nacimiento");
        modelo.addColumn("Email");
        modelo.addColumn("Sexo");
        modelo.addColumn("Telefono");
        
        List<Docente> lista = new ArrayList<>();
        try {
            IDocente docenteDao= new DocenteImpl();
            lista = docenteDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(Docente est:lista){
            modelo.addRow(new Object[]{est.getCod_docente(),est.getCedula(),est.getNombres(),est.getApellidos(),est.getDireccion(),est.getFecha_nac(),est.getEmail(),est.getSexo(),est.getTelefono()});
        }
        tabla.setModel(modelo);
    }
}

