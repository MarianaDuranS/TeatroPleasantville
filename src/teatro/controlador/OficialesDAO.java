package teatro.controlador;
import teatro.conexionDB.conexionBD
import teatro.modelo.Miembros;
import teatro.modelo.Oficiales;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OficialesDAO {
    private Connection conexion;

    public OficialesDAO(){
        this.conexion=conexionBD.getInstancia().getConexion();
    }

    public boolean agregarOficiales(Oficiales oficiales) {
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO oficiales (Id_Oficiales, Id_Miembro, cargo,Fecha_Inicio, Fecha_Fin) VALUES (?, ?, ?, ?, ?,?)";
            statement = conexion.prepareStatement(sql);

            statement.setString(1, oficiales.getIdOficial());
            statement.setString(2,oficiales.getIdNombre());
            statement.setString(3,oficiales.cargo());
            statement.setDate(4, new java.sql.Date(oficiales.getFechaInicio().getTime()));
            statement.setDate(4, new java.sql.Date(oficiales.getFechaFin().getTime()));

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar oficial: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }

    public boolean editarOficiales(Oficiales oficiales) {
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE oficiales SET Id_Miembro=?,cargo=?,Fecha_Inicio=?,Fecha_Fin=? WHERE Id_Oficiales=?";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, oficiales.getIdMiembro());
            statement.setString(2, oficiales.getCargo());
            statement.setDate(3, new java.sql.Date(oficiales.getFechaInicio).getTime()));
            statement.setDate(4, new java.sql.Date(oficiales.getFechaFin().getTime()));
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar Oficial: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }

    public boolean eliminarOficial(String idOficiales) {
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM oficiales WHERE Id_Oficiales=?";
            statement = conexion.prepareStatement(sql);

            statement.setString(1, idOficiales);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Oficial: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }

    public Miembros mostrarOficiales(String idMiembro) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Oficiales oficial = null;

        try {
            String sql = "SELECT * FROM oficiales WHERE Id_Oficiales=?";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, idMiembro);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                oficial = new Oficiales(
                        resultSet.getString("Id_Oficiales"),
                        resultSet.getString("Id_Miembro"),
                        resultSet.getString("Cargo"),
                        resultSet.getDate("Fecha_Inicio"),
                        resultSet.getDate("Fecha_Fin"),
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar Oficial: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            cerrarRecursos(statement, resultSet);
        }
        return oficial;
    }

    public List<Oficiales> obtenerTodosOficiales() {
        List<Oficiales> oficiales = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM oficiales";
            statement = conexion.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Oficiales oficiales = new Oficiales(
                        resultSet.getString("Id_Oficiales"),
                        resultSet.getString("Id_Miembro"),
                        resultSet.getString("Cargo"),
                        resultSet.getDate("Fecha_Inicio"),
                        resultSet.getDate("Fecha_Fin"),
                );
                oficiales.add(oficiales);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener oficiales: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }finally {
            cerrarRecursos(statement, resultSet);
        }

        return oficiales;
    }

    private void cerrarRecursos(Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
