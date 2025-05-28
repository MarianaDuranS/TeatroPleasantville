package teatro.vista;
import teatro.controlador.DireccionesDAO;
import teatro.modelo.Direcciones;
import javax.swing.*;
import java.awt.*;


public class vistaDirecciones extends JFrame {
    private String seleccion;
    private JTextField txtIdDirecciones,txtNumeroCasa,txtCalle,txtColonia,txtCiudad,txtEstado,txtCodigoPostal,txtTelefono;
    private JButton btnGuardar,btnCancelar,btnReestablecer;
    GridBagConstraints gbc;
    private JPanel panelMain,panel,panelBotones;
    
    public vistaDirecciones(String seleccion){
        this.seleccion = seleccion;

    }
}
