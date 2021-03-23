/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author FUJITSU
 */
public class conexion {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password="";
    private static final String url ="jdbc:mysql://localhost:3306/hr";

    public conexion() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if( conn != null){
                System.out.println("Conexion Establecida");
            }
            
        } catch (Exception e) {
            System.out.println(" Eror al conectar");
        }
    }
    
 public Connection getConnection(){
     return conn;
 }   
    public void desconectar (){
        conn = null;
        if (conn == null){
            System.out.println(" Conexion terminada");
        }
    }
    
}
