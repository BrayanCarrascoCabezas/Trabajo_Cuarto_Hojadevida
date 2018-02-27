package trabajo_hoja_de_vida.vistas;
import trabajo_hoja_de_vida.accesodatos.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;

public class FrmDeclaracion extends JInternalFrame{
    JLabel lblTitulo,lblId,lblDescripcion;
    JTextField txtId,txtDescripcion;
    
    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    
    public FrmDeclaracion(){
        this.setSize(300,200);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("DATOS de DECLARACION");
                
        lblId= new JLabel("CODIGO:");
        lblDescripcion= new JLabel("DESCRIPCION:");
        
        txtId = new JTextField(2);
        txtDescripcion= new JTextField(2);
        
        btnAceptar= new JButton("Aceptar");
        btnLimpiar= new JButton("Limpiar");
        
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblId);
        pnlCentral.add(txtId);
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
               
        pnlInferior.add(btnLimpiar);
        pnlInferior.add(btnAceptar);
        pnlCentral.setBackground(Color.getHSBColor(100,60,270).brighter());
        this.add(pnlSuperior, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlInferior, BorderLayout.SOUTH);  
        this.setClosable(true); 
    }
        public static void main(String[] args) {
        FrmDeclaracion frmMenu= new FrmDeclaracion();
        frmMenu.setVisible(true);
    } 
            public void btnAceptarActionListener(ActionEvent e){
        
        try {
            
            Curso curso = new Curso();
            curso.setCodigo(Integer.parseInt(txtId.getText()));
            curso.setDescripcion(txtDescripcion.getText());

            ICurso cursoDao = new CursoImpl();
            
            if(cursoDao.insertar(curso)>0){
                JOptionPane.showMessageDialog(this,"Registro Correcto!!",
                        "Transacción correcta",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this,"Error de Guardado!!",
                "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
            
            
        } catch (Exception x) {
              JOptionPane.showMessageDialog(this,"Proceso incorrecto!!" + x.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            
        }
}}