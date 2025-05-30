package teatro.conexionDB;
import java.sql.*;

public class ConexionBD {
    private Connection conexion;
    private static ConexionBD objetoConexion;
    private PreparedStatement stm;
    private ResultSet rs;

    public static ConexionBD getobjetoConexion(){
        if (objetoConexion==null){
            return objetoConexion=new ConexionBD();
        }else {
            return objetoConexion;
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    private ConexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //127.0.0.1
            String URL = "jdbc:mysql://localhost:3306/teatro_pleasantville";
            conexion = DriverManager.getConnection(URL, "root", "carmelo");

            System.out.println("YEEEEI Casi son ingeniera/o INMORTAL !!!!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error en el connector/driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexion a MySQL");
        }
    }

    public boolean ejecutarInstruccionLMD(String sql) {
        boolean res = false;
        try {
            stm = conexion.prepareStatement(sql);
            int rowsAffected = stm.executeUpdate(); // Cambia a stm.executeUpdate()
            if (rowsAffected >= 1) {
                res = true;
            }
        } catch (SQLException e) {
            System.out.println("Error en la ejecución de la instrucción SQL: " + e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

    //Metodo para CONSULTAS
    public ResultSet ejecutarInstruccionSQL(String sql) {
        rs = null;
        System.out.println("SQL => " + sql);
        try {
            stm = conexion.prepareStatement(sql);
            rs = stm.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la instruccion SQL");
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println("Magia magia con INTELLIJ");
        new ConexionBD();
    }
}
