/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Card;
import View.GameFrame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author moham
 */
public class GameController {
    
    private int essais;
    private ArrayList<Card> cards;
    private int correctCardsNumber;
    private GameFrame gameFrame;
    
    public GameController(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        this.essais = 3;
        this.cards = new ArrayList<>();
        fillGrid();
        shuffleGrid();
    }
    
    //le remplissage du tableau des cartes : 
    public void fillGrid(){
        
        cards.add(new Card("/ressources/Cards/Dragon.png"));
        cards.add(new Card("/ressources/Cards/Dragon.png"));
        
        cards.add(new Card("/ressources/Cards/Golem.png"));
        cards.add(new Card("/ressources/Cards/Golem.png"));
        
        cards.add(new Card("/ressources/Cards/Wolf.png"));
        cards.add(new Card("/ressources/Cards/Wolf.png"));
        
        cards.add(new Card("/ressources/Cards/Wond.png"));
        cards.add(new Card("/ressources/Cards/Wond.png"));
        
        cards.add(new Card("/ressources/Cards/mage.png"));
        cards.add(new Card("/ressources/Cards/mage.png"));
        
        cards.add(new Card("/ressources/Cards/sceleton.png"));
        cards.add(new Card("/ressources/Cards/sceleton.png"));
        
        cards.add(new Card("/ressources/Cards/worrior.png"));
        cards.add(new Card("/ressources/Cards/worrior.png"));
        
        cards.add(new Card("/ressources/Cards/worrior2.png"));
        cards.add(new Card("/ressources/Cards/worrior2.png"));
    }
    
    //randomiser la table des cartes : 
    public void shuffleGrid(){
        Collections.shuffle(this.cards);
    }
    
    //vérifier la correspondance des paires : 
    public boolean checkCouples(int firstIndex, int secondIndex){
        
        if(cards.get(firstIndex).equals(cards.get(secondIndex))){
            correctCardsNumber++;
            return true;
        }
        essais--;
        return false;
    }
    
    //vérifcation de la fin du jeu : 
    public int checkEndGame(){
        if (essais == 0){
            return -1;
        }else if (correctCardsNumber == cards.size()/2){
            return 1;
        }
        return 0;
    }
    
    
    //Vérifier si le score actuel dépasse celui en base du joueur :
    public void checkScoreUpdate() throws SQLException{
        int newScore = gameFrame.getMinutes() * 60 + gameFrame.getSeconds();
        
        if (ServiceController.getCurrentPlayer().getHighScore() == 0)
            ServiceController.updatePlayerScore(newScore);
        
        else if (newScore < ServiceController.getCurrentPlayer().getHighScore())
            ServiceController.updatePlayerScore(newScore);
    }
    
    public ArrayList<Card> getCards(){
        return this.cards;
    }
    
    public int getEssais(){
        return this.essais;
    }
}
