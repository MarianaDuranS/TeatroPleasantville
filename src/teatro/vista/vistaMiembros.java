package teatro.vista;
import javax.swing.*;
import java.awt.*;
import java.sql.Date;
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
private JPanel panelMain;
private JPanel panel;
private JPanel panelBotones;

public vistaMiembros(){
    setTitle("Teatro Pleasantville - vistaMiembros");
    setSize(550, 550);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);

    panelMain = new JPanel(new BorderLayout());
    add(panelMain);

    JLabel Titulo= new JLabel("MIEMBROS", SwingConstants.CENTER);
    Titulo.setFont(new Font("Arial",Font.BOLD,24));
    Titulo.setBorder(BorderFactory.createEmptyBorder(15,0,15,0));
    panelMain.add(Titulo, BorderLayout.NORTH);

    panel= new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
    panel.setLayout(new GridBagLayout());
    panelMain.add(panel,BorderLayout.CENTER);

    gbc= new GridBagConstraints();
    gbc.insets= new Insets(5,5,5,5);
    gbc.fill=GridBagConstraints.HORIZONTAL;


    //agregarComponentes


    agregarEtiquetas("Id Miembro: ",0,0);
    txtIdMiembro=new JTextField(8);
    agregarComponentes(txtIdMiembro,1,0);

    agregarEtiquetas("Nombre :",0,1);
    txtNombre= new JTextField(30);
    agregarComponentes(txtNombre,1,1);

    agregarEtiquetas("Primer apellido: ",0,2);
    txtPrimerApellido= new JTextField(30);
    agregarComponentes(txtPrimerApellido,1,2);

    agregarEtiquetas("Segundo apellido: ",0,3);
    txtsegundoApellido= new JTextField(30);
    agregarComponentes(txtsegundoApellido,1,3);

    agregarEtiquetas("Fecha nacimiento :",0,4);
    txtFechaNacimiento= new JTextField(20);
    agregarComponentes(txtFechaNacimiento,1,4);

    String generos[]= {"Hombre","Mujer","Otro"};
    agregarEtiquetas("Género",0,5);
    spinnerGenero= new JSpinner(new SpinnerListModel(generos));
    agregarComponentes(spinnerGenero,1,5);

    agregarEtiquetas("Email: ",0,6);
    txtEmail= new JTextField(30);
    agregarComponentes(txtEmail,1,6);

    String estadoCuota []={"Pagada","Pendiente"};
    agregarEtiquetas("Estado cuota: ",0,7);
    spinnerEstadoCuota= new JSpinner(new SpinnerListModel(estadoCuota));
    agregarComponentes(spinnerEstadoCuota,1,7);

    agregarEtiquetas("Id Direccion: ",0,8);
    txtIdDireccion= new JTextField(30);
    agregarComponentes(txtIdDireccion,1,8);

    panelBotones= new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));

    btnGuardar=new JButton("Guardar");
    panelBotones.add(btnGuardar);

    btnCancelar= new JButton("Cancelar");
    panelBotones.add(btnCancelar);

    btnReestablecer= new JButton("Reestablecer");
    panelBotones.add(btnReestablecer);

    gbc.gridx = 0;
    gbc.gridy = 9;
    gbc.gridwidth=2;
    gbc.fill=GridBagConstraints.CENTER;
    panel.add(panelBotones,gbc);






}
    private void agregarComponentes(JComponent component, int gridx, int gridy){
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, gbc);
    }
    private void agregarEtiquetas(String texto, int gridx, int gridy){
    JLabel etiqueta= new JLabel(texto);
    gbc.gridx = gridx;
        gbc.gridy = gridy;
        panel.add(etiqueta, gbc);
    }
public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new vistaMiembros().setVisible(true);
        }
    });
}

}
