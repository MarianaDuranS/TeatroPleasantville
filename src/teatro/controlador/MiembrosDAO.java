package teatro.controlador;
import teatro.conexionDB.conexionBD;
import teatro.modelo.Miembros;
import javax.swing.*;
import java.sql.*;
public class MiembrosDAO {
    private Connection conexion;

    public MiembrosDAO() {
        this.conexion=conexionBD.getInstancia().getConexion();
    }

    public boolean agregarMiembro(Miembros miembro) {
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO miembros (Id_Miembro, Nombre, Primer_Apellido, Segundo_Apellido,Fecha_Nacimiento, Genero, Email, Estado_Cuota, Id_Direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conexion.prepareStatement(sql);

            statement.setString(1, miembro.getIdMiembro());
            statement.setString(2,miembro.getNombre());
            statement.setString(3,miembro.getPrimerApellido());
            statement.setString(4,miembro.getSegundoApellido());
            statement.setDate(5, new java.sql.Date(miembro.getFechaNacimiento().getTime()));
            statement.setString(6,miembro.getGenero());
            statement.setString(7,miembro.getEmail());
            statement.setString(8,miembro.getEstadoCuota());
            statement.setString(9,miembro.getIdDireccion());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar miembro: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }

    public boolean editarMiembro(Miembros miembro) {
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE miembros SET Nombre=?, Primer_Apellido=?, Segundo_Apellido=?,Fecha_Nacimiento=?, Genero=?, Email=?, Estado_Cuota=?, Id_Direccion=? WHERE Id_Miembro=?";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, miembro.getNombre());
            statement.setString(2, miembro.getPrimerApellido());
            statement.setString(3, miembro.getSegundoApellido());
            statement.setDate(4, new java.sql.Date(miembro.getFechaNacimiento().getTime()));
            statement.setString(5, miembro.getGenero());
            statement.setString(6, miembro.getEmail());
            statement.setString(7, miembro.getEstadoCuota());
            statement.setString(8, miembro.getIdDireccion());
            statement.setString(9, miembro.getIdMiembro());
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar miembro: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }

    public boolean eliminarMiembro(String idMiembro) {
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM miembros WHERE Id_Miembro=?";
            statement = conexion.prepareStatement(sql);

            statement.setString(1, idMiembro);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar miembro: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }

    public Miembros mostrarMiembro(String idMiembro) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Miembros miembro = null;

        try {
            String sql = "SELECT * FROM miembros WHERE Id_Miembro=?";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, idMiembro);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                miembro = new Miembros(
                        resultSet.getString("Id_Miembro"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Primer_Apellido"),
                        resultSet.getString("Segundo_Apellido"),
                        resultSet.getDate("Fecha_Nacimiento"),
                        resultSet.getString("Genero"),
                        resultSet.getString("Email"),
                        resultSet.getString("Estado_Cuota"),
                        resultSet.getString("Id_Direccion")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar miembro: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            cerrarRecursos(statement, resultSet);
        }
        return miembro;
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
