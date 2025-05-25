package teatro.controlador;
import teatro.modelo.Direcciones;
import java.sql.*;
import javax.swing.JOptionPane;
public class DireccionesDAO {
    private Connection conexion;
    private final String url = "jdbc:mysql://localhost:3306/teatro_pleasantville";
    private final String user = "root";
    private final String contra = "carmelo";
    private final String driver = "com.mysql.cj.jdbc.Driver";

    public DireccionesDAO(){
        establecerConexion();
    }

    private void establecerConexion() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, contra);
            if (conexion != null) {
                System.out.println("Conexión a la base de datos exitosa.");
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador JDBC.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            conexion = null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage(), "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            conexion = null;
        }
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
            JOptionPane.showMessageDialog(null, "Error al editar direccion: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            cerrarRecursos(statement, null);
        }
    }

    public boolean eliminarDireccion(String idDireccion){
    PreparedStatement statement= null;
    try {
        String sql= "DELETE FROM direcciones WHERE Id_Direccion=?";
        statement = conexion.prepareStatement(sql);
        statement.setString(1,idDireccion);
        int filasAfectadas = statement.executeUpdate();
        return filasAfectadas > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar direccion: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
        return false;
    } finally {
        cerrarRecursos(statement, null);
    }
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
