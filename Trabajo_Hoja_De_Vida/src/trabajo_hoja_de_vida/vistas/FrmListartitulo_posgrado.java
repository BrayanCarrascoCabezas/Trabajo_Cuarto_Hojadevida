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
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
public class FrmListartitulo_posgrado extends JInternalFrame {
 JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
 public FrmListartitulo_posgrado(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo =new JLabel("Listado Posgrado ");
    tabla = new JTable();
    jscTabla= new JScrollPane(tabla); 
    this.add(lblTitulo, BorderLayout.NORTH);
    this.add(jscTabla, BorderLayout.CENTER);
    cargarTabla();
    } 
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo posgrado");
        modelo.addColumn("Codigo docente");
        modelo.addColumn("pais");
        modelo.addColumn("Titulo_posgrado");
        modelo.addColumn("universidad");
        
        
        List<Titulo_Posgrado>lista= new ArrayList<>();
        try {
            ITitulo_Posgrado tposDao = new Titulo_PosgradoImpl();
            lista = tposDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Titulo_Posgrado pos : lista){
            modelo.addRow(new Object[]{ pos.getCodTitulo_posgrado(),pos.getDocente().getCod_docente(),pos.getPais(),pos.getTitulo_posgrado()
                    ,pos.getUniversidad().toString()});
        }
        tabla.setModel(modelo);
    }
}

    

