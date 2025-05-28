package teatro.conexionDB;
import java.sql.*;
public class conexionBD {
    private static conexionBD instancia;
    private Connection conexion;
    private final String URL="jdbc:mysql://localhost:3306/teatro_pleasantville";
    private final String USER = "root";
    private final String PASSWORD = "carmelo";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";


    public conexionBD(){
        conectar();
    }

    public static synchronized conexionBD getInstancia(){
        if (instancia==null){
            instancia= new conexionBD();
        }
        return instancia;
    }

    private void conectar(){
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver JDBC no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar a MySQL");
            e.printStackTrace();
        }
    }

    public boolean ejecutarInstruccionLMD(String sql){
        try (Statement stm = conexion.createStatement()) {
            return stm.executeUpdate(sql) >= 1;
        } catch (SQLException e) {
            System.err.println("Error en ejecución LMD: " + e.getMessage());
            return false;
        }
    }


    //metodo para consultas

    public ResultSet ejecutarInstruccionSQL(String sql){
        try {
            Statement stm = conexion.createStatement();
            return stm.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Error en ejecución SQL: " + e.getMessage());
            return null;
        }
    }
    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexión");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Magia magia con INTELLI");
        new conexionBD();

    }
}
