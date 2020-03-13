
package model;

import config.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class User {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean save(){
        Statement s = null;
        String values=this.name+"','"+this.lastName+"','"+this.email+"','"+this.password;
        String query="INSERT INTO users(name,lastName,email,password) VALUES ('"+values+"')";
            
        database database= new database();
        database.conexion();
    
        try {
            s = database.connection.createStatement();
            int z = s.executeUpdate(query);
            System.out.println ("Registro exitoso");  
        } 
        
        catch (Exception e) {
            System.out.println(e);
        }
        
        return true;
    }
    
    public boolean get(User user){
        
        Statement s = null;
        ResultSet result=null;
        String query="SELECT * FROM users WHERE id="+user.getId();
        database database= new database();
        database.conexion();
    
        try {
            s = database.connection.createStatement();
            result=s.executeQuery(query);
            if(result.next()){
                user.setName(result.getString("name"));
                user.setLastName(result.getString("lastName"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
            }
            return true;
            
        } 
        
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
     
        
        
       
    }
    
    
    public boolean update(User user){
        
        //Statement s = null;
        ResultSet result=null;
        String query="UPDATE users SET name=?,lastName=?,email=?,password=? WHERE id=?";
        PreparedStatement s=null;
        
        database database= new database();
        database.conexion();
        
        System.out.println(query);
    
        try {
            s = database.connection.prepareStatement(query);
            s.setString(1, user.getName());
            s.setString(2,user.getLastName());
            s.setString(3, user.getEmail());
            s.setString(4, user.getPassword());
            s.setInt(5, user.getId());
            
            s.execute();
            
            return true;
            
        } 
        
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
     
        
        
       
    }
    
    public boolean destroy(User user){
        
        Statement s = null;
        ResultSet result=null;
        String query="DELETE FROM users WHERE id="+user.getId();
        database database= new database();
        database.conexion();
        
        System.out.println(query);
    
        try {
             s = database.connection.createStatement();
            int z = s.executeUpdate(query);
            return true;
            
        } 
        
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
     
        
        
        
        
        
        
       
    }
    
    
    
}
