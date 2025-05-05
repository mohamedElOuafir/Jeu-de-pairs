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
    
    private Connection connection = null;
    private String url;
    private String user;
    private String password;
    
    public Connexion(){
        
        //Using a properties file to hide the informations about our DATABASE.
        
        /*
        *Using InputStram class to get the properties file for its path
        *Using Properties class to get the informations about the DataBase using the load methode.
        */
        
        
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("ressources/DB.properties")){
            Properties props = new Properties();
            
            if (input == null){
                System.out.println("File propreties doesn't exist !");
                return ;
            }
            
            props.load(input);
            this.url = props.getProperty("DB.url");
            this.user = props.getProperty("DB.user");
            this.password = props.getProperty("DB.password");
            
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
    
    public Connection getConnection(){
        return connection;
    }
}
