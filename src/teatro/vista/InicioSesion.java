package teatro.vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InicioSesion extends JFrame{
    private JTextField txtUsuario;
    private JPasswordField txtContrasenia;
    private JButton btnInicioSesion;
    private JPanel panel;
    GridBagConstraints gbc;
    private String usuarioTeatro= "adminM1";
    private String contraseniaTeatro ="teatro1M";
    public InicioSesion(){
        setTitle("Teatro Pleasantville - Inicio de Sesión");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel= new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        panel.setLayout(new GridBagLayout());
        add(panel);

        gbc= new GridBagConstraints();
        gbc.insets= new Insets(10,10,10,10);
        gbc.fill=GridBagConstraints.HORIZONTAL;

        JLabel etTitulo= new JLabel("Teatro Pleasantville");
        etTitulo.setFont(new Font("Brasika",Font.BOLD,20));
        etTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridwidth=2;
        agregarComponentes(etTitulo,0,0);


        JLabel etUsuario = new JLabel("Usuario");
        gbc.gridwidth=1;
        agregarComponentes(etUsuario,0,1);

        txtUsuario=new JTextField(15);
        agregarComponentes(txtUsuario,1,1);

        JLabel etContra= new JLabel("Contraseña");
        agregarComponentes(etContra,0,2);

        txtContrasenia= new JPasswordField(8);
        agregarComponentes(txtContrasenia,1,2);


        btnInicioSesion= new JButton("Iniciar Sesion");
        btnInicioSesion.setPreferredSize(new Dimension(150,30));
        btnInicioSesion.setBackground(new Color(226, 187, 128));
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        btnInicioSesion.addActionListener(this::validacionInicioSesion);
        agregarComponentes(btnInicioSesion,0,3);


    }
    private void validacionInicioSesion(ActionEvent e){
        String usuario=txtUsuario.getText();
        String contrasenia= new String(txtContrasenia.getPassword());

        if (usuarioTeatro.equals(usuario)&& contraseniaTeatro.equals(contrasenia)){
            JOptionPane.showMessageDialog(this, "Acceso concedido", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            //agregar el menu principal
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"Usuario o contraseña incorrectos","Error",JOptionPane.ERROR_MESSAGE);
            txtContrasenia.setText("");
            txtUsuario.setText("");
        }
    }
    private void agregarComponentes(JComponent component, int gridx, int gridy){
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        panel.add(component, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }
}
