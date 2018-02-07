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
public class FrmListaEx_Capacitador extends JInternalFrame {
 JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaEx_Capacitador(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo =new JLabel("Listado Ex Cacitador ");
    tabla = new JTable();
    jscTabla= new JScrollPane(tabla); 
    this.add(lblTitulo, BorderLayout.NORTH);
    this.add(jscTabla, BorderLayout.CENTER);
    cargarTabla();
    } 
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo_E");
        modelo.addColumn("Codigo_ec");
        modelo.addColumn("Cursos_Seminarios");
        modelo.addColumn("Entidades");
        modelo.addColumn("Fecha_inicio");
         modelo.addColumn("Fecha_final");
        
        List<Exp_Capacitador>lista= new ArrayList<>();
        try {
            IExp_Capacitador excaDao = new Exp_CapacitadorImpl();
            lista = excaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Exp_Capacitador ec : lista){
            modelo.addRow(new Object[]{ ec.getExperiencia().getCodigoE(),ec.getCodigo_EC(),ec.getCursoSeminario(),ec.getEntidades()
                    ,ec.getFecha_inicio(),ec.getFecha_final().toString()});
        }
        tabla.setModel(modelo);
    }
    }



    

