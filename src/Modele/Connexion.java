/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author moham
 */
public class Connexion {
    
    private static Connection connection = null;
    private static String url;
    private static String user;
    private static String password;
    
    static {
        
        //Using a properties file to hide the informations about our DATABASE.
        
        /*
        *Using InputStram class to get the properties file for its path
        *Using Properties class to get the informations about the DataBase using the load methode.
        */
        
        
        try (InputStream input = Connexion.class.getClassLoader().getResourceAsStream("ressources/DB.properties")){
            Properties props = new Properties();
            
            if (input == null){
                System.out.println("File propreties doesn't exist !");
            }
            
            props.load(input);
            url = props.getProperty("DB.url");
            user = props.getProperty("DB.user");
            password = props.getProperty("DB.password");
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("The DATABASE connected successfully !");
            
            
        }catch (ClassNotFoundException e){
            System.out.println("Classe introuvable : "+ e.getMessage());
            
        }catch (SQLException e){
            System.out.println("Connexion impossible : "+ e.getMessage());
            
        } catch (IOException e) {
            System.out.println("Input Stream error :"+ e.getMessage());
            
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }
    
    public static void closeConnection() throws SQLException{
        
        if (connection != null)
            try{
                connection.close();
                System.out.println("Connexion Closed successfully !");
            }catch (SQLException e){
                System.out.println("Error closing Connexion : "+ e.getMessage());
            }
            
    }
}
