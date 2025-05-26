package teatro.vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class vistaMiembros extends  JFrame {
private JTextField txtIdMiembro;
private JTextField txtNombre;
private JTextField txtPrimerApellido;
private JTextField txtsegundoApellido;
private JTextField txtFechaNacimiento;
private JSpinner spinnerGenero;
private JTextField txtEmail;
private JSpinner spinnerEstadoCuota;
private JTextField txtIdDireccion;
private JButton btnGuardar;
private JButton btnCancelar;
private JButton btnReestablecer;
GridBagConstraints gbc;
private JPanel panel;

public vistaMiembros(){
    setTitle("Teatro Pleasantville - vistaMiembros");
    setSize(550, 550);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);

    panel= new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    panel.setLayout(new GridBagLayout());
    add(panel);

    gbc= new GridBagConstraints();
    gbc.insets= new Insets(5,5,5,5);
    gbc.fill=GridBagConstraints.HORIZONTAL;

    //agregarComponentes();
    txtIdMiembro=new JTextField(8);
    agregarComponentes(txtIdMiembro,1,1);

    txtNombre= new JTextField(30);
    



}
    private void agregarComponentes(JComponent component, int gridx, int gridy){
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, gbc);
    }


}
