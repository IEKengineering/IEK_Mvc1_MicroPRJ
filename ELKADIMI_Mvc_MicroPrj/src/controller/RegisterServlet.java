package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.RegisterDao;
 
public class RegisterServlet extends HttpServlet {
  
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
    	 String email=request.getParameter("email");
 		String nom=request.getParameter("nom");
 		String prenom=request.getParameter("prenom");
 		String adresse=request.getParameter("adresse");
 		int codepostal=Integer.parseInt(request.getParameter("codepostal"));
 		String ville=request.getParameter("ville");
 		String tel=request.getParameter("tel");
 		String username=request.getParameter("username");
 		String password=request.getParameter("password");
          
         Client client  = new Client();
        //Using Java Beans - An easiest way to play with group of related data
         client.setEmail(email);
         client.setNom(nom);
         client.setPrenom(prenom);
         client.setAdresse(adresse); 
         client.setcodepostal(codepostal);
         client.setVille(ville);
         client.setTel(tel);
         client.setUsername(username);
         client.setpassword(password); 
          
         RegisterDao registerDao = new RegisterDao();
          
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String userRegistered = registerDao.registerUser(client);
          
         if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
         }
     }
}