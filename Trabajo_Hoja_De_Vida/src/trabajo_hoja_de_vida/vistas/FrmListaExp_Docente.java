
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

public class FrmListaExp_Docente extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaExp_Docente() {
        this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo =new JLabel("Listado Experiencia Docente ");
    tabla = new JTable();
    jscTabla= new JScrollPane(tabla); 
    this.add(lblTitulo, BorderLayout.NORTH);
    this.add(jscTabla, BorderLayout.CENTER);
    cargarTabla();
    }
    
     public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo: ");
        modelo.addColumn("Experiencia: ");
        modelo.addColumn("Curso Materias: ");
        modelo.addColumn("Institucion: ");
        modelo.addColumn("Fecha de Inicio: ");
         modelo.addColumn("Fecha Fin: ");
        
        List<Exp_Docente>lista= new ArrayList<>();
        try {
            IExp_Docente exdoDao = new Exp_DocenteImpl();
            lista = exdoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Exp_Docente ec : lista){
            modelo.addRow(new Object[]{ ec.getCodigo_Ex_D(),ec.getExperiencia().getCodigoE(),ec.getCursomateria().getCurso_Materia(),ec.getInstitucion()
                    ,ec.getFechainicio(),ec.getFechafinal().toString()});
        }
        tabla.setModel(modelo);
    }
    
    
}
