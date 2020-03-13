/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;
import config.database;
import controller.UserController;
import model.User;
import view.registerFrame;

/**
 *
 * @author pc
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          //database database= new database();
          //database.conexion();
          
          User modelo= new User();
          registerFrame vista =new registerFrame();
          
          UserController controller= new UserController(vista,modelo);
          
          //controller.init();
          vista.setVisible(true);
          
          
    }
    
}
