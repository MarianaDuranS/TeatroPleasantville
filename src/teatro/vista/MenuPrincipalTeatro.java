package teatro.vista;

import javax.swing.*;
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

        JMenuBar menuBar= new JMenuBar();

        //Opciones Asientos
        menuOpcionesAsientos= new JMenu("Asientos");
        menuBar.add(menuOpcionesAsientos);

        itemAltasAsientos = new JMenuItem("Altas Asientos");
        //agregar manejo de menu para asientos en cualquier ABCC
        menuOpcionesAsientos.add(itemAltasAsientos);
        itemBajasAsientos= new JMenuItem("Bajas Asientos");
        menuOpcionesAsientos.add(itemBajasAsientos);
        itemCambiosAsientos= new JMenuItem("Cambios Asientos");
        menuOpcionesAsientos.add(itemCambiosAsientos);
        itemConsultasAsientos= new JMenuItem("Consultas Asientos");
        menuOpcionesAsientos.add(itemConsultasAsientos);

        //Opciones Boletos

        menuOpcionesBoletos= new JMenu("Boletos");
        menuBar.add(menuOpcionesBoletos);
        itemAltasBoletos = new JMenuItem("Altas Boletos");
        //agregar manejo de menu para boletos en cualquier ABCC
        menuOpcionesBoletos.add(itemAltasBoletos);
        itemBajasBoletos= new JMenuItem("Bajas Boletos");
        menuOpcionesBoletos.add(itemBajasBoletos);
        itemCambiosBoletos= new JMenuItem("Cambios Boletos");
        menuOpcionesBoletos.add(itemCambiosBoletos);
        itemConsultasBoletos= new JMenuItem("Consultas Boletos");
        menuOpcionesBoletos.add(itemConsultasBoletos);

        //Opciones Direcciones
        menuOpcionesDirecciones= new JMenu("Direcciones");
        menuBar.add(menuOpcionesDirecciones);
        itemAltasDirecciones= new JMenuItem("Altas Direcciones");
        //agregar manejo de menu para direcciones en cualquier ABCC
        menuOpcionesDirecciones.add(itemAltasDirecciones);
        itemBajasDirecciones= new JMenuItem("Bajas Direcciones");
        menuOpcionesDirecciones.add(itemBajasDirecciones);
        itemCambiosDirecciones= new JMenuItem("Cambios Direcciones");
        menuOpcionesDirecciones.add(itemCambiosDirecciones);
        itemConsultasDirecciones= new JMenuItem("Consultas Direcciones");
        menuOpcionesDirecciones.add(itemConsultasDirecciones);

        //Opciones Financieros
        menuOpcionesFinancieros= new JMenu("Financieros");
        menuBar.add(menuOpcionesFinancieros);
        itemAltasFinancieros= new JMenuItem("Altas Financieros");
        //agregar manejo de menu para financieros en cualquier ABCC
        menuOpcionesFinancieros.add(itemAltasFinancieros);
        itemBajasFinancieros= new JMenuItem("Bajas Financieros");
        menuOpcionesFinancieros.add(itemBajasFinancieros);
        itemCambiosFinancieros= new JMenuItem("Cambios Financieros");
        menuOpcionesFinancieros.add(itemCambiosFinancieros);
        itemConsultasFinancieros= new JMenuItem("Consultas Financieros");
        menuOpcionesFinancieros.add(itemConsultasFinancieros);
        //Opciones Funciones
        menuOpcionesFunciones= new JMenu("Funciones");
        menuBar.add(menuOpcionesFunciones);
        itemAltasFunciones= new JMenuItem("Altas Funciones");
        //agregar manejo de menu para funciones en cualquier ABCC
        menuOpcionesFunciones.add(itemAltasFunciones);
        itemBajasFunciones= new JMenuItem("Bajas Funciones");
        menuOpcionesFunciones.add(itemBajasFunciones);
        itemCambiosFunciones= new JMenuItem("Cambios Funciones");
        menuOpcionesFunciones.add(itemCambiosFunciones);
        itemConsultasFunciones= new JMenuItem("Consultas Funciones");
        menuOpcionesFunciones.add(itemConsultasFunciones);

        //Opciones Miembros
        menuOpcionesMiembros= new JMenu("Miembros");
        menuBar.add(menuOpcionesMiembros);
        itemAltasMiembros= new JMenuItem("Altas Miembros");
        //agregar manejo de menu para miembros en cualquier ABCC
        menuOpcionesMiembros.add(itemAltasMiembros);
        itemBajasMiembros= new JMenuItem("Bajas Miembros");
        menuOpcionesMiembros.add(itemBajasMiembros);
        itemCambiosMiembros= new JMenuItem("Cambios Miembros");
        menuOpcionesMiembros.add(itemCambiosMiembros);
        itemConsultasMiembros= new JMenuItem("Consultas Miembros");
        menuOpcionesMiembros.add(itemConsultasMiembros);

        //Opciones Obras
        menuOpcionesObras= new JMenu("Obras");
        menuBar.add(menuOpcionesObras);
        itemAltasObras= new JMenuItem("Altas Obras");
        //agregar manejo de menu para Obras en cualquier ABCC
        menuOpcionesObras.add(itemAltasObras);
        itemBajasObras= new JMenuItem("Bajas Obras");
        menuOpcionesObras.add(itemBajasObras);
        itemCambiosObras= new JMenuItem("Cambios Obras");
        menuOpcionesObras.add(itemCambiosObras);
        itemConsultasObras= new JMenuItem("Consultas Obras");
        menuOpcionesObras.add(itemConsultasObras);
        //Opciones Oficiales
        menuOpcionesOficiales=new JMenu("Oficiales");
        menuBar.add(menuOpcionesOficiales);

        itemAltasOficiales= new JMenuItem("Altas Oficiales");
        //agregar manejo de menu para oficiales en cualquier ABCC
        menuOpcionesOficiales.add(itemAltasOficiales);
        itemBajasOficiales= new JMenuItem("Bajas Oficiales");
        menuOpcionesOficiales.add(itemBajasOficiales);
        itemCambiosOficiales= new JMenuItem("Cambios Oficiales");
        menuOpcionesOficiales.add(itemCambiosOficiales);
        itemConsultasOficiales= new JMenuItem("Consultas Oficiales");
        menuOpcionesOficiales.add(itemConsultasOficiales);

        //Opciones patrocinadores
        menuOpcionesPatrocinadores= new JMenu("Patrocinadores");
        menuBar.add(menuOpcionesPatrocinadores);

        itemAltasPatrocinadores= new JMenuItem("Altas Patrocinadores");
        //agregar manejo de menu para asientos en patrocinadores ABCC
        menuOpcionesPatrocinadores.add(itemAltasPatrocinadores);
        itemBajasPatrocinadores= new JMenuItem("Bajas Patrocinadores");
        menuOpcionesPatrocinadores.add(itemBajasPatrocinadores);
        itemCambiosPatrocinadores= new JMenuItem("Cambios Patrocinadores");
        menuOpcionesPatrocinadores.add(itemCambiosPatrocinadores);
        itemConsultasPatrocinadores= new JMenuItem("Consultas Patrocinadores");
        menuOpcionesPatrocinadores.add(itemConsultasPatrocinadores);

        //Opciones Patronos
        menuOpcionesPatronos = new JMenu("Patronos");
        menuBar.add(menuOpcionesPatronos);

        itemAltasPatronos= new JMenuItem("Altas Patronos");
        //agregar manejo de menu para patronos en cualquier ABCC
        menuOpcionesPatronos.add(itemAltasPatronos);
        itemBajasPatronos= new JMenuItem("Bajas Patronos");
        menuOpcionesPatronos.add(itemBajasPatronos);
        itemCambiosPatronos= new JMenuItem("Cambios Patronos");
        menuOpcionesPatronos.add(itemCambiosPatronos);
        itemConsultasPatronos= new JMenuItem("Consultas Patronos");
        menuOpcionesPatronos.add(itemConsultasPatronos);

        //Opciones Producciones
        menuOpcionesProducciones= new JMenu("Producciones");
        menuBar.add(menuOpcionesProducciones);

        itemAltasProducciones= new JMenuItem("Altas Producciones");
        //agregar manejo de menu para producciones en cualquier ABCC
        menuOpcionesProducciones.add(itemAltasProducciones);
        itemBajasProducciones= new JMenuItem("Bajas Producciones");
        menuOpcionesProducciones.add(itemBajasProducciones);
        itemCambiosProducciones= new JMenuItem("Cambios Producciones");
        menuOpcionesProducciones.add(itemCambiosProducciones);
        itemConsultasProducciones= new JMenuItem("Consultas Producciones");
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

    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipalTeatro().setVisible(true);
            }
        });
    }

}
