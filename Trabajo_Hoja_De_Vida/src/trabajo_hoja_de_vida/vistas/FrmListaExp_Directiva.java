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
public class FrmListaExp_Directiva extends JInternalFrame {
 JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaExp_Directiva(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo =new JLabel("Listado Exp Directiva ");
    tabla = new JTable();
    jscTabla= new JScrollPane(tabla); 
    this.add(lblTitulo, BorderLayout.NORTH);
    this.add(jscTabla, BorderLayout.CENTER);
    cargarTabla();
    } 
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("CodigoExp_D");
        modelo.addColumn("CodigoE");
        modelo.addColumn("Empresa_Institucion");
        modelo.addColumn("Entidades");
        modelo.addColumn("Fecha_Inicio");
         modelo.addColumn("Fecha_Final");
        
        List<Exp_Directiva>lista= new ArrayList<>();
        try {
            IExp_Directiva excaDao = new Exp_DirectivaImpl();
            lista = excaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Exp_Directiva ec : lista){
            modelo.addRow(new Object[]{ ec.getCodigoExp_D(),ec.getCodigoE(),ec.getEmpresa_Institucion(),ec.getEntidades()
                    ,ec.getFecha_Inicio(),ec.getFecha_Final().toString()});
        }
        tabla.setModel(modelo);
    }
    }
