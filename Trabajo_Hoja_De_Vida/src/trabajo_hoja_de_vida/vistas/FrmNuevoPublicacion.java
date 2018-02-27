
package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.dao.IPublicacion;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.entidades.Publicacion;
import trabajo_hoja_de_vida.rnegocio.impl.DocenteImpl;
import trabajo_hoja_de_vida.rnegocio.impl.PublicacionImpl;

/**
 *
 * @author Francisco
 */
public class FrmNuevoPublicacion extends JInternalFrame{
    List<Docente> lstDocente;
    JComboBox<Docente> cmbDocente;
    
    JLabel lblTitulo0;
    JLabel lblCodigo;
    JLabel lbltitulo;
    JLabel lbleditorial;
    JLabel lblaño;
    JLabel lblDocente;

    JTextField txtCodigo;
    JTextField txttitulo;
    JTextField txteditorial;
    JTextField txtaño;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoPublicacion() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Producto");
        
        lblCodigo = new JLabel("Código:");
        lbltitulo = new JLabel("Titulo de la Publicacion:");
        lbleditorial= new JLabel("Editorial:");
        lblaño= new JLabel("Año de publicacion:");
        lblDocente  = new JLabel("Docente:");
       

        txtCodigo = new JTextField(2);
        txttitulo= new JTextField(2);
        txteditorial = new JTextField(2);
        txtaño = new JTextField(2);
        cargarDocente();
        
        cmbDocente = new JComboBox(lstDocente.toArray());
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
       
        pnlCentral.add(lbltitulo);
        pnlCentral.add(txttitulo);
        pnlCentral.add(lbleditorial);
        pnlCentral.add(txteditorial);
        pnlCentral.add(lblaño);
        pnlCentral.add(txtaño);
      
        pnlCentral.add(lblDocente);
        pnlCentral.add(cmbDocente);
        
                
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    
    
    public static void main(String[] args) {
        FrmNuevoPublicacion frmMenu= new FrmNuevoPublicacion();
        frmMenu.setVisible(true);
    } 
    
    
    public void cargarDocente(){
        IDocente docenteDao = new DocenteImpl();
        try {
            lstDocente = docenteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar arreglate!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IPublicacion publicacionDao = new PublicacionImpl();
        Publicacion publicacion = new Publicacion();
        publicacion.setCod_publicacion(Integer.parseInt(txtCodigo.getText()));
        publicacion.setDocente((Docente) cmbDocente.getSelectedItem());
        publicacion.setTitulo(txttitulo.getText());
        publicacion.setEditorial(txteditorial.getText());
        publicacion.setAño(txtaño.getText());
        
       
        try {
            if(publicacionDao.insertar(publicacion)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
}
    
    
    
    
    
    
    

