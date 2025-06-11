/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Exceptions.PlayerNotFoundException;
import Model.Player;
import Model.ServiceModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author moham
 */
public class ServiceController {
    
    private static Player currentPlayer ;
    
    public static void addPlayer(String userName, String email, String password) throws SQLException{
        Player newPlayer = new Player(userName, email, password);
        ServiceModel.inserPlayer(newPlayer);
        setCurrentPlayer(newPlayer);
    }
    
    public static void getPlayer(String email, String password) throws SQLException, PlayerNotFoundException{
        Player player = ServiceModel.playerAuthentification(email, password);
        if (player == null){
            throw new PlayerNotFoundException();
        }
        setCurrentPlayer(player);
    }
    
    public static ArrayList<Player> getAllRecords() throws SQLException{
        ArrayList<Player> records = ServiceModel.getAllRecords();
        
        if(records != null)
            return records;
        return null;
        
    }
    
    public static void updatePlayerScore(int score) throws SQLException{
        currentPlayer.setHighScore(score);
        ServiceModel.updateScore(currentPlayer);
    }
    
    public static Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public static void setCurrentPlayer(Player player){
        currentPlayer = player;
    }
}
