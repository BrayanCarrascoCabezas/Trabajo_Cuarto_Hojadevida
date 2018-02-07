package trabajo_hoja_de_vida.vistas;



import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.*;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.entidades.AreaGeneral;
import trabajo_hoja_de_vida.rnegocio.impl.AreaImpl;
import trabajo_hoja_de_vida.rnegocio.dao.IAreaGeneral;

/**
 *
 * @author Usuario
 */
public class FrmListaArea extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmListaArea(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Lista Area");
    tabla = new JTable();
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(tabla,BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
       
        modelo.addColumn("Descripcion");
        
        List<AreaGeneral> lista = new ArrayList<>();
        try {
            IAreaGeneral areaDao= new AreaImpl();
            lista = areaDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(AreaGeneral est:lista){
            modelo.addRow(new Object[]{est.getCodigo(),est.getdescripcion() });
        }
        tabla.setModel(modelo);
    }
}
