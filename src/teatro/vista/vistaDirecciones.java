package teatro.vista;
import teatro.controlador.DireccionesDAO;
import teatro.modelo.Direcciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;


public class vistaDirecciones extends JFrame {
    private String seleccion;
    private JTextField txtIdDirecciones,txtNumeroCasa,txtCalle,txtColonia,txtCiudad,txtEstado,txtCodigoPostal,txtTelefono;
    private JButton btnGuardar,btnRegresar;
    GridBagConstraints gbc;
    private JPanel panelMain,panel,panelBotones;
    private DireccionesDAO direccionesDAO;

    public vistaDirecciones(String seleccion){
        this.seleccion = seleccion;
        direccionesDAO= new DireccionesDAO();
        setTitle("Teatro Pleasantville - vistaDirecciones");
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panelMain = new JPanel(new BorderLayout());
        add(panelMain);

        JLabel Titulo= new JLabel("DIRECCIONES", SwingConstants.CENTER);
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

        //agregar Componentes
        agregarEtiquetas("Id Direccion: ",0,0);
        txtIdDirecciones=new JTextField(8);
        agregarComponentes(txtIdDirecciones,1,0);

        agregarEtiquetas("Numero Casa :",0,1);
        txtNumeroCasa= new JTextField(30);
        agregarComponentes(txtNumeroCasa,1,1);

        agregarEtiquetas("Calle: ",0,2);
        txtCalle= new JTextField(30);
        agregarComponentes(txtCalle,1,2);

        agregarEtiquetas("Colonia: ",0,3);
        txtColonia= new JTextField(30);
        agregarComponentes(txtColonia,1,3);

        agregarEtiquetas("Ciudad:",0,4);
        txtCiudad= new JTextField(20);
        agregarComponentes(txtCiudad,1,4);

        agregarEtiquetas("Estado:",0,5);
        txtEstado= new JTextField(20);
        agregarComponentes(txtEstado,1,5);

        agregarEtiquetas("C.P: ",0,6);
        txtCodigoPostal= new JTextField(30);
        agregarComponentes(txtCodigoPostal,1,6);

        agregarEtiquetas("Telefono: ",0,7);
        txtTelefono= new JTextField(10);
        agregarComponentes(txtTelefono,1,7);

        panelBotones= new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));

        btnGuardar=new JButton("Guardar");
        panelBotones.add(btnGuardar);

        btnRegresar=new JButton("Regresar");
        panelBotones.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window ventana= SwingUtilities.getWindowAncestor(btnRegresar);
                if (ventana != null) {
                    ventana.dispose(); // Cierra la ventana
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth=2;
        gbc.fill=GridBagConstraints.CENTER;
        panel.add(panelBotones,gbc);
        configuracionInterfaz();
    }
    private void configuracionInterfaz(){
        switch (seleccion.toLowerCase()){
            case "alta":
                configuracionAltasDirecciones();
                break;
            case "baja":
                configuracionBajasDirecciones();
                break;
            case "cambio":
                configuracionCambiosDirecciones();
                break;
            case "consulta":
                configuracionConsultasDirecciones();
                break;
            default:
                configuracionConsultasDirecciones();
        }

    }
    private void configuracionAltasDirecciones(){
        setTitle("Teatro Pleasantville - Altas Direcciones");
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(e -> guardarDireccion());
        habilitarCampos(true);
        txtIdDirecciones.setEnabled(false);
    }
    private void configuracionBajasDirecciones(){
        setTitle("Teatro Pleasantville - Baja de Miembro");
        btnGuardar.setText("Eliminar");
        btnGuardar.addActionListener(e -> eliminarDireccion());

        habilitarCampos(false);
        txtIdDirecciones.setEnabled(true);

        txtIdDirecciones.addActionListener(e -> buscarDireccion());
    }
    private void configuracionCambiosDirecciones(){
        setTitle("Teatro Pleasantville - Modificar Miembro");
        btnGuardar.setText("Actualizar");
        btnGuardar.addActionListener(e -> actualizarDireccion());

        habilitarCampos(false);
        txtIdDirecciones.setEnabled(true);
        txtIdDirecciones.addActionListener(e -> {
            buscarDireccion();
            if (!txtNumeroCasa.getText().isEmpty()) {
                habilitarCampos(true);
            }
        });
    }
    private void configuracionConsultasDirecciones(){
        setTitle("Teatro Pleasantville - Consultar Direccion");
        btnGuardar.setText("Buscar");
        btnGuardar.addActionListener(e -> buscarDireccion());

        habilitarCampos(false);
        txtIdDirecciones.setEnabled(true);
    }
    private void guardarDireccion(){
        if (validarCampos()){
            try {
                String idDireccion = String.format("%08d", (int) (Math.random() * 100000000));
                txtIdDirecciones.setText(idDireccion);

                Direcciones direccion = crearDireccionCampos(idDireccion);
                if (direccionesDAO.agregarDireccion(direccion)) {
                    JOptionPane.showMessageDialog(this, "Direccion registrada con éxito");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al registrar Direccion", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch (ParseException e){
            }

        }
    }
    private void eliminarDireccion(){
        String idDireccion=txtIdDirecciones.getText();
        if (txtIdDirecciones.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Ingrese un ID");
        }
        int confirmacion= JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta Direccion?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (direccionesDAO.eliminarDireccion(idDireccion)) {
                JOptionPane.showMessageDialog(this, "Direccion eliminada con éxito");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar Direccion", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        limpiarCampos();
    }
    private void actualizarDireccion(){
        try {
            String idDireccion = txtIdDirecciones.getText().trim();
            Direcciones direcciones = crearDireccionCampos(idDireccion);
            if (direccionesDAO.editarDireccion(direcciones)) {
                JOptionPane.showMessageDialog(this, "Direccion actualizada con éxito");
                limpiarCampos();
                habilitarCampos(false);
                txtIdDirecciones.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar Direccion", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ParseException e) {
        }
    }
    private void buscarDireccion(){
        String idDireccion=txtIdDirecciones.getText();
        if (idDireccion.isEmpty()){
            JOptionPane.showMessageDialog(this,"Ingrese el id");
            return;
        }

        Direcciones direcciones= direccionesDAO.mostrarDireccion(idDireccion);
        if (direcciones != null) {
            llenadoDesdeCampos(direcciones);
        } else {
            JOptionPane.showMessageDialog(this, "Direccion no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }

    }
    private Direcciones crearDireccionCampos(String idDireccion) throws ParseException{
        String numeroCasa=txtNumeroCasa.getText();
        String calle=txtCalle.getText();
        String colonia=txtColonia.getText();
        String ciudad=txtCiudad.getText();
        String estado=txtEstado.getText();
        String codigoPostal=txtCodigoPostal.getText();
        String telefono=txtTelefono.getText();

        return new Direcciones(idDireccion,numeroCasa,calle,colonia,ciudad,estado,codigoPostal,telefono);
    }
    private void llenadoDesdeCampos(Direcciones direcciones){
        txtIdDirecciones.setText(direcciones.getIdDireccion());
        txtNumeroCasa.setText(direcciones.getNumeroCasa() != null ? direcciones.getNumeroCasa() : "");
        txtCalle.setText(direcciones.getCalle() != null ? direcciones.getCalle() : "");
        txtColonia.setText(direcciones.getColonia() != null ? direcciones.getColonia() : "");
        txtCiudad.setText(direcciones.getCiudad() != null ? direcciones.getCiudad() : "");
        txtEstado.setText(direcciones.getEstado() != null ? direcciones.getEstado() : "");
        txtCodigoPostal.setText(direcciones.getCodigoPostal() != null ? direcciones.getCodigoPostal() : "");
        txtTelefono.setText(direcciones.getTelefono() != null ? direcciones.getTelefono() : "");
    }
    private void agregarComponentes(JComponent component, int gridx, int gridy){
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, gbc);
    }
    private void habilitarCampos(boolean habilitar){
        txtIdDirecciones.setEnabled(habilitar);
        txtNumeroCasa.setEnabled(habilitar);
        txtColonia.setEnabled(habilitar);
        txtCiudad.setEnabled(habilitar);
        txtEstado.setEnabled(habilitar);
        txtCodigoPostal.setEnabled(habilitar);
        txtTelefono.setEnabled(habilitar);
    }
    private void limpiarCampos() {
        txtIdDirecciones.setText("");
        txtNumeroCasa.setText("");
        txtCalle.setText("");
        txtColonia.setText("");
        txtCiudad.setText("");
        txtEstado.setText("");
        txtCodigoPostal.setText("");
        txtTelefono.setText("");
    }
    private boolean validarCampos(){
        if (txtNumeroCasa.getText().isEmpty()||txtCalle.getText().isEmpty()||txtColonia.getText().isEmpty()
        ||txtCiudad.getText().isEmpty()||txtEstado.getText().isEmpty()||txtCodigoPostal.getText().isEmpty()
        ||txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Ingrese la informacion restante");
            return false;
        }

        return true;
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
                new vistaDirecciones("alta").setVisible(true);
            }
        });
    }
}
