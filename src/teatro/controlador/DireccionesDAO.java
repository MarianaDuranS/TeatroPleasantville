package teatro.controlador;
import teatro.conexionDB.ConexionBD;
import teatro.modelo.Direcciones;
import java.sql.*;
import javax.swing.JOptionPane;
public class DireccionesDAO {
    private Connection conexion;
    public DireccionesDAO(){
      ConexionBD.getobjetoConexion();
    }


    public boolean agregarDireccion(Direcciones direcciones) {
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO direcciones (Id_Direccion,Numero_Casa,Calle,Colonia,Ciudad,Estado,Codigo_Postal,Telefono)VALUES (?,?,?,?,?,?,?,?)";
            statement = conexion.prepareStatement(sql);

            statement.setString(1, direcciones.getIdDireccion());
            statement.setString(2,direcciones.getNumeroCasa());
            statement.setString(3,direcciones.getCalle());
            statement.setString(4,direcciones.getColonia());
            statement.setString(5,direcciones.getCiudad());
            statement.setString(6,direcciones.getEstado());
            statement.setString(7,direcciones.getCodigoPostal());
            statement.setString(8,direcciones.getTelefono());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar direccion: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }

    public boolean editarDireccion(Direcciones direcciones){
        PreparedStatement statement= null;

        try {
          String sql= "UPDATE direcciones SET Numero_Casa=?,Calle=?,Colonia=?,Ciudad=?,Estado=?,Codigo_Postal=?,Telefono=? WHERE Id_Direccion=?";
          statement= conexion.prepareStatement(sql);


            statement.setString(1,direcciones.getNumeroCasa());
            statement.setString(2,direcciones.getCalle());
            statement.setString(3,direcciones.getColonia());
            statement.setString(4,direcciones.getCiudad());
            statement.setString(5,direcciones.getEstado());
            statement.setString(6,direcciones.getCodigoPostal());
            statement.setString(7,direcciones.getTelefono());
            statement.setString(8, direcciones.getIdDireccion());
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar direccion: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }

    public boolean eliminarDireccion(String idDireccion){
        if (direccionEnUso(idDireccion)) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar: La dirección está asociada a un miembro.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM direcciones WHERE Id_Direccion=?";
            statement = conexion.prepareStatement(sql);

            statement.setString(1, idDireccion);
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar dirección: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }
    private boolean direccionEnUso(String idDireccion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT COUNT(*) FROM miembros WHERE Id_Direccion = ?";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, idDireccion);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
            return false;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar direccion: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return true;
        } finally {
            cerrarRecursos(statement, resultSet);
        }
    }


    public Direcciones mostrarDireccion(String idDireccion){
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Direcciones direcciones = null;
        try {
            String sql = "SELECT * FROM Direcciones WHERE Id_Direccion = ?";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, idDireccion);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                direcciones = crearDireccionDesdeResultSet(resultSet);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar direccion: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            cerrarRecursos(statement, resultSet);
        }
        return direcciones;
    }

    private Direcciones crearDireccionDesdeResultSet(ResultSet rs) throws SQLException{
        return new Direcciones(
          rs.getString("Id_Direccion"), rs.getString("Numero_Casa"),
                rs.getString("Calle"), rs.getString("Colonia"),
                rs.getString("Ciudad"), rs.getString("Estado"),
                rs.getString("Codigo_Postal"),rs.getString("Telefono")
        );
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
