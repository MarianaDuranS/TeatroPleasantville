package conexion;

import java.sql.*;

 class ConexionBD {

    private Connection conexion;
    private static ConexionBD objetoConexion;
    private Statement stm;  //PreparedStatement ES MEJOR YA QUE EVITA SQL Injection
    private ResultSet rs;

    public static ConexionBD getobjetoConexion(){
        if (objetoConexion==null){
            return objetoConexion=new ConexionBD();
        }else {
            return objetoConexion;
        }
    }

    private ConexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                                    //127.0.0.1
            String URL = "jdbc:mysql://localhost:3306/BD_Topicos_2025";
            conexion = DriverManager.getConnection(URL, "salvatore", "salvatore");

            System.out.println("YEEEEI Casi son ingeniera/o INMORTAL !!!!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error en el connector/driver");
        } catch (SQLException e) {
           e.printStackTrace();
            System.out.println("Error en la conexion a MySQL");
        }
    }

    //CRUD - Create Read Update Delete
    //Metodo para los proces de ABC (altas, bajas y cambios)
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

    //Metodo para CONSULTAS
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
        System.out.println("Magia magia con INTELLIJ");
        new ConexionBD();
    }

}
