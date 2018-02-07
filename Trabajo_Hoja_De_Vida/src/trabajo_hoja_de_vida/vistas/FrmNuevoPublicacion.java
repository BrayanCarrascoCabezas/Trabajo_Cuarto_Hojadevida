
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
    List<Docente> lstDocentes;
    JComboBox<Docente> cmbDocente;
    JLabel titulo0;
    JLabel cod_Docente;
    JLabel cod_publicacion;
    JLabel tiulo;
    JLabel editorial;
    JLabel año;
    JTextField txtcod_Docente;
    JTextField txtcod_publicacion;
    JTextField txttitulo;
    JTextField txteditorial;
    JTextField txtaño;
    JComboBox cmbDocentes;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;
    public FrmNuevoPublicacion(){
    this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS DE LA  PUBLICACION");
        cod_Docente = new JLabel("CODIGO DOCENTE ");
        cod_publicacion= new JLabel("CODIGO DE LA PUBLICACION");
        tiulo = new JLabel("TITULO DE LA PUBLICACION");
        editorial= new JLabel("NOMBRE DE LA EDITORIAL");
        año = new JLabel("AÑO DE PUBLICACION");
        txtcod_Docente = new JTextField();
        txtcod_publicacion = new JTextField();
        txttitulo = new JTextField();
        txteditorial = new JTextField();
        txtaño = new JTextField();

        CargarDocente();
        cmbDocentes = new JComboBox(lstDocentes.toArray());
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(cod_Docente);
        pnlcentral.add(cmbDocentes);
        pnlcentral.add(cod_publicacion);
        
        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error " + ex.getMessage());
                }
            }
        });
        this.add(titulo0, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        FrmNuevoPublicacion frmMenu= new FrmNuevoPublicacion();
        frmMenu.setVisible(true);

    }
    public void CargarDocente() {

        IDocente curDao = new DocenteImpl();
        try {
            lstDocentes = curDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }
 public void btnAceptarActionListener(ActionEvent e){
        Publicacion publicacion = new Publicacion();
            IPublicacion publicacionDao = new PublicacionImpl();
          //  docente.setcInteger.parseInt(txtCodigo.getText()));
            publicacion.setCod_publicacion(Integer.parseInt(txtcod_publicacion.getText()));
            publicacion.setTitulo(txttitulo.getText());
            publicacion.setEditorial(txteditorial.getText());
            publicacion.setAño(txtaño.getText());
            
            try {
                if(publicacionDao.insertar(publicacion)>0 ){
                JOptionPane.showMessageDialog(this,"Registrado correctamente!!",
                "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(this,"Error desconocido: ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    
    
    
    
    
    

