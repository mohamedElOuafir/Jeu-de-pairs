/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

/**
 *
 * @author moham
 */
public class Connexion {
    
    private Connection connection = null;
    
    private final String url = "jdbc:mysql://localhost:3307/jeudepairsdb";
    private final String user = "root";
    private final String password = "";
    
    public Connexion(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.driver");
            connection = DriverManager.getConnection(url, user, password);
            
        }catch(ClassNotFoundException e){
            System.out.println("Classe introuvable ! ");
        }catch (SQLException e){
            System.out.println("Connexion impossible !");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
}
