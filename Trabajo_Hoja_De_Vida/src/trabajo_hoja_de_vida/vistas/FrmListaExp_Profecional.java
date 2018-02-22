
package trabajo_hoja_de_vida.vistas;


import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.dao.IExp_Profecional;
import trabajo_hoja_de_vida.rnegocio.entidades.Exp_Profecional;
import trabajo_hoja_de_vida.rnegocio.impl.Exp_ProfecionalImpl;

public class FrmListaExp_Profecional extends JInternalFrame{
     JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaExp_Profecional(){
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
        modelo.addColumn("Empresa");
        modelo.addColumn("Posicion");
       modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Final");
       
        
        List<Exp_Profecional> lista = new ArrayList<>();
        try {
            IExp_Profecional exp_profecionalDao= new Exp_ProfecionalImpl();
            lista = exp_profecionalDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(Exp_Profecional est:lista){
            modelo.addRow(new Object[]{est.getCodigoExp(),est.getEmpresa_nstitucion(),est.getPosicion(),est.getFecha_inicio(),est.getFecha_final()});
        }
        tabla.setModel(modelo);
    }
   
    
}
