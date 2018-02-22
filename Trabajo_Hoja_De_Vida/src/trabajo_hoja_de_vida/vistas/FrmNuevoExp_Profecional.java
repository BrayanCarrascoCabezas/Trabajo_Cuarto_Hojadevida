
package trabajo_hoja_de_vida.vistas;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import javax.swing.*;
public class FrmNuevoExp_Profecional extends JInternalFrame {
     List<Experiencia> lstExperiencia;
    JComboBox<Experiencia> cmbExperiencia;
    JLabel lblTitulo0;
    JLabel lblCodigoExp;
    JLabel lblExperiencia;
    JLabel lblEmpresa_Institucion;
    JLabel lblPosicion;
    JLabel lblFecha_Inicio;
    JLabel lblFecha_Final;
    
    JTextField txtCodigoExp;
    JTextField txtEmpresa_Institucion;
    JTextField txtPosicion;
    JTextField txtFecha_Inicio;
    JTextField txtFecha_Final;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public FrmNuevoExp_Profecional() {
        this.setSize(350, 350);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(9, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Exp_Profecional");
        
        lblCodigoExp= new JLabel("CódigoExp_Profecional:");
        lblExperiencia = new JLabel("Experiencia");
        lblEmpresa_Institucion= new JLabel("Empresa_Institucion:");
        lblPosicion = new JLabel("Posicion:");
        lblFecha_Inicio = new JLabel("Fecha Inicio:");
        lblFecha_Final = new JLabel("Fecha Final:");
        
        
        txtCodigoExp = new JTextField(2);
        cargarExperiencias();
        cmbExperiencia = new JComboBox(lstExperiencia.toArray());
        txtEmpresa_Institucion = new JTextField(2);
        txtPosicion = new JTextField(2);
        txtFecha_Inicio = new JTextField(2); 
        txtFecha_Final = new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigoExp);
        pnlCentral.add(txtCodigoExp);
        pnlCentral.add(lblExperiencia);
        pnlCentral.add(cmbExperiencia);
        pnlCentral.add(lblEmpresa_Institucion);
        pnlCentral.add(txtEmpresa_Institucion);
        pnlCentral.add(lblPosicion);
        pnlCentral.add(txtPosicion);
        pnlCentral.add(lblFecha_Inicio);
        pnlCentral.add(txtFecha_Inicio);
        pnlCentral.add(lblFecha_Final);
        pnlCentral.add(txtFecha_Final);
    
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
        FrmNuevoExp_Profecional frmMenu= new FrmNuevoExp_Profecional();
        frmMenu.setVisible(true);
    } 
    public void cargarExperiencias(){
        IExperiencia experienciaDao = new ExperienciaImpl();
        try {
            lstExperiencia = experienciaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar la Experiencia!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        Exp_Profecional exp_profecional = new Exp_Profecional();
            IExp_Profecional exp_profecionalDao = new Exp_ProfecionalImpl();
            exp_profecional.setCodigoExp(Integer.parseInt(txtCodigoExp.getText()));
           exp_profecional.setExperiencia((Experiencia) cmbExperiencia.getSelectedItem());
            exp_profecional.setEmpresa_nstitucion(txtEmpresa_Institucion.getText());
            exp_profecional.setPosicion(txtPosicion.getText());
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                exp_profecional.setFecha_inicio(formatoFecha.parse(txtFecha_Inicio.getText()));
                exp_profecional.setFecha_final(formatoFecha.parse(txtFecha_Final.getText()));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Error", JOptionPane.ERROR_MESSAGE);
            }
         
            
            try {
                if(exp_profecionalDao.insertar(exp_profecional)>0 ){
                JOptionPane.showMessageDialog(this,"Registrado correctamente!!",
                "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(this,"Error desconocido: ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }

  

   
    
}
