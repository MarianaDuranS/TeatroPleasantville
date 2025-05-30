package teatro.vista;
import teatro.controlador.MiembrosDAO;
import teatro.modelo.Miembros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class vistaMiembros extends  JFrame {
    private String seleccion;
    private JTextField txtIdMiembro,txtNombre,txtPrimerApellido,txtSegundoApellido,txtFechaNacimiento,txtEmail,txtIdDireccion,txtBusqueda;
    private JSpinner spinnerGenero,spinnerEstadoCuota;
    private JButton btnGuardar,btnRegresar,btnReestablecer,btnBuscar;
    GridBagConstraints gbc;
    private JPanel panelMain,panel,panelBotones;
    private MiembrosDAO miembrosDAO;
    private final SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
    private JComboBox<String> comboFiltro;
    private JTable tablaMiembros;
    private DefaultTableModel modeloTabla;
    public vistaMiembros(String seleccion){
        this.seleccion = seleccion;

        miembrosDAO= new MiembrosDAO();
        setTitle("Teatro Pleasantville - vistaMiembros");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panelMain = new JPanel(new BorderLayout());
        panelMain.setBackground(new Color(00, 149, 236));
        add(panelMain);

        JLabel Titulo= new JLabel("MIEMBROS", SwingConstants.CENTER);
        Titulo.setFont(new Font("Verdana",Font.BOLD,24));
        Titulo.setBorder(BorderFactory.createEmptyBorder(15,0,15,0));
        panelMain.add(Titulo, BorderLayout.NORTH);

        panel= new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
        panel.setBackground(new Color(00, 149, 236));
        panel.setLayout(new GridBagLayout());
        panelMain.add(panel,BorderLayout.CENTER);

        gbc= new GridBagConstraints();
        gbc.insets= new Insets(5,5,5,5);
        gbc.fill=GridBagConstraints.HORIZONTAL;

        crearTablaMiembros();

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
        txtSegundoApellido= new JTextField(30);
        agregarComponentes(txtSegundoApellido,1,3);

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
        panelBotones.setBackground(new Color(00, 149, 236));

        btnGuardar=new JButton("GUARDAR");
        panelBotones.add(btnGuardar);

        btnRegresar= new JButton("REGRESAR");
        panelBotones.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window ventana= SwingUtilities.getWindowAncestor(btnRegresar);
                if (ventana != null) {
                    ventana.dispose();
                }
            }
        });

        btnReestablecer= new JButton("REESTABLECER");
        panelBotones.add(btnReestablecer);
        btnReestablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        btnBuscar= new JButton("BUSCAR");
        panel.add(btnBuscar);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarMiembro();
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
                configuracionAltasMiembros();
                break;
            case "baja":
                configuracionBajasMiembros();
                break;
            case "cambio":
                configuracionCambiosMiembros();
                break;
            case "consulta":
                agregarPanelBusqueda();
                configuracionConsultasMiembros();
                break;
            default:

                configuracionConsultasMiembros();
        }

    }
    private void agregarPanelBusqueda(){
        JPanel panelBusqueda = new JPanel(new GridBagLayout());
        panelBusqueda.setBackground(new Color(00, 149, 236));
        panelBusqueda.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        GridBagConstraints gbcBusqueda = new GridBagConstraints();
        gbcBusqueda.insets = new Insets(5, 5, 5, 5);
        gbcBusqueda.fill = GridBagConstraints.HORIZONTAL;

        // Combo box para seleccionar el criterio de búsqueda
        String[] criterios = {"ID Miembro", "Nombre", "Primer Apellido", "Segundo Apellido",
                "Género", "Estado Cuota", "Todos"};
        comboFiltro = new JComboBox<>(criterios);

        JLabel lblFiltro = new JLabel("Buscar por:");
        lblFiltro.setForeground(Color.WHITE);
        lblFiltro.setFont(new Font("Courier New", Font.BOLD, 15));

        txtBusqueda = new JTextField(20);
        JButton btnBuscarAvanzada = new JButton("Buscar");
        btnBuscarAvanzada.addActionListener(e -> busquedaFiltro());

        // Posicionamiento de componentes
        gbcBusqueda.gridx = 0;
        gbcBusqueda.gridy = 1;
        panelBusqueda.add(lblFiltro, gbcBusqueda);

        gbcBusqueda.gridx = 2;
        panelBusqueda.add(comboFiltro, gbcBusqueda);

        gbcBusqueda.gridx = 3;
        panelBusqueda.add(txtBusqueda, gbcBusqueda);

        gbcBusqueda.gridx = 4;
        panelBusqueda.add(btnBuscarAvanzada, gbcBusqueda);

        panelMain.add(panelBusqueda, BorderLayout.CENTER);
        btnBuscar.setText("Buscar por ID");
        btnBuscar.addActionListener(e -> buscarMiembro());
    }

    private void configuracionAltasMiembros(){
        setTitle("Teatro Pleasantville - Altas Miembros");
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(e -> guardarMiembro());
        habilitarCampos(true);
        txtIdMiembro.setEnabled(false);
    }
    private void configuracionBajasMiembros(){
        setTitle("Teatro Pleasantville - Baja de Miembro");
        btnGuardar.setText("Eliminar");
        btnGuardar.addActionListener(e -> eliminarMiembro());

        habilitarCampos(false);
        txtIdMiembro.setEnabled(true);

        txtIdMiembro.addActionListener(e -> buscarMiembro());
    }
    private void configuracionCambiosMiembros(){
        setTitle("Teatro Pleasantville - Modificar Miembro");
        btnGuardar.setText("Actualizar");
        btnGuardar.addActionListener(e -> actualizarMiembro());

        habilitarCampos(true);


    }
    private void configuracionConsultasMiembros(){
        setTitle("Teatro Pleasantville - Consultar Miembro");
        panel.setVisible(false);
        btnGuardar.setText("Buscar");
        btnGuardar.addActionListener(e -> buscarMiembro());

        habilitarCampos(false);
    }
    private void busquedaFiltro(){
        String criterio = (String) comboFiltro.getSelectedItem();
        String valor = txtBusqueda.getText().trim();

        List<Miembros> resultados = new ArrayList<>();

        try {
            switch (criterio) {
                case "ID Miembro":
                    Miembros miembro = miembrosDAO.mostrarMiembro(valor);
                    if (miembro != null) resultados.add(miembro);
                    break;
                case "Nombre":
                    resultados = buscarPorNombre(valor);
                    break;
                case "Primer Apellido":
                    resultados = buscarPorApellido(valor, "primer");
                    break;
                case "Segundo Apellido":
                    resultados = buscarPorApellido(valor, "segundo");
                    break;
                case "Género":
                    resultados = buscarPorGenero(valor);
                    break;
                case "Estado Cuota":
                    resultados = buscarPorEstadoCuota(valor);
                    break;
                case "Todos":
                    resultados = miembrosDAO.obtenerTodosMiembros();
                    break;
            }

            mostrarResultadosBusqueda(resultados);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<Miembros> buscarPorNombre(String nombre) {
        List<Miembros> todos = miembrosDAO.obtenerTodosMiembros();
        List<Miembros> resultados = new ArrayList<>();

        for (Miembros m : todos) {
            if (m.getNombre() != null && m.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(m);
            }
        }
        return resultados;
    }

    private List<Miembros> buscarPorApellido(String apellido, String tipo) {
        List<Miembros> todos = miembrosDAO.obtenerTodosMiembros();
        List<Miembros> resultados = new ArrayList<>();

        for (Miembros m : todos) {
            if (tipo.equals("primer") && m.getPrimerApellido() != null &&
                    m.getPrimerApellido().toLowerCase().contains(apellido.toLowerCase())) {
                resultados.add(m);
            } else if (tipo.equals("segundo") && m.getSegundoApellido() != null &&
                    m.getSegundoApellido().toLowerCase().contains(apellido.toLowerCase())) {
                resultados.add(m);
            }
        }
        return resultados;
    }

    private List<Miembros> buscarPorGenero(String genero) {
        List<Miembros> todos = miembrosDAO.obtenerTodosMiembros();
        List<Miembros> resultados = new ArrayList<>();

        for (Miembros m : todos) {
            if (m.getGenero() != null && m.getGenero().equalsIgnoreCase(genero)) {
                resultados.add(m);
            }
        }
        return resultados;
    }

    private List<Miembros> buscarPorEstadoCuota(String estado) {
        List<Miembros> todos = miembrosDAO.obtenerTodosMiembros();
        List<Miembros> resultados = new ArrayList<>();

        for (Miembros m : todos) {
            if (m.getEstadoCuota() != null && m.getEstadoCuota().equalsIgnoreCase(estado)) {
                resultados.add(m);
            }
        }
        return resultados;
    }

    private void mostrarResultadosBusqueda(List<Miembros> resultados) {
        modeloTabla.setRowCount(0);

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron resultados",
                    "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (Miembros miembro : resultados) {
            Object[] fila = {
                    miembro.getIdMiembro(),
                    miembro.getNombre(),
                    miembro.getPrimerApellido(),
                    miembro.getSegundoApellido(),
                    formato.format(miembro.getFechaNacimiento()),
                    miembro.getGenero(),
                    miembro.getEmail(),
                    miembro.getEstadoCuota(),
                    miembro.getIdDireccion()
            };
            modeloTabla.addRow(fila);
        }
    }
    private void guardarMiembro(){
        if (validarCampos()){
            try {
                String idMiembro = String.format("%08d", (int) (Math.random() * 100000000));
                txtIdMiembro.setText(idMiembro);

                Miembros miembro = crearMiembroCampos(idMiembro);
                if (miembrosDAO.agregarMiembro(miembro)) {
                    JOptionPane.showMessageDialog(this, "Miembro registrado con éxito");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al registrar miembro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch (ParseException e){
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido (use yyyy-MM-dd)", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        cargarDatos();
    }
    private void eliminarMiembro(){
        String idMiembro=txtIdMiembro.getText();
        if (txtIdMiembro.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Ingrese un ID");
        }
        buscarMiembro();
        int confirmacion= JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este miembro?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (miembrosDAO.eliminarMiembro(idMiembro)) {
                JOptionPane.showMessageDialog(this, "Miembro eliminado con éxito");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar miembro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        limpiarCampos();
        cargarDatos();
    }
    private void actualizarMiembro(){

        try {
            txtIdMiembro.setEnabled(true);
            Miembros miembro = crearMiembroCampos(txtIdMiembro.getText());
            if (validarCampos()==true){
                if (miembrosDAO.editarMiembro(miembro)) {
                    JOptionPane.showMessageDialog(this, "Miembro actualizado con éxito");
                    limpiarCampos();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar miembro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido (use yyyy-MM-dd)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarDatos();
    }
    private void buscarMiembro(){
        String idMiembro=txtIdMiembro.getText();
        if (idMiembro.isEmpty()){
            JOptionPane.showMessageDialog(this,"Ingrese el id");
            return;
        }
        btnGuardar.setEnabled(false);
        SwingWorker<Miembros, Void> worker = new SwingWorker<Miembros, Void>() {
            @Override
            protected Miembros doInBackground() throws Exception {
                return miembrosDAO.mostrarMiembro(idMiembro);
            }

            @Override
            protected void done() {
                try {
                    Miembros miembro = get();
                    if (miembro != null) {
                        llenadoDesdeCampos(miembro);
                        JOptionPane.showMessageDialog(vistaMiembros.this,
                                "Miembro encontrado con éxito",
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                        txtIdMiembro.setEnabled(false);
                        selectMemberInTable(idMiembro);
                    } else {
                        JOptionPane.showMessageDialog(vistaMiembros.this,
                                "Miembro con ID " + idMiembro + " no encontrado",
                                "No Encontrado",
                                JOptionPane.WARNING_MESSAGE);
                        limpiarCampos();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(vistaMiembros.this,
                            "Error al buscar miembro: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                } finally {
                    btnGuardar.setEnabled(true);
                }
            }
        };
        worker.execute();
        cargarDatos();
    }
    private void selectMemberInTable(String idMiembro) {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            if (modeloTabla.getValueAt(i, 0).equals(idMiembro)) {
                tablaMiembros.setRowSelectionInterval(i, i);
                tablaMiembros.scrollRectToVisible(tablaMiembros.getCellRect(i, 0, true));
                break;
            }
        }
    }
    private Miembros crearMiembroCampos(String idMiembro) throws ParseException{
        String nombre=txtNombre.getText();
        String primerApellido=txtPrimerApellido.getText();
        String segundoApellido=txtSegundoApellido.getText();
        Date fechaNacimiento=formato.parse(txtFechaNacimiento.getText());
        String genero=(String) spinnerGenero.getValue();
        String email=txtEmail.getText();
        String estadoCuota=(String) spinnerEstadoCuota.getValue();
        String idDireccion=txtIdDireccion.getText();

        return new Miembros(idMiembro,nombre,primerApellido,segundoApellido,fechaNacimiento,genero,email,estadoCuota,idDireccion);
    }
    private void llenadoDesdeCampos(Miembros miembro){
        txtIdMiembro.setText(miembro.getIdMiembro());
        txtNombre.setText(miembro.getNombre() != null ? miembro.getNombre() : "");
        txtPrimerApellido.setText(miembro.getPrimerApellido() != null ? miembro.getPrimerApellido() : "");
        txtSegundoApellido.setText(miembro.getSegundoApellido() != null ? miembro.getSegundoApellido() : "");
        txtFechaNacimiento.setText(miembro.getFechaNacimiento() != null ? formato.format(miembro.getFechaNacimiento()) : "");
        spinnerGenero.setValue(miembro.getGenero() != null ? miembro.getGenero() : "Hombre");
        txtEmail.setText(miembro.getEmail() != null ? miembro.getEmail() : "");
        spinnerEstadoCuota.setValue(miembro.getEstadoCuota() != null ? miembro.getEstadoCuota() : "Pagada");
        txtIdDireccion.setText(miembro.getIdDireccion() != null ? miembro.getIdDireccion() : "");
    }
    private void agregarComponentes(JComponent component, int gridx, int gridy){
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, gbc);
    }
    private void habilitarCampos(boolean habilitar){
        txtNombre.setEnabled(habilitar);
        txtPrimerApellido.setEnabled(habilitar);
        txtSegundoApellido.setEnabled(habilitar);
        txtFechaNacimiento.setEnabled(habilitar);
        spinnerGenero.setEnabled(habilitar);
        txtEmail.setEnabled(habilitar);
        spinnerEstadoCuota.setEnabled(habilitar);
        txtIdDireccion.setEnabled(habilitar);
    }
    private void limpiarCampos() {
        txtIdMiembro.setText("");
        txtNombre.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        txtFechaNacimiento.setText("");
        spinnerGenero.setValue("Hombre");
        txtEmail.setText("");
        spinnerEstadoCuota.setValue("Pagada");
        txtIdDireccion.setText("");
    }
    private boolean validarCampos(){

        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"El nombre es obligatorio");
            return false;
        }else if (!txtNombre.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtPrimerApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"El primer apellido es obligatorio");
            return false;
        }else if (!txtPrimerApellido.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(this, "El apellido solo puede contener letras", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!txtSegundoApellido.getText().isEmpty() && !txtSegundoApellido.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(this, "El segundo apellido solo puede contener letras", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtFechaNacimiento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"La fecha de nacimiento es obligatoria");
            return false;
        }
        if (txtEmail.getText().isEmpty() || !txtEmail.getText().contains("@")) {
            JOptionPane.showMessageDialog(this,"Ingrese un email válido");
            return false;
        }else{
            String email = txtEmail.getText().trim();
            if (!email.contains("@") ||
                    email.startsWith("@") ||
                    email.endsWith("@") ||
                    email.indexOf("@") != email.lastIndexOf("@")) {
                JOptionPane.showMessageDialog(this, "Ingrese un email válido (formato: usuario@dominio.com)", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        String idDireccion = txtIdDireccion.getText().trim();

        if (idDireccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID de dirección es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (idDireccion.length() != 8 || !idDireccion.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El ID de dirección debe ser un número de 8 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    private void crearTablaMiembros(){
        String[] columnas = {"ID", "Nombre", "Primer Apellido", "Segundo Apellido", "Fecha Nac.",
                "Género", "Email", "Estado Cuota", "ID Dirección"};

        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaMiembros = new JTable(modeloTabla);
        tablaMiembros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(tablaMiembros);
        scrollPane.setPreferredSize(new Dimension(800, 200));

        panelMain.add(scrollPane, BorderLayout.SOUTH);

        cargarDatos();
    }
    private void cargarDatos(){
        modeloTabla.setRowCount(0);
        List<Miembros> miembros = miembrosDAO.obtenerTodosMiembros();
        if (miembros != null) {
            for (Miembros miembro : miembros) {
                Object[] fila = {
                        miembro.getIdMiembro(),
                        miembro.getNombre(),
                        miembro.getPrimerApellido(),
                        miembro.getSegundoApellido(),
                        formato.format(miembro.getFechaNacimiento()),
                        miembro.getGenero(),
                        miembro.getEmail(),
                        miembro.getEstadoCuota(),
                        miembro.getIdDireccion()
                };
                modeloTabla.addRow(fila);
            }
        }
    }
    private void agregarEtiquetas(String texto, int gridx, int gridy){
        JLabel etiqueta= new JLabel(texto);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setFont(new Font("Courier New",Font.BOLD,15));
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        panel.add(etiqueta, gbc);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new vistaMiembros("consulta").setVisible(true);
            }
        });
    }

}