/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author moham
 */
public class Card {
    
    private ImageIcon image;
    private String src;
    
    public Card(String src) {
        this.src = src;
        this.image = new ImageIcon(getClass().getResource(src));
    }
    
    public ImageIcon getImage(){
        return image;
    }
    
    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public String getSrc(){
        return src;
    }
    
    public void setSrc(String src) {
        this.src = src;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(src);
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other =(Card)obj;
        return Objects.equals(src, other.src);
    }
    
}
