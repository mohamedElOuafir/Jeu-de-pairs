/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controller.ServiceController;
import Model.Connexion;
import Model.ServiceModel;
import View.LoginFrame;



/**
 *
 * @author moham
 */
public class Main {
   
    public static void main (String[] args){
        ServiceModel model = new ServiceModel();
        ServiceController controller = new ServiceController(model);
        
        LoginFrame login = new LoginFrame(controller);
        login.setVisible(true);
    }
}
