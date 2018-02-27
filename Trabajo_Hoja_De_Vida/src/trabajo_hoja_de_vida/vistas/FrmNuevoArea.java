package trabajo_hoja_de_vida.vistas;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class FrmNuevoArea extends JInternalFrame{

    JLabel lblCodigo;
    JLabel lblTitulo0;
    JLabel lblDescripcion;
    
    JTextField txtCodigo;
    
    JTextField txtDescripcion;
    JTextField txtTitulo0;
    
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoArea() {
        this.setSize(350, 350);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(9, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Area");
        
        lblCodigo= new JLabel("Código:");
        lblDescripcion= new JLabel("Descripcion:");
        
        txtCodigo = new JTextField(2);
        txtDescripcion= new JTextField(2);
        
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblDescripcion);
        pnlCentral.add(txtDescripcion);
 
                
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
        FrmNuevoArea frmMenu= new FrmNuevoArea();
        frmMenu.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionEvent e){
        AreaGeneral area = new AreaGeneral();
            IAreaGeneral areaDao = new AreaImpl();
            area.setCodigo(Integer.parseInt(txtCodigo.getText()));
            area.setDescripcion(txtDescripcion.getText());
            
          
            
            
            try {
                if(areaDao.insertar(area)>0 ){
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
 