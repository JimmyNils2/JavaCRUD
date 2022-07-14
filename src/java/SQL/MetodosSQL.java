package SQL;

import java.sql.*;

/**
 *
 * @author jimmy
 */
public class MetodosSQL {
    
    //Atributos
    private Connection conexion;
    private PreparedStatement sentenciaPreparada;
    private ResultSet resultado;
    
    /**
     * Registra usuarios mediante una consulta SQL
     * @param dni celda dni
     * @param nombre celda nombre
     * @param apellidos celda apellidos
     * @param contrasena celda contrasena
     * @param usuarioAutomatico celda usuarioAutomatico
    */
    public boolean registrarUsuario(String dni, String nombre, String apellidos, String contrasena, String usuarioAutomatico){
        
        boolean registro = false;
        
        try {
            
            //Invoca el metodo ConexionDB.conectar
            conexion = ConexionBD.conectar();
            
            //Inserta fila
            String consulta = "INSERT INTO usuarios (dni,nombre,apellidos,contrasena,usuario_automatico) VALUES(?,?,?,?,?)";
            
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, dni);
            sentenciaPreparada.setString(2, nombre);
            sentenciaPreparada.setString(3, apellidos);
            sentenciaPreparada.setString(4, contrasena);
            sentenciaPreparada.setString(5, usuarioAutomatico);
            
            //Se inserto = 1 sino es 0
            int resultadoInsercion = sentenciaPreparada.executeUpdate();
        
        
            //Verifica si se inserto
            if(resultadoInsercion > 0){
                registro = true;
                System.out.println("Registro exitoso");
            }
            else{
                System.out.println("Registro fallido");
            }
            
            //Cierrra el puerto
            conexion.close();
        } 
        catch (SQLException e) {
        
            System.out.println("Error: "+e);
        }
        finally{
        
            try{
            
                conexion.close();
            }
            catch(SQLException e){
            
                System.out.println("Error: "+e);
            }
        }
        
        System.out.println("Valor del registro: "+registro);
        return registro; 
    }
    
    /**
     * Verifica si el dni esta repetido en la base de datos
     * @param dni 
     * @return  dniRepetido boolean
     */
    public boolean buscarUsuarioRepetidoBD(String dni){
    
        boolean dniRepetido = false;
        try {
            //Conectamos a la BD
            conexion = ConexionBD.conectar();
            
            //Consulta
            String consulta = "SELECT dni FROM usuarios WHERE dni = ?";
            
            //Prepara consulta
            sentenciaPreparada = conexion.prepareStatement(consulta);
            
            //Reemplaza ?
            sentenciaPreparada.setString(1, dni);
            
            //Ejecuta la consulta
            resultado = sentenciaPreparada.executeQuery();
            
            //Verifica resultado
            if (resultado.next()){
                dniRepetido = true; //El dni esta repetido
            }
            else{
                dniRepetido = false; //El dni no esta repetido
            }
        } catch (SQLException e) {
            System.out.println("Descricion: Error verificando si el DNI esta registrado");
            System.out.println("Error: "+e);
        }
        finally{
            try{
                conexion.close(); //Cierra la conexion
            }
            catch(SQLException e){
                System.out.println("Descricion: Error al intentar cerrar la conexion");
                System.out.println("Error: "+e);
            }
        }
        //Log dniRepetido
        System.out.println("El dni esta repetido? "+dniRepetido);
        return dniRepetido;
    }
    
    public boolean buscarUsuarioLogin(String usuario, String contrasena){
        
        boolean inicioSesion = false;
        
        try {
            //Conectamos a la BD
            conexion = ConexionBD.conectar();
            
            //Consulta
            String consulta = "SELECT contrasena,usuario_automatico FROM usuarios WHERE usuario_automatico = ? AND contrasena = ?";
            
            //Prepara consulta
            sentenciaPreparada = conexion.prepareStatement(consulta);
            
            //Reemplaza ?
            sentenciaPreparada.setString(1, usuario);
            sentenciaPreparada.setString(2, contrasena);
            
            //Ejecuta consulta
            resultado = sentenciaPreparada.executeQuery();
            
            //Verifica si el usuario existe
            if(resultado.next()){
                inicioSesion = true; //El usuario puede ingresar
            }
            else{
                inicioSesion = false; //El usuario no esta registrado
            }
        } 
        catch (SQLException e) {
            System.out.println("Descricion: Error al verificar si el usuario ya existia");
            System.out.println("Error: "+e);
        }
        finally{
            try{
                conexion.close(); //Cierra conexion
            }
            catch(SQLException e){
                System.out.println("Descricion: Error al intentar cerrar la conexion");
                System.out.println("Error: "+e);
            }
        }
        System.out.println("El usuario puede ingresar? "+inicioSesion);
        return inicioSesion;
    }
    
    public String buscarNombre(String usuario){
        
        String nombre = null;
        
        try {
            //Conectamos a la BD
            conexion = ConexionBD.conectar();
            
            //Consulta
            String consulta = "SELECT nombre FROM usuarios WHERE usuario_automatico = ?";
            
            //Prepara consulta
            sentenciaPreparada = conexion.prepareStatement(consulta);
            
            //Reemplaza ?
            sentenciaPreparada.setString(1, usuario);
            
            //Ejecuta consulta
            resultado = sentenciaPreparada.executeQuery();
            
            if (resultado.next()){
                System.out.println("Nombre de usuario encontrado");
                nombre = resultado.getString("nombre");
            }
            else{
                System.out.println("Nombre de usuario no encontrado");
                nombre = null;
            }
            conexion.close();
        }
        catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        finally{
            try{
                conexion.close(); //Cierra conexion
            }
            catch(SQLException e){
                System.out.println("Descricion: Error al intentar cerrar la conexion");
                System.out.println("Error: "+e);
            }
        }
        //Log
        System.out.println("El nombre es " + nombre);
        return nombre;
    }
}
