package trabajo_hoja_de_vida.vistas;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import javax.swing.*;
public class FrmNuevoExp_Directiva extends JInternalFrame {
    JLabel lblTitulo0;
    JLabel lblCodigoExp_D;
    JLabel lblCodigoE;
    JLabel lblEmpresa_Institucion;
    JLabel lblEntidades;
    JLabel lblFecha_Inicio;
    JLabel lblFecha_Final;
    
    JTextField txtCodigoExp_D;
    JTextField txtCodigoE;
    JTextField txtEmpresa_Institucion;
    JTextField txtEntidades;
    JTextField txtFecha_Inicio;
    JTextField txtFecha_Final;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public FrmNuevoExp_Directiva() {
        this.setSize(350, 350);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(9, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Exp_Directiva");
        
        lblCodigoExp_D= new JLabel("CódigoExp_Directiva:");
        lblCodigoE = new JLabel("CodigoExperiencia");
        lblEmpresa_Institucion= new JLabel("Empresa_Institucion:");
        lblEntidades = new JLabel("Posicion:");
        lblFecha_Inicio = new JLabel("Fecha Inicio:");
        lblFecha_Final = new JLabel("Fecha Final:");
        
        
        txtCodigoExp_D = new JTextField(2);
        txtCodigoE = new JTextField(2);
        txtEmpresa_Institucion = new JTextField(2);
        txtEntidades = new JTextField(2);
        txtFecha_Inicio = new JTextField(2); 
        txtFecha_Final = new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigoExp_D);
        pnlCentral.add(txtCodigoExp_D);
        pnlCentral.add(lblCodigoE);
        pnlCentral.add(txtCodigoE);
        pnlCentral.add(lblEmpresa_Institucion);
        pnlCentral.add(txtEmpresa_Institucion);
        pnlCentral.add(lblEntidades);
        pnlCentral.add(txtEntidades);
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
        FrmNuevoExp_Directiva frmMenu= new FrmNuevoExp_Directiva();
        frmMenu.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionEvent e){
        Exp_Directiva expdirectiva = new Exp_Directiva();
            IExp_Directiva expdirectivaDao = new Exp_DirectivaImpl();
            expdirectiva.setCodigoExp_D(Integer.parseInt(txtCodigoExp_D.getText()));
            expdirectiva.setCodigoE(Integer.parseInt(txtCodigoE.getText()));
            expdirectiva.setEmpresa_Institucion(txtEmpresa_Institucion.getText());
            expdirectiva.setEntidades(txtEntidades.getText());
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                expdirectiva.setFecha_Inicio((Date) formatoFecha.parse(txtFecha_Inicio.getText()));
                expdirectiva.setFecha_Final((Date) formatoFecha.parse(txtFecha_Final.getText()));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Error", JOptionPane.ERROR_MESSAGE);
            }
         
            
            try {
                if(expdirectivaDao.insertar(expdirectiva)>0 ){
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
