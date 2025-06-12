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
    
    private Player currentPlayer ;
    private ServiceModel model;
    
    //le constructeur de la classe ServiceController : 
    public ServiceController(ServiceModel model) {
        this.model = model;
    }
    
    //ajouter un joueur au base de données :
    public void addPlayer(String userName, String email, String password) throws SQLException{
        Player newPlayer = new Player(userName, email, password);
        model.inserPlayer(newPlayer);
        setCurrentPlayer(newPlayer);
    }
    
    //récuper un joueur selon son email et mot de passe :
    public void getPlayer(String email, String password) throws SQLException, PlayerNotFoundException{
        Player player = model.playerAuthentification(email, password);
        if (player == null){
            throw new PlayerNotFoundException();
        }
        setCurrentPlayer(player);
    }
    
    //récuperrer les trois premier high scores : 
    public ArrayList<Player> getAllRecords() throws SQLException{
        ArrayList<Player> records = model.getAllRecords();
        
        if(records != null)
            return records;
        return null;
        
    }
    
    //modifier le high score d'un joueur : 
    public void updatePlayerScore(int score) throws SQLException{
        currentPlayer.setHighScore(score);
        model.updateScore(currentPlayer);
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public void setCurrentPlayer(Player player){
        currentPlayer = player;
    }
}
