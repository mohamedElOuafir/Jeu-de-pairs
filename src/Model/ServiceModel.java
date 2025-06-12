/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;




import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author moham
 */
public class ServiceModel {
    
    private Connection connection;
    
    public ServiceModel() {
        connection = Connexion.getConnection();
    }
    
    //ajouter un joueur dans la base de donnée :
    public void inserPlayer(Player player) throws SQLException{
        
        String query = "INSERT INTO player (email, username, motDePasse, highScore) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1,player.getEmail());
        statement.setString(2,player.getUserName());
        statement.setString(3,player.getPassword());
        statement.setInt(4,player.getHighScore());
        
        statement.executeUpdate();
    }
    
    
    //faire une authentification d'un joueur selon som email et son mot de passe : 
    public Player playerAuthentification(String email, String password) throws SQLException{
        
        String query = "SELECT * FROM player WHERE player.email = ? AND player.motDePasse = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, email);
        statement.setString(2, password);
        
        ResultSet result = statement.executeQuery();
        
        if(result.next()){
            Player p = new Player(result.getString("username"),
                    result.getString("email"),
                    result.getString("motDePasse")
            );
            p.setHighScore(result.getInt("highScore"));
            
            return p;
        }
        
        return null;
    }
    
    //mettre à jour le score d'un joueur :
    public void updateScore(Player player) throws SQLException{
        
        String query = "UPDATE player SET highScore = ? WHERE email = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setInt(1, player.getHighScore());
        statement.setString(2, player.getEmail());
        
        statement.executeUpdate();
        
    }
    
    //récupérations des trois premier records des joueurs :
    public ArrayList<Player> getAllRecords() throws SQLException{
        ArrayList<Player> records = new ArrayList<>();
        
        String query = "SELECT * FROM player ORDER BY highscore ASC";
        PreparedStatement statement = connection.prepareStatement(query);
        
        ResultSet result = statement.executeQuery();
        
        while(result.next()){
            if (result.getInt("highscore") != 0){
                Player player = new Player(
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("motdepasse")
                );
                player.setHighScore(result.getInt("highscore"));
                records.add(player);
                
                if (records.size() == 3)
                    break;
            }
        }
        
        
        if (records.isEmpty())
            return null;
        
        System.out.println("model : "+ records.size());
        return records;
    }
}

