/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.User;
import view.registerFrame;

public class UserController implements ActionListener {
    
    private registerFrame view;
    private User model;
    
    public UserController(registerFrame view, User model){
        this.view=view;
        this.model=model;
        this.view.registerButton.addActionListener(this);
        this.view.btnSearch.addActionListener(this);
        this.view.btnUpdate.addActionListener(this);
        this.view.btnDestroy.addActionListener(this);
    }
    
    public void init(){
        view.setLocation(null);
    }
  

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(view.registerButton==evento.getSource()){
            this.register();
        }
        if(view.btnSearch==evento.getSource()){
            this.getUser();
         }
        if(view.btnUpdate==evento.getSource()){
            this.updateUser();
        }
        if(view.btnDestroy==evento.getSource()){
            this.destroyUser();
        }
       
       
    }
    
    public void register(){
        
        model.setEmail(view.txtEmail.getText());
        model.setName(view.txtName.getText());
        model.setLastName(view.txtLastName.getText());
        model.setPassword(view.txtPassword.getText());
        model.save();
        
    }
    
    public void getUser(){
        
        int id=Integer.parseInt(view.txtId.getText());
        model.setId(id);
        if(model.get(model)){
            view.txtName.setText(String.valueOf(model.getName()));
            view.txtLastName.setText(String.valueOf(model.getLastName()));
            view.txtEmail.setText(String.valueOf(model.getEmail()));
            view.txtPassword.setText(String.valueOf(model.getPassword()));
        }
    }
    
    public void updateUser(){
        model.setEmail(view.txtEmail.getText());
        model.setName(view.txtName.getText());
        model.setLastName(view.txtLastName.getText());
        model.setPassword(view.txtPassword.getText());
        int id=Integer.parseInt(view.txtId.getText());
        model.setId(id);
        if(model.update(model)){
            System.out.println("exito");
        }
    }
    
    public void destroyUser(){
        if(model.destroy(model)){
            JOptionPane.showMessageDialog(null, "Destruido");
            limpiar();
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar");
            limpiar();
        
        }
        
    }
    
    
    public void limpiar(){
        view.txtName.setText(null);
        view.txtLastName.setText(null);
        view.txtEmail.setText(null);
        view.txtPassword.setText(null);
        view.txtId.setText(null);
        view.txtIdDestroy.setText(null);     
    }
    
    
}
