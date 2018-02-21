
package trabajo_hoja_de_vida.vistas;
import trabajo_hoja_de_vida.rnegocio.Impl.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
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
/**
 *
 * @author JOSEPH
 */

public class FrmMateria extends JInternalFrame{
       JLabel lblTitulo1,lblTitulo2;
    JLabel lblGenero;
    JLabel lblTitulo0;
    
    JTextField txtTitulo1,txtTitulo2;

    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmMateria() {
        
        this.setSize(250,160);
        this.setLayout(new BorderLayout());
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("MATERIA");
        
        lblTitulo1= new JLabel(" CODIGO :");
        lblTitulo2= new JLabel(" NOMBRE :");
 
        

        txtTitulo1 = new JTextField(2);
        txtTitulo2= new JTextField(2);


        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblTitulo1);
        pnlCentral.add(txtTitulo1);
        pnlCentral.add(lblTitulo2);
        pnlCentral.add(txtTitulo2);

  

        
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
        pnlCentral.setBackground(Color.getHSBColor(100,60,270).brighter());
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);   
        
    }
    public static void main(String[] args) {
        FrmMateria frmMenu= new FrmMateria();
        frmMenu.setVisible(true);
    } 
    
public void btnAceptarActionListener(ActionEvent e){
        
        try {
            
            Materia materia = new Materia();
            materia.setCodigo(Integer.parseInt(txtTitulo1.getText()));
            materia.setNombre(txtTitulo2.getText());

            IMateria materiaDao = new MateriaImpl();
            
            if(materiaDao.insertar(materia)>0){
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
}
}
