package teatro.vista;
import teatro.controlador.OficialesDAO;
import teatro.modelo.Oficiales;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class vistaOficiales extends JFrame {
    private String seleccion;
    private JTextField txtIdOficial, txtIdMiembro, txtCargo;
    private JButton btnGuardar, btnRegresar, btnReestablecer;
    GridBagConstraints gbc;
    private JPanel panelMain, panel, panelBotones;
    private OficialesDAO oficialesDAO;
    private final SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    private JTable tablaOficiales;
    private DefaultTableModel modeloTabla;
    private JTextField txtFechaInicio, txtFechaFin;

    public vistaOficiales(String seleccion) {
        this.seleccion = seleccion;
        oficialesDAO = new OficialesDAO();
        setTitle("Teatro Pleasantville - Vista Oficiales");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panelMain = new JPanel(new BorderLayout());
        panelMain.setBackground(new Color(00, 149, 236));
        add(panelMain);

        JLabel Titulo = new JLabel("OFICIALES", SwingConstants.CENTER);
        Titulo.setFont(new Font("Verdana", Font.BOLD, 24));
        Titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        panelMain.add(Titulo, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        panel.setBackground(new Color(00, 149, 236));
        panel.setLayout(new GridBagLayout());
        panelMain.add(panel, BorderLayout.CENTER);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        crearTablaOficiales();

        // Campos del formulario
        agregarEtiquetas("ID Oficial:", 0, 0);
        txtIdOficial = new JTextField(8);
        agregarComponentes(txtIdOficial, 1, 0);

        agregarEtiquetas("ID Miembro:", 0, 1);
        txtIdMiembro = new JTextField(8);
        agregarComponentes(txtIdMiembro, 1, 1);

        agregarEtiquetas("Cargo:", 0, 2);
        txtCargo = new JTextField(30);
        agregarComponentes(txtCargo, 1, 2);

        agregarEtiquetas("Fecha Inicio (yyyy-MM-dd):", 0, 3);
        txtFechaInicio = new JTextField(10);
        agregarComponentes(txtFechaInicio, 1, 3);

        agregarEtiquetas("Fecha Fin (yyyy-MM-dd):", 0, 4);
        txtFechaFin = new JTextField(10);
        agregarComponentes(txtFechaFin, 1, 4);

        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBackground(new Color(00, 149, 236));

        btnGuardar = new JButton("Guardar");
        panelBotones.add(btnGuardar);

        btnRegresar = new JButton("Regresar");
        panelBotones.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window ventana = SwingUtilities.getWindowAncestor(btnRegresar);
                if (ventana != null) {
                    ventana.dispose();
                }
            }
        });

        btnReestablecer = new JButton("Reestablecer");
        panelBotones.add(btnReestablecer);
        btnReestablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(panelBotones, gbc);
        configuracionInterfaz();
    }

    private void configuracionInterfaz() {
        switch (seleccion.toLowerCase()) {
            case "alta":
                configuracionAltasOficiales();
                break;
            case "baja":
                configuracionBajasOficiales();
                break;
            case "cambio":
                configuracionCambiosOficiales();
                break;
            case "consulta":
                configuracionConsultasOficiales();
                break;
            default:
                configuracionConsultasOficiales();
        }
    }

    private void configuracionAltasOficiales() {
        setTitle("Teatro Pleasantville - Altas Oficiales");
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(e -> guardarOficial());
        habilitarCampos(true);
        txtIdOficial.setEnabled(false);
    }

    private void configuracionBajasOficiales() {
        setTitle("Teatro Pleasantville - Baja de Oficial");
        btnGuardar.setText("Eliminar");
        btnGuardar.addActionListener(e -> eliminarOficial());
        habilitarCampos(false);
        txtIdOficial.setEnabled(true);
        txtIdOficial.addActionListener(e -> buscarOficial());
    }

    private void configuracionCambiosOficiales() {
        setTitle("Teatro Pleasantville - Modificar Oficial");
        btnGuardar.setText("Actualizar");
        btnGuardar.addActionListener(e -> actualizarOficial());
        habilitarCampos(false);
        txtIdOficial.setEnabled(true);
        txtIdOficial.addActionListener(e -> {
            buscarOficial();
            if (!txtIdMiembro.getText().isEmpty()) {
                habilitarCampos(true);
            }
        });
    }

    private void configuracionConsultasOficiales() {
        setTitle("Teatro Pleasantville - Consultar Oficial");
        btnGuardar.setText("Buscar");
        btnGuardar.addActionListener(e -> buscarOficial());
        habilitarCampos(false);
        txtIdOficial.setEnabled(true);
    }

    private void guardarOficial() {
        if (validarCampos()) {
            try {
                String idOficial = String.format("%08d", (int) (Math.random() * 100000000));
                txtIdOficial.setText(idOficial);

                Oficiales oficial = crearOficialDesdeCampos(idOficial);
                if (oficialesDAO.agregarOficiales(oficial)) {
                    JOptionPane.showMessageDialog(this, "Oficial registrado con éxito");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al registrar oficial", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido (use yyyy-MM-dd)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        cargarDatos();
    }

    private void eliminarOficial() {
        String idOficial = txtIdOficial.getText();
        if (txtIdOficial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID");
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este oficial?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (oficialesDAO.eliminarOficial(idOficial)) {
                JOptionPane.showMessageDialog(this, "Oficial eliminado con éxito");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar oficial", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        cargarDatos();
    }

    private void actualizarOficial() {
        try {
            String idOficial = txtIdOficial.getText().trim();
            Oficiales oficial = crearOficialDesdeCampos(idOficial);
            if (oficialesDAO.editarOficiales(oficial)) {
                JOptionPane.showMessageDialog(this, "Oficial actualizado con éxito");
                limpiarCampos();
                habilitarCampos(false);
                txtIdOficial.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar oficial", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido (use yyyy-MM-dd)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarDatos();
    }

    private void buscarOficial() {
        String idOficial = txtIdOficial.getText();
        if (idOficial.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el id");
            return;
        }
        btnGuardar.setEnabled(false);
        SwingWorker<Oficiales, Void> worker = new SwingWorker<Oficiales, Void>() {
            @Override
            protected Oficiales doInBackground() throws Exception {
                return oficialesDAO.mostrarOficiales(idOficial);
            }

            @Override
            protected void done() {
                try {
                    Oficiales oficial = get();
                    if (oficial != null) {
                        llenarCamposDesdeOficial(oficial);
                    } else {
                        JOptionPane.showMessageDialog(vistaOficiales.this, "Oficial no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                        limpiarCampos();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(vistaOficiales.this, "Error al buscar oficial: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                } finally {
                    btnGuardar.setEnabled(true);
                }
            }
        };
        worker.execute();
    }

    private Oficiales crearOficialDesdeCampos(String idOficial) throws ParseException {
        String idMiembro = txtIdMiembro.getText();
        String cargo = txtCargo.getText();
        Date fechaInicio = formato.parse(txtFechaInicio.getText());
        Date fechaFin = formato.parse(txtFechaFin.getText());

        return new Oficiales(idOficial, idMiembro, cargo, fechaInicio, fechaFin);
    }

    private void llenarCamposDesdeOficial(Oficiales oficial) {
        txtIdOficial.setText(oficial.getIdOficial());
        txtIdMiembro.setText(oficial.getIdMiembro() != null ? oficial.getIdMiembro() : "");
        txtCargo.setText(oficial.getCargo() != null ? oficial.getCargo() : "");
        txtFechaInicio.setText(oficial.getFechaInicio() != null ? formato.format(oficial.getFechaInicio()) : "");
        txtFechaFin.setText(oficial.getFechaFin() != null ? formato.format(oficial.getFechaFin()) : "");
    }

    private void agregarComponentes(JComponent component, int gridx, int gridy) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, gbc);
    }

    private void habilitarCampos(boolean habilitar) {
        txtIdMiembro.setEnabled(habilitar);
        txtCargo.setEnabled(habilitar);
        txtFechaInicio.setEnabled(habilitar);
        txtFechaFin.setEnabled(habilitar);
    }

    private void limpiarCampos() {
        txtIdOficial.setText("");
        txtIdMiembro.setText("");
        txtCargo.setText("");
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
    }

    private boolean validarCampos() {
        if (txtIdMiembro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID del miembro es obligatorio");
            return false;
        }

        if (txtCargo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El cargo es obligatorio");
            return false;
        }

        if (txtFechaInicio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha de inicio es obligatoria");
            return false;
        }

        if (txtFechaFin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha de fin es obligatoria");
            return false;
        }

        try {
            Date inicio = formato.parse(txtFechaInicio.getText());
            Date fin = formato.parse(txtFechaFin.getText());
            if (fin.before(inicio)) {
                JOptionPane.showMessageDialog(this, "La fecha de fin debe ser posterior a la fecha de inicio");
                return false;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido (use yyyy-MM-dd)");
            return false;
        }

        return true;
    }

    private void crearTablaOficiales() {
        String[] columnas = {"ID Oficial", "ID Miembro", "Cargo", "Fecha Inicio", "Fecha Fin"};

        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaOficiales = new JTable(modeloTabla);
        tablaOficiales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(tablaOficiales);
        scrollPane.setPreferredSize(new Dimension(800, 200));

        panelMain.add(scrollPane, BorderLayout.SOUTH);

        cargarDatos();
    }

    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        List<Oficiales> oficiales = oficialesDAO.obtenerTodosOficiales();
        if (oficiales != null) {
            for (Oficiales oficial : oficiales) {
                Object[] fila = {
                        oficial.getIdOficial(),
                        oficial.getIdMiembro(),
                        oficial.getCargo(),
                        formato.format(oficial.getFechaInicio()),
                        oficial.getFechaFin() != null ? formato.format(oficial.getFechaFin()) : "N/A"
                };
                modeloTabla.addRow(fila);
            }
        }
    }

    private void agregarEtiquetas(String texto, int gridx, int gridy) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setFont(new Font("Courier New", Font.BOLD, 15));
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        panel.add(etiqueta, gbc);
    }
}
