package teatro.conexionDB;
import java.sql.*;
public class conexionBD {
    private Connection conexion;
    private Statement stm;
    private ResultSet rs;

    public conexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL="jdbc:mysql://localhost:3306/bd_topicos_2025";
            conexion=DriverManager.getConnection(URL,"root","carmelo");

            System.out.println("YEYYY");

        } catch (ClassNotFoundException e) {
            System.out.println("Error en el conector/driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexion a mysql");

        }
    }
    //Metodo para los procesos de ABC altas bajas cambios y consultas

    public boolean ejecutarInstruccionLMD(String sql){
        boolean res = false;
        try {
            stm = conexion.createStatement();
            if(stm.executeUpdate(sql) >=1)
                res = true;
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la instruccion SQL");
        }
        return res;
    }


    //metodo para consultas

    public ResultSet ejecutarInstruccionSQL(String sql){
        rs = null;
        System.out.println("SQL => " + sql);
        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la instruccion SQL");
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println("Magia magia con INTELLI");
        new conexionBD();

    }
}
