package model;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class RegisterDao { 
     public String registerUser(Client client)
     {
    	 String email=client.getEmail();
       
  		String nom= client.getNom();
       
  		String prenom= client.getPrenom();
        
  		String adresse=client.getAdresse(); 
       
  		int codepostal= client.getcodepostal();
        
  		String ville=client.getVille();
         
  		String tel=client.getTel();
       
  		String username=client.getUsername();
     
  		String password= client.getpassword();
  		
  	    
          
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into clients(Id,Email,Nom,Prenom,Adresse,CodePostal,Ville,Tel,userName,password) values (NULL,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, email);
             preparedStatement.setString(2, nom);
             preparedStatement.setString(3, prenom);
             preparedStatement.setString(4, adresse);
             preparedStatement.setInt(5, codepostal);
             preparedStatement.setString(6, ville);
             preparedStatement.setString(7, tel);
             preparedStatement.setString(8, username);
             preparedStatement.setString(9, password);
              
             int i= preparedStatement.executeUpdate();
              
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
     }
}