package SQL;

import java.sql.*;

/**
 *
 * @author jimmy
 */
public class ConexionBD {
    
    //Atributos
    private static final String URL = "jdbc:mysql://127.0.0.1:3306:3306/bd_login"; //127.0.0.1:3306 = localhost
    private static final String USUARIO = "root";
    private static final String PASS = "";
    
    
//    private static Connection conexion;
//    private static PreparedStatement sentenciaPreparada;
//    private static ResultSet resultado;
    
    //Metodos
    
    /**
     * Connect to the DDBB
     * @return 
     */
    public static Connection conectar(){
        
        Connection conexion = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, PASS);
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+ e);
        }
        return conexion;
    }
    
//    public static void main(String[] args) {
//        
//        try {
//            conexion = conectar();
//            
//            String consulta = "INSERT INTO usuarios (dni, nombre, apellidos, contrasena, usuario_automatico) VALUES ('abc','manuel','gonza','123','abc@empresa.com')";
//            
//            sentenciaPreparada = conexion.prepareStatement(consulta);
//            
//            int i = sentenciaPreparada.executeUpdate();
//            
//            if (i > 0){
//                System.out.println("Carga exitosa");
//            }
//            else{
//                System.out.println("Carga Fallida");
//            }
//            
//            conexion.close();
//        } 
//        catch (SQLException e) {
//            System.out.println("Error: "+e);
//        }
//    }
}
