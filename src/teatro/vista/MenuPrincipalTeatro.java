package teatro.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPrincipalTeatro extends JFrame{

     JPanel panelMain;
    JMenu menuOpcionesAsientos,menuOpcionesBoletos,menuOpcionesDirecciones,menuOpcionesFinancieros,menuOpcionesFunciones,
            menuOpcionesMiembros,menuOpcionesObras,menuOpcionesOficiales,menuOpcionesPatrocinadores,menuOpcionesPatronos,
            menuOpcionesProducciones;
    JMenuItem itemAltasAsientos,itemAltasBoletos,itemAltasDirecciones,itemAltasFinancieros,itemAltasFunciones,itemAltasMiembros,
    itemAltasObras,itemAltasOficiales,itemAltasPatrocinadores,itemAltasPatronos,itemAltasProducciones;
    JMenuItem itemBajasAsientos,itemBajasBoletos,itemBajasDirecciones,itemBajasFinancieros,itemBajasFunciones,itemBajasMiembros,
            itemBajasObras,itemBajasOficiales,itemBajasPatrocinadores,itemBajasPatronos,itemBajasProducciones;
    JMenuItem itemCambiosAsientos,itemCambiosBoletos,itemCambiosDirecciones,itemCambiosFinancieros,itemCambiosFunciones,itemCambiosMiembros,
            itemCambiosObras,itemCambiosOficiales,itemCambiosPatrocinadores,itemCambiosPatronos,itemCambiosProducciones;
    JMenuItem itemConsultasAsientos,itemConsultasBoletos,itemConsultasDirecciones,itemConsultasFinancieros,itemConsultasFunciones,itemConsultasMiembros,
            itemConsultasObras,itemConsultasOficiales,itemConsultasPatrocinadores,itemConsultasPatronos,itemConsultasProducciones;


    public MenuPrincipalTeatro(){
        setTitle("Teatro Pleasantville - Menu Principal");
        setSize(850, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panelMain= new JPanel();
        panelMain.setLayout(new BorderLayout());

        ImageIcon fondoImagen = new ImageIcon(getClass().getResource("/teatro/imagenes/fondoTeatro.jpg"));
        JLabel lblFondo = new JLabel(fondoImagen);
        lblFondo.setHorizontalAlignment(JLabel.CENTER);
        lblFondo.setVerticalAlignment(JLabel.CENTER);
        panelMain.add(lblFondo, BorderLayout.CENTER);

        add(panelMain);

        JMenuBar menuBar= new JMenuBar();
        menuBar.setBackground(new Color(00, 149, 236));
        //Opciones Asientos
        menuOpcionesAsientos= new JMenu("Asientos");
        menuBar.add(menuOpcionesAsientos);

        itemAltasAsientos = new JMenuItem("Altas Asientos");
        itemAltasAsientos.addActionListener(this::seleccionMenuAsientos);
        menuOpcionesAsientos.add(itemAltasAsientos);

        itemBajasAsientos= new JMenuItem("Bajas Asientos");
        itemBajasAsientos.addActionListener(this::seleccionMenuAsientos);
        menuOpcionesAsientos.add(itemBajasAsientos);

        itemCambiosAsientos= new JMenuItem("Cambios Asientos");
        itemCambiosAsientos.addActionListener(this::seleccionMenuAsientos);
        menuOpcionesAsientos.add(itemCambiosAsientos);

        itemConsultasAsientos= new JMenuItem("Consultas Asientos");
        itemConsultasAsientos.addActionListener(this::seleccionMenuAsientos);
        menuOpcionesAsientos.add(itemConsultasAsientos);

        //Opciones Boletos

        menuOpcionesBoletos= new JMenu("Boletos");
        menuBar.add(menuOpcionesBoletos);

        itemAltasBoletos = new JMenuItem("Altas Boletos");
        itemAltasBoletos.addActionListener(this::seleccionMenuBoletos);
        menuOpcionesBoletos.add(itemAltasBoletos);

        itemBajasBoletos= new JMenuItem("Bajas Boletos");
        itemBajasBoletos.addActionListener(this::seleccionMenuBoletos);
        menuOpcionesBoletos.add(itemBajasBoletos);

        itemCambiosBoletos= new JMenuItem("Cambios Boletos");
        itemCambiosBoletos.addActionListener(this::seleccionMenuBoletos);
        menuOpcionesBoletos.add(itemCambiosBoletos);

        itemConsultasBoletos= new JMenuItem("Consultas Boletos");
        itemConsultasBoletos.addActionListener(this::seleccionMenuBoletos);
        menuOpcionesBoletos.add(itemConsultasBoletos);

        //Opciones Direcciones
        menuOpcionesDirecciones= new JMenu("Direcciones");
        menuBar.add(menuOpcionesDirecciones);

        itemAltasDirecciones= new JMenuItem("Altas Direcciones");
        itemAltasDirecciones.addActionListener(this::seleccionMenuDirecciones);
        menuOpcionesDirecciones.add(itemAltasDirecciones);

        itemBajasDirecciones= new JMenuItem("Bajas Direcciones");
        itemBajasDirecciones.addActionListener(this::seleccionMenuDirecciones);
        menuOpcionesDirecciones.add(itemBajasDirecciones);

        itemCambiosDirecciones= new JMenuItem("Cambios Direcciones");
        itemCambiosDirecciones.addActionListener(this::seleccionMenuDirecciones);
        menuOpcionesDirecciones.add(itemCambiosDirecciones);

        itemConsultasDirecciones= new JMenuItem("Consultas Direcciones");
        itemConsultasDirecciones.addActionListener(this::seleccionMenuDirecciones);
        menuOpcionesDirecciones.add(itemConsultasDirecciones);

        //Opciones Financieros
        menuOpcionesFinancieros= new JMenu("Financieros");
        menuBar.add(menuOpcionesFinancieros);

        itemAltasFinancieros= new JMenuItem("Altas Financieros");
        itemAltasFinancieros.addActionListener(this::seleccionMenuFinancieros);
        menuOpcionesFinancieros.add(itemAltasFinancieros);

        itemBajasFinancieros= new JMenuItem("Bajas Financieros");
        itemBajasFinancieros.addActionListener(this::seleccionMenuFinancieros);
        menuOpcionesFinancieros.add(itemBajasFinancieros);

        itemCambiosFinancieros= new JMenuItem("Cambios Financieros");
        itemCambiosFinancieros.addActionListener(this::seleccionMenuFinancieros);
        menuOpcionesFinancieros.add(itemCambiosFinancieros);

        itemConsultasFinancieros= new JMenuItem("Consultas Financieros");
        itemConsultasFinancieros.addActionListener(this::seleccionMenuFinancieros);
        menuOpcionesFinancieros.add(itemConsultasFinancieros);

        //Opciones Funciones
        menuOpcionesFunciones= new JMenu("Funciones");
        menuBar.add(menuOpcionesFunciones);

        itemAltasFunciones= new JMenuItem("Altas Funciones");
        itemAltasFunciones.addActionListener(this::seleccionMenuFunciones);
        menuOpcionesFunciones.add(itemAltasFunciones);

        itemBajasFunciones= new JMenuItem("Bajas Funciones");
        itemBajasFunciones.addActionListener(this::seleccionMenuFunciones);
        menuOpcionesFunciones.add(itemBajasFunciones);

        itemCambiosFunciones= new JMenuItem("Cambios Funciones");
        itemCambiosFunciones.addActionListener(this::seleccionMenuFunciones);
        menuOpcionesFunciones.add(itemCambiosFunciones);

        itemConsultasFunciones= new JMenuItem("Consultas Funciones");
        itemConsultasFunciones.addActionListener(this::seleccionMenuFunciones);
        menuOpcionesFunciones.add(itemConsultasFunciones);

        //Opciones Miembros
        menuOpcionesMiembros= new JMenu("Miembros");
        menuBar.add(menuOpcionesMiembros);

        itemAltasMiembros= new JMenuItem("Altas Miembros");
        itemAltasMiembros.addActionListener(this::seleccionMenuMiembros);
        menuOpcionesMiembros.add(itemAltasMiembros);

        itemBajasMiembros= new JMenuItem("Bajas Miembros");
        itemBajasMiembros.addActionListener(this::seleccionMenuMiembros);
        menuOpcionesMiembros.add(itemBajasMiembros);

        itemCambiosMiembros= new JMenuItem("Cambios Miembros");
        itemCambiosMiembros.addActionListener(this::seleccionMenuMiembros);
        menuOpcionesMiembros.add(itemCambiosMiembros);

        itemConsultasMiembros= new JMenuItem("Consultas Miembros");
        itemConsultasMiembros.addActionListener(this::seleccionMenuMiembros);
        menuOpcionesMiembros.add(itemConsultasMiembros);

        //Opciones Obras
        menuOpcionesObras= new JMenu("Obras");
        menuBar.add(menuOpcionesObras);

        itemAltasObras= new JMenuItem("Altas Obras");
        itemAltasObras.addActionListener(this::seleccionMenuObras);
        menuOpcionesObras.add(itemAltasObras);

        itemBajasObras= new JMenuItem("Bajas Obras");
        itemBajasObras.addActionListener(this::seleccionMenuObras);
        menuOpcionesObras.add(itemBajasObras);

        itemCambiosObras= new JMenuItem("Cambios Obras");
        itemCambiosObras.addActionListener(this::seleccionMenuObras);
        menuOpcionesObras.add(itemCambiosObras);

        itemConsultasObras= new JMenuItem("Consultas Obras");
        itemConsultasObras.addActionListener(this::seleccionMenuObras);
        menuOpcionesObras.add(itemConsultasObras);

        //Opciones Oficiales
        menuOpcionesOficiales=new JMenu("Oficiales");
        menuBar.add(menuOpcionesOficiales);

        itemAltasOficiales= new JMenuItem("Altas Oficiales");
        itemAltasOficiales.addActionListener(this::seleccionMenuOficiales);
        menuOpcionesOficiales.add(itemAltasOficiales);

        itemBajasOficiales= new JMenuItem("Bajas Oficiales");
        itemBajasOficiales.addActionListener(this::seleccionMenuOficiales);
        menuOpcionesOficiales.add(itemBajasOficiales);

        itemCambiosOficiales= new JMenuItem("Cambios Oficiales");
        itemCambiosOficiales.addActionListener(this::seleccionMenuOficiales);
        menuOpcionesOficiales.add(itemCambiosOficiales);

        itemConsultasOficiales= new JMenuItem("Consultas Oficiales");
        itemConsultasOficiales.addActionListener(this::seleccionMenuOficiales);
        menuOpcionesOficiales.add(itemConsultasOficiales);

        //Opciones patrocinadores
        menuOpcionesPatrocinadores= new JMenu("Patrocinadores");
        menuBar.add(menuOpcionesPatrocinadores);

        itemAltasPatrocinadores= new JMenuItem("Altas Patrocinadores");
        itemAltasPatrocinadores.addActionListener(this::seleccionMenuPatrocinadores);
        menuOpcionesPatrocinadores.add(itemAltasPatrocinadores);

        itemBajasPatrocinadores= new JMenuItem("Bajas Patrocinadores");
        itemBajasPatrocinadores.addActionListener(this::seleccionMenuPatrocinadores);
        menuOpcionesPatrocinadores.add(itemBajasPatrocinadores);

        itemCambiosPatrocinadores= new JMenuItem("Cambios Patrocinadores");
        itemCambiosPatrocinadores.addActionListener(this::seleccionMenuPatrocinadores);
        menuOpcionesPatrocinadores.add(itemCambiosPatrocinadores);

        itemConsultasPatrocinadores= new JMenuItem("Consultas Patrocinadores");
        itemConsultasPatrocinadores.addActionListener(this::seleccionMenuPatrocinadores);
        menuOpcionesPatrocinadores.add(itemConsultasPatrocinadores);

        //Opciones Patronos
        menuOpcionesPatronos = new JMenu("Patronos");
        menuBar.add(menuOpcionesPatronos);

        itemAltasPatronos= new JMenuItem("Altas Patronos");
        itemAltasPatronos.addActionListener(this::seleccionMenuPatronos);
        menuOpcionesPatronos.add(itemAltasPatronos);

        itemBajasPatronos= new JMenuItem("Bajas Patronos");
        itemBajasPatronos.addActionListener(this::seleccionMenuPatronos);
        menuOpcionesPatronos.add(itemBajasPatronos);

        itemCambiosPatronos= new JMenuItem("Cambios Patronos");
        itemCambiosPatronos.addActionListener(this::seleccionMenuPatronos);
        menuOpcionesPatronos.add(itemCambiosPatronos);

        itemConsultasPatronos= new JMenuItem("Consultas Patronos");
        itemConsultasPatronos.addActionListener(this::seleccionMenuPatronos);
        menuOpcionesPatronos.add(itemConsultasPatronos);

        //Opciones Producciones
        menuOpcionesProducciones= new JMenu("Producciones");
        menuBar.add(menuOpcionesProducciones);

        itemAltasProducciones= new JMenuItem("Altas Producciones");
        itemAltasProducciones.addActionListener(this::seleccionMenuProducciones);
        menuOpcionesProducciones.add(itemAltasProducciones);

        itemBajasProducciones= new JMenuItem("Bajas Producciones");
        itemBajasProducciones.addActionListener(this::seleccionMenuProducciones);
        menuOpcionesProducciones.add(itemBajasProducciones);

        itemCambiosProducciones= new JMenuItem("Cambios Producciones");
        itemCambiosProducciones.addActionListener(this::seleccionMenuProducciones);
        menuOpcionesProducciones.add(itemCambiosProducciones);

        itemConsultasProducciones= new JMenuItem("Consultas Producciones");
        itemConsultasProducciones.addActionListener(this::seleccionMenuProducciones);
        menuOpcionesProducciones.add(itemConsultasProducciones);
        setJMenuBar(menuBar);

    }

    //Metodos asientos
    private void seleccionMenuAsientos(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }

        abrirVistaAsientos(seleccion);

    }
    private void abrirVistaAsientos(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaAsientos vistaAsiento = new vistaAsientos(seleccion);
            vistaAsiento.setVisible(true);
        });
    }
    //Metodos Boletos
    private void seleccionMenuBoletos(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaBoletos(seleccion);
    }
    private void abrirVistaBoletos(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaBoletos vistaBoleto = new vistaBoletos(seleccion);
            vistaBoleto.setVisible(true);
        });
    }
    //Metodos Direcciones
    private void seleccionMenuDirecciones(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaDirecciones(seleccion);
    }
    private void abrirVistaDirecciones(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaDirecciones vistaDireccion = new vistaDirecciones(seleccion);
            vistaDireccion.setVisible(true);
        });
    }
    //Metodos Financieros
    private void seleccionMenuFinancieros(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaFinancieros(seleccion);
    }
    private void abrirVistaFinancieros(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaFinancieros vistaFinanciero = new vistaFinancieros(seleccion);
            vistaFinanciero.setVisible(true);
        });
    }
    //Metodos Funciones
    private void seleccionMenuFunciones(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaFunciones(seleccion);
    }
    private void abrirVistaFunciones(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaFunciones vistaFuncion = new vistaFunciones(seleccion);
            vistaFuncion.setVisible(true);
        });
    }
    //Metodos Miembros
    private void seleccionMenuMiembros(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaMiembros(seleccion);
    }
    private void abrirVistaMiembros(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaMiembros vistaMiembro = new vistaMiembros(seleccion);
            vistaMiembro.setVisible(true);
        });
    }
    //Metodos Obras
    private void seleccionMenuObras(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaObras(seleccion);
    }
    private void abrirVistaObras(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaObras vistaObra = new vistaObras(seleccion);
            vistaObra.setVisible(true);
        });
    }
    //Metodos Oficiales
    private void seleccionMenuOficiales(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaOficiales(seleccion);
    }
    private void abrirVistaOficiales(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaOficiales vistaOficial = new vistaOficiales(seleccion);
            vistaOficial.setVisible(true);
        });
    }
    //Metodos patrocinadores
    private void seleccionMenuPatrocinadores(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaPatrocinadores(seleccion);
    }
    private void abrirVistaPatrocinadores(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaPatrocinadores vistaPatrocinador = new vistaPatrocinadores(seleccion);
            vistaPatrocinador.setVisible(true);
        });
    }
    //Metodos patronos
    private void seleccionMenuPatronos(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaPatronos(seleccion);
    }
    private void abrirVistaPatronos(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaPatronos vistaPatrono = new vistaPatronos(seleccion);
            vistaPatrono.setVisible(true);
        });
    }
    //Metodos producciones
    private void seleccionMenuProducciones(ActionEvent e){
        String accion= e.getActionCommand();
        String seleccion="";

        if (accion.contains("Altas")){
            seleccion="alta";
        } else if (accion.contains("Bajas")) {
            seleccion="baja";
        } else if (accion.contains("Cambios")) {
            seleccion="cambio";
        } else if (accion.contains("Consultas")) {
            seleccion="consulta";
        }
        abrirVistaProducciones(seleccion);
    }
    private void abrirVistaProducciones(String seleccion){
        SwingUtilities.invokeLater(() -> {
            vistaProducciones vistaProduccion = new vistaProducciones(seleccion);
            vistaProduccion.setVisible(true);
        });
    }

    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipalTeatro().setVisible(true);
            }
        });
    }

}
